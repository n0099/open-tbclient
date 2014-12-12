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
public class GuideActivity extends BaseActivity<GuideActivity> {
    private boolean bwt;
    private ArrayList<ImageView> caA;
    private h caB;
    private BaseViewPager caC;
    private ImageView caD;
    private View caE;
    private ViewGroup caH;
    private ArrayList<View> caz;
    private g cax = null;
    private String cay = null;
    private boolean caF = true;
    public boolean caG = true;
    private final com.baidu.tbadk.core.view.a Li = new b(this);
    private View.OnClickListener caI = new c(this);
    public View.OnClickListener caJ = new d(this);
    private final ViewPager.OnPageChangeListener caK = new e(this);
    private final HttpMessageListener caL = new f(this, CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015000, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cay = bundle.getString(GuildActivityConfig.FROM_PAGE);
        } else {
            this.cay = getIntent().getStringExtra(GuildActivityConfig.FROM_PAGE);
        }
        if (TextUtils.isEmpty(this.cay)) {
            this.cay = "";
        }
        try {
            setContentView(com.baidu.tieba.x.guide_activity);
            NZ();
            this.caG = com.baidu.tbadk.core.sharedPref.b.og().getBoolean("jump_to_new_user_guide", true);
            if (this.caG) {
                aix();
            }
            try {
                aiu();
                this.caB = new h(this, null);
                this.caC = (BaseViewPager) findViewById(com.baidu.tieba.w.guide_pager);
                this.caC.setAdapter(this.caB);
                this.caC.setOnFlipOutListener(this.Li);
                this.caC.setOnPageChangeListener(this.caK);
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "new_user_guide_pv");
                if (this.cay != null && this.cay.equals(GuildActivityConfig.FROM_LOGO_PAGE)) {
                    this.cax = new g(this, null);
                    this.cax.setSelfExecute(true);
                    this.cax.execute(new String[0]);
                    return;
                }
                this.cax = null;
            } catch (OutOfMemoryError e) {
                YS();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e);
                this.caF = true;
                this.caG = false;
                aiw();
            } catch (RuntimeException e2) {
                YS();
                TbadkApplication.getInst().onAppMemoryLow();
                BdLog.detailException(e2);
                this.caF = true;
                this.caG = false;
                aiw();
            }
        } catch (RuntimeException e3) {
            this.caF = true;
            this.caG = false;
            aiw();
        }
    }

    private void aiu() {
        this.caz = new ArrayList<>();
        this.caA = new ArrayList<>();
        View a = com.baidu.adp.lib.g.b.ek().a(getPageContext().getPageActivity(), com.baidu.tieba.x.guide_page_first, null, false);
        View a2 = com.baidu.adp.lib.g.b.ek().a(getPageContext().getPageActivity(), com.baidu.tieba.x.guide_page_second, null, false);
        View a3 = com.baidu.adp.lib.g.b.ek().a(getPageContext().getPageActivity(), com.baidu.tieba.x.guide_page_third, null, false);
        this.caA.add((ImageView) a.findViewById(com.baidu.tieba.w.image_first));
        this.caA.add((ImageView) a2.findViewById(com.baidu.tieba.w.image_second));
        this.caA.add((ImageView) a3.findViewById(com.baidu.tieba.w.image_third));
        this.caH = (ViewGroup) a3.findViewById(com.baidu.tieba.w.guide_page_end_hao123_open_layout);
        this.caD = (ImageView) a3.findViewById(com.baidu.tieba.w.radio_hao123_open);
        this.caE = a3.findViewById(com.baidu.tieba.w.start_app);
        this.caH.setVisibility(8);
        this.caE.setVisibility(0);
        this.caE.setOnClickListener(this.caJ);
        this.caz.add(a);
        this.caz.add(a2);
        this.caz.add(a3);
    }

    public void aiv() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012117));
    }

    public void aiw() {
        if (this.cay != null && !this.cay.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
            rq();
        }
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        YS();
        if (this.cax != null) {
            this.cax.cancel(true);
            this.cax = null;
        }
    }

    protected void YS() {
        if (this.caC != null) {
            this.caC.setBackgroundDrawable(null);
        }
        if (this.caA != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.caA.size()) {
                    ImageView imageView = this.caA.get(i2);
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
                aiw();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void rq() {
        boolean isFirstUse = TbadkApplication.getInst().getIsFirstUse();
        if (this.caF) {
            if (!this.caG) {
                if (!isFirstUse) {
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007006, null));
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                }
            } else {
                aiy();
                com.baidu.tbadk.core.sharedPref.b.og().putBoolean("jump_to_new_user_guide", false);
            }
            if (isFirstUse) {
                TbadkApplication.getInst().setUsed();
                TbadkApplication.getInst().setFirstGoMaintab(true);
                TbadkApplication.getInst().setFirstGoFrs(true);
            }
            finish();
            this.caF = false;
        }
    }

    public void NZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.JUMP_TO_NEW_USER_CHOOSE_BAR);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(ShowNewUserGuideResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.caL);
    }

    public void aix() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.JUMP_TO_NEW_GUIDE_HTTP_CMD);
        httpMessage.addParam(SapiAccountManager.SESSION_UID, currentAccount);
        sendMessage(httpMessage);
    }

    public void aiy() {
        sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), false, true)));
    }

    public void aiz() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        intent.setComponent(new ComponentName(getPageContext().getPageActivity().getPackageName(), String.valueOf(getPageContext().getPageActivity().getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getPageContext().getString(com.baidu.tieba.z.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), com.baidu.tieba.v.icon));
        getPageContext().getPageActivity().sendBroadcast(intent2);
    }

    public boolean aiA() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getPageContext().getString(com.baidu.tieba.z.app_name)}, null);
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
