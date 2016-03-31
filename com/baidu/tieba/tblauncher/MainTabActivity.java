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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
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
    private static long ety = 259200000;
    private com.baidu.adp.lib.f.b<TbImageView> ahC;
    VoiceManager bja;
    private com.baidu.adp.lib.f.b<TbImageView> dwT;
    private boolean etI;
    private aa etw;
    private a etx;
    private boolean isFirstGoMaintab;
    private boolean etp = false;
    private int etq = -1;
    private boolean isUserChanged = false;
    private boolean etr = false;
    private long ets = 0;
    private long ett = 0;
    private final long etu = 2000;
    private final long etv = 7200000;
    private Handler mHandler = null;
    private long etz = -1;
    private boolean etA = false;
    private final CustomMessageListener etB = new b(this, CmdConfigCustom.CMD_CLOSE_MATINTAB);
    private final CustomMessageListener eeF = new k(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener etC = new m(this, CmdConfigCustom.CMD_SYNC_FINISH);
    private final CustomMessageListener etD = new n(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final CustomMessageListener skinTypeChangeListener = new o(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final com.baidu.adp.framework.listener.e cmn = new p(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    private final CustomMessageListener etE = new q(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener etF = new r(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private final CustomMessageListener etG = new s(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener dKu = new c(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener etH = new d(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener etJ = new e(this, CmdConfigCustom.MAINTAB_SET_INST);
    private CustomMessageListener cyr = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(String str) {
        if (str != null && TbadkCoreApplication.m411getInst().getConfigVersion() != null && aVa()) {
            this.etz = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean aVa() {
        if (-1 == this.etz) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.etz;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void aVb() {
        registerListener(this.eeF);
    }

    private void aui() {
        registerListener(new g(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVc() {
        boolean z = true;
        if (MainTabActivityStatic.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (MainTabActivityStatic.getGame().hasGameCenter != null && MainTabActivityStatic.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.etw.iR(true);
                long j = com.baidu.tbadk.core.sharedPref.b.vk().getLong("game_last_time", 0L);
                if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.vk().putLong("game_last_time", MainTabActivityStatic.getGame().gameLastLaunchtime.longValue());
                } else if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.etw.iU(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            this.etw.iR(false);
            this.etw.iU(false);
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("game_is_show_tip", false);
        }
    }

    public void a(com.baidu.tbadk.data.f fVar) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && fVar != null) {
            if ((fVar.CF() == 1 || fVar.CF() == 2) && com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("show_member_deid_line", true)) {
                long qW = fVar.qW() * 1000;
                if (qW < System.currentTimeMillis()) {
                    if (StringUtils.isNull(fVar.CG())) {
                        fVar.eY(getPageContext().getString(t.j.member));
                    } else {
                        fVar.eY(String.valueOf(fVar.CG()) + getPageContext().getString(t.j.member_already_Expire));
                    }
                    this.etw.a(fVar, 0);
                } else if (qW - System.currentTimeMillis() < ety) {
                    if (StringUtils.isNull(fVar.CG())) {
                        fVar.eY(getPageContext().getString(t.j.member));
                    } else {
                        fVar.eY(String.valueOf(fVar.CG()) + getPageContext().getString(t.j.member_will_Expire));
                    }
                    this.etw.a(fVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.etI) {
            return false;
        }
        if (this.etw.aVp() == null || this.etw.aVp().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.etw.atR()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atN() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.ab.Ha().ac(System.currentTimeMillis());
        ac(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aVb();
        aui();
        int i = -1;
        if (getIntent() != null) {
            v(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
        }
        int i2 = i;
        this.isFirstGoMaintab = TbadkCoreApplication.m411getInst().isFirstGoMaintab();
        this.mHandler = new Handler();
        z zVar = new z();
        com.baidu.tbadk.core.d.b.a(zVar);
        zVar.a(this);
        if (aVd()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(t.h.maintabs_activity);
        com.baidu.tbadk.core.a.a.qM().qN();
        this.etw = new aa(this);
        this.etw.iP(this.mIsLogin);
        aVc();
        KL();
        com.baidu.tieba.tblauncher.alarmRemind.b.aVt().g(this);
        atN();
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
        String installOtherApp = TbadkCoreApplication.m411getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), installOtherApp);
            TbadkCoreApplication.m411getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.m411getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new h(this));
        registerListener(this.cmn);
        if (i2 == 1) {
            this.etw.iS(true);
            this.etw.iT(true);
        } else {
            this.etw.iS(false);
            this.etw.iT(false);
        }
        this.etw.aVq();
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onCreate(getPageContext());
        }
        registerListener(this.cyr);
        adjustResizeForSoftInput();
        com.baidu.tbadk.performanceLog.ab.Ha().ad(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.ab.Ha().Hb();
        }
    }

    private void v(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                TiebaStatic.log(new aw("c10320").r("obj_locate", 1).r("obj_type", 1));
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
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onStart(getPageContext());
        }
    }

    public boolean aVd() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        abL();
        com.baidu.tbadk.coreExtra.messageCenter.a.zp().zC();
        com.baidu.tbadk.coreExtra.messageCenter.a.zp().zv();
        com.baidu.tbadk.coreExtra.messageCenter.a.zp().aG(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.h.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        aVe();
        if (this.etw != null && this.etw.aVp() != null) {
            this.etw.aVp().reset();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.d.b.a(null);
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onDestory(getPageContext());
        }
        System.gc();
    }

    private void aVe() {
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

    private void KL() {
        registerListener(this.etB);
        this.dKu.setPriority(100);
        registerListener(this.dKu);
        registerListener(this.etH);
        registerListener(this.etJ);
        registerListener(this.etE);
        registerListener(this.etF);
        registerListener(this.etG);
        registerListener(this.etD);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.etC);
        this.etx = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.etx, intentFilter);
    }

    private void abL() {
        if (this.etx != null) {
            unregisterReceiver(this.etx);
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
        this.etq = this.etw.aVp().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.ab.Ha().GZ()) {
            com.baidu.tbadk.performanceLog.ab.Ha().Hb();
        }
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onResume(getPageContext());
        }
        if (this.etw != null) {
            this.etw.aVq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.etA = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.EG().EI();
        }
        this.etw.switchNaviBarStatus(z);
        this.etw.aVp().setWidgetLayerVisibleNoAnimation(false);
        this.isUserChanged = true;
        atN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.etp) {
            this.etp = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), t.a.down, t.a.hold);
        }
        TbadkCoreApplication.m411getInst().DelResumeNum();
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.etw.aVp().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        v(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            aVf();
        }
        com.baidu.tbadk.getUserInfo.b.EG().EI();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.etw.aVp().setWidgetLayerVisibleNoAnimation(false);
            atN();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.m411getInst().notifyAppEnterBackground();
            finish();
        } else {
            this.etw.aVp().setCurrentTabByType(intExtra);
        }
        f(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.etw != null) {
            this.etw.aVq();
        }
    }

    private void aVf() {
    }

    protected void q(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bZ(t.j.confirm_title).am(false).ca(t.j.background_process_permission).a(t.j.now_goto_setting, new i(this)).b(t.j.next_time, new j(this)).b(com.baidu.adp.base.l.s(activity)).up();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aVg() {
        com.baidu.adp.lib.g.c.hr().d(getUniqueId());
        aVi();
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
                    if (this.etw.atR()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    }
                    if (System.currentTimeMillis() - this.ets > 2000) {
                        showToast(t.j.double_back_quit);
                        this.ets = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        q(getPageContext().getPageActivity());
                        return true;
                    } else {
                        aVg();
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
    public void w(Intent intent) {
        try {
            this.etw.aVp().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void aVh() {
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
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(t.j.login_home_tab), 11003)));
            }
            if (this.etw.aVp().getCurrentFragment() != null) {
                this.etw.aVp().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            aVh();
        } else if (this.etw.aVp().getCurrentFragment() != null) {
            this.etw.aVp().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.etw.onChangeSkinType(i);
        bt(i);
    }

    private void aVi() {
        if (System.currentTimeMillis() - this.ett >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.ett = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.etw.aVp() != null) {
            return this.etw.aVp().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bja == null) {
            this.bja = VoiceManager.instance();
        }
        return this.bja;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int xH() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> xI() {
        if (this.ahC == null) {
            this.ahC = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.ahC;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Qr() {
        if (this.dwT == null) {
            this.dwT = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.dwT;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new l(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.etA && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.etA = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
