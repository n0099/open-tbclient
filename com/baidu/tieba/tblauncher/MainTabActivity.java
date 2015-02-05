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
    public static boolean ccD = true;
    private static long ccR = 259200000;
    private static Game ccS;
    private ai ccJ;
    private CustomMessageListener ccU;
    private boolean isFirstGoMaintab;
    private boolean ccE = false;
    private long ccF = 0;
    private long ccG = 0;
    private final long ccH = 2000;
    private final long ccI = 7200000;
    private ag ccK = null;
    private int ccL = 0;
    private int ccM = 0;
    private int ccN = 0;
    private boolean mHasNewVersion = false;
    private boolean ccO = false;
    private boolean ccP = false;
    private boolean ccQ = false;
    private Handler mHandler = null;
    private long ccT = -1;
    private final CustomMessageListener ccV = new t(this, 2009503);
    private final e bio = new z(this, 1001);
    final CustomMessageListener ccW = new aa(this, 2001124);
    private final CustomMessageListener atW = new ab(this, 2001236);
    private final CustomMessageListener ccX = new ac(this, 2001258);
    private final CustomMessageListener ccY = new ad(this, 2001253);
    final CustomMessageListener ccZ = new ae(this, 2007002);
    private final CustomMessageListener cda = new af(this, 2001237);
    private final CustomMessageListener cdb = new j(this, 2001266);
    private final CustomMessageListener cdc = new k(this, 2001267);
    private final CustomMessageListener cdd = new l(this, 2001271);
    private final CustomMessageListener cde = new m(this, 2007006);
    private final CustomMessageListener aDB = new n(this, 2012112);
    private final CustomMessageListener cdf = new o(this, 2007005);
    private final Runnable cdg = new p(this);
    private final CustomMessageListener cdh = new q(this, 2001158);
    private final CustomMessageListener cdi = new r(this, 2001124);
    final Runnable cdj = new s(this);

    static {
        FJ();
        ajf();
        CW();
        aje();
        MessageManager.getInstance().registerListener(new i(2002004));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ix(String str) {
        String configVersion;
        if (str != null && (configVersion = TbadkCoreApplication.m255getInst().getConfigVersion()) != null && !configVersion.equalsIgnoreCase(str) && aja()) {
            this.ccT = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean aja() {
        if (-1 == this.ccT) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.ccT;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    private void ajb() {
        registerListener(this.ccV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajc() {
        boolean z = true;
        if (ccS != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m255getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (ccS.hasGameCenter != null && ccS.hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.ccJ.eI(true);
                long j = b.oc().getLong("game_last_time", 0L);
                if (ccS.gameLastLaunchtime.longValue() > j) {
                    b.oc().putBoolean("game_is_show_tip", true);
                    b.oc().putLong("game_last_time", ccS.gameLastLaunchtime.longValue());
                } else if (ccS.gameLastLaunchtime.longValue() == j) {
                    z = b.oc().getBoolean("game_is_show_tip", true);
                } else {
                    b.oc().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.ccJ.eK(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, Boolean.valueOf(z)));
                return;
            }
            this.ccJ.eI(false);
            this.ccJ.eK(false);
            b.oc().putBoolean("game_is_show_tip", false);
        }
    }

    private void ajd() {
        this.ccU = new u(this, 2007007);
        this.ccU.setPriority(10);
        registerListener(this.ccU);
    }

    private static void FJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new v());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void CW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new w());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aje() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001258, new x());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void ajf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012111, new y());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(g gVar) {
        if (gVar != null) {
            if ((gVar.uE() == 1 || gVar.uE() == 2) && b.oc().getBoolean("show_member_deid_line", true)) {
                long ml = gVar.ml() * 1000;
                if (ml < System.currentTimeMillis()) {
                    if (StringUtils.isNull(gVar.uF())) {
                        gVar.dN(getPageContext().getString(com.baidu.tieba.z.member));
                    } else {
                        gVar.dN(String.valueOf(gVar.uF()) + getPageContext().getString(com.baidu.tieba.z.member_already_Expire));
                    }
                    this.ccJ.a(gVar, 0);
                } else if (ml - System.currentTimeMillis() < ccR) {
                    if (StringUtils.isNull(gVar.uF())) {
                        gVar.dN(getPageContext().getString(com.baidu.tieba.z.member));
                    } else {
                        gVar.dN(String.valueOf(gVar.uF()) + getPageContext().getString(com.baidu.tieba.z.member_will_Expire));
                    }
                    this.ccJ.a(gVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ccJ.ajt();
            this.mHandler.removeCallbacks(this.cdj);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void ajg() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.g(getPageContext().getPageActivity())));
    }

    protected void ajh() {
        ajd();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007007, new f(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.ad.zw().B(System.currentTimeMillis());
        super.onCreate(bundle);
        ajb();
        if (getIntent() != null && getIntent().getIntExtra("locate_type", 0) == 200) {
            finish();
            return;
        }
        this.isFirstGoMaintab = TbadkCoreApplication.m255getInst().getIsFirstUse() || TbadkCoreApplication.m255getInst().isFirstGoMaintab();
        if (this.isFirstGoMaintab) {
            TbadkApplication.getInst().setUsed();
            TbadkApplication.getInst().setFirstGoFrs(true);
        }
        this.mHandler = new Handler();
        ah ahVar = new ah();
        com.baidu.tbadk.core.b.b.a(ahVar);
        ahVar.a(this);
        if (aji()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        if (!com.baidu.adp.lib.g.b.ei().a(getPageContext().getPageActivity(), com.baidu.tieba.x.maintabs_activity)) {
            finish();
            return;
        }
        AccountLoginHelper.getInstance().reLoginByCacheAccount(getPageContext().getPageActivity());
        this.ccJ = new ai(this);
        this.ccJ.kC();
        ajc();
        regReceiver();
        com.baidu.tbadk.getUserInfo.b.vM().vO();
        ajg();
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
        ajh();
        if (this.isFirstGoMaintab) {
            this.ccJ.ajv().showMenu(true);
            this.ccJ.y(0.0f);
            TbadkCoreApplication.m255getInst().setFirstGoMaintab(false);
        }
        com.baidu.tbadk.performanceLog.ad.zw().C(System.currentTimeMillis());
        com.baidu.tbadk.performanceLog.ad.zw().zx();
        this.mHandler.postDelayed(this.cdg, 10000L);
        registerListener(this.bio);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ccJ.ajx()) {
            this.ccJ.im(0);
            ccD = false;
            sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(boolean z) {
        boolean z2 = true;
        this.ccJ.eJ(((this.ccL > 0 && this.ccO) || ((this.ccN > 0 && this.ccQ) || (this.ccM > 0 && this.ccP))) && !this.ccJ.isMenuShowing());
        if ((this.ccL <= 0 || !this.ccO) && (this.ccM <= 0 || !this.ccP)) {
            z2 = false;
        }
        this.ccJ.ajw().eM(z2);
        this.ccJ.ajw().ai(0, (this.ccN <= 0 || !this.ccQ) ? 0 : 2);
        this.ccJ.ajw().eN(this.mHasNewVersion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public boolean aji() {
        return TbadkCoreApplication.m255getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        unregReceiver();
        a.rS().sf();
        a.rS().rY();
        a.rS().av(false);
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
        registerListener(this.cdh);
        registerListener(this.cdi);
        registerListener(this.ccW);
        this.ccZ.setPriority(100);
        registerListener(this.ccZ);
        registerListener(this.cdf);
        registerListener(this.cde);
        registerListener(this.cda);
        registerListener(this.aDB);
        registerListener(this.atW);
        registerListener(this.ccX);
        registerListener(this.ccY);
        registerListener(this.cdb);
        registerListener(this.cdc);
        registerListener(this.cdd);
        this.ccK = new ag(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.ccK, intentFilter);
    }

    private void unregReceiver() {
        if (this.ccK != null) {
            unregisterReceiver(this.ccK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TbadkCoreApplication.m255getInst().AddResumeNum();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
            this.mHandler.postDelayed(this.cdj, 500L);
        }
        changeSkinType(this.mSkinType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.ccE) {
            this.ccE = false;
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
        bundle.putInt("locate_type", this.ccJ.aju().getCurrentTabType());
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
            ajj();
        }
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            com.baidu.tbadk.getUserInfo.b.vM().vO();
            ajg();
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
            this.ccJ.aju().setCurrentTabByType(intExtra);
        }
        this.ccJ.ajw().ajD();
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void ajj() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_AS_MAIN_APP && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (this.ccJ.ajv().isMenuShowing()) {
                this.ccJ.ajv().showContent(true);
                return true;
            }
            if (System.currentTimeMillis() - this.ccF > 2000) {
                showToast(com.baidu.tieba.z.double_back_quit);
                this.ccF = System.currentTimeMillis();
            } else {
                ajl();
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
            this.ccJ.aju().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void ajk() {
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
            if (this.ccJ.aju().getCurrentFragment() != null) {
                this.ccJ.aju().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            ajk();
        } else if (this.ccJ.aju().getCurrentFragment() != null) {
            this.ccJ.aju().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.ccJ.onChangeSkinType(i);
    }

    private void ajl() {
        if (System.currentTimeMillis() - this.ccG >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.ccG = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.h
    public int getCurrentTabType() {
        if (this.ccJ.aju() != null) {
            return this.ccJ.aju().getCurrentTabType();
        }
        return -1;
    }
}
