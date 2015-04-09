package com.baidu.tieba.launcherGuide.tblauncher;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.g.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity<GuideActivity> {
    private ArrayList<View> bxE;
    private ArrayList<ImageView> bxF;
    private g bxG;
    private BaseViewPager bxH;
    private View bxI;
    private f bxC = null;
    private String bxD = null;
    private boolean bxJ = true;
    public boolean bxK = true;
    private final com.baidu.tbadk.core.view.a Xd = new a(this);
    public View.OnClickListener bxL = new b(this);
    private final ViewPager.OnPageChangeListener bxM = new c(this);
    private final HttpMessageListener bxN = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bxD = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else {
            this.bxD = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.bxD)) {
            this.bxD = "";
        }
        if (this.bxD != null && !this.bxD.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            this.bxK = false;
            Wx();
            return;
        }
        try {
            setContentView(w.guide_activity);
            Qs();
            this.bxK = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("jump_to_new_user_guide", true);
            if (this.bxK) {
                Wz();
            }
            try {
                Ww();
                this.bxG = new g(this, null);
                this.bxH = (BaseViewPager) findViewById(v.guide_pager);
                this.bxH.setAdapter(this.bxG);
                this.bxH.setOnFlipOutListener(this.Xd);
                this.bxH.setOnPageChangeListener(this.bxM);
                k.A(getPageContext().getPageActivity(), "new_user_guide_pv");
                if (this.bxD != null && this.bxD.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.bxC = new f(this, null);
                    this.bxC.setSelfExecute(true);
                    this.bxC.execute(new String[0]);
                    return;
                }
                this.bxC = null;
            } catch (OutOfMemoryError e) {
                Wy();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.bxJ = true;
                this.bxK = false;
                Wx();
            } catch (RuntimeException e2) {
                Wy();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.bxJ = true;
                this.bxK = false;
                Wx();
            }
        } catch (RuntimeException e3) {
            this.bxJ = true;
            this.bxK = false;
            Wx();
        }
    }

    private void Ww() {
        this.bxE = new ArrayList<>();
        this.bxF = new ArrayList<>();
        View a = com.baidu.adp.lib.g.b.hH().a(getPageContext().getPageActivity(), w.guide_page_first, null, false);
        View a2 = com.baidu.adp.lib.g.b.hH().a(getPageContext().getPageActivity(), w.guide_page_second, null, false);
        this.bxF.add((ImageView) a.findViewById(v.image_first));
        this.bxF.add((ImageView) a2.findViewById(v.image_second));
        this.bxI = a2.findViewById(v.start_app);
        this.bxI.setVisibility(0);
        this.bxI.setOnClickListener(this.bxL);
        this.bxE.add(a);
        this.bxE.add(a2);
    }

    public void Wx() {
        if (this.bxD != null && !this.bxD.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            us();
        }
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Wy();
        if (this.bxC != null) {
            this.bxC.cancel(true);
            this.bxC = null;
        }
    }

    protected void Wy() {
        if (this.bxH != null) {
            this.bxH.setBackgroundDrawable(null);
        }
        if (this.bxF != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bxF.size()) {
                    ImageView imageView = this.bxF.get(i2);
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageBitmap(null);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                Wx();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void us() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.bxJ) {
            if (!this.bxK) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                }
            } else {
                WA();
                com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                l.hJ().b(new e(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            finish();
            this.bxJ = false;
        }
    }

    public void Qs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.bxN);
    }

    public void Wz() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void WA() {
        sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
    }

    public void WB() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), String.valueOf(getPageContext().getPageActivity().getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(y.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), u.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    public boolean WC() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(y.app_name)}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return false;
    }
}
