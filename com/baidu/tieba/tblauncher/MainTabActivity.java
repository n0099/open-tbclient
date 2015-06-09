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
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
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
    private boolean cvM;
    private aj cvs;
    private boolean isFirstGoMaintab;
    public static boolean cvj = true;
    private static long cvF = 259200000;
    private boolean cvk = false;
    private int cvl = -1;
    private boolean cvm = false;
    private boolean cvn = false;
    private long cvo = 0;
    private long cvp = 0;
    private final long cvq = 2000;
    private final long cvr = 7200000;
    private ac cvt = null;
    private int cvu = 0;
    private int cvv = 0;
    private int cvw = 0;
    private int cvx = 0;
    private int cvy = 0;
    private boolean cvz = false;
    private boolean cvA = false;
    private boolean mHasNewVersion = false;
    private boolean cvB = false;
    private boolean cvC = false;
    private boolean cvD = false;
    private boolean cvE = false;
    private Handler mHandler = null;
    private long cvG = -1;
    private final CustomMessageListener cha = new b(this, 2009503);
    private final com.baidu.adp.framework.listener.e bmu = new m(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
    final CustomMessageListener cvH = new v(this, 2001124);
    private final CustomMessageListener aDN = new w(this, 2001236);
    private final CustomMessageListener cvI = new x(this, 2001258);
    private final CustomMessageListener cvJ = new y(this, 2001253);
    final CustomMessageListener cvK = new z(this, 2007002);
    final CustomMessageListener cvL = new aa(this, 2007013);
    private final CustomMessageListener cvN = new ab(this, 2001237);
    private final CustomMessageListener cvO = new c(this, 2001266);
    private final CustomMessageListener cvP = new d(this, 2001324);
    CustomMessageListener cvQ = new e(this, 2001180);
    CustomMessageListener cvR = new f(this, 2001189);
    private final CustomMessageListener cvS = new g(this, 2001267);
    private final CustomMessageListener cvT = new h(this, 2001271);
    private final CustomMessageListener cvU = new i(this, 2007006);
    private final CustomMessageListener aMk = new j(this, 2012112);
    private final CustomMessageListener cvV = new k(this, 2007005);
    private final Runnable cvW = new l(this);
    private final CustomMessageListener cvX = new n(this, 2001158);
    private final CustomMessageListener cvY = new o(this, 2001124);

    /* JADX INFO: Access modifiers changed from: private */
    public void jM(String str) {
        String configVersion;
        if (str != null && (configVersion = TbadkCoreApplication.m411getInst().getConfigVersion()) != null && !configVersion.equalsIgnoreCase(str) && apZ()) {
            this.cvG = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean apZ() {
        if (-1 == this.cvG) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.cvG;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void aqa() {
        registerListener(this.cha);
    }

    private void aqb() {
        registerListener(new p(this, 2007009));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anW() {
        boolean z = true;
        if (MainTabActivityStatic.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (MainTabActivityStatic.getGame().hasGameCenter != null && MainTabActivityStatic.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.cvs.fn(true);
                long j = com.baidu.tbadk.core.sharedPref.b.sl().getLong("game_last_time", 0L);
                if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.sl().putLong("game_last_time", MainTabActivityStatic.getGame().gameLastLaunchtime.longValue());
                } else if (MainTabActivityStatic.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.cvs.fr(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, Boolean.valueOf(z)));
                return;
            }
            this.cvs.fn(false);
            this.cvs.fr(false);
            com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("game_is_show_tip", false);
        }
    }

    public void aqc() {
        this.cvA = false;
        this.cvy = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.cvz = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new q(this));
        fl(false);
    }

    public void a(com.baidu.tbadk.data.g gVar) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && gVar != null) {
            if ((gVar.yO() == 1 || gVar.yO() == 2) && com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("show_member_deid_line", true)) {
                long qs = gVar.qs() * 1000;
                if (qs < System.currentTimeMillis()) {
                    if (StringUtils.isNull(gVar.yP())) {
                        gVar.eq(getPageContext().getString(com.baidu.tieba.t.member));
                    } else {
                        gVar.eq(String.valueOf(gVar.yP()) + getPageContext().getString(com.baidu.tieba.t.member_already_Expire));
                    }
                    this.cvs.a(gVar, 0);
                } else if (qs - System.currentTimeMillis() < cvF) {
                    if (StringUtils.isNull(gVar.yP())) {
                        gVar.eq(getPageContext().getString(com.baidu.tieba.t.member));
                    } else {
                        gVar.eq(String.valueOf(gVar.yP()) + getPageContext().getString(com.baidu.tieba.t.member_will_Expire));
                    }
                    this.cvs.a(gVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.cvM) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.cvs.fs(this.mIsLogin);
        }
        if (this.cvs.aqv() == null || this.cvs.aqv().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void aqd() {
        if (this.cvA) {
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
    public void aqe() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.f(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.ai.DI().B(System.currentTimeMillis());
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aqa();
        aqb();
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
        this.cvz = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        ai aiVar = new ai();
        com.baidu.tbadk.core.c.b.a(aiVar);
        aiVar.a(this);
        if (aqg()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(com.baidu.tieba.r.maintabs_activity);
        com.baidu.tbadk.core.a.a.qi().qj();
        this.cvs = new aj(this);
        this.cvs.fm(this.mIsLogin);
        anW();
        this.cvs.setSlidingEnabled(this.mIsLogin);
        aqf();
        regReceiver();
        com.baidu.tbadk.getUserInfo.b.Ag().Ai();
        aqe();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
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
            this.cvs.aqw().showMenu(true);
            this.cvs.y(0.0f);
            TbadkCoreApplication.m411getInst().setFirstGoMaintab(false);
        }
        com.baidu.tbadk.performanceLog.ai.DI().C(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.performanceLog.ai.DI().DJ();
        }
        this.mHandler.postDelayed(this.cvW, 10000L);
        this.mHandler.post(new r(this));
        this.mHandler.post(new s(this));
        registerListener(this.bmu);
        if (i2 == 1) {
            this.cvs.fp(true);
        } else {
            this.cvs.fp(false);
        }
    }

    private void aqf() {
        this.cvw = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgLiveVip();
        if (this.cvw > 0) {
            this.cvE = true;
        }
        fl(false);
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
        if (view == this.cvs.aqy()) {
            this.cvs.jd(0);
            cvj = false;
            sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(boolean z) {
        int i = 2;
        this.cvs.fo(((this.cvu > 0 && this.cvB) || ((this.cvy > 0 && this.cvA) || ((this.cvx > 0 && this.cvD) || ((this.cvv > 0 && this.cvC) || (this.cvw > 0 && this.cvE))))) && !this.cvs.isMenuShowing());
        this.cvs.aqx().fu((this.cvu > 0 && this.cvB) || (this.cvv > 0 && this.cvC));
        this.cvs.aqx().am(0, (this.cvy <= 0 || !this.cvA) ? 0 : 2);
        this.cvs.aqx().am(1, (this.cvx <= 0 || !this.cvD) ? 0 : 2);
        com.baidu.tieba.tblauncher.a.d aqx = this.cvs.aqx();
        if (this.cvw <= 0 || !this.cvE) {
            i = 0;
        }
        aqx.am(3, i);
        this.cvs.aqx().fv(this.mHasNewVersion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public void jc(int i) {
        this.cvl = i;
    }

    public boolean aqg() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        unregReceiver();
        com.baidu.tbadk.coreExtra.messageCenter.a.vJ().vW();
        com.baidu.tbadk.coreExtra.messageCenter.a.vJ().vP();
        com.baidu.tbadk.coreExtra.messageCenter.a.vJ().av(false);
        aqd();
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.k.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cvW);
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
        registerListener(this.cvX);
        registerListener(this.cvY);
        registerListener(this.cvH);
        this.cvK.setPriority(100);
        registerListener(this.cvK);
        registerListener(this.cvL);
        registerListener(this.cvV);
        registerListener(this.cvU);
        registerListener(this.cvN);
        registerListener(this.aMk);
        registerListener(this.aDN);
        registerListener(this.cvI);
        registerListener(this.cvJ);
        registerListener(this.cvO);
        registerListener(this.cvS);
        registerListener(this.cvT);
        registerListener(this.cvQ);
        registerListener(this.cvR);
        registerListener(this.cvP);
        this.cvt = new ac(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cvt, intentFilter);
    }

    private void unregReceiver() {
        if (this.cvt != null) {
            unregisterReceiver(this.cvt);
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
        this.cvl = this.cvs.aqv().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.performanceLog.ai.DI().DH()) {
            com.baidu.tbadk.performanceLog.ai.DI().DJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            com.baidu.tbadk.getUserInfo.b.Ag().Ai();
        }
        this.cvs.setSlidingEnabled(z);
        this.cvs.switchNaviBarStatus(z);
        this.cvm = true;
        aqe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.cvk) {
            this.cvk = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), com.baidu.tieba.k.down, com.baidu.tieba.k.hold);
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
        bundle.putInt("locate_type", this.cvs.aqv().getCurrentTabType());
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
            aqh();
        }
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
            com.baidu.tbadk.getUserInfo.b.Ag().Ai();
            aqe();
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
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4) {
            this.cvs.aqv().setCurrentTabByType(intExtra);
        }
        this.cvs.aqx().aqB();
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void aqh() {
    }

    protected void s(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bt(com.baidu.tieba.t.confirm_title).ag(false).bu(com.baidu.tieba.t.background_process_permission).a(com.baidu.tieba.t.now_goto_setting, new t(this)).b(com.baidu.tieba.t.next_time, new u(this)).b(com.baidu.adp.base.n.D(activity)).rL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqi() {
        aqk();
        moveTaskToBack(true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (this.cvs.aqw().isMenuShowing()) {
                this.cvs.aqw().showContent(true);
                return true;
            } else if (this.cvs.aqt()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                return true;
            } else {
                if (System.currentTimeMillis() - this.cvo > 2000) {
                    showToast(com.baidu.tieba.t.double_back_quit);
                    this.cvo = System.currentTimeMillis();
                } else if (UtilHelper.isBackgroundProcessLimitNone()) {
                    s(getPageContext().getPageActivity());
                    return true;
                } else {
                    aqi();
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
    public void W(Intent intent) {
        try {
            this.cvs.aqv().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void aqj() {
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
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(com.baidu.tieba.t.login_home_tab), 11003)));
            }
            if (this.cvs.aqv().getCurrentFragment() != null) {
                this.cvs.aqv().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            aqj();
        } else if (this.cvs.aqv().getCurrentFragment() != null) {
            this.cvs.aqv().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cvs.onChangeSkinType(i);
    }

    private void aqk() {
        if (System.currentTimeMillis() - this.cvp >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.c.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.cvp = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.cvs.aqv() != null) {
            return this.cvs.aqv().getCurrentTabType();
        }
        return -1;
    }
}
