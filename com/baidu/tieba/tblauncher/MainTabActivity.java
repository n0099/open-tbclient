package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static long fwt = 259200000;
    private com.baidu.adp.lib.f.b<TbImageView> ahC;
    VoiceManager bQi;
    private boolean fwD;
    private ac fwr;
    private a fws;
    private com.baidu.adp.lib.f.b<TbImageView> fwv;
    private com.baidu.tieba.a fwx;
    private boolean isFirstGoMaintab;
    private boolean fwk = false;
    private int fwl = -1;
    private boolean fwm = false;
    private long fwn = 0;
    private long fwo = 0;
    private final long fwp = 2000;
    private final long fwq = 7200000;
    private Handler mHandler = null;
    private long fwu = -1;
    private boolean fww = false;
    private final CustomMessageListener fwy = new b(this, CmdConfigCustom.CMD_CLOSE_MATINTAB);
    private final CustomMessageListener fhL = new m(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener fwz = new n(this, CmdConfigCustom.CMD_SYNC_FINISH);
    private CustomMessageListener dns = new o(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private final CustomMessageListener fwA = new p(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final CustomMessageListener skinTypeChangeListener = new q(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final com.baidu.adp.framework.listener.e dhe = new r(this, 1001);
    private final CustomMessageListener cDM = new s(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cDN = new t(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private final CustomMessageListener fwB = new c(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener ePA = new d(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener fwC = new e(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener fwE = new f(this, CmdConfigCustom.MAINTAB_SET_INST);
    private CustomMessageListener dtq = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(String str) {
        if (str != null && TbadkCoreApplication.m9getInst().getConfigVersion() != null && bkJ()) {
            this.fwu = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean bkJ() {
        if (-1 == this.fwu) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.fwu;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void bkK() {
        registerListener(this.fhL);
    }

    private void aIk() {
        registerListener(new h(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ama() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.fwr.eW(true);
                long j = com.baidu.tbadk.core.sharedPref.b.tS().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.tS().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.fwr.eV(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            this.fwr.eW(false);
            this.fwr.eV(false);
            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("game_is_show_tip", false);
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && hVar != null) {
            if ((hVar.BY() == 1 || hVar.BY() == 2) && com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("show_member_deid_line", true)) {
                long oZ = hVar.oZ() * 1000;
                if (oZ < System.currentTimeMillis()) {
                    if (StringUtils.isNull(hVar.BZ())) {
                        hVar.fc(getPageContext().getString(t.j.member));
                    } else {
                        hVar.fc(String.valueOf(hVar.BZ()) + getPageContext().getString(t.j.member_already_Expire));
                    }
                    this.fwr.a(hVar, 0);
                } else if (oZ - System.currentTimeMillis() < fwt) {
                    if (StringUtils.isNull(hVar.BZ())) {
                        hVar.fc(getPageContext().getString(t.j.member));
                    } else {
                        hVar.fc(String.valueOf(hVar.BZ()) + getPageContext().getString(t.j.member_will_Expire));
                    }
                    this.fwr.a(hVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.fwD) {
            return false;
        }
        if (this.fwr.bkZ() == null || this.fwr.bkZ().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.fwr.aHU()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aHQ() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.e(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.ab.Gv().af(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        bkK();
        aIk();
        int i = -1;
        if (getIntent() != null) {
            B(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
        }
        int i2 = i;
        this.isFirstGoMaintab = TbadkCoreApplication.m9getInst().isFirstGoMaintab();
        this.mHandler = new Handler();
        ab abVar = new ab();
        com.baidu.tbadk.core.d.b.a(abVar);
        abVar.a(this);
        if (bkL()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(t.h.maintabs_activity);
        com.baidu.tbadk.core.a.a.oO().oP();
        this.fwr = new ac(this);
        this.fwr.kP(this.mIsLogin);
        ama();
        apx();
        com.baidu.tieba.tblauncher.alarmRemind.b.bld().h(this);
        this.fwx = new com.baidu.tieba.a();
        aHQ();
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
        f(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        String installOtherApp = TbadkCoreApplication.m9getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), installOtherApp);
            TbadkCoreApplication.m9getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.m9getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new i(this));
        registerListener(this.dhe);
        if (i2 == 1) {
            this.fwr.kQ(true);
        } else {
            this.fwr.kQ(false);
        }
        this.fwr.bla();
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onCreate(getPageContext());
        }
        registerListener(this.dtq);
        adjustResizeForSoftInput();
        com.baidu.tbadk.performanceLog.ab.Gv().ag(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.ab.Gv().Gw();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.Ec().Ee();
        }
        bkM();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean lX(int i) {
        switch (i) {
            case 0:
                return com.baidu.tbadk.coreExtra.messageCenter.c.yX().zf() || com.baidu.tbadk.coreExtra.messageCenter.c.yX().zm();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().ze()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zc()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zc()) {
                }
                return true;
            default:
                return true;
        }
    }

    public static int a(NewsNotifyMessage newsNotifyMessage) {
        int i;
        int i2;
        if (newsNotifyMessage == null) {
            return 0;
        }
        if (lX(0)) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        return ((lX(2) ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (lX(1) ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
    }

    private void B(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                TiebaStatic.log(new ay("c10320").s("obj_locate", 1).s("obj_type", 1));
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

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onStart(getPageContext());
        }
    }

    public boolean bkL() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        apy();
        com.baidu.tbadk.coreExtra.messageCenter.a.yA().yN();
        com.baidu.tbadk.coreExtra.messageCenter.a.yA().yG();
        com.baidu.tbadk.coreExtra.messageCenter.a.yA().aP(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.h.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        bkN();
        if (this.fwr != null) {
            this.fwr.aca();
            if (this.fwr.bkZ() != null) {
                this.fwr.bkZ().reset();
            }
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.d.b.a(null);
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onDestory(getPageContext());
        }
        System.gc();
    }

    private void bkM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_DOWNLAOD));
    }

    private void bkN() {
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

    private void f(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void apx() {
        registerListener(this.fwy);
        this.ePA.setPriority(100);
        registerListener(this.ePA);
        registerListener(this.fwC);
        registerListener(this.fwE);
        registerListener(this.cDM);
        registerListener(this.cDN);
        registerListener(this.fwB);
        registerListener(this.fwA);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.fwz);
        registerListener(this.dns);
        this.fws = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.fws, intentFilter);
    }

    private void apy() {
        if (this.fws != null) {
            unregisterReceiver(this.fws);
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
                refreshNewVersion();
            }
        }

        private void refreshNewVersion() {
            TbadkCoreApplication.checkNeedShowNewVersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TbadkCoreApplication.m9getInst().AddResumeNum();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
        }
        this.fwl = this.fwr.bkZ().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.ab.Gv().Gu()) {
            com.baidu.tbadk.performanceLog.ab.Gv().Gw();
        }
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onResume(getPageContext());
        }
        if (this.fwr != null) {
            this.fwr.bla();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fww = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.Ec().Ee();
        }
        this.fwr.switchNaviBarStatus(z);
        this.fwr.bkZ().setWidgetLayerVisibleNoAnimation(false);
        aHQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.fwk) {
            this.fwk = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), t.a.down, t.a.hold);
        }
        TbadkCoreApplication.m9getInst().DelResumeNum();
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.fwr.bkZ().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        B(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            bkO();
        }
        com.baidu.tbadk.getUserInfo.b.Ec().Ee();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.fwr.bkZ().setWidgetLayerVisibleNoAnimation(false);
            aHQ();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.m9getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8) {
            if (intExtra != 8) {
                intExtra = this.fwx.IW();
            }
            this.fwr.bkZ().setCurrentTabByType(intExtra);
        }
        f(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.fwr != null) {
            this.fwr.bla();
        }
    }

    private void bkO() {
    }

    protected void x(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bY(t.j.confirm_title).aq(false).bZ(t.j.background_process_permission).a(t.j.now_goto_setting, new j(this)).b(t.j.next_time, new k(this)).b(com.baidu.adp.base.l.C(activity)).sX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bkP() {
        com.baidu.adp.lib.g.c.eA().d(getUniqueId());
        bkR();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.k
    public void onPreLoad(BdListView bdListView) {
        super.onPreLoad(bdListView);
        com.baidu.tbadk.core.util.aj.a(bdListView, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.fwr.aHU()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    }
                    if (System.currentTimeMillis() - this.fwn > 2000) {
                        showToast(t.j.double_back_quit);
                        this.fwn = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        x(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bkP();
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Intent intent) {
        try {
            this.fwr.bkZ().setCurrentTabByType(this.fwx.IW());
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

    protected void bkQ() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
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
                TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(t.j.login_home_tab), 11003)));
            }
            if (this.fwr.bkZ().getCurrentFragment() != null) {
                this.fwr.bkZ().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bkQ();
        } else if (this.fwr.bkZ().getCurrentFragment() != null) {
            this.fwr.bkZ().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fwr.onChangeSkinType(i);
        by(i);
    }

    private void bkR() {
        if (System.currentTimeMillis() - this.fwo >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.fwo = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.fwr.bkZ() != null) {
            return this.fwr.bkZ().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bQi == null) {
            this.bQi = VoiceManager.instance();
        }
        return this.bQi;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int wE() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wF() {
        if (this.ahC == null) {
            this.ahC = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.ahC;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> aaC() {
        if (this.fwv == null) {
            this.fwv = FrsCommonImageLayout.p(getPageContext().getPageActivity(), 12);
        }
        return this.fwv;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new l(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.fww && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.fww = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
