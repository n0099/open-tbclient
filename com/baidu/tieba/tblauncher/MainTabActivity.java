package com.baidu.tieba.tblauncher;

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
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.messageCenter.a;
import com.baidu.tbadk.data.g;
import com.baidu.tbadk.mainTab.f;
import com.baidu.tieba.compatible.CompatibleUtile;
import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements h {
    public static boolean ccE = true;
    private static long ccS = 259200000;
    private static Game ccT;
    private ai ccK;
    private CustomMessageListener ccV;
    private boolean isFirstGoMaintab;
    private boolean ccF = false;
    private long ccG = 0;
    private long ccH = 0;
    private final long ccI = 2000;
    private final long ccJ = 7200000;
    private ag ccL = null;
    private int ccM = 0;
    private int ccN = 0;
    private int ccO = 0;
    private boolean mHasNewVersion = false;
    private boolean ccP = false;
    private boolean ccQ = false;
    private boolean ccR = false;
    private Handler mHandler = null;
    private long ccU = -1;
    private final CustomMessageListener ccW = new t(this, 2009503);
    private final e bip = new z(this, 1001);
    final CustomMessageListener ccX = new aa(this, 2001124);
    private final CustomMessageListener atZ = new ab(this, 2001236);
    private final CustomMessageListener ccY = new ac(this, 2001258);
    private final CustomMessageListener ccZ = new ad(this, 2001253);
    final CustomMessageListener cda = new ae(this, 2007002);
    private final CustomMessageListener cdb = new af(this, 2001237);
    private final CustomMessageListener cdc = new j(this, 2001266);
    private final CustomMessageListener cdd = new k(this, 2001267);
    private final CustomMessageListener cde = new l(this, 2001271);
    private final CustomMessageListener cdf = new m(this, 2007006);
    private final CustomMessageListener aDE = new n(this, 2012112);
    private final CustomMessageListener cdg = new o(this, 2007005);
    private final Runnable cdh = new p(this);
    private final CustomMessageListener cdi = new q(this, 2001158);
    private final CustomMessageListener cdj = new r(this, 2001124);
    final Runnable cdk = new s(this);

    static {
        FP();
        ajk();
        Dc();
        ajj();
        MessageManager.getInstance().registerListener(new i(2002004));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz(String str) {
        String configVersion;
        if (str != null && (configVersion = TbadkCoreApplication.m255getInst().getConfigVersion()) != null && !configVersion.equalsIgnoreCase(str) && ajf()) {
            this.ccU = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean ajf() {
        if (-1 == this.ccU) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.ccU;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void ajg() {
        registerListener(this.ccW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajh() {
        boolean z = true;
        if (ccT != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m255getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (ccT.hasGameCenter != null && ccT.hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.ccK.eI(true);
                long j = b.oj().getLong("game_last_time", 0L);
                if (ccT.gameLastLaunchtime.longValue() > j) {
                    b.oj().putBoolean("game_is_show_tip", true);
                    b.oj().putLong("game_last_time", ccT.gameLastLaunchtime.longValue());
                } else if (ccT.gameLastLaunchtime.longValue() == j) {
                    z = b.oj().getBoolean("game_is_show_tip", true);
                } else {
                    b.oj().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.ccK.eK(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, Boolean.valueOf(z)));
                return;
            }
            this.ccK.eI(false);
            this.ccK.eK(false);
            b.oj().putBoolean("game_is_show_tip", false);
        }
    }

    private void aji() {
        this.ccV = new u(this, 2007007);
        this.ccV.setPriority(10);
        registerListener(this.ccV);
    }

    private static void FP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new v());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Dc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new w());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void ajj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001258, new x());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void ajk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012111, new y());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(g gVar) {
        if (gVar != null) {
            if ((gVar.uK() == 1 || gVar.uK() == 2) && b.oj().getBoolean("show_member_deid_line", true)) {
                long ms = gVar.ms() * 1000;
                if (ms < System.currentTimeMillis()) {
                    if (StringUtils.isNull(gVar.uL())) {
                        gVar.dQ(getPageContext().getString(com.baidu.tieba.z.member));
                    } else {
                        gVar.dQ(String.valueOf(gVar.uL()) + getPageContext().getString(com.baidu.tieba.z.member_already_Expire));
                    }
                    this.ccK.a(gVar, 0);
                } else if (ms - System.currentTimeMillis() < ccS) {
                    if (StringUtils.isNull(gVar.uL())) {
                        gVar.dQ(getPageContext().getString(com.baidu.tieba.z.member));
                    } else {
                        gVar.dQ(String.valueOf(gVar.uL()) + getPageContext().getString(com.baidu.tieba.z.member_will_Expire));
                    }
                    this.ccK.a(gVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ccK.ajy();
            this.mHandler.removeCallbacks(this.cdk);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void ajl() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.g(getPageContext().getPageActivity())));
    }

    protected void ajm() {
        aji();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007007, new f(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.ad.zC().B(System.currentTimeMillis());
        super.onCreate(bundle);
        ajg();
        if (getIntent() != null && getIntent().getIntExtra("locate_type", 0) == 200) {
            finish();
            return;
        }
        this.isFirstGoMaintab = TbadkCoreApplication.m255getInst().getIsFirstUse();
        if (this.isFirstGoMaintab) {
            TbadkApplication.getInst().setUsed();
            TbadkApplication.getInst().setFirstGoFrs(true);
        }
        this.mHandler = new Handler();
        ah ahVar = new ah();
        com.baidu.tbadk.core.b.b.a(ahVar);
        ahVar.a(this);
        if (ajn()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        if (!com.baidu.adp.lib.g.b.ei().a(getPageContext().getPageActivity(), com.baidu.tieba.x.maintabs_activity)) {
            finish();
            return;
        }
        AccountLoginHelper.getInstance().reLoginByCacheAccount(getPageContext().getPageActivity());
        this.ccK = new ai(this);
        this.ccK.kJ();
        ajh();
        regReceiver();
        com.baidu.tbadk.getUserInfo.b.vS().vU();
        ajl();
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
        String installOtherApp = TbadkCoreApplication.m255getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.m255getInst().getApp(), installOtherApp);
            TbadkCoreApplication.m255getInst().setInstallOtherApp(null);
        }
        ajm();
        if (this.isFirstGoMaintab) {
            this.ccK.ajA().showMenu(true);
            this.ccK.y(0.0f);
            TbadkCoreApplication.m255getInst().setFirstGoMaintab(false);
        }
        com.baidu.tbadk.performanceLog.ad.zC().C(System.currentTimeMillis());
        com.baidu.tbadk.performanceLog.ad.zC().zD();
        this.mHandler.postDelayed(this.cdh, 10000L);
        registerListener(this.bip);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ccK.ajC()) {
            this.ccK.im(0);
            ccE = false;
            sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(boolean z) {
        boolean z2 = true;
        this.ccK.eJ(((this.ccM > 0 && this.ccP) || ((this.ccO > 0 && this.ccR) || (this.ccN > 0 && this.ccQ))) && !this.ccK.isMenuShowing());
        if ((this.ccM <= 0 || !this.ccP) && (this.ccN <= 0 || !this.ccQ)) {
            z2 = false;
        }
        this.ccK.ajB().eM(z2);
        this.ccK.ajB().ah(0, (this.ccO <= 0 || !this.ccR) ? 0 : 2);
        this.ccK.ajB().eN(this.mHasNewVersion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public boolean ajn() {
        return TbadkCoreApplication.m255getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        unregReceiver();
        a.rY().sl();
        a.rY().se();
        a.rY().av(false);
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.k.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
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
        registerListener(this.cdi);
        registerListener(this.cdj);
        registerListener(this.ccX);
        this.cda.setPriority(100);
        registerListener(this.cda);
        registerListener(this.cdg);
        registerListener(this.cdf);
        registerListener(this.cdb);
        registerListener(this.aDE);
        registerListener(this.atZ);
        registerListener(this.ccY);
        registerListener(this.ccZ);
        registerListener(this.cdc);
        registerListener(this.cdd);
        registerListener(this.cde);
        this.ccL = new ag(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.ccL, intentFilter);
    }

    private void unregReceiver() {
        if (this.ccL != null) {
            unregisterReceiver(this.ccL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TbadkCoreApplication.m255getInst().AddResumeNum();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
            this.mHandler.postDelayed(this.cdk, 500L);
        }
        changeSkinType(this.mSkinType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.ccF) {
            this.ccF = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), com.baidu.tieba.q.down, com.baidu.tieba.q.hold);
        }
        TbadkCoreApplication.m255getInst().DelResumeNum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.ccK.ajz().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            ajo();
        }
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            com.baidu.tbadk.getUserInfo.b.vS().vU();
            ajl();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.m255getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 4) {
            this.ccK.ajz().setCurrentTabByType(intExtra);
        }
        this.ccK.ajB().ajI();
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void ajo() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_AS_MAIN_APP && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (this.ccK.ajA().isMenuShowing()) {
                this.ccK.ajA().showContent(true);
                return true;
            }
            if (System.currentTimeMillis() - this.ccG > 2000) {
                showToast(com.baidu.tieba.z.double_back_quit);
                this.ccG = System.currentTimeMillis();
            } else {
                ajq();
                moveTaskToBack(true);
                TbadkCoreApplication.m255getInst().notifyAppEnterBackground();
            }
            return false;
        }
        if (keyEvent.getAction() == 0) {
            keyEvent.getKeyCode();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Intent intent) {
        try {
            this.ccK.ajz().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void ajp() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
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
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(com.baidu.tieba.z.login_home_tab), 11003)));
            }
            if (this.ccK.ajz().getCurrentFragment() != null) {
                this.ccK.ajz().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            ajp();
        } else if (this.ccK.ajz().getCurrentFragment() != null) {
            this.ccK.ajz().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.ccK.onChangeSkinType(i);
    }

    private void ajq() {
        if (System.currentTimeMillis() - this.ccH >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.ccH = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.h
    public int getCurrentTabType() {
        if (this.ccK.ajz() != null) {
            return this.ccK.ajz().getCurrentTabType();
        }
        return -1;
    }
}
