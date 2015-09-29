package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
    public static boolean dbS = true;
    private static long dco = 259200000;
    private ao dcb;
    private boolean dcw;
    private boolean isFirstGoMaintab;
    private PopupWindow dbT = null;
    private boolean dbU = false;
    private int dbV = -1;
    private boolean isUserChanged = false;
    private boolean dbW = false;
    private long dbX = 0;
    private long dbY = 0;
    private final long dbZ = 2000;
    private final long dca = 7200000;
    private a dcc = null;
    private int dcd = 0;
    private int dce = 0;
    private int dcf = 0;
    private int dcg = 0;
    private int dch = 0;
    private boolean dci = false;
    private boolean dcj = false;
    private boolean mHasNewVersion = false;
    private boolean dck = false;
    private boolean dcl = false;
    private boolean dcm = false;
    private boolean dcn = false;
    private Handler mHandler = null;
    private long dcp = -1;
    private final CustomMessageListener cOx = new b(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener dcq = new m(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final CustomMessageListener skinTypeChangeListener = new x(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final com.baidu.adp.framework.listener.e bDQ = new ac(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    final CustomMessageListener dcr = new ad(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private final CustomMessageListener aKp = new ae(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener dcs = new af(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private CustomMessageListener dct = new ag(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
    private final CustomMessageListener dcu = new ah(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener mAddTablistener = new c(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener dcv = new d(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener dcx = new e(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private final CustomMessageListener dcy = new f(this, CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK);
    private final CustomMessageListener dcz = new g(this, CmdConfigCustom.LEFT_NAV_LIVE_CLICK);
    CustomMessageListener dcA = new h(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
    CustomMessageListener dcB = new i(this, CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP);
    private final CustomMessageListener dcC = new j(this, CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK);
    private final CustomMessageListener dcD = new k(this, CmdConfigCustom.LEFT_NAV_SETTING_CLICK);
    private final CustomMessageListener dcE = new l(this, CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE);
    private final CustomMessageListener aUT = new n(this, CmdConfigCustom.MSG_READ);
    private final CustomMessageListener dcF = new o(this, CmdConfigCustom.MAINTAB_SET_INST);
    private final CustomMessageListener dcG = new p(this, CmdConfigCustom.CMD_ENTER_PERSONINFO_FROM_NOTIFI_LOCAL);
    private final CustomMessageListener dcH = new q(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    CustomMessageListener dcI = new r(this, CmdConfigCustom.CMD_SHOW_GO_TO_MY_LIVE_TIPS);

    /* JADX INFO: Access modifiers changed from: private */
    public void lK(String str) {
        String configVersion;
        if (str != null && (configVersion = TbadkCoreApplication.m411getInst().getConfigVersion()) != null && !configVersion.equalsIgnoreCase(str) && aya()) {
            this.dcp = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean aya() {
        if (-1 == this.dcp) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.dcp;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void ayb() {
        registerListener(this.cOx);
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new s(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayc() {
        boolean z = true;
        if (MainTabActivityStatic.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (MainTabActivityStatic.getGame().hasGameCenter != null && MainTabActivityStatic.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.dcb.gA(true);
                long j = com.baidu.tbadk.core.sharedPref.b.tu().getLong("game_last_time", 0L);
                if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.tu().putLong("game_last_time", MainTabActivityStatic.getGame().gameLastLaunchtime.longValue());
                } else if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.dcb.gD(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            this.dcb.gA(false);
            this.dcb.gD(false);
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("game_is_show_tip", false);
        }
    }

    public void ayd() {
        this.dcj = false;
        this.dch = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.dci = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new t(this));
        gy(false);
    }

    public void a(com.baidu.tbadk.data.e eVar) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && eVar != null) {
            if ((eVar.zW() == 1 || eVar.zW() == 2) && com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("show_member_deid_line", true)) {
                long rn = eVar.rn() * 1000;
                if (rn < System.currentTimeMillis()) {
                    if (StringUtils.isNull(eVar.zX())) {
                        eVar.eF(getPageContext().getString(i.h.member));
                    } else {
                        eVar.eF(String.valueOf(eVar.zX()) + getPageContext().getString(i.h.member_already_Expire));
                    }
                    this.dcb.a(eVar, 0);
                } else if (rn - System.currentTimeMillis() < dco) {
                    if (StringUtils.isNull(eVar.zX())) {
                        eVar.eF(getPageContext().getString(i.h.member));
                    } else {
                        eVar.eF(String.valueOf(eVar.zX()) + getPageContext().getString(i.h.member_will_Expire));
                    }
                    this.dcb.a(eVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.dcw) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.dcb.gE(this.mIsLogin);
        }
        if (this.dcb.ayy() == null || this.dcb.ayy().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.dcb.adr()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void aye() {
        if (this.dcj) {
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
        com.baidu.tbadk.performanceLog.z.Eh().N(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        ayb();
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
        this.dci = TbadkSettings.getInst().loadBoolean("has_clicked_addresslist_item_in_leftnavi" + TbadkCoreApplication.getCurrentAccount(), false);
        an anVar = new an();
        com.baidu.tbadk.core.c.b.a(anVar);
        anVar.a(this);
        if (ayh()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(i.g.maintabs_activity);
        com.baidu.tbadk.core.a.a.rd().re();
        this.dcb = new ao(this);
        this.dcb.gz(this.mIsLogin);
        ayc();
        this.dcb.setSlidingEnabled(this.mIsLogin);
        ayf();
        regReceiver();
        com.baidu.tieba.tblauncher.alarmRemind.b.ayE().b(this);
        com.baidu.tbadk.getUserInfo.b.BY().Ca();
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
            this.dcb.ayz().showMenu(true);
            this.dcb.z(0.0f);
            TbadkCoreApplication.m411getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new u(this));
        this.mHandler.post(new v(this));
        registerListener(this.bDQ);
        if (i2 == 1) {
            this.dcb.gC(true);
        } else {
            this.dcb.gC(false);
        }
        com.baidu.tbadk.performanceLog.z.Eh().O(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.z.Eh().Ei();
        }
        registerListener(this.dcI);
    }

    private void V(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10320").r("obj_locate", 1).r("obj_type", 1));
            }
        }
    }

    private void ayf() {
        this.dcf = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgLiveVip();
        if (this.dcf > 0) {
            this.dcn = true;
        }
        gy(false);
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
        if (view == this.dcb.ayB()) {
            this.dcb.lm(0);
            dbS = false;
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
            MainTabActivity.this.gy(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gy(boolean z) {
        int i = 2;
        this.dcb.gB(((this.dcd > 0 && this.dck) || ((this.dch > 0 && this.dcj) || ((this.dcg > 0 && this.dcm) || ((this.dce > 0 && this.dcl) || (this.dcf > 0 && this.dcn))))) && !this.dcb.isMenuShowing());
        this.dcb.ayA().gH((this.dcd > 0 && this.dck) || (this.dce > 0 && this.dcl));
        this.dcb.ayA().aK(0, (this.dch <= 0 || !this.dcj) ? 0 : 2);
        com.baidu.tieba.tblauncher.a.e ayA = this.dcb.ayA();
        if (this.dcg <= 0 || !this.dcm) {
            i = 0;
        }
        ayA.aK(1, i);
        this.dcb.ayA().gI(this.mHasNewVersion);
        ayg();
    }

    public void ayg() {
        if (com.baidu.tbadk.core.sharedPref.b.tu().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.m411getInst().getLastUpdateThemeTime()) {
            this.dcb.ayA().aK(5, 2);
        } else {
            this.dcb.ayA().aK(5, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public void ll(int i) {
        this.dbV = i;
    }

    public boolean ayh() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        unregReceiver();
        com.baidu.tbadk.coreExtra.messageCenter.a.wK().wX();
        com.baidu.tbadk.coreExtra.messageCenter.a.wK().wQ();
        com.baidu.tbadk.coreExtra.messageCenter.a.wK().ay(false);
        aye();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        ayi();
        if (this.dcb != null && this.dcb.ayy() != null) {
            this.dcb.ayy().reset();
        }
        super.onDestroy();
        com.baidu.tbadk.core.c.b.a(null);
        System.gc();
    }

    private void ayi() {
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
        registerListener(this.dcG);
        registerListener(this.dcH);
        registerListener(this.dcr);
        this.mAddTablistener.setPriority(100);
        registerListener(this.mAddTablistener);
        registerListener(this.dcv);
        registerListener(this.dcF);
        registerListener(this.dcE);
        registerListener(this.dcx);
        registerListener(this.aUT);
        registerListener(this.aKp);
        registerListener(this.dcs);
        registerListener(this.dcu);
        registerListener(this.dcy);
        registerListener(this.dcC);
        registerListener(this.dcD);
        registerListener(this.dcA);
        registerListener(this.dcB);
        registerListener(this.dcz);
        registerListener(this.dcq);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.dct);
        this.dcc = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.dcc, intentFilter);
    }

    private void unregReceiver() {
        if (this.dcc != null) {
            unregisterReceiver(this.dcc);
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
        this.dbV = this.dcb.ayy().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.z.Eh().Eg()) {
            com.baidu.tbadk.performanceLog.z.Eh().Ei();
        }
        if (this.dbT != null && this.dbT.isShowing()) {
            this.mHandler.postDelayed(new w(this), 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            com.baidu.tbadk.getUserInfo.b.BY().Ca();
        }
        this.dcb.setSlidingEnabled(z);
        this.dcb.switchNaviBarStatus(z);
        this.dcb.ayy().setWidgetLayerVisibleNoAnimation(false);
        this.isUserChanged = true;
        initTabsOnActivityCreated();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.dbU) {
            this.dbU = false;
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
        bundle.putInt("locate_type", this.dcb.ayy().getCurrentTabType());
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
        V(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            ayj();
        }
        com.baidu.tbadk.getUserInfo.b.BY().Ca();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.dcb.ayy().setWidgetLayerVisibleNoAnimation(false);
            initTabsOnActivityCreated();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intent.getBooleanExtra(MainTabActivityConfig.NEED_CLOSE_MENU, false) && this.dcb.ayz() != null) {
            this.dcb.ayz().showContent(true);
            this.dcb.z(1.0f);
        }
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.m411getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4) {
            this.dcb.ayy().setCurrentTabByType(intExtra);
        }
        this.dcb.ayA().ayM();
        this.dcb.ayA().ayN();
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void ayj() {
    }

    protected void t(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bE(i.h.confirm_title).aj(false).bF(i.h.background_process_permission).a(i.h.now_goto_setting, new y(this)).b(i.h.next_time, new z(this)).b(com.baidu.adp.base.l.C(activity)).sR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayk() {
        com.baidu.adp.lib.f.c.ha().d(getUniqueId());
        aym();
        moveTaskToBack(true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (this.dcb.ayz().isMenuShowing()) {
                this.dcb.ayz().showContent(true);
                return true;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.dcb.adr()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                }
                if (System.currentTimeMillis() - this.dbX > 2000) {
                    showToast(i.h.double_back_quit);
                    this.dbX = System.currentTimeMillis();
                } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                    t(getPageContext().getPageActivity());
                    return true;
                } else {
                    ayk();
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
    public void W(Intent intent) {
        try {
            this.dcb.ayy().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void ayl() {
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
            if (this.dcb.ayy().getCurrentFragment() != null) {
                this.dcb.ayy().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            ayl();
        } else if (this.dcb.ayy().getCurrentFragment() != null) {
            this.dcb.ayy().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.dcb.onChangeSkinType(i);
    }

    private void aym() {
        if (System.currentTimeMillis() - this.dbY >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.dbY = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.dcb.ayy() != null) {
            return this.dcb.ayy().getCurrentTabType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayn() {
        this.dbT = new PopupWindow(getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.go_to_my_live_tip, (ViewGroup) null);
        getLayoutMode().k(inflate);
        this.dbT.setContentView(inflate);
        inflate.setOnClickListener(new aa(this));
        this.dbT.setWidth(getPageContext().getResources().getDimensionPixelSize(i.d.ds480));
        this.dbT.setHeight(getPageContext().getResources().getDimensionPixelSize(i.d.ds88));
        this.dbT.setBackgroundDrawable(new BitmapDrawable());
        this.dbT.setOutsideTouchable(true);
        this.dbT.setTouchInterceptor(new ab(this));
        int[] iArr = new int[2];
        HeadImageView ayw = this.dcb.ayw();
        if (ayw != null) {
            ayw.getLocationOnScreen(iArr);
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.dbT, this.dcb.ayy(), 0, (int) getResources().getDimension(i.d.ds20), iArr[1] + ayw.getWidth());
            this.dbT.update();
        }
    }
}
