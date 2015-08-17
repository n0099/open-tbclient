package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tieba.tblauncher.a {
    public static boolean cLK = true;
    private static long cMg = 259200000;
    private ai cLT;
    private boolean cMo;
    private boolean isFirstGoMaintab;
    private boolean cLL = false;
    private int cLM = -1;
    private boolean cLN = false;
    private boolean cLO = false;
    private long cLP = 0;
    private long cLQ = 0;
    private final long cLR = 2000;
    private final long cLS = 7200000;
    private a cLU = null;
    private int cLV = 0;
    private int cLW = 0;
    private int cLX = 0;
    private int cLY = 0;
    private int cLZ = 0;
    private boolean cMa = false;
    private boolean cMb = false;
    private boolean mHasNewVersion = false;
    private boolean cMc = false;
    private boolean cMd = false;
    private boolean cMe = false;
    private boolean cMf = false;
    private Handler mHandler = null;
    private long cMh = -1;
    private final CustomMessageListener cyY = new b(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener cMi = new m(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final com.baidu.adp.framework.listener.e bAh = new v(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    final CustomMessageListener cMj = new w(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private final CustomMessageListener aLk = new x(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener cMk = new y(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private final CustomMessageListener cMl = new z(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener cMm = new aa(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener cMn = new ab(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener cMp = new c(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private final CustomMessageListener cMq = new d(this, CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK);
    private final CustomMessageListener cMr = new e(this, CmdConfigCustom.LEFT_NAV_LIVE_CLICK);
    CustomMessageListener cMs = new f(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
    CustomMessageListener cMt = new g(this, CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP);
    private final CustomMessageListener cMu = new h(this, CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK);
    private final CustomMessageListener cMv = new i(this, CmdConfigCustom.LEFT_NAV_SETTING_CLICK);
    private final CustomMessageListener cMw = new j(this, CmdConfigCustom.MAINTAB_SET_RELOGIN_TYPE);
    private final CustomMessageListener aVw = new k(this, CmdConfigCustom.MSG_READ);
    private final CustomMessageListener cMx = new l(this, CmdConfigCustom.MAINTAB_SET_INST);
    private final CustomMessageListener cMy = new n(this, CmdConfigCustom.CMD_ENTER_PERSONINFO_FROM_NOTIFI_LOCAL);
    private final CustomMessageListener cMz = new o(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);

    /* JADX INFO: Access modifiers changed from: private */
    public void kF(String str) {
        String configVersion;
        if (str != null && (configVersion = TbadkCoreApplication.m411getInst().getConfigVersion()) != null && !configVersion.equalsIgnoreCase(str) && ary()) {
            this.cMh = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean ary() {
        if (-1 == this.cMh) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.cMh;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void arz() {
        registerListener(this.cyY);
    }

    private void arA() {
        registerListener(new p(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arB() {
        boolean z = true;
        if (MainTabActivityStatic.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (MainTabActivityStatic.getGame().hasGameCenter != null && MainTabActivityStatic.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.cLT.fF(true);
                long j = com.baidu.tbadk.core.sharedPref.b.ts().getLong("game_last_time", 0L);
                if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.ts().putLong("game_last_time", MainTabActivityStatic.getGame().gameLastLaunchtime.longValue());
                } else if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.cLT.fJ(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            this.cLT.fF(false);
            this.cLT.fJ(false);
            com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("game_is_show_tip", false);
        }
    }

    public void arC() {
        this.cMb = false;
        this.cLZ = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.cMa = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new q(this));
        fD(false);
    }

    public void a(com.baidu.tbadk.data.f fVar) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && fVar != null) {
            if ((fVar.zY() == 1 || fVar.zY() == 2) && com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("show_member_deid_line", true)) {
                long rt = fVar.rt() * 1000;
                if (rt < System.currentTimeMillis()) {
                    if (StringUtils.isNull(fVar.zZ())) {
                        fVar.et(getPageContext().getString(i.C0057i.member));
                    } else {
                        fVar.et(String.valueOf(fVar.zZ()) + getPageContext().getString(i.C0057i.member_already_Expire));
                    }
                    this.cLT.a(fVar, 0);
                } else if (rt - System.currentTimeMillis() < cMg) {
                    if (StringUtils.isNull(fVar.zZ())) {
                        fVar.et(getPageContext().getString(i.C0057i.member));
                    } else {
                        fVar.et(String.valueOf(fVar.zZ()) + getPageContext().getString(i.C0057i.member_will_Expire));
                    }
                    this.cLT.a(fVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.cMo) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.cLT.fK(this.mIsLogin);
        }
        if (this.cLT.arW() == null || this.cLT.arW().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void arD() {
        if (this.cMb) {
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
    public void arE() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.z.Ek().D(System.currentTimeMillis());
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        arz();
        arA();
        int i = -1;
        if (getIntent() != null && (i = getIntent().getIntExtra("locate_type", 0)) == 200) {
            finish();
            return;
        }
        int i2 = i;
        this.isFirstGoMaintab = TbadkCoreApplication.m411getInst().isFirstGoMaintab();
        this.mHandler = new Handler();
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.cMa = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        ah ahVar = new ah();
        com.baidu.tbadk.core.c.b.a(ahVar);
        ahVar.a(this);
        if (arG()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(i.g.maintabs_activity);
        com.baidu.tbadk.core.a.a.rj().rk();
        this.cLT = new ai(this);
        this.cLT.fE(this.mIsLogin);
        arB();
        this.cLT.setSlidingEnabled(this.mIsLogin);
        arF();
        regReceiver();
        com.baidu.tbadk.getUserInfo.b.BX().BZ();
        arE();
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
            this.cLT.arX().showMenu(true);
            this.cLT.y(0.0f);
            TbadkCoreApplication.m411getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new r(this));
        this.mHandler.post(new s(this));
        registerListener(this.bAh);
        if (i2 == 1) {
            this.cLT.fH(true);
        } else {
            this.cLT.fH(false);
        }
        com.baidu.tbadk.performanceLog.z.Ek().E(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.z.Ek().El();
        }
    }

    private void arF() {
        this.cLX = com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgLiveVip();
        if (this.cLX > 0) {
            this.cMf = true;
        }
        fD(false);
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
        if (view == this.cLT.arZ()) {
            this.cLT.jY(0);
            cLK = false;
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
            MainTabActivity.this.fD(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(boolean z) {
        int i = 2;
        this.cLT.fG(((this.cLV > 0 && this.cMc) || ((this.cLZ > 0 && this.cMb) || ((this.cLY > 0 && this.cMe) || ((this.cLW > 0 && this.cMd) || (this.cLX > 0 && this.cMf))))) && !this.cLT.isMenuShowing());
        this.cLT.arY().fM((this.cLV > 0 && this.cMc) || (this.cLW > 0 && this.cMd));
        this.cLT.arY().aC(0, (this.cLZ <= 0 || !this.cMb) ? 0 : 2);
        this.cLT.arY().aC(1, (this.cLY <= 0 || !this.cMe) ? 0 : 2);
        com.baidu.tieba.tblauncher.a.d arY = this.cLT.arY();
        if (this.cLX <= 0 || !this.cMf) {
            i = 0;
        }
        arY.aC(3, i);
        this.cLT.arY().fN(this.mHasNewVersion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public void jX(int i) {
        this.cLM = i;
    }

    public boolean arG() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        unregReceiver();
        com.baidu.tbadk.coreExtra.messageCenter.a.wT().xg();
        com.baidu.tbadk.coreExtra.messageCenter.a.wT().wZ();
        com.baidu.tbadk.coreExtra.messageCenter.a.wT().az(false);
        arD();
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        arH();
        if (this.cLT != null && this.cLT.arW() != null) {
            this.cLT.arW().reset();
        }
        super.onDestroy();
        com.baidu.tbadk.core.c.b.a(null);
        System.gc();
    }

    private void arH() {
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
        registerListener(this.cMy);
        registerListener(this.cMz);
        registerListener(this.cMj);
        this.cMm.setPriority(100);
        registerListener(this.cMm);
        registerListener(this.cMn);
        registerListener(this.cMx);
        registerListener(this.cMw);
        registerListener(this.cMp);
        registerListener(this.aVw);
        registerListener(this.aLk);
        registerListener(this.cMk);
        registerListener(this.cMl);
        registerListener(this.cMq);
        registerListener(this.cMu);
        registerListener(this.cMv);
        registerListener(this.cMs);
        registerListener(this.cMt);
        registerListener(this.cMr);
        registerListener(this.cMi);
        this.cLU = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cLU, intentFilter);
    }

    private void unregReceiver() {
        if (this.cLU != null) {
            unregisterReceiver(this.cLU);
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
        this.cLM = this.cLT.arW().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.z.Ek().Ej()) {
            com.baidu.tbadk.performanceLog.z.Ek().El();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            com.baidu.tbadk.getUserInfo.b.BX().BZ();
        }
        this.cLT.setSlidingEnabled(z);
        this.cLT.switchNaviBarStatus(z);
        this.cLT.arW().setWidgetLayerVisibleNoAnimation(false);
        this.cLN = true;
        arE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.cLL) {
            this.cLL = false;
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
        bundle.putInt("locate_type", this.cLT.arW().getCurrentTabType());
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
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            arI();
        }
        com.baidu.tbadk.getUserInfo.b.BX().BZ();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.cLT.arW().setWidgetLayerVisibleNoAnimation(false);
            arE();
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
            this.cLT.arW().setCurrentTabByType(intExtra);
        }
        this.cLT.arY().asc();
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void arI() {
    }

    protected void s(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bB(i.C0057i.confirm_title).aj(false).bC(i.C0057i.background_process_permission).a(i.C0057i.now_goto_setting, new t(this)).b(i.C0057i.next_time, new u(this)).b(com.baidu.adp.base.l.C(activity)).sP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arJ() {
        com.baidu.adp.lib.f.c.hc().d(getUniqueId());
        arL();
        moveTaskToBack(true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (this.cLT.arX().isMenuShowing()) {
                this.cLT.arX().showContent(true);
                return true;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.cLT.arU()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                }
                if (System.currentTimeMillis() - this.cLP > 2000) {
                    showToast(i.C0057i.double_back_quit);
                    this.cLP = System.currentTimeMillis();
                } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                    s(getPageContext().getPageActivity());
                    return true;
                } else {
                    arJ();
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
    public void T(Intent intent) {
        try {
            this.cLT.arW().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void arK() {
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
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(i.C0057i.login_home_tab), 11003)));
            }
            if (this.cLT.arW().getCurrentFragment() != null) {
                this.cLT.arW().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            arK();
        } else if (this.cLT.arW().getCurrentFragment() != null) {
            this.cLT.arW().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cLT.onChangeSkinType(i);
    }

    private void arL() {
        if (System.currentTimeMillis() - this.cLQ >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.cLQ = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.cLT.arW() != null) {
            return this.cLT.arW().getCurrentTabType();
        }
        return -1;
    }
}
