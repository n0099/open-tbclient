package com.baidu.tieba.tblauncher;

import android.app.AlertDialog;
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
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements i {
    public static boolean caN = true;
    private static long cbc = 259200000;
    private static Game cbd;
    private an caU;
    private CustomMessageListener cbe;
    private boolean isFirstGoMaintab;
    private boolean caO = false;
    private int caP = -1;
    private long caQ = 0;
    private long caR = 0;
    private final long caS = 2000;
    private final long caT = 7200000;
    private aj caV = null;
    private int caW = 0;
    private int caX = 0;
    private int caY = 0;
    private boolean mHasNewVersion = false;
    private boolean caZ = false;
    private boolean cba = false;
    private boolean cbb = false;
    private Handler mHandler = null;
    private final CustomMessageListener cbf = new u(this, 2009503);
    final CustomMessageListener cbg = new ac(this, 2001124);
    private final CustomMessageListener asS = new ad(this, 2001236);
    private final CustomMessageListener cbh = new ae(this, 2001258);
    private final CustomMessageListener cbi = new af(this, 2001253);
    final CustomMessageListener cbj = new ag(this, 2007002);
    private final CustomMessageListener cbk = new ah(this, 2001237);
    private final CustomMessageListener cbl = new ai(this, 2001266);
    private final CustomMessageListener cbm = new k(this, 2001267);
    private final CustomMessageListener cbn = new l(this, 2001271);
    private final CustomMessageListener cbo = new m(this, 2007006);
    private final CustomMessageListener aCD = new n(this, 2012112);
    private final CustomMessageListener cbp = new o(this, 2007005);
    private final Runnable cbq = new p(this);
    public final View.OnClickListener cbr = new q(this);
    private final CustomMessageListener cbs = new r(this, 2001158);
    private final CustomMessageListener cbt = new s(this, 2001124);
    final Runnable cbu = new t(this);

    static {
        Fr();
        aiF();
        CD();
        aiE();
        MessageManager.getInstance().registerListener(new j(2002004));
    }

    private void aiB() {
        registerListener(this.cbf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiC() {
        boolean z = true;
        if (cbd != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m255getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (cbd.hasGameCenter != null && cbd.hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                this.caU.eD(true);
                long j = com.baidu.tbadk.core.sharedPref.b.og().getLong("game_last_time", 0L);
                if (cbd.gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.og().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.og().putLong("game_last_time", cbd.gameLastLaunchtime.longValue());
                } else if (cbd.gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.og().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.og().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                this.caU.eF(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, Boolean.valueOf(z)));
                return;
            }
            this.caU.eD(false);
            this.caU.eF(false);
            com.baidu.tbadk.core.sharedPref.b.og().putBoolean("game_is_show_tip", false);
        }
    }

    private void aiD() {
        this.cbe = new v(this, 2007007);
        this.cbe.setPriority(10);
        registerListener(this.cbe);
    }

    private static void Fr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new w());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void CD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new x());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aiE() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001258, new y());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aiF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012111, new z());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void a(com.baidu.tbadk.data.g gVar) {
        if (gVar != null) {
            if ((gVar.ut() == 1 || gVar.ut() == 2) && com.baidu.tbadk.core.sharedPref.b.og().getBoolean("show_member_deid_line", true)) {
                long ms = gVar.ms() * 1000;
                if (ms < System.currentTimeMillis()) {
                    if (StringUtils.isNull(gVar.uu())) {
                        gVar.dR(getPageContext().getString(com.baidu.tieba.z.member));
                    } else {
                        gVar.dR(String.valueOf(gVar.uu()) + getPageContext().getString(com.baidu.tieba.z.member_already_Expire));
                    }
                    this.caU.a(gVar, 0);
                } else if (ms - System.currentTimeMillis() < cbc) {
                    if (StringUtils.isNull(gVar.uu())) {
                        gVar.dR(getPageContext().getString(com.baidu.tieba.z.member));
                    } else {
                        gVar.dR(String.valueOf(gVar.uu()) + getPageContext().getString(com.baidu.tieba.z.member_will_Expire));
                    }
                    this.caU.a(gVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.caU.aiW();
            this.mHandler.removeCallbacks(this.cbu);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void aiG() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.g(getPageContext().getPageActivity())));
    }

    protected void aiH() {
        aiD();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007007, new com.baidu.tbadk.mainTab.f(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.performanceLog.ad.zl().B(System.currentTimeMillis());
        super.onCreate(bundle);
        aiB();
        if (getIntent() != null && getIntent().getIntExtra("locate_type", 0) == 200) {
            finish();
            return;
        }
        this.isFirstGoMaintab = TbadkCoreApplication.m255getInst().isFirstGoMaintab();
        this.mHandler = new Handler();
        ak akVar = new ak();
        com.baidu.tbadk.core.b.b.a(akVar);
        akVar.a(this);
        if (aiJ()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        if (!com.baidu.adp.lib.g.b.ek().a(getPageContext().getPageActivity(), com.baidu.tieba.x.maintabs_activity)) {
            finish();
            return;
        }
        AccountLoginHelper.getInstance().reLoginByCacheAccount(getPageContext().getPageActivity());
        this.caU = new an(this);
        this.caU.kJ();
        aiC();
        regReceiver();
        aiG();
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
        aiH();
        if (this.isFirstGoMaintab) {
            this.caU.aiZ().showMenu(true);
            this.caU.z(0.0f);
            TbadkCoreApplication.m255getInst().setFirstGoMaintab(false);
        }
        com.baidu.tbadk.performanceLog.ad.zl().C(System.currentTimeMillis());
        com.baidu.tbadk.performanceLog.ad.zl().zm();
        this.mHandler.postDelayed(this.cbq, 10000L);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.caU.getMoreButton()) {
            this.caU.showPopMenu();
            eA(true);
        } else if (view == this.caU.ajb()) {
            this.caU.aiX();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), currentAccountObj.getID(), currentAccountObj.getAccount())));
            }
            this.caZ = false;
            this.cba = false;
            eA(true);
        } else if (view == this.caU.ajc()) {
            this.caU.aiX();
            sendMessage(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity())));
            this.mHasNewVersion = false;
            eA(true);
        } else if (view == this.caU.ajd()) {
            this.caU.aiX();
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData != null && antiData.getIfpost() == 0) {
                com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
                return;
            }
            antiData.setIfVoice(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
        } else if (view == this.caU.aje()) {
            this.caU.aiX();
            sendMessage(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity())));
        } else if (view == this.caU.ajf()) {
            this.caU.aiX();
            aiI().show();
        } else if (view == this.caU.ajg()) {
            this.caU.ih(0);
            caN = false;
            sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(getPageContext().getPageActivity())));
        }
    }

    private AlertDialog aiI() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setTitle(com.baidu.tieba.z.del_post_tip);
        builder.setMessage(com.baidu.tieba.z.exit_tip);
        builder.setPositiveButton(com.baidu.tieba.z.alert_yes_button, new aa(this));
        builder.setNegativeButton(com.baidu.tieba.z.alert_no_button, new ab(this));
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(boolean z) {
        boolean z2 = true;
        this.caU.eA(z);
        this.caU.eE(((this.caW > 0 && this.caZ) || ((this.caY > 0 && this.cbb) || (this.caX > 0 && this.cba))) && !this.caU.isMenuShowing());
        if ((this.caW <= 0 || !this.caZ) && (this.caX <= 0 || !this.cba)) {
            z2 = false;
        }
        this.caU.aja().eH(z2);
        this.caU.aja().ag(0, (this.caY <= 0 || !this.cbb) ? 0 : 2);
        this.caU.aja().eI(this.mHasNewVersion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public void ic(int i) {
        this.caP = i;
    }

    public boolean aiJ() {
        return TbadkCoreApplication.m255getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        unregReceiver();
        com.baidu.tbadk.coreExtra.messageCenter.a.rI().rV();
        com.baidu.tbadk.coreExtra.messageCenter.a.rI().rO();
        com.baidu.tbadk.coreExtra.messageCenter.a.rI().at(false);
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
        registerListener(this.cbs);
        registerListener(this.cbt);
        registerListener(this.cbg);
        this.cbj.setPriority(100);
        registerListener(this.cbj);
        registerListener(this.cbp);
        registerListener(this.cbo);
        registerListener(this.cbk);
        registerListener(this.aCD);
        registerListener(this.asS);
        registerListener(this.cbh);
        registerListener(this.cbi);
        registerListener(this.cbl);
        registerListener(this.cbm);
        registerListener(this.cbn);
        this.caV = new aj(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.caV, intentFilter);
    }

    private void unregReceiver() {
        if (this.caV != null) {
            unregisterReceiver(this.caV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TbadkCoreApplication.m255getInst().AddResumeNum();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
            this.mHandler.postDelayed(this.cbu, 500L);
        }
        this.caP = this.caU.aiY().getCurrentTabType();
        changeSkinType(this.mSkinType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.caO) {
            this.caO = false;
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
        bundle.putInt("locate_type", this.caU.aiY().getCurrentTabType());
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
            aiK();
        }
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            aiG();
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
            this.caU.aiY().setCurrentTabByType(intExtra);
        }
        this.caU.aja().ajm();
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
    }

    private void aiK() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_AS_MAIN_APP && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (this.caU.aiZ().isMenuShowing()) {
                this.caU.aiZ().showContent(true);
                return true;
            }
            if (System.currentTimeMillis() - this.caQ > 2000) {
                showToast(com.baidu.tieba.z.double_back_quit);
                this.caQ = System.currentTimeMillis();
            } else {
                aiM();
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
    public void V(Intent intent) {
        try {
            this.caU.aiY().setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void aiL() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i == 12007) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(com.baidu.tieba.z.login_home_tab), 11003)));
            }
            if (this.caU.aiY().getCurrentFragment() != null) {
                this.caU.aiY().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            aiL();
        } else if (this.caU.aiY().getCurrentFragment() != null) {
            this.caU.aiY().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.caU.onChangeSkinType(i);
    }

    private void aiM() {
        if (System.currentTimeMillis() - this.caR >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.caR = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.i
    public int getCurrentTabType() {
        if (this.caU.aiY() != null) {
            return this.caU.aiY().getCurrentTabType();
        }
        return -1;
    }
}
