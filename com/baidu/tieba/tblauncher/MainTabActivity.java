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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
    private static long ewG = 259200000;
    private com.baidu.adp.lib.f.b<TbImageView> adv;
    VoiceManager beZ;
    private com.baidu.adp.lib.f.b<TbImageView> dzY;
    private ab ewE;
    private a ewF;
    private boolean ewO;
    private boolean isFirstGoMaintab;
    private boolean ewx = false;
    private int ewy = -1;
    private boolean isUserChanged = false;
    private boolean ewz = false;
    private long ewA = 0;
    private long ewB = 0;
    private final long ewC = 2000;
    private final long ewD = 7200000;
    private Handler mHandler = null;
    private long ewH = -1;
    private boolean ewI = false;
    private final CustomMessageListener ewJ = new b(this, CmdConfigCustom.CMD_CLOSE_MATINTAB);
    private final CustomMessageListener ehP = new k(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener ewK = new n(this, CmdConfigCustom.CMD_SYNC_FINISH);
    private CustomMessageListener ctx = new o(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private final CustomMessageListener ewL = new p(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final CustomMessageListener skinTypeChangeListener = new q(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final com.baidu.adp.framework.listener.e cnk = new r(this, 1001);
    private final CustomMessageListener dZg = new s(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener dZh = new t(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private final CustomMessageListener ewM = new c(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener dND = new d(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener ewN = new e(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener ewP = new f(this, CmdConfigCustom.MAINTAB_SET_INST);
    private CustomMessageListener czq = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(String str) {
        if (str != null && TbadkCoreApplication.m11getInst().getConfigVersion() != null && aVv()) {
            this.ewH = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean aVv() {
        if (-1 == this.ewH) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.ewH;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void aVw() {
        registerListener(this.ehP);
    }

    private void aun() {
        registerListener(new h(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMm() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m11getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.ewE.iP(true);
                long j = com.baidu.tbadk.core.sharedPref.b.sQ().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.sQ().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.ewE.iO(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            this.ewE.iP(false);
            this.ewE.iO(false);
            com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("game_is_show_tip", false);
        }
    }

    public void a(com.baidu.tbadk.data.g gVar) {
        if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && gVar != null) {
            if ((gVar.Az() == 1 || gVar.Az() == 2) && com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("show_member_deid_line", true)) {
                long ot = gVar.ot() * 1000;
                if (ot < System.currentTimeMillis()) {
                    if (StringUtils.isNull(gVar.AA())) {
                        gVar.eV(getPageContext().getString(t.j.member));
                    } else {
                        gVar.eV(String.valueOf(gVar.AA()) + getPageContext().getString(t.j.member_already_Expire));
                    }
                    this.ewE.a(gVar, 0);
                } else if (ot - System.currentTimeMillis() < ewG) {
                    if (StringUtils.isNull(gVar.AA())) {
                        gVar.eV(getPageContext().getString(t.j.member));
                    } else {
                        gVar.eV(String.valueOf(gVar.AA()) + getPageContext().getString(t.j.member_will_Expire));
                    }
                    this.ewE.a(gVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.ewO) {
            return false;
        }
        if (this.ewE.aVL() == null || this.ewE.aVL().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.ewE.atX()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atT() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.e(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.ab.ES().ad(System.currentTimeMillis());
        af(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aVw();
        aun();
        int i = -1;
        if (getIntent() != null) {
            x(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
        }
        int i2 = i;
        this.isFirstGoMaintab = TbadkCoreApplication.m11getInst().isFirstGoMaintab();
        this.mHandler = new Handler();
        aa aaVar = new aa();
        com.baidu.tbadk.core.e.b.a(aaVar);
        aaVar.a(this);
        if (aVx()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(t.h.maintabs_activity);
        com.baidu.tbadk.core.a.a.oj().ok();
        this.ewE = new ab(this);
        this.ewE.jE(this.mIsLogin);
        aMm();
        abK();
        com.baidu.tieba.tblauncher.alarmRemind.b.aVP().g(this);
        atT();
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
        f(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        String installOtherApp = TbadkCoreApplication.m11getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.m11getInst().getApp(), installOtherApp);
            TbadkCoreApplication.m11getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.m11getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new i(this));
        registerListener(this.cnk);
        if (i2 == 1) {
            this.ewE.jF(true);
            this.ewE.jG(true);
        } else {
            this.ewE.jF(false);
            this.ewE.jG(false);
        }
        this.ewE.aVM();
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onCreate(getPageContext());
        }
        registerListener(this.czq);
        adjustResizeForSoftInput();
        com.baidu.tbadk.performanceLog.ab.ES().ae(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.ab.ES().ET();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean jN(int i) {
        switch (i) {
            case 0:
                return com.baidu.tbadk.coreExtra.messageCenter.c.xF().xN() || com.baidu.tbadk.coreExtra.messageCenter.c.xF().xU();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().xM()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().xK()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().xK()) {
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
        if (jN(0)) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        return ((jN(2) ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (jN(1) ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
    }

    private void x(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10320").s("obj_locate", 1).s("obj_type", 1));
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
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onStart(getPageContext());
        }
    }

    public boolean aVx() {
        return TbadkCoreApplication.m11getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        abL();
        com.baidu.tbadk.coreExtra.messageCenter.a.xi().xv();
        com.baidu.tbadk.coreExtra.messageCenter.a.xi().xo();
        com.baidu.tbadk.coreExtra.messageCenter.a.xi().aM(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.h.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        aVy();
        if (this.ewE != null) {
            this.ewE.aVG();
            if (this.ewE.aVL() != null) {
                this.ewE.aVL().reset();
            }
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onDestory(getPageContext());
        }
        System.gc();
    }

    private void aVy() {
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

    private void abK() {
        registerListener(this.ewJ);
        this.dND.setPriority(100);
        registerListener(this.dND);
        registerListener(this.ewN);
        registerListener(this.ewP);
        registerListener(this.dZg);
        registerListener(this.dZh);
        registerListener(this.ewM);
        registerListener(this.ewL);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.ewK);
        registerListener(this.ctx);
        this.ewF = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.ewF, intentFilter);
    }

    private void abL() {
        if (this.ewF != null) {
            unregisterReceiver(this.ewF);
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
        TbadkCoreApplication.m11getInst().AddResumeNum();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
        }
        this.ewy = this.ewE.aVL().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.ab.ES().ER()) {
            com.baidu.tbadk.performanceLog.ab.ES().ET();
        }
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onResume(getPageContext());
        }
        if (this.ewE != null) {
            this.ewE.aVM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.ewI = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.Cz().CB();
        }
        this.ewE.switchNaviBarStatus(z);
        this.ewE.aVL().setWidgetLayerVisibleNoAnimation(false);
        this.isUserChanged = true;
        atT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.ewx) {
            this.ewx = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), t.a.down, t.a.hold);
        }
        TbadkCoreApplication.m11getInst().DelResumeNum();
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.ewE.aVL().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            aVz();
        }
        com.baidu.tbadk.getUserInfo.b.Cz().CB();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.ewE.aVL().setWidgetLayerVisibleNoAnimation(false);
            atT();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.m11getInst().notifyAppEnterBackground();
            finish();
        } else {
            this.ewE.aVL().setCurrentTabByType(intExtra);
        }
        f(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.ewE != null) {
            this.ewE.aVM();
        }
    }

    private void aVz() {
    }

    protected void r(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bL(t.j.confirm_title).ap(false).bM(t.j.background_process_permission).a(t.j.now_goto_setting, new j(this)).b(t.j.next_time, new l(this)).b(com.baidu.adp.base.l.s(activity)).rU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aVA() {
        com.baidu.adp.lib.g.c.dF().d(getUniqueId());
        aVC();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.k
    public void onPreLoad(BdListView bdListView) {
        super.onPreLoad(bdListView);
        com.baidu.tbadk.core.util.ai.a(bdListView, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.ewE.atX()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    }
                    if (System.currentTimeMillis() - this.ewA > 2000) {
                        showToast(t.j.double_back_quit);
                        this.ewA = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        r(getPageContext().getPageActivity());
                        return true;
                    } else {
                        aVA();
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
    public void y(Intent intent) {
        try {
            this.ewE.aVL().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void aVB() {
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
                TbadkCoreApplication.m11getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(t.j.login_home_tab), 11003)));
            }
            if (this.ewE.aVL().getCurrentFragment() != null) {
                this.ewE.aVL().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            aVB();
        } else if (this.ewE.aVL().getCurrentFragment() != null) {
            this.ewE.aVL().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.ewE.onChangeSkinType(i);
        bi(i);
    }

    private void aVC() {
        if (System.currentTimeMillis() - this.ewB >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.ewB = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.ewE.aVL() != null) {
            return this.ewE.aVL().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.beZ == null) {
            this.beZ = VoiceManager.instance();
        }
        return this.beZ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vx() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vy() {
        if (this.adv == null) {
            this.adv = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.adv;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Po() {
        if (this.dzY == null) {
            this.dzY = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.dzY;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new m(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.ewI && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.ewI = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
