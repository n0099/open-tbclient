package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements a {
    public static boolean cqO = true;
    private static long crg = 259200000;
    private ai cqV;
    private boolean crm;
    private boolean isFirstGoMaintab;
    private boolean cqP = false;
    private int cqQ = -1;
    private long cqR = 0;
    private long cqS = 0;
    private final long cqT = 2000;
    private final long cqU = 7200000;
    private ab cqW = null;
    private int cqX = 0;
    private int cqY = 0;
    private int cqZ = 0;
    private int cra = 0;
    private boolean crb = false;
    private boolean crc = false;
    private boolean mHasNewVersion = false;
    private boolean crd = false;
    private boolean cre = false;
    private boolean crf = false;
    private Handler mHandler = null;
    private long crh = -1;
    private final CustomMessageListener cci = new b(this, 2009503);
    private final com.baidu.adp.framework.listener.e bjA = new m(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    final CustomMessageListener cri = new u(this, 2001124);
    private final CustomMessageListener aBH = new v(this, 2001236);
    private final CustomMessageListener crj = new w(this, 2001258);
    private final CustomMessageListener crk = new x(this, 2001253);
    final CustomMessageListener crl = new y(this, 2007002);
    private final CustomMessageListener crn = new z(this, 2001237);
    private final CustomMessageListener cro = new aa(this, 2001266);
    CustomMessageListener crp = new c(this, 2001180);
    CustomMessageListener crq = new d(this, 2001189);
    private final CustomMessageListener crr = new e(this, 2001267);
    private final CustomMessageListener crs = new f(this, 2001271);
    private final CustomMessageListener crt = new g(this, 2007006);
    private final CustomMessageListener aJS = new h(this, 2012112);
    private final CustomMessageListener cru = new i(this, 2007005);
    private final Runnable crv = new j(this);
    private final CustomMessageListener crw = new k(this, 2001158);
    private final CustomMessageListener crx = new l(this, 2001124);
    final Runnable cry = new n(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void iP(String str) {
        String configVersion;
        if (str != null && (configVersion = TbadkCoreApplication.m411getInst().getConfigVersion()) != null && !configVersion.equalsIgnoreCase(str) && anS()) {
            this.crh = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean anS() {
        if (-1 == this.crh) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.crh;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void anT() {
        registerListener(this.cci);
    }

    private void anU() {
        registerListener(new o(this, 2007009));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alU() {
        boolean z = true;
        if (MainTabActivityStatic.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (MainTabActivityStatic.getGame().hasGameCenter != null && MainTabActivityStatic.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.cqV.eV(true);
                long j = com.baidu.tbadk.core.sharedPref.b.rB().getLong("game_last_time", 0L);
                if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.rB().putLong("game_last_time", MainTabActivityStatic.getGame().gameLastLaunchtime.longValue());
                } else if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.cqV.eY(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, Boolean.valueOf(z)));
                return;
            }
            this.cqV.eV(false);
            this.cqV.eY(false);
            com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("game_is_show_tip", false);
        }
    }

    public void anV() {
        this.crc = false;
        this.cra = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.crb = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new p(this));
        eU(false);
    }

    public void a(com.baidu.tbadk.data.g gVar) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && gVar != null) {
            if ((gVar.xU() == 1 || gVar.xU() == 2) && com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("show_member_deid_line", true)) {
                long pM = gVar.pM() * 1000;
                if (pM < System.currentTimeMillis()) {
                    if (StringUtils.isNull(gVar.xV())) {
                        gVar.dW(getPageContext().getString(com.baidu.tieba.y.member));
                    } else {
                        gVar.dW(String.valueOf(gVar.xV()) + getPageContext().getString(com.baidu.tieba.y.member_already_Expire));
                    }
                    this.cqV.a(gVar, 0);
                } else if (pM - System.currentTimeMillis() < crg) {
                    if (StringUtils.isNull(gVar.xV())) {
                        gVar.dW(getPageContext().getString(com.baidu.tieba.y.member));
                    } else {
                        gVar.dW(String.valueOf(gVar.xV()) + getPageContext().getString(com.baidu.tieba.y.member_will_Expire));
                    }
                    this.cqV.a(gVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.crm) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.cqV.aoo();
            this.mHandler.removeCallbacks(this.cry);
        }
        if (this.cqV.aop() == null || this.cqV.aop().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void anW() {
        if (this.crc) {
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

    protected void anX() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.f(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.ai.CQ().B(System.currentTimeMillis());
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        anT();
        anU();
        if (getIntent() != null && getIntent().getIntExtra("locate_type", 0) == 200) {
            finish();
            return;
        }
        this.isFirstGoMaintab = TbadkCoreApplication.m411getInst().isFirstGoMaintab();
        this.mHandler = new Handler();
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.crb = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        ah ahVar = new ah();
        com.baidu.tbadk.core.c.b.a(ahVar);
        ahVar.a(this);
        if (anY()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        if (!com.baidu.adp.lib.g.b.hH().a(getPageContext().getPageActivity(), com.baidu.tieba.w.maintabs_activity)) {
            finish();
            return;
        }
        com.baidu.tbadk.core.a.a.pD().p(getPageContext().getPageActivity());
        this.cqV = new ai(this);
        this.cqV.ov();
        alU();
        regReceiver();
        com.baidu.tbadk.getUserInfo.b.zm().zo();
        anX();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        String installOtherApp = TbadkCoreApplication.m411getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), installOtherApp);
            TbadkCoreApplication.m411getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            this.cqV.aoq().showMenu(true);
            this.cqV.x(0.0f);
            TbadkCoreApplication.m411getInst().setFirstGoMaintab(false);
        }
        com.baidu.tbadk.performanceLog.ai.CQ().C(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.ai.CQ().CR();
        }
        this.mHandler.postDelayed(this.crv, 10000L);
        this.mHandler.post(new q(this));
        this.mHandler.post(new r(this));
        registerListener(this.bjA);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cqV.aos()) {
            this.cqV.iE(0);
            cqO = false;
            sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eU(boolean z) {
        int i = 2;
        this.cqV.eW(((this.cqX > 0 && this.crd) || ((this.cra > 0 && this.crc) || ((this.cqZ > 0 && this.crf) || (this.cqY > 0 && this.cre)))) && !this.cqV.isMenuShowing());
        this.cqV.aor().fa((this.cqX > 0 && this.crd) || (this.cqY > 0 && this.cre));
        this.cqV.aor().al(0, (this.cra <= 0 || !this.crc) ? 0 : 2);
        com.baidu.tieba.tblauncher.a.d aor = this.cqV.aor();
        if (this.cqZ <= 0 || !this.crf) {
            i = 0;
        }
        aor.al(1, i);
        this.cqV.aor().fb(this.mHasNewVersion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public void iD(int i) {
        this.cqQ = i;
    }

    public boolean anY() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        unregReceiver();
        com.baidu.tbadk.coreExtra.messageCenter.a.uT().vg();
        com.baidu.tbadk.coreExtra.messageCenter.a.uT().uZ();
        com.baidu.tbadk.coreExtra.messageCenter.a.uT().ao(false);
        anW();
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.k.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.crv);
        }
        super.onDestroy();
        System.gc();
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
        registerListener(this.crw);
        registerListener(this.crx);
        registerListener(this.cri);
        this.crl.setPriority(100);
        registerListener(this.crl);
        registerListener(this.cru);
        registerListener(this.crt);
        registerListener(this.crn);
        registerListener(this.aJS);
        registerListener(this.aBH);
        registerListener(this.crj);
        registerListener(this.crk);
        registerListener(this.cro);
        registerListener(this.crr);
        registerListener(this.crs);
        registerListener(this.crp);
        registerListener(this.crq);
        this.cqW = new ab(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cqW, intentFilter);
    }

    private void unregReceiver() {
        if (this.cqW != null) {
            unregisterReceiver(this.cqW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TbadkCoreApplication.m411getInst().AddResumeNum();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
            this.mHandler.postDelayed(this.cry, 500L);
        }
        this.cqQ = this.cqV.aop().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.ai.CQ().CP()) {
            com.baidu.tbadk.performanceLog.ai.CQ().CR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.cqP) {
            this.cqP = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), com.baidu.tieba.p.down, com.baidu.tieba.p.hold);
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
        bundle.putInt("locate_type", this.cqV.aop().getCurrentTabType());
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
            anZ();
        }
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
            com.baidu.tbadk.getUserInfo.b.zm().zo();
            anX();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.m411getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 4) {
            this.cqV.aop().setCurrentTabByType(intExtra);
        }
        this.cqV.aor().aow();
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void anZ() {
    }

    protected void s(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bw(com.baidu.tieba.y.confirm_title).ac(false).bx(com.baidu.tieba.y.background_process_permission).a(com.baidu.tieba.y.now_goto_setting, new s(this)).b(com.baidu.tieba.y.next_time, new t(this)).b(com.baidu.adp.base.m.D(activity)).re();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoa() {
        aoc();
        moveTaskToBack(true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_AS_MAIN_APP && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (this.cqV.aoq().isMenuShowing()) {
                this.cqV.aoq().showContent(true);
                return true;
            } else if (this.cqV.aom()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                return true;
            } else {
                if (System.currentTimeMillis() - this.cqR > 2000) {
                    showToast(com.baidu.tieba.y.double_back_quit);
                    this.cqR = System.currentTimeMillis();
                } else if (UtilHelper.isBackgroundProcessLimitNone()) {
                    s(getPageContext().getPageActivity());
                    return true;
                } else {
                    aoa();
                }
                return false;
            }
        }
        if (keyEvent.getAction() == 0) {
            keyEvent.getKeyCode();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Intent intent) {
        try {
            this.cqV.aop().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void aob() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i == 12007) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(com.baidu.tieba.y.login_home_tab), 11003)));
            }
            if (this.cqV.aop().getCurrentFragment() != null) {
                this.cqV.aop().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            aob();
        } else if (this.cqV.aop().getCurrentFragment() != null) {
            this.cqV.aop().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cqV.onChangeSkinType(i);
    }

    private void aoc() {
        if (System.currentTimeMillis() - this.cqS >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.cqS = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.cqV.aop() != null) {
            return this.cqV.aop().getCurrentTabType();
        }
        return -1;
    }
}
