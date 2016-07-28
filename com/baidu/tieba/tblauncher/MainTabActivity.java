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
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.u;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static long foA = 259200000;
    private com.baidu.adp.lib.f.b<TbImageView> aeH;
    VoiceManager bEE;
    private com.baidu.adp.lib.f.b<TbImageView> esJ;
    private com.baidu.tieba.a foD;
    private boolean foJ;
    private ab foy;
    private a foz;
    private boolean isFirstGoMaintab;
    private boolean foq = false;

    /* renamed from: for  reason: not valid java name */
    private int f1for = -1;
    private boolean fot = false;
    private long fou = 0;
    private long fov = 0;
    private final long fow = 2000;
    private final long fox = 7200000;
    private Handler mHandler = null;
    private long foB = -1;
    private boolean foC = false;
    private final CustomMessageListener foE = new b(this, CmdConfigCustom.CMD_CLOSE_MATINTAB);
    private final CustomMessageListener eZz = new m(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener foF = new n(this, CmdConfigCustom.CMD_SYNC_FINISH);
    private CustomMessageListener dbK = new o(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private final CustomMessageListener foG = new p(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final CustomMessageListener skinTypeChangeListener = new q(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final com.baidu.adp.framework.listener.e cVu = new r(this, 1001);
    private final CustomMessageListener csE = new s(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener csF = new t(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private final CustomMessageListener foH = new c(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener eIq = new d(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener foI = new e(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener foK = new f(this, CmdConfigCustom.MAINTAB_SET_INST);
    private CustomMessageListener dhL = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    /* JADX INFO: Access modifiers changed from: private */
    public void qA(String str) {
        if (str != null && TbadkCoreApplication.m10getInst().getConfigVersion() != null && bhh()) {
            this.foB = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean bhh() {
        if (-1 == this.foB) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.foB;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void bhi() {
        registerListener(this.eZz);
    }

    private void aDw() {
        registerListener(new h(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahp() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m10getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.foy.eA(true);
                long j = com.baidu.tbadk.core.sharedPref.b.sN().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.sN().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.foy.ez(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            this.foy.eA(false);
            this.foy.ez(false);
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("game_is_show_tip", false);
        }
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && hVar != null) {
            if ((hVar.AJ() == 1 || hVar.AJ() == 2) && com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("show_member_deid_line", true)) {
                long od = hVar.od() * 1000;
                if (od < System.currentTimeMillis()) {
                    if (StringUtils.isNull(hVar.AK())) {
                        hVar.eZ(getPageContext().getString(u.j.member));
                    } else {
                        hVar.eZ(String.valueOf(hVar.AK()) + getPageContext().getString(u.j.member_already_Expire));
                    }
                    this.foy.a(hVar, 0);
                } else if (od - System.currentTimeMillis() < foA) {
                    if (StringUtils.isNull(hVar.AK())) {
                        hVar.eZ(getPageContext().getString(u.j.member));
                    } else {
                        hVar.eZ(String.valueOf(hVar.AK()) + getPageContext().getString(u.j.member_will_Expire));
                    }
                    this.foy.a(hVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.foJ) {
            return false;
        }
        if (this.foy.bhv() == null || this.foy.bhv().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.foy.aDg()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDc() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.e(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.ab.Fb().ab(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        bhi();
        aDw();
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
        this.isFirstGoMaintab = TbadkCoreApplication.m10getInst().isFirstGoMaintab();
        this.mHandler = new Handler();
        aa aaVar = new aa();
        com.baidu.tbadk.core.d.b.a(aaVar);
        aaVar.a(this);
        if (bhj()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(u.h.maintabs_activity);
        com.baidu.tbadk.core.a.a.nT().nU();
        this.foy = new ab(this);
        this.foy.kD(this.mIsLogin);
        ahp();
        akI();
        com.baidu.tieba.tblauncher.alarmRemind.b.bhz().i(this);
        this.foD = new com.baidu.tieba.a();
        aDc();
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
        String installOtherApp = TbadkCoreApplication.m10getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.m10getInst().getApp(), installOtherApp);
            TbadkCoreApplication.m10getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.m10getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new i(this));
        registerListener(this.cVu);
        if (i2 == 1) {
            this.foy.kE(true);
        } else {
            this.foy.kE(false);
        }
        this.foy.bhw();
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onCreate(getPageContext());
        }
        registerListener(this.dhL);
        adjustResizeForSoftInput();
        com.baidu.tbadk.performanceLog.ab.Fb().ac(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.ab.Fb().Fc();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.CH().CJ();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean lu(int i) {
        switch (i) {
            case 0:
                return com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS() || com.baidu.tbadk.coreExtra.messageCenter.c.xK().xZ();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xR()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xP()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xP()) {
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
        if (lu(0)) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        return ((lu(2) ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (lu(1) ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
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
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onStart(getPageContext());
        }
    }

    public boolean bhj() {
        return TbadkCoreApplication.m10getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        akJ();
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().xA();
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().xt();
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().aN(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.h.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        bhk();
        if (this.foy != null) {
            this.foy.Xd();
            if (this.foy.bhv() != null) {
                this.foy.bhv().reset();
            }
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.d.b.a(null);
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onDestory(getPageContext());
        }
        System.gc();
    }

    private void bhk() {
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

    private void akI() {
        registerListener(this.foE);
        this.eIq.setPriority(100);
        registerListener(this.eIq);
        registerListener(this.foI);
        registerListener(this.foK);
        registerListener(this.csE);
        registerListener(this.csF);
        registerListener(this.foH);
        registerListener(this.foG);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.foF);
        registerListener(this.dbK);
        this.foz = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.foz, intentFilter);
    }

    private void akJ() {
        if (this.foz != null) {
            unregisterReceiver(this.foz);
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
        TbadkCoreApplication.m10getInst().AddResumeNum();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
        }
        this.f1for = this.foy.bhv().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.ab.Fb().Fa()) {
            com.baidu.tbadk.performanceLog.ab.Fb().Fc();
        }
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onResume(getPageContext());
        }
        if (this.foy != null) {
            this.foy.bhw();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.foC = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.CH().CJ();
        }
        this.foy.switchNaviBarStatus(z);
        this.foy.bhv().setWidgetLayerVisibleNoAnimation(false);
        aDc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.foq) {
            this.foq = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), u.a.down, u.a.hold);
        }
        TbadkCoreApplication.m10getInst().DelResumeNum();
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.foy.bhv().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        B(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            bhl();
        }
        com.baidu.tbadk.getUserInfo.b.CH().CJ();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.foy.bhv().setWidgetLayerVisibleNoAnimation(false);
            aDc();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.m10getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8) {
            if (intExtra != 8) {
                intExtra = this.foD.HD();
            }
            this.foy.bhv().setCurrentTabByType(intExtra);
        }
        f(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.foy != null) {
            this.foy.bhw();
        }
    }

    private void bhl() {
    }

    protected void t(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bL(u.j.confirm_title).ap(false).bM(u.j.background_process_permission).a(u.j.now_goto_setting, new j(this)).b(u.j.next_time, new k(this)).b(com.baidu.adp.base.l.s(activity)).rS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhm() {
        com.baidu.adp.lib.g.c.dF().d(getUniqueId());
        bho();
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
                    if (this.foy.aDg()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    }
                    if (System.currentTimeMillis() - this.fou > 2000) {
                        showToast(u.j.double_back_quit);
                        this.fou = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        t(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bhm();
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
            this.foy.bhv().setCurrentTabByType(this.foD.HD());
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

    protected void bhn() {
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
                TbadkCoreApplication.m10getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(u.j.login_home_tab), 11003)));
            }
            if (this.foy.bhv().getCurrentFragment() != null) {
                this.foy.bhv().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bhn();
        } else if (this.foy.bhv().getCurrentFragment() != null) {
            this.foy.bhv().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.foy.onChangeSkinType(i);
        bl(i);
    }

    private void bho() {
        if (System.currentTimeMillis() - this.fov >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.fov = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.foy.bhv() != null) {
            return this.foy.bhv().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bEE == null) {
            this.bEE = VoiceManager.instance();
        }
        return this.bEE;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vA() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vB() {
        if (this.aeH == null) {
            this.aeH = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.aeH;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> VH() {
        if (this.esJ == null) {
            this.esJ = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.esJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new l(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.foC && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.foC = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
