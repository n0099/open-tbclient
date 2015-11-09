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
    public static boolean deB = true;
    private static long deX = 259200000;
    private ao deK;
    private boolean dff;
    private boolean isFirstGoMaintab;
    private PopupWindow deC = null;
    private boolean deD = false;
    private int deE = -1;
    private boolean isUserChanged = false;
    private boolean deF = false;
    private long deG = 0;
    private long deH = 0;
    private final long deI = 2000;
    private final long deJ = 7200000;
    private a deL = null;
    private int deM = 0;
    private int deN = 0;
    private int deO = 0;
    private int deP = 0;
    private int deQ = 0;
    private boolean deR = false;
    private boolean deS = false;
    private boolean mHasNewVersion = false;
    private boolean deT = false;
    private boolean deU = false;
    private boolean deV = false;
    private boolean deW = false;
    private Handler mHandler = null;
    private long deY = -1;
    private final CustomMessageListener cQs = new b(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener deZ = new m(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final CustomMessageListener skinTypeChangeListener = new x(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final com.baidu.adp.framework.listener.e bEw = new ac(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    final CustomMessageListener dfa = new ad(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private final CustomMessageListener aJu = new ae(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener dfb = new af(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private CustomMessageListener dfc = new ag(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
    private final CustomMessageListener dfd = new ah(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener mAddTablistener = new c(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener dfe = new d(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener dfg = new e(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private final CustomMessageListener dfh = new f(this, CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK);
    private final CustomMessageListener dfi = new g(this, CmdConfigCustom.LEFT_NAV_LIVE_CLICK);
    CustomMessageListener dfj = new h(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
    CustomMessageListener dfk = new i(this, CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP);
    private final CustomMessageListener dfl = new j(this, CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK);
    private final CustomMessageListener dfm = new k(this, CmdConfigCustom.LEFT_NAV_SETTING_CLICK);
    private final CustomMessageListener dfn = new l(this, CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE);
    private final CustomMessageListener aVm = new n(this, CmdConfigCustom.MSG_READ);
    private final CustomMessageListener dfo = new o(this, CmdConfigCustom.MAINTAB_SET_INST);
    private final CustomMessageListener dfp = new p(this, CmdConfigCustom.CMD_ENTER_PERSONINFO_FROM_NOTIFI_LOCAL);
    private final CustomMessageListener dfq = new q(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    CustomMessageListener dfr = new r(this, CmdConfigCustom.CMD_SHOW_GO_TO_MY_LIVE_TIPS);

    /* JADX INFO: Access modifiers changed from: private */
    public void lT(String str) {
        String configVersion;
        if (str != null && (configVersion = TbadkCoreApplication.m411getInst().getConfigVersion()) != null && !configVersion.equalsIgnoreCase(str) && azp()) {
            this.deY = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean azp() {
        if (-1 == this.deY) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.deY;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void axY() {
        registerListener(this.cQs);
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new s(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axZ() {
        boolean z = true;
        if (MainTabActivityStatic.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (MainTabActivityStatic.getGame().hasGameCenter != null && MainTabActivityStatic.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.deK.gG(true);
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
                this.deK.gJ(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            this.deK.gG(false);
            this.deK.gJ(false);
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("game_is_show_tip", false);
        }
    }

    public void azq() {
        this.deS = false;
        this.deQ = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.deR = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new t(this));
        gE(false);
    }

    public void a(com.baidu.tbadk.data.e eVar) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && eVar != null) {
            if ((eVar.zY() == 1 || eVar.zY() == 2) && com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("show_member_deid_line", true)) {
                long rl = eVar.rl() * 1000;
                if (rl < System.currentTimeMillis()) {
                    if (StringUtils.isNull(eVar.zZ())) {
                        eVar.eF(getPageContext().getString(i.h.member));
                    } else {
                        eVar.eF(String.valueOf(eVar.zZ()) + getPageContext().getString(i.h.member_already_Expire));
                    }
                    this.deK.a(eVar, 0);
                } else if (rl - System.currentTimeMillis() < deX) {
                    if (StringUtils.isNull(eVar.zZ())) {
                        eVar.eF(getPageContext().getString(i.h.member));
                    } else {
                        eVar.eF(String.valueOf(eVar.zZ()) + getPageContext().getString(i.h.member_will_Expire));
                    }
                    this.deK.a(eVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.dff) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.deK.gK(this.mIsLogin);
        }
        if (this.deK.azL() == null || this.deK.azL().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.deK.adI()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void azr() {
        if (this.deS) {
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
        com.baidu.tbadk.performanceLog.z.DX().N(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        axY();
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
        this.deR = TbadkSettings.getInst().loadBoolean("has_clicked_addresslist_item_in_leftnavi" + TbadkCoreApplication.getCurrentAccount(), false);
        an anVar = new an();
        com.baidu.tbadk.core.c.b.a(anVar);
        anVar.a(this);
        if (azu()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(i.g.maintabs_activity);
        com.baidu.tbadk.core.a.a.rb().rc();
        this.deK = new ao(this);
        this.deK.gF(this.mIsLogin);
        axZ();
        this.deK.setSlidingEnabled(this.mIsLogin);
        azs();
        regReceiver();
        com.baidu.tieba.tblauncher.alarmRemind.b.azR().b(this);
        com.baidu.tbadk.getUserInfo.b.BO().BQ();
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
            this.deK.azM().showMenu(true);
            this.deK.z(0.0f);
            TbadkCoreApplication.m411getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new u(this));
        this.mHandler.post(new v(this));
        registerListener(this.bEw);
        if (i2 == 1) {
            this.deK.gI(true);
        } else {
            this.deK.gI(false);
        }
        com.baidu.tbadk.performanceLog.z.DX().O(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.z.DX().DY();
        }
        registerListener(this.dfr);
    }

    private void V(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10320").r("obj_locate", 1).r("obj_type", 1));
            }
        }
    }

    private void azs() {
        this.deO = com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgLiveVip();
        if (this.deO > 0) {
            this.deW = true;
        }
        gE(false);
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
        if (view == this.deK.azO()) {
            this.deK.lD(0);
            deB = false;
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
            MainTabActivity.this.gE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(boolean z) {
        int i = 2;
        this.deK.gH(((this.deM > 0 && this.deT) || ((this.deQ > 0 && this.deS) || ((this.deP > 0 && this.deV) || ((this.deN > 0 && this.deU) || (this.deO > 0 && this.deW))))) && !this.deK.isMenuShowing());
        this.deK.azN().gy((this.deM > 0 && this.deT) || (this.deN > 0 && this.deU));
        this.deK.azN().aK(0, (this.deQ <= 0 || !this.deS) ? 0 : 2);
        com.baidu.tieba.tbadkCore.f.e azN = this.deK.azN();
        if (this.deP <= 0 || !this.deV) {
            i = 0;
        }
        azN.aK(1, i);
        this.deK.azN().gz(this.mHasNewVersion);
        azt();
    }

    public void azt() {
        if (com.baidu.tbadk.core.sharedPref.b.tu().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.m411getInst().getLastUpdateThemeTime()) {
            this.deK.azN().aK(5, 2);
        } else {
            this.deK.azN().aK(5, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public void lC(int i) {
        this.deE = i;
    }

    public boolean azu() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        unregReceiver();
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().wZ();
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().wS();
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().ay(false);
        azr();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        azv();
        if (this.deK != null && this.deK.azL() != null) {
            this.deK.azL().reset();
        }
        super.onDestroy();
        com.baidu.tbadk.core.c.b.a(null);
        System.gc();
    }

    private void azv() {
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
        registerListener(this.dfp);
        registerListener(this.dfq);
        registerListener(this.dfa);
        this.mAddTablistener.setPriority(100);
        registerListener(this.mAddTablistener);
        registerListener(this.dfe);
        registerListener(this.dfo);
        registerListener(this.dfn);
        registerListener(this.dfg);
        registerListener(this.aVm);
        registerListener(this.aJu);
        registerListener(this.dfb);
        registerListener(this.dfd);
        registerListener(this.dfh);
        registerListener(this.dfl);
        registerListener(this.dfm);
        registerListener(this.dfj);
        registerListener(this.dfk);
        registerListener(this.dfi);
        registerListener(this.deZ);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.dfc);
        this.deL = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.deL, intentFilter);
    }

    private void unregReceiver() {
        if (this.deL != null) {
            unregisterReceiver(this.deL);
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
        this.deE = this.deK.azL().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.z.DX().DW()) {
            com.baidu.tbadk.performanceLog.z.DX().DY();
        }
        if (this.deC != null && this.deC.isShowing()) {
            this.mHandler.postDelayed(new w(this), 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            com.baidu.tbadk.getUserInfo.b.BO().BQ();
        }
        this.deK.setSlidingEnabled(z);
        this.deK.switchNaviBarStatus(z);
        this.deK.azL().setWidgetLayerVisibleNoAnimation(false);
        this.isUserChanged = true;
        initTabsOnActivityCreated();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.deD) {
            this.deD = false;
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
        bundle.putInt("locate_type", this.deK.azL().getCurrentTabType());
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
            azw();
        }
        com.baidu.tbadk.getUserInfo.b.BO().BQ();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.deK.azL().setWidgetLayerVisibleNoAnimation(false);
            initTabsOnActivityCreated();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intent.getBooleanExtra(MainTabActivityConfig.NEED_CLOSE_MENU, false) && this.deK.azM() != null) {
            this.deK.azM().showContent(true);
            this.deK.z(1.0f);
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
            this.deK.azL().setCurrentTabByType(intExtra);
        }
        this.deK.azN().ayb();
        this.deK.azN().ayc();
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void azw() {
    }

    protected void t(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bE(i.h.confirm_title).aj(false).bF(i.h.background_process_permission).a(i.h.now_goto_setting, new y(this)).b(i.h.next_time, new z(this)).b(com.baidu.adp.base.l.C(activity)).sR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azx() {
        com.baidu.adp.lib.f.c.hb().d(getUniqueId());
        azz();
        moveTaskToBack(true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (this.deK.azM().isMenuShowing()) {
                this.deK.azM().showContent(true);
                return true;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.deK.adI()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                }
                if (System.currentTimeMillis() - this.deG > 2000) {
                    showToast(i.h.double_back_quit);
                    this.deG = System.currentTimeMillis();
                } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                    t(getPageContext().getPageActivity());
                    return true;
                } else {
                    azx();
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
            this.deK.azL().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void azy() {
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
            if (this.deK.azL().getCurrentFragment() != null) {
                this.deK.azL().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            azy();
        } else if (this.deK.azL().getCurrentFragment() != null) {
            this.deK.azL().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.deK.onChangeSkinType(i);
    }

    private void azz() {
        if (System.currentTimeMillis() - this.deH >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.deH = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.deK.azL() != null) {
            return this.deK.azL().getCurrentTabType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azA() {
        this.deC = new PopupWindow(getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.go_to_my_live_tip, (ViewGroup) null);
        getLayoutMode().k(inflate);
        this.deC.setContentView(inflate);
        inflate.setOnClickListener(new aa(this));
        this.deC.setWidth(getPageContext().getResources().getDimensionPixelSize(i.d.ds480));
        this.deC.setHeight(getPageContext().getResources().getDimensionPixelSize(i.d.ds88));
        this.deC.setBackgroundDrawable(new BitmapDrawable());
        this.deC.setOutsideTouchable(true);
        this.deC.setTouchInterceptor(new ab(this));
        int[] iArr = new int[2];
        HeadImageView azJ = this.deK.azJ();
        if (azJ != null) {
            azJ.getLocationOnScreen(iArr);
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.deC, this.deK.azL(), 0, (int) getResources().getDimension(i.d.ds20), iArr[1] + azJ.getWidth());
            this.deC.update();
        }
    }
}
