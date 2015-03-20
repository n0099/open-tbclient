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
    private ArrayList<View> bxo;
    private ArrayList<ImageView> bxp;
    private g bxq;
    private BaseViewPager bxr;
    private View bxs;
    private f bxm = null;
    private String bxn = null;
    private boolean bxt = true;
    public boolean bxu = true;
    private final com.baidu.tbadk.core.view.a Xb = new a(this);
    public View.OnClickListener bxv = new b(this);
    private final ViewPager.OnPageChangeListener bxw = new c(this);
    private final HttpMessageListener bxx = new d(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (bundle != null) {
            this.bxn = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else {
            this.bxn = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.bxn)) {
            this.bxn = "";
        }
        try {
            setContentView(w.guide_activity);
            Qf();
            this.bxu = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("jump_to_new_user_guide", true);
            if (this.bxu) {
                Wm();
            }
            try {
                Wj();
                this.bxq = new g(this, null);
                this.bxr = (BaseViewPager) findViewById(v.guide_pager);
                this.bxr.setAdapter(this.bxq);
                this.bxr.setOnFlipOutListener(this.Xb);
                this.bxr.setOnPageChangeListener(this.bxw);
                k.A(getPageContext().getPageActivity(), "new_user_guide_pv");
                if (this.bxn != null && this.bxn.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.bxm = new f(this, null);
                    this.bxm.setSelfExecute(true);
                    this.bxm.execute(new String[0]);
                    return;
                }
                this.bxm = null;
            } catch (OutOfMemoryError e) {
                Wl();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.bxt = true;
                this.bxu = false;
                Wk();
            } catch (RuntimeException e2) {
                Wl();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.bxt = true;
                this.bxu = false;
                Wk();
            }
        } catch (RuntimeException e3) {
            this.bxt = true;
            this.bxu = false;
            Wk();
        }
    }

    private void Wj() {
        this.bxo = new ArrayList<>();
        this.bxp = new ArrayList<>();
        View a = com.baidu.adp.lib.g.b.hH().a(getPageContext().getPageActivity(), w.guide_page_first, null, false);
        View a2 = com.baidu.adp.lib.g.b.hH().a(getPageContext().getPageActivity(), w.guide_page_second, null, false);
        this.bxp.add((ImageView) a.findViewById(v.image_first));
        this.bxp.add((ImageView) a2.findViewById(v.image_second));
        this.bxs = a2.findViewById(v.start_app);
        this.bxs.setVisibility(0);
        this.bxs.setOnClickListener(this.bxv);
        this.bxo.add(a);
        this.bxo.add(a2);
    }

    public void Wk() {
        if (this.bxn != null && !this.bxn.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            us();
        }
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Wl();
        if (this.bxm != null) {
            this.bxm.cancel(true);
            this.bxm = null;
        }
    }

    protected void Wl() {
        if (this.bxr != null) {
            this.bxr.setBackgroundDrawable(null);
        }
        if (this.bxp != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bxp.size()) {
                    ImageView imageView = this.bxp.get(i2);
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
                Wk();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void us() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.bxt) {
            if (!this.bxu) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                }
            } else {
                Wn();
                com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                l.hJ().b(new e(this));
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            finish();
            this.bxt = false;
        }
    }

    public void Qf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.bxx);
    }

    public void Wm() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void Wn() {
        sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
    }

    public void Wo() {
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

    public boolean Wp() {
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
