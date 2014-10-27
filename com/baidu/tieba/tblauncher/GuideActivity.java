package com.baidu.tieba.tblauncher;

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
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GuideActivity extends BaseActivity {
    private ArrayList<View> bOa;
    private ArrayList<ImageView> bOb;
    private h bOc;
    private BaseViewPager bOd;
    private ImageView bOe;
    private View bOf;
    private ViewGroup bOi;
    private boolean bsI;
    private g bNY = null;
    private String bNZ = null;
    private boolean bOg = true;
    public boolean bOh = true;
    private final com.baidu.tbadk.core.view.a GY = new b(this);
    private View.OnClickListener bOj = new c(this);
    public View.OnClickListener bOk = new d(this);
    private final ViewPager.OnPageChangeListener bOl = new e(this);
    private final HttpMessageListener bOm = new f(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015000, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.bNZ = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else {
            this.bNZ = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.bNZ)) {
            this.bNZ = "";
        }
        try {
            setContentView(com.baidu.tieba.w.guide_activity);
            aea();
            this.bOh = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("jump_to_new_user_guide", true);
            if (this.bOh) {
                aeb();
            }
            try {
                adX();
                this.bOc = new h(this, null);
                this.bOd = (BaseViewPager) findViewById(com.baidu.tieba.v.guide_pager);
                this.bOd.setAdapter(this.bOc);
                this.bOd.setOnFlipOutListener(this.GY);
                this.bOd.setOnPageChangeListener(this.bOl);
                com.baidu.tbadk.core.i.l(this, "new_user_guide_pv");
                if (this.bNZ != null && this.bNZ.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.bNY = new g(this, null);
                    this.bNY.setSelfExecute(true);
                    this.bNY.execute(new String[0]);
                    return;
                }
                this.bNY = null;
            } catch (OutOfMemoryError e) {
                Yr();
                TbadkApplication.m251getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.bOg = true;
                this.bOh = false;
                adZ();
            } catch (RuntimeException e2) {
                Yr();
                TbadkApplication.m251getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.bOg = true;
                this.bOh = false;
                adZ();
            }
        } catch (RuntimeException e3) {
            this.bOg = true;
            this.bOh = false;
            adZ();
        }
    }

    private void adX() {
        this.bOa = new ArrayList<>();
        this.bOb = new ArrayList<>();
        View a = com.baidu.adp.lib.g.b.ek().a(this, com.baidu.tieba.w.guide_page_first, null, false);
        View a2 = com.baidu.adp.lib.g.b.ek().a(this, com.baidu.tieba.w.guide_page_second, null, false);
        View a3 = com.baidu.adp.lib.g.b.ek().a(this, com.baidu.tieba.w.guide_page_third, null, false);
        this.bOb.add((ImageView) a.findViewById(com.baidu.tieba.v.image_first));
        this.bOb.add((ImageView) a2.findViewById(com.baidu.tieba.v.image_second));
        this.bOb.add((ImageView) a3.findViewById(com.baidu.tieba.v.image_third));
        this.bOi = (ViewGroup) a3.findViewById(com.baidu.tieba.v.guide_page_end_hao123_open_layout);
        this.bOe = (ImageView) a3.findViewById(com.baidu.tieba.v.radio_hao123_open);
        this.bOf = a3.findViewById(com.baidu.tieba.v.start_app);
        this.bOi.setVisibility(8);
        this.bOf.setVisibility(0);
        this.bOf.setOnClickListener(this.bOk);
        this.bOa.add(a);
        this.bOa.add(a2);
        this.bOa.add(a3);
    }

    public void adY() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012117));
    }

    public void adZ() {
        if (this.bNZ != null && !this.bNZ.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            oq();
        }
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Yr();
        if (this.bNY != null) {
            this.bNY.cancel(true);
            this.bNY = null;
        }
    }

    protected void Yr() {
        if (this.bOd != null) {
            this.bOd.setBackgroundDrawable(null);
        }
        if (this.bOb != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOb.size()) {
                    ImageView imageView = this.bOb.get(i2);
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
                adZ();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void oq() {
        boolean isFirstUse = TbadkApplication.m251getInst().getIsFirstUse();
        if (this.bOg) {
            if (!this.bOh) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(this).createNormalCfg(1)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(this).createNormalCfg(4)));
                }
            } else {
                aec();
                com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                TbadkApplication.m251getInst().setUsed();
                TbadkApplication.m251getInst().setFirstGoMaintab(true);
                TbadkApplication.m251getInst().setFirstGoFrs(true);
            }
            finish();
            this.bOg = false;
        }
    }

    public void aea() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.bOm);
    }

    public void aeb() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void aec() {
        sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(this, false, true)));
    }

    public void aed() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPackageName(), String.valueOf(getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getString(com.baidu.tieba.y.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, com.baidu.tieba.u.icon));
        sendBroadcast(intent2);
    }

    public boolean aee() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getString(com.baidu.tieba.y.app_name)}, null);
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
