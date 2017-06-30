package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, b {
    private com.baidu.adp.lib.e.b<TbImageView> anq;
    private CheckRealNameModel bjw;
    VoiceManager cci;
    private com.baidu.tieba.write.e cpJ;
    private FrameLayout eNa;
    private ad fQq;
    private a fQr;
    private com.baidu.adp.lib.e.b<TbImageView> fQt;
    private com.baidu.tieba.a fQv;
    private boolean fQz;
    private boolean isFirstGoMaintab;
    private boolean fQl = false;
    private int fQm = -1;
    private boolean fQn = false;
    private long fQo = 0;
    private long fQp = 0;
    private long fQs = -1;
    private boolean fQu = false;
    private final CustomMessageListener fQw = new c(this, CmdConfigCustom.CMD_CLOSE_MATINTAB);
    private final CustomMessageListener skinTypeChangeListener = new n(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final com.baidu.adp.framework.listener.e dkS = new o(this, 1001);
    private final CustomMessageListener fQx = new p(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener fek = new q(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener fQy = new r(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener fQA = new s(this, CmdConfigCustom.MAINTAB_SET_INST);
    private final CustomMessageListener fQB = new t(this, CmdConfigCustom.CMD_HOME_WRITE_THREAD);
    private CheckRealNameModel.a fQC = new u(this);
    private CustomMessageListener fQD = new d(this, 2000994);
    private CustomMessageListener duu = new e(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener fQE = new f(this, CmdConfigCustom.CMD_GAME_CENTER_INIT);
    private final CustomMessageListener fQF = new g(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);

    /* JADX INFO: Access modifiers changed from: private */
    public void rC(String str) {
        if (str != null && TbadkCoreApplication.m9getInst().getConfigVersion() != null && bnW()) {
            this.fQs = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean bnW() {
        if (-1 == this.fQs) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.fQs;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnX() {
        if (com.baidu.adp.lib.b.e.eY().ad("android_game_enter_switch") == 1 && com.baidu.tbadk.core.util.r.aek) {
            this.fQq.lZ(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.fQq.lZ(false);
        this.fQq.mb(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && hVar != null) {
            if ((hVar.Cb() == 1 || hVar.Cb() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long pd = hVar.pd() * 1000;
                if (pd < System.currentTimeMillis()) {
                    if (StringUtils.isNull(hVar.Cc())) {
                        hVar.fk(getPageContext().getString(w.l.member));
                    } else {
                        hVar.fk(String.valueOf(hVar.Cc()) + getPageContext().getString(w.l.member_already_Expire));
                    }
                    this.fQq.a(hVar, 0);
                } else if (pd - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(hVar.Cc())) {
                        hVar.fk(getPageContext().getString(w.l.member));
                    } else {
                        hVar.fk(String.valueOf(hVar.Cc()) + getPageContext().getString(w.l.member_will_Expire));
                    }
                    this.fQq.a(hVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.fQz) {
            return false;
        }
        if (this.fQq.bom() == null || this.fQq.bom().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.fQq.aIl()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnY() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.cpJ == null) {
            this.cpJ = new com.baidu.tieba.write.e(getPageContext(), this.eNa);
            this.cpJ.sa("1");
        }
        if (this.fQq != null) {
            this.fQq.bop();
        }
        this.cpJ.ms(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIh() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.j.ab.Gh().ae(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int i = -1;
        if (getIntent() != null) {
            S(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
            String stringExtra = getIntent().getStringExtra("from");
            if (stringExtra != null && stringExtra.equals("from_tieba_kuang")) {
                TiebaStatic.log(new au("c12264").r("obj_type", 3));
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
        int i2 = i;
        this.isFirstGoMaintab = TbadkCoreApplication.m9getInst().isFirstGoMaintab();
        ac acVar = new ac();
        com.baidu.tbadk.core.e.b.a(acVar);
        acVar.a(this);
        if (bob()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(w.j.maintabs_activity);
        this.eNa = (FrameLayout) findViewById(w.h.maintabContainer);
        com.baidu.tbadk.core.a.a.oS().oT();
        this.fQq = new ad(this);
        this.fQq.lY(this.mIsLogin);
        bnX();
        apx();
        com.baidu.tieba.tblauncher.alarmRemind.b.bot().g(this);
        this.fQv = new com.baidu.tieba.a();
        aIh();
        aIB();
        bnZ();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_ACTIVE, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN));
        k(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.g.ar(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.m9getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), installOtherApp);
            TbadkCoreApplication.m9getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.m9getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new h(this));
        registerListener(this.dkS);
        if (i2 == 1) {
            this.fQq.ma(true);
        } else {
            this.fQq.ma(false);
        }
        this.fQq.bon();
        this.cci = getVoiceManager();
        if (this.cci != null) {
            this.cci.onCreate(getPageContext());
        }
        registerListener(this.duu);
        adjustResizeForSoftInput();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        com.baidu.tbadk.j.ab.Gh().af(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.j.ab.Gh().Gi();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.DT().DV();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_DOWNLAOD));
        registerListener(this.fQB);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.bjw = new CheckRealNameModel(getPageContext());
        this.bjw.a(this.fQC);
        boa();
    }

    private void bnZ() {
        be.vP().a(new i(this));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup oH() {
        return this.eNa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boa() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && com.baidu.adp.lib.util.k.hA()) {
            this.bjw.nC(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, false);
        }
    }

    private void S(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new au("c10320").r("obj_locate", 1).r("obj_type", 1));
                    return;
                }
                Matcher matcher = Pattern.compile(".*fr=(.*)").matcher(decode);
                if (matcher.find() && !"mpush".equals(matcher.group(1)) && "bpush".equals(matcher.group(1))) {
                    TiebaStatic.log(new au("c10320").r("obj_locate", 1).r("obj_type", 1));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.cci = getVoiceManager();
        if (this.cci != null) {
            this.cci.onStart(getPageContext());
        }
    }

    public boolean bob() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        apy();
        com.baidu.tbadk.coreExtra.messageCenter.a.yG().yT();
        com.baidu.tbadk.coreExtra.messageCenter.a.yG().yM();
        com.baidu.tbadk.coreExtra.messageCenter.a.yG().aS(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        boc();
        if (this.fQq != null) {
            this.fQq.boj();
            if (this.fQq.bom() != null) {
                this.fQq.bom().reset();
            }
            this.fQq.bop();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.cci = getVoiceManager();
        if (this.cci != null) {
            this.cci.onDestory(getPageContext());
        }
        if (this.cpJ != null) {
            this.cpJ.onDestroy();
        }
        System.gc();
    }

    private void boc() {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (currentFocus != null && currentFocus.getWindowToken() != null && (inputMethodManager = (InputMethodManager) getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
            Method method = null;
            try {
                method = InputMethodManager.class.getDeclaredMethod("windowDismissed", IBinder.class);
            } catch (NoSuchMethodException e) {
            } catch (SecurityException e2) {
            }
            if (method != null && currentFocus != null) {
                method.setAccessible(true);
                try {
                    method.invoke(inputMethodManager, currentFocus.getWindowToken());
                } catch (IllegalAccessException e3) {
                } catch (IllegalArgumentException e4) {
                } catch (InvocationTargetException e5) {
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    private void k(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void apx() {
        registerListener(this.fQw);
        this.fek.setPriority(100);
        registerListener(this.fek);
        registerListener(this.fQy);
        registerListener(this.fQA);
        registerListener(this.fQE);
        registerListener(this.fQF);
        registerListener(this.fQx);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.fQD);
        this.fQr = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.fQr, intentFilter);
    }

    private void apy() {
        if (this.fQr != null) {
            unregisterReceiver(this.fQr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(MainTabActivity mainTabActivity, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(TbConfig.getBroadcastActionNewVersion())) {
                TbadkCoreApplication.checkNeedShowNewVersion();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
        }
        this.fQm = this.fQq.bom().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.j.ab.Gh().Gg()) {
            com.baidu.tbadk.j.ab.Gh().Gi();
        }
        this.cci = getVoiceManager();
        if (this.cci != null) {
            this.cci.onResume(getPageContext());
        }
        if (this.fQq != null) {
            this.fQq.bon();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fQu = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.DT().DV();
            bnX();
            boa();
        }
        this.fQq.switchNaviBarStatus(z);
        aIh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.fQl) {
            this.fQl = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), w.a.down, w.a.hold);
        }
        this.cci = getVoiceManager();
        if (this.cci != null) {
            this.cci.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.fQq != null) {
            this.fQq.bop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.fQq.bom().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.cci = getVoiceManager();
        if (this.cci != null) {
            this.cci.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.cci = getVoiceManager();
        if (this.cci != null) {
            this.cci.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        S(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.DT().DV();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            aIh();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.m9getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15) {
            if (intExtra != 8 && intExtra != 3 && intExtra != 15) {
                intExtra = this.fQv.IR();
            }
            this.fQq.bom().setCurrentTabByType(intExtra);
        }
        k(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.fQq != null) {
            this.fQq.bon();
        }
        String stringExtra = getIntent().getStringExtra("from");
        if (stringExtra != null && stringExtra.equals("from_tieba_kuang")) {
            TiebaStatic.log(new au("c12264").r("obj_type", 3));
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    protected void B(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bX(w.l.confirm_title).as(false).bY(w.l.background_process_permission).a(w.l.now_goto_setting, new j(this)).b(w.l.next_time, new k(this)).b(com.baidu.adp.base.k.Z(activity)).ta();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bod() {
        com.baidu.adp.lib.f.c.fL().d(getUniqueId());
        bof();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.j
    public void onPreLoad(com.baidu.adp.widget.ListView.w wVar) {
        super.onPreLoad(wVar);
        com.baidu.tbadk.core.util.ai.a(wVar, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.cpJ != null && this.cpJ.isShowing()) {
                    this.cpJ.brz();
                    return true;
                } else if (this.fQq.aIl()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.fQo > 2000) {
                        showToast(w.l.double_back_quit);
                        this.fQo = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        B(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bod();
                    }
                    return false;
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Intent intent) {
        try {
            this.fQq.bom().setCurrentTabByType(this.fQv.IR());
        } catch (Throwable th) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyDown(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    private void aIB() {
        registerListener(new l(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    protected void boe() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i == 12007) {
                TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(w.l.login_home_tab), 11003)));
            }
            if (this.fQq.bom().getCurrentFragment() != null) {
                this.fQq.bom().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            boe();
        } else if (i == 13003) {
            Z(intent);
        } else if (this.fQq.bom().getCurrentFragment() != null) {
            this.fQq.bom().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fQq.onChangeSkinType(i);
        bt(i);
        if (this.cpJ != null) {
            this.cpJ.onChangeSkinType();
        }
    }

    private void Z(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT, postWriteCallBackData));
        }
    }

    private void bof() {
        if (System.currentTimeMillis() - this.fQp >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.fQp = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.b
    public int getCurrentTabType() {
        if (this.fQq.bom() != null) {
            return this.fQq.bom().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cci == null) {
            this.cci = VoiceManager.instance();
        }
        return this.cci;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wU() {
        if (this.anq == null) {
            this.anq = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.anq;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> agn() {
        if (this.fQt == null) {
            this.fQt = FrsCommonImageLayout.s(getPageContext().getPageActivity(), 12);
        }
        return this.fQt;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new m(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.fQu && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.fQu = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
