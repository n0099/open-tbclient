package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tieba.tblauncher.a {
    private boolean cUP;
    private am cUv;
    private boolean isFirstGoMaintab;
    public static boolean cUl = true;
    private static long cUI = 259200000;
    private PopupWindow cUm = null;
    private boolean cUn = false;
    private int cUo = -1;
    private boolean cUp = false;
    private boolean cUq = false;
    private long cUr = 0;
    private long cUs = 0;
    private final long cUt = 2000;
    private final long cUu = 7200000;
    private a cUw = null;
    private int cUx = 0;
    private int cUy = 0;
    private int cUz = 0;
    private int cUA = 0;
    private int cUB = 0;
    private boolean cUC = false;
    private boolean cUD = false;
    private boolean mHasNewVersion = false;
    private boolean cUE = false;
    private boolean cUF = false;
    private boolean cUG = false;
    private boolean cUH = false;
    private Handler mHandler = null;
    private long cUJ = -1;
    private final CustomMessageListener cHw = new b(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener cUK = new m(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final com.baidu.adp.framework.listener.e bAO = new v(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    final CustomMessageListener cUL = new aa(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private final CustomMessageListener aLx = new ab(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cUM = new ac(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private final CustomMessageListener cUN = new ad(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener mAddTablistener = new ae(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener cUO = new af(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener cUQ = new c(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private final CustomMessageListener cUR = new d(this, CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK);
    private final CustomMessageListener cUS = new e(this, CmdConfigCustom.LEFT_NAV_LIVE_CLICK);
    CustomMessageListener cUT = new f(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
    CustomMessageListener cUU = new g(this, CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP);
    private final CustomMessageListener cUV = new h(this, CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK);
    private final CustomMessageListener cUW = new i(this, CmdConfigCustom.LEFT_NAV_SETTING_CLICK);
    private final CustomMessageListener cUX = new j(this, CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE);
    private final CustomMessageListener aVL = new k(this, CmdConfigCustom.MSG_READ);
    private final CustomMessageListener cUY = new l(this, CmdConfigCustom.MAINTAB_SET_INST);
    private final CustomMessageListener cUZ = new n(this, CmdConfigCustom.CMD_ENTER_PERSONINFO_FROM_NOTIFI_LOCAL);
    private final CustomMessageListener cVa = new o(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    CustomMessageListener cVb = new p(this, CmdConfigCustom.CMD_SHOW_GO_TO_MY_LIVE_TIPS);

    /* JADX INFO: Access modifiers changed from: private */
    public void lk(String str) {
        String configVersion;
        if (str != null && (configVersion = TbadkCoreApplication.m411getInst().getConfigVersion()) != null && !configVersion.equalsIgnoreCase(str) && avM()) {
            this.cUJ = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean avM() {
        if (-1 == this.cUJ) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.cUJ;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void avN() {
        registerListener(this.cHw);
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new q(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avO() {
        boolean z = true;
        if (MainTabActivityStatic.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (MainTabActivityStatic.getGame().hasGameCenter != null && MainTabActivityStatic.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.cUv.gq(true);
                long j = com.baidu.tbadk.core.sharedPref.b.tx().getLong("game_last_time", 0L);
                if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.tx().putLong("game_last_time", MainTabActivityStatic.getGame().gameLastLaunchtime.longValue());
                } else if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.cUv.gt(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            this.cUv.gq(false);
            this.cUv.gt(false);
            com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("game_is_show_tip", false);
        }
    }

    public void avP() {
        this.cUD = false;
        this.cUB = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.cUC = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new r(this));
        go(false);
    }

    public void a(com.baidu.tbadk.data.f fVar) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && fVar != null) {
            if ((fVar.Al() == 1 || fVar.Al() == 2) && com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("show_member_deid_line", true)) {
                long rs = fVar.rs() * 1000;
                if (rs < System.currentTimeMillis()) {
                    if (StringUtils.isNull(fVar.Am())) {
                        fVar.eB(getPageContext().getString(i.h.member));
                    } else {
                        fVar.eB(String.valueOf(fVar.Am()) + getPageContext().getString(i.h.member_already_Expire));
                    }
                    this.cUv.a(fVar, 0);
                } else if (rs - System.currentTimeMillis() < cUI) {
                    if (StringUtils.isNull(fVar.Am())) {
                        fVar.eB(getPageContext().getString(i.h.member));
                    } else {
                        fVar.eB(String.valueOf(fVar.Am()) + getPageContext().getString(i.h.member_will_Expire));
                    }
                    this.cUv.a(fVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.cUP) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.cUv.gu(this.mIsLogin);
        }
        if (this.cUv.awj() == null || this.cUv.awj().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.cUv.abZ()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void avQ() {
        if (this.cUD) {
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.m411getInst();
            inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
            return;
        }
        TbadkSettings inst2 = TbadkSettings.getInst();
        StringBuilder sb2 = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        inst2.saveBoolean(sb2.append(TbadkCoreApplication.getCurrentAccount()).toString(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initTabsOnActivityCreated() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.z.Eu().E(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        avN();
        registerNavigationBarEditStateListener();
        int i = -1;
        if (getIntent() != null) {
            W(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
        }
        int i2 = i;
        this.isFirstGoMaintab = TbadkCoreApplication.m411getInst().isFirstGoMaintab();
        this.mHandler = new Handler();
        this.cUC = TbadkSettings.getInst().loadBoolean("has_clicked_addresslist_item_in_leftnavi" + TbadkCoreApplication.getCurrentAccount(), false);
        al alVar = new al();
        com.baidu.tbadk.core.c.b.a(alVar);
        alVar.a(this);
        if (avS()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(i.g.maintabs_activity);
        com.baidu.tbadk.core.a.a.rh().ri();
        this.cUv = new am(this);
        this.cUv.gp(this.mIsLogin);
        avO();
        this.cUv.setSlidingEnabled(this.mIsLogin);
        avR();
        regReceiver();
        com.baidu.tieba.tblauncher.alarmRemind.b.awp().b(this);
        com.baidu.tbadk.getUserInfo.b.Cl().Cn();
        initTabsOnActivityCreated();
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
            this.cUv.awk().showMenu(true);
            this.cUv.z(0.0f);
            TbadkCoreApplication.m411getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new s(this));
        this.mHandler.post(new t(this));
        registerListener(this.bAO);
        if (i2 == 1) {
            this.cUv.gs(true);
        } else {
            this.cUv.gs(false);
        }
        com.baidu.tbadk.performanceLog.z.Eu().F(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.z.Eu().Ev();
        }
        registerListener(this.cVb);
    }

    private void W(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10320").r("obj_locate", 1).r("obj_type", 1));
            }
        }
    }

    private void avR() {
        this.cUz = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgLiveVip();
        if (this.cUz > 0) {
            this.cUH = true;
        }
        go(false);
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
        if (view == this.cUv.awm()) {
            this.cUv.kJ(0);
            cUl = false;
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SingleMentionActivityConfig(getPageContext().getPageActivity())));
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
            if (TbadkCoreApplication.checkNeedShowNewVersion()) {
                MainTabActivity.this.mHasNewVersion = true;
            } else {
                MainTabActivity.this.mHasNewVersion = false;
            }
            MainTabActivity.this.go(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void go(boolean z) {
        int i = 2;
        this.cUv.gr(((this.cUx > 0 && this.cUE) || ((this.cUB > 0 && this.cUD) || ((this.cUA > 0 && this.cUG) || ((this.cUy > 0 && this.cUF) || (this.cUz > 0 && this.cUH))))) && !this.cUv.isMenuShowing());
        this.cUv.awl().gx((this.cUx > 0 && this.cUE) || (this.cUy > 0 && this.cUF));
        this.cUv.awl().aL(0, (this.cUB <= 0 || !this.cUD) ? 0 : 2);
        com.baidu.tieba.tblauncher.a.d awl = this.cUv.awl();
        if (this.cUA <= 0 || !this.cUG) {
            i = 0;
        }
        awl.aL(1, i);
        this.cUv.awl().gy(this.mHasNewVersion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public void kI(int i) {
        this.cUo = i;
    }

    public boolean avS() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        unregReceiver();
        com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xm();
        com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xf();
        com.baidu.tbadk.coreExtra.messageCenter.a.wZ().az(false);
        avQ();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        avT();
        if (this.cUv != null && this.cUv.awj() != null) {
            this.cUv.awj().reset();
        }
        super.onDestroy();
        com.baidu.tbadk.core.c.b.a(null);
        System.gc();
    }

    private void avT() {
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
        registerListener(this.cUZ);
        registerListener(this.cVa);
        registerListener(this.cUL);
        this.mAddTablistener.setPriority(100);
        registerListener(this.mAddTablistener);
        registerListener(this.cUO);
        registerListener(this.cUY);
        registerListener(this.cUX);
        registerListener(this.cUQ);
        registerListener(this.aVL);
        registerListener(this.aLx);
        registerListener(this.cUM);
        registerListener(this.cUN);
        registerListener(this.cUR);
        registerListener(this.cUV);
        registerListener(this.cUW);
        registerListener(this.cUT);
        registerListener(this.cUU);
        registerListener(this.cUS);
        registerListener(this.cUK);
        this.cUw = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cUw, intentFilter);
    }

    private void unregReceiver() {
        if (this.cUw != null) {
            unregisterReceiver(this.cUw);
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
        this.cUo = this.cUv.awj().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.z.Eu().Et()) {
            com.baidu.tbadk.performanceLog.z.Eu().Ev();
        }
        if (this.cUm != null && this.cUm.isShowing()) {
            this.mHandler.postDelayed(new u(this), 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            com.baidu.tbadk.getUserInfo.b.Cl().Cn();
        }
        this.cUv.setSlidingEnabled(z);
        this.cUv.switchNaviBarStatus(z);
        this.cUv.awj().setWidgetLayerVisibleNoAnimation(false);
        this.cUp = true;
        initTabsOnActivityCreated();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.cUn) {
            this.cUn = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), i.a.down, i.a.hold);
        }
        TbadkCoreApplication.m411getInst().DelResumeNum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.cUv.awj().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        W(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            avU();
        }
        com.baidu.tbadk.getUserInfo.b.Cl().Cn();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.cUv.awj().setWidgetLayerVisibleNoAnimation(false);
            initTabsOnActivityCreated();
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
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4) {
            this.cUv.awj().setCurrentTabByType(intExtra);
        }
        this.cUv.awl().awu();
        this.cUv.awl().awv();
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void avU() {
    }

    protected void t(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bE(i.h.confirm_title).aj(false).bF(i.h.background_process_permission).a(i.h.now_goto_setting, new w(this)).b(i.h.next_time, new x(this)).b(com.baidu.adp.base.l.C(activity)).sU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avV() {
        com.baidu.adp.lib.f.c.gZ().d(getUniqueId());
        avX();
        moveTaskToBack(true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (this.cUv.awk().isMenuShowing()) {
                this.cUv.awk().showContent(true);
                return true;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.cUv.abZ()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                }
                if (System.currentTimeMillis() - this.cUr > 2000) {
                    showToast(i.h.double_back_quit);
                    this.cUr = System.currentTimeMillis();
                } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                    t(getPageContext().getPageActivity());
                    return true;
                } else {
                    avV();
                }
                return false;
            }
            return true;
        }
        if (keyEvent.getAction() == 0) {
            keyEvent.getKeyCode();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Intent intent) {
        try {
            this.cUv.awj().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void avW() {
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
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(i.h.login_home_tab), 11003)));
            }
            if (this.cUv.awj().getCurrentFragment() != null) {
                this.cUv.awj().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            avW();
        } else if (this.cUv.awj().getCurrentFragment() != null) {
            this.cUv.awj().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cUv.onChangeSkinType(i);
    }

    private void avX() {
        if (System.currentTimeMillis() - this.cUs >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.cUs = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.cUv.awj() != null) {
            return this.cUv.awj().getCurrentTabType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avY() {
        this.cUm = new PopupWindow(getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.go_to_my_live_tip, (ViewGroup) null);
        getLayoutMode().k(inflate);
        this.cUm.setContentView(inflate);
        inflate.setOnClickListener(new y(this));
        this.cUm.setWidth(getPageContext().getResources().getDimensionPixelSize(i.d.ds480));
        this.cUm.setHeight(getPageContext().getResources().getDimensionPixelSize(i.d.ds88));
        this.cUm.setBackgroundDrawable(new BitmapDrawable());
        this.cUm.setOutsideTouchable(true);
        this.cUm.setTouchInterceptor(new z(this));
        int[] iArr = new int[2];
        HeadImageView awh = this.cUv.awh();
        if (awh != null) {
            awh.getLocationOnScreen(iArr);
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.cUm, this.cUv.awj(), 0, (int) getResources().getDimension(i.d.ds20), iArr[1] + awh.getWidth());
            this.cUm.update();
        }
    }
}
