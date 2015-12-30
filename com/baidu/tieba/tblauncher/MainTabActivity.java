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
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static long dKA = 259200000;
    private com.baidu.adp.lib.f.b<TbImageView> agI;
    private com.baidu.adp.lib.f.b<TbImageView> dKC;
    private boolean dKI;
    private w dKy;
    private a dKz;
    private boolean isFirstGoMaintab;
    VoiceManager mVoiceManager;
    private boolean dKr = false;
    private int dKs = -1;
    private boolean isUserChanged = false;
    private boolean dKt = false;
    private long dKu = 0;
    private long dKv = 0;
    private final long dKw = 2000;
    private final long dKx = 7200000;
    private Handler mHandler = null;
    private long dKB = -1;
    private final CustomMessageListener dKD = new b(this, CmdConfigCustom.CMD_CLOSE_MATINTAB);
    private final CustomMessageListener dwb = new i(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener dKE = new j(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final CustomMessageListener skinTypeChangeListener = new k(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final com.baidu.adp.framework.listener.e bXo = new l(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    private final CustomMessageListener aRN = new m(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener dKF = new n(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private final CustomMessageListener dKG = new o(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener dcT = new p(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener dKH = new c(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener dKJ = new d(this, CmdConfigCustom.MAINTAB_SET_INST);

    /* JADX INFO: Access modifiers changed from: private */
    public void mH(String str) {
        if (str != null && TbadkCoreApplication.m411getInst().getConfigVersion() != null && aGU()) {
            this.dKB = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean aGU() {
        if (-1 == this.dKB) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.dKB;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void aGV() {
        registerListener(this.dwb);
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new e(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGW() {
        boolean z = true;
        if (MainTabActivityStatic.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (MainTabActivityStatic.getGame().hasGameCenter != null && MainTabActivityStatic.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.dKy.hz(true);
                long j = com.baidu.tbadk.core.sharedPref.b.tJ().getLong("game_last_time", 0L);
                if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.tJ().putLong("game_last_time", MainTabActivityStatic.getGame().gameLastLaunchtime.longValue());
                } else if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.dKy.hB(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            this.dKy.hz(false);
            this.dKy.hB(false);
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("game_is_show_tip", false);
        }
    }

    public void a(com.baidu.tbadk.data.e eVar) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && eVar != null) {
            if ((eVar.AK() == 1 || eVar.AK() == 2) && com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("show_member_deid_line", true)) {
                long ri = eVar.ri() * 1000;
                if (ri < System.currentTimeMillis()) {
                    if (StringUtils.isNull(eVar.AL())) {
                        eVar.eS(getPageContext().getString(n.j.member));
                    } else {
                        eVar.eS(String.valueOf(eVar.AL()) + getPageContext().getString(n.j.member_already_Expire));
                    }
                    this.dKy.a(eVar, 0);
                } else if (ri - System.currentTimeMillis() < dKA) {
                    if (StringUtils.isNull(eVar.AL())) {
                        eVar.eS(getPageContext().getString(n.j.member));
                    } else {
                        eVar.eS(String.valueOf(eVar.AL()) + getPageContext().getString(n.j.member_will_Expire));
                    }
                    this.dKy.a(eVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.dKI) {
            return false;
        }
        if (this.dKy.aHi() == null || this.dKy.aHi().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.dKy.ajc()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiY() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.z.EN().V(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aGV();
        registerNavigationBarEditStateListener();
        int i = -1;
        if (getIntent() != null) {
            U(getIntent());
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
        if (aGX()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(n.h.maintabs_activity);
        com.baidu.tbadk.core.a.a.qY().qZ();
        this.dKy = new w(this);
        this.dKy.hy(this.mIsLogin);
        aGW();
        regReceiver();
        com.baidu.tieba.tblauncher.alarmRemind.b.aHm().d(this);
        aiY();
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
        registerListener(this.bXo);
        if (i2 == 1) {
            this.dKy.hA(true);
        } else {
            this.dKy.hA(false);
        }
        this.dKy.aHj();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onCreate(getPageContext());
        }
        adjustResizeForSoftInput();
        com.baidu.tbadk.performanceLog.z.EN().W(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.z.EN().EO();
        }
    }

    private void U(Intent intent) {
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

    public boolean aGX() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        unregReceiver();
        com.baidu.tbadk.coreExtra.messageCenter.a.xv().xI();
        com.baidu.tbadk.coreExtra.messageCenter.a.xv().xB();
        com.baidu.tbadk.coreExtra.messageCenter.a.xv().aA(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.h.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        aGY();
        if (this.dKy != null && this.dKy.aHi() != null) {
            this.dKy.aHi().reset();
        }
        super.onDestroy();
        com.baidu.tbadk.core.c.b.a(null);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        System.gc();
    }

    private void aGY() {
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
        registerListener(this.dKD);
        this.dcT.setPriority(100);
        registerListener(this.dcT);
        registerListener(this.dKH);
        registerListener(this.dKJ);
        registerListener(this.aRN);
        registerListener(this.dKF);
        registerListener(this.dKG);
        registerListener(this.dKE);
        registerListener(this.skinTypeChangeListener);
        this.dKz = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.dKz, intentFilter);
    }

    private void unregReceiver() {
        if (this.dKz != null) {
            unregisterReceiver(this.dKz);
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
        this.dKs = this.dKy.aHi().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.z.EN().EM()) {
            com.baidu.tbadk.performanceLog.z.EN().EO();
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        if (this.dKy != null) {
            this.dKy.aHj();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            com.baidu.tbadk.getUserInfo.b.CE().CG();
        }
        this.dKy.switchNaviBarStatus(z);
        this.dKy.aHi().setWidgetLayerVisibleNoAnimation(false);
        this.isUserChanged = true;
        aiY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.dKr) {
            this.dKr = false;
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
        bundle.putInt("locate_type", this.dKy.aHi().getCurrentTabType());
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
        U(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            aGZ();
        }
        com.baidu.tbadk.getUserInfo.b.CE().CG();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.dKy.aHi().setWidgetLayerVisibleNoAnimation(false);
            aiY();
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
            this.dKy.aHi().setCurrentTabByType(intExtra);
        }
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.dKy != null) {
            this.dKy.aHj();
        }
    }

    private void aGZ() {
    }

    protected void v(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bF(n.j.confirm_title).ai(false).bG(n.j.background_process_permission).a(n.j.now_goto_setting, new g(this)).b(n.j.next_time, new h(this)).b(com.baidu.adp.base.l.C(activity)).tf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aHa() {
        com.baidu.adp.lib.g.c.hd().d(getUniqueId());
        aHc();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.k
    public void onPreLoad(BdListView bdListView) {
        super.onPreLoad(bdListView);
        com.baidu.tbadk.core.util.ah.a(bdListView, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.dKy.ajc()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    }
                    if (System.currentTimeMillis() - this.dKu > 2000) {
                        showToast(n.j.double_back_quit);
                        this.dKu = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        v(getPageContext().getPageActivity());
                        return true;
                    } else {
                        aHa();
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
    public void V(Intent intent) {
        try {
            this.dKy.aHi().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void aHb() {
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
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(n.j.login_home_tab), 11003)));
            }
            if (this.dKy.aHi().getCurrentFragment() != null) {
                this.dKy.aHi().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            aHb();
        } else if (this.dKy.aHi().getCurrentFragment() != null) {
            this.dKy.aHi().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.dKy.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
    }

    private void aHc() {
        if (System.currentTimeMillis() - this.dKv >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.dKv = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.dKy.aHi() != null) {
            return this.dKy.aHi().getCurrentTabType();
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

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vU() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vV() {
        if (this.agI == null) {
            this.agI = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.agI;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> MH() {
        if (this.dKC == null) {
            this.dKC = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.dKC;
    }
}
