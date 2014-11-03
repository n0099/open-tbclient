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
    private ArrayList<View> bOp;
    private ArrayList<ImageView> bOq;
    private h bOr;
    private BaseViewPager bOs;
    private ImageView bOt;
    private View bOu;
    private ViewGroup bOx;
    private boolean bsW;
    private g bOn = null;
    private String bOo = null;
    private boolean bOv = true;
    public boolean bOw = true;
    private final com.baidu.tbadk.core.view.a GZ = new b(this);
    private View.OnClickListener bOy = new c(this);
    public View.OnClickListener bOz = new d(this);
    private final ViewPager.OnPageChangeListener bOA = new e(this);
    private final HttpMessageListener bOB = new f(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015000, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.bOo = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else {
            this.bOo = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.bOo)) {
            this.bOo = "";
        }
        try {
            setContentView(com.baidu.tieba.w.guide_activity);
            aed();
            this.bOw = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("jump_to_new_user_guide", true);
            if (this.bOw) {
                aee();
            }
            try {
                aea();
                this.bOr = new h(this, null);
                this.bOs = (BaseViewPager) findViewById(com.baidu.tieba.v.guide_pager);
                this.bOs.setAdapter(this.bOr);
                this.bOs.setOnFlipOutListener(this.GZ);
                this.bOs.setOnPageChangeListener(this.bOA);
                com.baidu.tbadk.core.j.l(this, "new_user_guide_pv");
                if (this.bOo != null && this.bOo.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.bOn = new g(this, null);
                    this.bOn.setSelfExecute(true);
                    this.bOn.execute(new String[0]);
                    return;
                }
                this.bOn = null;
            } catch (OutOfMemoryError e) {
                Yu();
                TbadkApplication.m251getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.bOv = true;
                this.bOw = false;
                aec();
            } catch (RuntimeException e2) {
                Yu();
                TbadkApplication.m251getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.bOv = true;
                this.bOw = false;
                aec();
            }
        } catch (RuntimeException e3) {
            this.bOv = true;
            this.bOw = false;
            aec();
        }
    }

    private void aea() {
        this.bOp = new ArrayList<>();
        this.bOq = new ArrayList<>();
        View a = com.baidu.adp.lib.g.b.ek().a(this, com.baidu.tieba.w.guide_page_first, null, false);
        View a2 = com.baidu.adp.lib.g.b.ek().a(this, com.baidu.tieba.w.guide_page_second, null, false);
        View a3 = com.baidu.adp.lib.g.b.ek().a(this, com.baidu.tieba.w.guide_page_third, null, false);
        this.bOq.add((ImageView) a.findViewById(com.baidu.tieba.v.image_first));
        this.bOq.add((ImageView) a2.findViewById(com.baidu.tieba.v.image_second));
        this.bOq.add((ImageView) a3.findViewById(com.baidu.tieba.v.image_third));
        this.bOx = (ViewGroup) a3.findViewById(com.baidu.tieba.v.guide_page_end_hao123_open_layout);
        this.bOt = (ImageView) a3.findViewById(com.baidu.tieba.v.radio_hao123_open);
        this.bOu = a3.findViewById(com.baidu.tieba.v.start_app);
        this.bOx.setVisibility(8);
        this.bOu.setVisibility(0);
        this.bOu.setOnClickListener(this.bOz);
        this.bOp.add(a);
        this.bOp.add(a2);
        this.bOp.add(a3);
    }

    public void aeb() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012117));
    }

    public void aec() {
        if (this.bOo != null && !this.bOo.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            oq();
        }
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Yu();
        if (this.bOn != null) {
            this.bOn.cancel(true);
            this.bOn = null;
        }
    }

    protected void Yu() {
        if (this.bOs != null) {
            this.bOs.setBackgroundDrawable(null);
        }
        if (this.bOq != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOq.size()) {
                    ImageView imageView = this.bOq.get(i2);
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
                aec();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void oq() {
        boolean isFirstUse = TbadkApplication.m251getInst().getIsFirstUse();
        if (this.bOv) {
            if (!this.bOw) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(this).createNormalCfg(1)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(this).createNormalCfg(4)));
                }
            } else {
                aef();
                com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                TbadkApplication.m251getInst().setUsed();
                TbadkApplication.m251getInst().setFirstGoMaintab(true);
                TbadkApplication.m251getInst().setFirstGoFrs(true);
            }
            finish();
            this.bOv = false;
        }
    }

    public void aed() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.bOB);
    }

    public void aee() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void aef() {
        sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(this, false, true)));
    }

    public void aeg() {
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

    public boolean aeh() {
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
