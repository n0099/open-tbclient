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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements VoiceManager.c, com.baidu.tieba.tblauncher.a {
    private static long dCY = 259200000;
    private w dCW;
    private a dCX;
    private boolean dDf;
    private boolean isFirstGoMaintab;
    VoiceManager mVoiceManager;
    private boolean dCP = false;
    private int dCQ = -1;
    private boolean isUserChanged = false;
    private boolean dCR = false;
    private long dCS = 0;
    private long dCT = 0;
    private final long dCU = 2000;
    private final long dCV = 7200000;
    private Handler mHandler = null;
    private long dCZ = -1;
    private final CustomMessageListener dDa = new b(this, CmdConfigCustom.CMD_CLOSE_MATINTAB);
    private final CustomMessageListener doO = new i(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener dDb = new j(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final CustomMessageListener skinTypeChangeListener = new k(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final com.baidu.adp.framework.listener.e bTC = new l(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    private final CustomMessageListener aNV = new m(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener dDc = new n(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private final CustomMessageListener dDd = new o(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener cXO = new p(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener dDe = new c(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener dDg = new d(this, CmdConfigCustom.MAINTAB_SET_INST);

    /* JADX INFO: Access modifiers changed from: private */
    public void mK(String str) {
        if (str != null && TbadkCoreApplication.m411getInst().getConfigVersion() != null && aEG()) {
            this.dCZ = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean aEG() {
        if (-1 == this.dCZ) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.dCZ;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void aEH() {
        registerListener(this.doO);
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new e(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEI() {
        boolean z = true;
        if (MainTabActivityStatic.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (MainTabActivityStatic.getGame().hasGameCenter != null && MainTabActivityStatic.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.dCW.hq(true);
                long j = com.baidu.tbadk.core.sharedPref.b.tZ().getLong("game_last_time", 0L);
                if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.tZ().putLong("game_last_time", MainTabActivityStatic.getGame().gameLastLaunchtime.longValue());
                } else if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.dCW.hs(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            this.dCW.hq(false);
            this.dCW.hs(false);
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("game_is_show_tip", false);
        }
    }

    public void a(com.baidu.tbadk.data.e eVar) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && eVar != null) {
            if ((eVar.AU() == 1 || eVar.AU() == 2) && com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("show_member_deid_line", true)) {
                long rz = eVar.rz() * 1000;
                if (rz < System.currentTimeMillis()) {
                    if (StringUtils.isNull(eVar.AV())) {
                        eVar.eP(getPageContext().getString(n.i.member));
                    } else {
                        eVar.eP(String.valueOf(eVar.AV()) + getPageContext().getString(n.i.member_already_Expire));
                    }
                    this.dCW.a(eVar, 0);
                } else if (rz - System.currentTimeMillis() < dCY) {
                    if (StringUtils.isNull(eVar.AV())) {
                        eVar.eP(getPageContext().getString(n.i.member));
                    } else {
                        eVar.eP(String.valueOf(eVar.AV()) + getPageContext().getString(n.i.member_will_Expire));
                    }
                    this.dCW.a(eVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.dDf) {
            return false;
        }
        if (this.dCW.aEU() == null || this.dCW.aEU().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.dCW.ahS()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahO() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.z.EY().U(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aEH();
        registerNavigationBarEditStateListener();
        int i = -1;
        if (getIntent() != null) {
            V(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
        }
        int i2 = i;
        this.isFirstGoMaintab = TbadkCoreApplication.m411getInst().isFirstGoMaintab();
        this.mHandler = new Handler();
        v vVar = new v();
        com.baidu.tbadk.core.c.b.a(vVar);
        vVar.a(this);
        if (aEJ()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(n.g.maintabs_activity);
        com.baidu.tbadk.core.a.a.rp().rq();
        this.dCW = new w(this);
        this.dCW.hp(this.mIsLogin);
        aEI();
        regReceiver();
        com.baidu.tieba.tblauncher.alarmRemind.b.aEX().c(this);
        ahO();
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
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        String installOtherApp = TbadkCoreApplication.m411getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), installOtherApp);
            TbadkCoreApplication.m411getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.m411getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new f(this));
        registerListener(this.bTC);
        if (i2 == 1) {
            this.dCW.hr(true);
        } else {
            this.dCW.hr(false);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onCreate(getPageContext());
        }
        com.baidu.tbadk.performanceLog.z.EY().V(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.z.EY().EZ();
        }
    }

    private void V(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                TiebaStatic.log(new av("c10320").r("obj_locate", 1).r("obj_type", 1));
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
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    public boolean aEJ() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        unregReceiver();
        com.baidu.tbadk.coreExtra.messageCenter.a.xJ().xW();
        com.baidu.tbadk.coreExtra.messageCenter.a.xJ().xP();
        com.baidu.tbadk.coreExtra.messageCenter.a.xJ().aD(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.h.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        aEK();
        if (this.dCW != null && this.dCW.aEU() != null) {
            this.dCW.aEU().reset();
        }
        super.onDestroy();
        com.baidu.tbadk.core.c.b.a(null);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        System.gc();
    }

    private void aEK() {
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

    private void j(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void regReceiver() {
        registerListener(this.dDa);
        this.cXO.setPriority(100);
        registerListener(this.cXO);
        registerListener(this.dDe);
        registerListener(this.dDg);
        registerListener(this.aNV);
        registerListener(this.dDc);
        registerListener(this.dDd);
        registerListener(this.dDb);
        registerListener(this.skinTypeChangeListener);
        this.dCX = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.dCX, intentFilter);
    }

    private void unregReceiver() {
        if (this.dCX != null) {
            unregisterReceiver(this.dCX);
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
        TbadkCoreApplication.m411getInst().AddResumeNum();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
        }
        this.dCQ = this.dCW.aEU().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.z.EY().EX()) {
            com.baidu.tbadk.performanceLog.z.EY().EZ();
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            com.baidu.tbadk.getUserInfo.b.CP().CR();
        }
        this.dCW.switchNaviBarStatus(z);
        this.dCW.aEU().setWidgetLayerVisibleNoAnimation(false);
        this.isUserChanged = true;
        ahO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.dCP) {
            this.dCP = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), n.a.down, n.a.hold);
        }
        TbadkCoreApplication.m411getInst().DelResumeNum();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.dCW.aEU().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        V(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            aEL();
        }
        com.baidu.tbadk.getUserInfo.b.CP().CR();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.dCW.aEU().setWidgetLayerVisibleNoAnimation(false);
            ahO();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.m411getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8) {
            this.dCW.aEU().setCurrentTabByType(intExtra);
        }
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void aEL() {
    }

    protected void u(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bM(n.i.confirm_title).al(false).bN(n.i.background_process_permission).a(n.i.now_goto_setting, new g(this)).b(n.i.next_time, new h(this)).b(com.baidu.adp.base.l.C(activity)).tv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aEM() {
        com.baidu.adp.lib.g.c.hd().d(getUniqueId());
        aEO();
        moveTaskToBack(true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.dCW.ahS()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                }
                if (System.currentTimeMillis() - this.dCS > 2000) {
                    showToast(n.i.double_back_quit);
                    this.dCS = System.currentTimeMillis();
                } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                    u(getPageContext().getPageActivity());
                    return true;
                } else {
                    aEM();
                }
                return false;
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Intent intent) {
        try {
            this.dCW.aEU().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void aEN() {
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
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(n.i.login_home_tab), 11003)));
            }
            if (this.dCW.aEU().getCurrentFragment() != null) {
                this.dCW.aEU().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            aEN();
        } else if (this.dCW.aEU().getCurrentFragment() != null) {
            this.dCW.aEU().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.dCW.onChangeSkinType(i);
    }

    private void aEO() {
        if (System.currentTimeMillis() - this.dCT >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.dCT = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.dCW.aEU() != null) {
            return this.dCW.aEU().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }
}
