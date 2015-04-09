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
    public static boolean cre = true;
    private static long crw = 259200000;
    private boolean crC;
    private ai crl;
    private boolean isFirstGoMaintab;
    private boolean crf = false;
    private int crg = -1;
    private long crh = 0;
    private long cri = 0;
    private final long crj = 2000;
    private final long crk = 7200000;
    private ab crm = null;
    private int crn = 0;
    private int cro = 0;
    private int crp = 0;
    private int crq = 0;
    private boolean crr = false;
    private boolean crs = false;
    private boolean mHasNewVersion = false;
    private boolean crt = false;
    private boolean cru = false;
    private boolean crv = false;
    private Handler mHandler = null;
    private long crx = -1;
    private final CustomMessageListener ccx = new b(this, 2009503);
    private final com.baidu.adp.framework.listener.e bjQ = new m(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    final CustomMessageListener cry = new u(this, 2001124);
    private final CustomMessageListener aBP = new v(this, 2001236);
    private final CustomMessageListener crz = new w(this, 2001258);
    private final CustomMessageListener crA = new x(this, 2001253);
    final CustomMessageListener crB = new y(this, 2007002);
    private final CustomMessageListener crD = new z(this, 2001237);
    private final CustomMessageListener crE = new aa(this, 2001266);
    CustomMessageListener crF = new c(this, 2001180);
    CustomMessageListener crG = new d(this, 2001189);
    private final CustomMessageListener crH = new e(this, 2001267);
    private final CustomMessageListener crI = new f(this, 2001271);
    private final CustomMessageListener crJ = new g(this, 2007006);
    private final CustomMessageListener aKc = new h(this, 2012112);
    private final CustomMessageListener crK = new i(this, 2007005);
    private final Runnable crL = new j(this);
    private final CustomMessageListener crM = new k(this, 2001158);
    private final CustomMessageListener crN = new l(this, 2001124);
    final Runnable crO = new n(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(String str) {
        String configVersion;
        if (str != null && (configVersion = TbadkCoreApplication.m411getInst().getConfigVersion()) != null && !configVersion.equalsIgnoreCase(str) && aoh()) {
            this.crx = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean aoh() {
        if (-1 == this.crx) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.crx;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void aoi() {
        registerListener(this.ccx);
    }

    private void aoj() {
        registerListener(new o(this, 2007009));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amj() {
        boolean z = true;
        if (MainTabActivityStatic.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (MainTabActivityStatic.getGame().hasGameCenter != null && MainTabActivityStatic.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.crl.eT(true);
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
                this.crl.eW(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, Boolean.valueOf(z)));
                return;
            }
            this.crl.eT(false);
            this.crl.eW(false);
            com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("game_is_show_tip", false);
        }
    }

    public void aok() {
        this.crs = false;
        this.crq = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.crr = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new p(this));
        eS(false);
    }

    public void a(com.baidu.tbadk.data.g gVar) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && gVar != null) {
            if ((gVar.ya() == 1 || gVar.ya() == 2) && com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("show_member_deid_line", true)) {
                long pM = gVar.pM() * 1000;
                if (pM < System.currentTimeMillis()) {
                    if (StringUtils.isNull(gVar.yb())) {
                        gVar.dZ(getPageContext().getString(com.baidu.tieba.y.member));
                    } else {
                        gVar.dZ(String.valueOf(gVar.yb()) + getPageContext().getString(com.baidu.tieba.y.member_already_Expire));
                    }
                    this.crl.a(gVar, 0);
                } else if (pM - System.currentTimeMillis() < crw) {
                    if (StringUtils.isNull(gVar.yb())) {
                        gVar.dZ(getPageContext().getString(com.baidu.tieba.y.member));
                    } else {
                        gVar.dZ(String.valueOf(gVar.yb()) + getPageContext().getString(com.baidu.tieba.y.member_will_Expire));
                    }
                    this.crl.a(gVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.crC) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.crl.aoD();
            this.mHandler.removeCallbacks(this.crO);
        }
        if (this.crl.aoE() == null || this.crl.aoE().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void aol() {
        if (this.crs) {
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

    protected void aom() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.f(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.ai.CW().B(System.currentTimeMillis());
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aoi();
        aoj();
        if (getIntent() != null && getIntent().getIntExtra("locate_type", 0) == 200) {
            finish();
            return;
        }
        this.isFirstGoMaintab = TbadkCoreApplication.m411getInst().isFirstGoMaintab();
        this.mHandler = new Handler();
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.crr = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        ah ahVar = new ah();
        com.baidu.tbadk.core.c.b.a(ahVar);
        ahVar.a(this);
        if (aon()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        if (!com.baidu.adp.lib.g.b.hH().a(getPageContext().getPageActivity(), com.baidu.tieba.w.maintabs_activity)) {
            finish();
            return;
        }
        com.baidu.tbadk.core.a.a.pD().p(getPageContext().getPageActivity());
        this.crl = new ai(this);
        this.crl.ov();
        amj();
        regReceiver();
        com.baidu.tbadk.getUserInfo.b.zs().zu();
        aom();
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
            this.crl.aoF().showMenu(true);
            this.crl.x(0.0f);
            TbadkCoreApplication.m411getInst().setFirstGoMaintab(false);
        }
        com.baidu.tbadk.performanceLog.ai.CW().C(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.ai.CW().CX();
        }
        this.mHandler.postDelayed(this.crL, 10000L);
        this.mHandler.post(new q(this));
        this.mHandler.post(new r(this));
        registerListener(this.bjQ);
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
        if (view == this.crl.aoH()) {
            this.crl.iH(0);
            cre = false;
            sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS(boolean z) {
        int i = 2;
        this.crl.eU(((this.crn > 0 && this.crt) || ((this.crq > 0 && this.crs) || ((this.crp > 0 && this.crv) || (this.cro > 0 && this.cru)))) && !this.crl.isMenuShowing());
        this.crl.aoG().eY((this.crn > 0 && this.crt) || (this.cro > 0 && this.cru));
        this.crl.aoG().al(0, (this.crq <= 0 || !this.crs) ? 0 : 2);
        com.baidu.tieba.tblauncher.a.d aoG = this.crl.aoG();
        if (this.crp <= 0 || !this.crv) {
            i = 0;
        }
        aoG.al(1, i);
        this.crl.aoG().eZ(this.mHasNewVersion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public void iG(int i) {
        this.crg = i;
    }

    public boolean aon() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        unregReceiver();
        com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vm();
        com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vf();
        com.baidu.tbadk.coreExtra.messageCenter.a.uZ().ao(false);
        aol();
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.k.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.crL);
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
        registerListener(this.crM);
        registerListener(this.crN);
        registerListener(this.cry);
        this.crB.setPriority(100);
        registerListener(this.crB);
        registerListener(this.crK);
        registerListener(this.crJ);
        registerListener(this.crD);
        registerListener(this.aKc);
        registerListener(this.aBP);
        registerListener(this.crz);
        registerListener(this.crA);
        registerListener(this.crE);
        registerListener(this.crH);
        registerListener(this.crI);
        registerListener(this.crF);
        registerListener(this.crG);
        this.crm = new ab(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.crm, intentFilter);
    }

    private void unregReceiver() {
        if (this.crm != null) {
            unregisterReceiver(this.crm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TbadkCoreApplication.m411getInst().AddResumeNum();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
            this.mHandler.postDelayed(this.crO, 500L);
        }
        this.crg = this.crl.aoE().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.ai.CW().CV()) {
            com.baidu.tbadk.performanceLog.ai.CW().CX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.crf) {
            this.crf = false;
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
        bundle.putInt("locate_type", this.crl.aoE().getCurrentTabType());
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
            aoo();
        }
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
            com.baidu.tbadk.getUserInfo.b.zs().zu();
            aom();
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
            this.crl.aoE().setCurrentTabByType(intExtra);
        }
        this.crl.aoG().aoL();
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void aoo() {
    }

    protected void s(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bw(com.baidu.tieba.y.confirm_title).ac(false).bx(com.baidu.tieba.y.background_process_permission).a(com.baidu.tieba.y.now_goto_setting, new s(this)).b(com.baidu.tieba.y.next_time, new t(this)).b(com.baidu.adp.base.m.D(activity)).re();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aop() {
        aor();
        moveTaskToBack(true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_AS_MAIN_APP && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (this.crl.aoF().isMenuShowing()) {
                this.crl.aoF().showContent(true);
                return true;
            } else if (this.crl.aoB()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                return true;
            } else {
                if (System.currentTimeMillis() - this.crh > 2000) {
                    showToast(com.baidu.tieba.y.double_back_quit);
                    this.crh = System.currentTimeMillis();
                } else if (UtilHelper.isBackgroundProcessLimitNone()) {
                    s(getPageContext().getPageActivity());
                    return true;
                } else {
                    aop();
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
            this.crl.aoE().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void aoq() {
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
            if (this.crl.aoE().getCurrentFragment() != null) {
                this.crl.aoE().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            aoq();
        } else if (this.crl.aoE().getCurrentFragment() != null) {
            this.crl.aoE().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.crl.onChangeSkinType(i);
    }

    private void aor() {
        if (System.currentTimeMillis() - this.cri >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.cri = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.crl.aoE() != null) {
            return this.crl.aoE().getCurrentTabType();
        }
        return -1;
    }
}
