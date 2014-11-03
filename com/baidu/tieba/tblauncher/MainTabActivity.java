package com.baidu.tieba.tblauncher;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements i {
    public static boolean bOD = true;
    private static boolean bOE = false;
    private static int bOF = -1;
    private TextView aEF;
    private int bFD;
    private View bOX;
    private ImageView bOY;
    private View bOZ;
    private ImageView bPa;
    private ImageView bPb;
    private ImageView bPc;
    private MainTabActivity bPd;
    private int bPf;
    private FragmentTabHost bfN;
    private boolean isFirstGoMaintab;
    private NavigationBar mNavigationBar;
    private long bOG = 0;
    private long bOH = 0;
    private final long bOI = 2000;
    private final long bOJ = 7200000;
    private MorePopupWindow mPopWindow = null;
    private View bOK = null;
    private HeadImageView bOL = null;
    private TextView bOM = null;
    private Drawable bON = null;
    private View bOO = null;
    private ImageView bOP = null;
    private View bOQ = null;
    private View bOR = null;
    private View bOS = null;
    private ImageView bOT = null;
    private TextView bOU = null;
    private TextView bOV = null;
    private TextView bOW = null;
    private ah bPe = null;
    private int bPg = 0;
    private int bPh = 0;
    private int bPi = 0;
    private boolean adC = false;
    private boolean bPj = false;
    private boolean bPk = false;
    private boolean bPl = false;
    private boolean bPm = false;
    private boolean bPn = false;
    private Handler mHandler = null;
    final Runnable bPo = new j(this);
    final CustomMessageListener bPp = new aa(this, 2001124);
    private final CustomMessageListener bPq = new ab(this, 2001236);
    final CustomMessageListener bPr = new ac(this, 2007002);
    private final CustomMessageListener bPs = new ad(this, 2001237);
    private final CustomMessageListener bPt = new ae(this, 2007006);
    private final CustomMessageListener aBb = new af(this, 2012112);
    private final CustomMessageListener bPu = new ag(this, 2007005);
    private final Runnable bPv = new k(this);
    private final CustomMessageListener bPw = new l(this, 2001158);
    private final CustomMessageListener bPx = new m(this, 2001124);
    private final CustomMessageListener bPy = new n(this, 2001230);

    static {
        Fm();
        aej();
        aei();
        MessageManager.getInstance().registerListener(new u(2002004));
    }

    private static void Fm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new o());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aei() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new p());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aej() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012111, new q());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(TextView textView, int i) {
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        aw.b(textView, com.baidu.tieba.s.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.bFD = com.baidu.tieba.u.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.bFD = com.baidu.tieba.u.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.bFD = com.baidu.tieba.u.icon_news_head_prompt_more;
        }
        aw.h((View) textView, this.bFD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.Cz = dVar.VY;
            bVar.mType = dVar.type;
            fragmentTabIndicator.setText(dVar.VZ);
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
            fragmentTabIndicator.VR = com.baidu.tieba.s.main_bottom_button_color;
            bVar.Cy = fragmentTabIndicator;
            this.bfN.a(bVar);
        }
    }

    protected void aek() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.e(this)));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getIntExtra("locate_type", 0) == 200) {
            finish();
            return;
        }
        this.isFirstGoMaintab = TbadkApplication.m251getInst().isFirstGoMaintab();
        this.bPd = this;
        this.mHandler = new Handler();
        ai aiVar = new ai();
        com.baidu.tbadk.core.b.b.a(aiVar);
        aiVar.a(this.bPd);
        if (aen()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        if (!com.baidu.adp.lib.g.b.ek().a(this, com.baidu.tieba.w.maintabs_activity)) {
            finish();
            return;
        }
        AccountLoginHelper.getInstance().reLoginByCacheAccount(this);
        this.bfN = (FragmentTabHost) findViewById(com.baidu.tieba.v.tab_host);
        this.bfN.setup(getSupportFragmentManager());
        this.bfN.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        nY();
        aek();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        if (TbadkApplication.getFrom() != null && TbadkApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        e(this, TbadkApplication.getIntent());
        String installOtherApp = TbadkApplication.m251getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkApplication.m251getInst().getApp(), installOtherApp);
            TbadkApplication.m251getInst().setInstallOtherApp(null);
        }
        Hh();
        if (this.isFirstGoMaintab) {
            TbadkApplication.m251getInst().setFirstGoMaintab(false);
        }
        if (PluginCenter.getInstance().isTipUpdate()) {
            this.bPn = true;
        }
        this.mHandler.postDelayed(this.bPv, 10000L);
    }

    public void ael() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(this.mNavigationBar).A(0).r(false);
        gVar.a(new r(this));
        gVar.dA().c(this.bPd);
    }

    public void Hh() {
        this.mNavigationBar = (NavigationBar) this.bPd.findViewById(com.baidu.tieba.v.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.widget_nb_item_logo, (View.OnClickListener) null);
            this.mNavigationBar.setTitleText(this.bPd.getResources().getString(com.baidu.tieba.y.app_name));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.game_tip_view, (View.OnClickListener) null);
            this.bPb = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.game_button_iv);
            this.bPc = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.game_tip_msg_iv);
            if (com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("game_is_show_tip", false)) {
                this.bPc.setVisibility(0);
            } else {
                this.bPc.setVisibility(4);
            }
            this.bPb.setOnClickListener(new s(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_maintab_message, (View.OnClickListener) null);
            this.bOX = addCustomView2.findViewById(com.baidu.tieba.v.maintab_message_button);
            this.bOX.setOnClickListener(new t(this));
            this.aEF = (TextView) addCustomView2.findViewById(com.baidu.tieba.v.maintab_message_text);
            this.bOY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_search, (View.OnClickListener) null);
            this.bOY.setOnClickListener(new v(this));
            this.bOZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.more_with_red_tag, this);
            this.bPa = (ImageView) this.bOZ.findViewById(com.baidu.tieba.v.more_with_red_tag_msg);
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bPd, com.baidu.tieba.w.main_tab_more_pop_window, null);
            this.bOK = inflate.findViewById(com.baidu.tieba.v.more_pop_item_account);
            this.bOK.setOnClickListener(this);
            this.bOL = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_account_head);
            this.bOM = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_account_name);
            this.bOO = inflate.findViewById(com.baidu.tieba.v.more_pop_item_mark);
            this.bOO.setOnClickListener(this);
            this.bOP = (ImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_mark_msg);
            this.bOQ = inflate.findViewById(com.baidu.tieba.v.more_pop_item_history);
            this.bOQ.setOnClickListener(this);
            this.bOR = inflate.findViewById(com.baidu.tieba.v.more_pop_item_mylive);
            this.bOR.setOnClickListener(new w(this));
            this.bOS = inflate.findViewById(com.baidu.tieba.v.more_pop_item_setting);
            this.bOS.setOnClickListener(this);
            this.bOT = (ImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_setting_msg);
            this.bOU = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_feedback);
            this.bOU.setOnClickListener(this);
            this.bOV = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_switchaccount);
            this.bOV.setOnClickListener(this);
            this.bOW = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_exitapp);
            this.bOW.setOnClickListener(this);
            this.mPopWindow = new MorePopupWindow(this.bPd, inflate, this.mNavigationBar, getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new x(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopMenu() {
        if (this.mPopWindow != null) {
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                this.bOL.c(currentAccountObj.getPortrait(), 12, false);
                this.bOM.setText(currentAccountObj.getAccount());
            }
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bOZ) {
            showPopMenu();
            eJ(true);
        } else if (view == this.bOK) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bPd, currentAccountObj.getID(), currentAccountObj.getAccount())));
            }
            this.bPk = false;
            this.bPm = false;
            eJ(true);
        } else if (view == this.bOO) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            sendMessage(new CustomMessage(2015005, new com.baidu.tbadk.core.frameworkData.a(this.bPd)));
            this.bPl = false;
            eJ(true);
        } else if (view == this.bOQ) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.bPd)));
        } else if (view == this.bOS) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            sendMessage(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.a(this.bPd)));
            this.adC = false;
            this.bPn = false;
            eJ(true);
        } else if (view == this.bOU) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData != null && antiData.getIfpost() == 0) {
                com.baidu.adp.lib.util.m.showToast(this.bPd, antiData.getForbid_info());
                return;
            }
            antiData.setIfVoice(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bPd, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
        } else if (view == this.bOV) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            sendMessage(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.a(this.bPd)));
        } else if (view == this.bOW) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            aem().show();
        }
    }

    private AlertDialog aem() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.baidu.tieba.y.del_post_tip);
        builder.setMessage(com.baidu.tieba.y.exit_tip);
        builder.setPositiveButton(com.baidu.tieba.y.alert_yes_button, new y(this));
        builder.setNegativeButton(com.baidu.tieba.y.alert_no_button, new z(this));
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(boolean z) {
        this.bON = aw.getDrawable(com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bOP, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bOT, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bPa, com.baidu.tieba.u.icon_news_down_bar_one);
        if (this.bPn || this.adC || this.bPg > 0 || this.bPi > 0 || this.bPh <= 0) {
        }
        if (this.bPj) {
            this.bPa.setVisibility(0);
        } else {
            this.bPa.setVisibility(4);
        }
        if (z) {
            this.bPa.setVisibility(4);
            this.bPj = false;
        }
        if ((this.bPg > 0 && this.bPk) || (this.bPh > 0 && this.bPm)) {
            this.bOM.setCompoundDrawablePadding(com.baidu.adp.lib.util.m.dip2px(this.bPd, 4.0f));
            this.bOM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.bON, (Drawable) null);
        } else {
            this.bOM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.bPi > 0 && this.bPl) {
            this.bOP.setVisibility(0);
        } else {
            this.bOP.setVisibility(4);
        }
        if (this.adC || this.bPn) {
            this.bOT.setVisibility(0);
        } else {
            this.bOT.setVisibility(4);
        }
        this.bPj = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public static void ht(int i) {
        bOF = i;
    }

    public boolean aen() {
        return TbadkApplication.m251getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        Jx();
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().oP();
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().oJ();
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().ac(false);
        com.baidu.tbadk.imageManager.e.si().sk();
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.j.b(this.mWaitingDialog, this);
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

    private void e(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkApplication.setIntent(null);
    }

    private void nY() {
        registerListener(this.bPw);
        registerListener(this.bPx);
        registerListener(this.bPp);
        this.bPr.setPriority(100);
        registerListener(this.bPr);
        registerListener(this.bPu);
        registerListener(this.bPt);
        registerListener(this.bPs);
        registerListener(this.aBb);
        registerListener(this.bPy);
        registerListener(this.bPq);
        this.bPe = new ah(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.bPe, intentFilter);
    }

    private void Jx() {
        if (this.bPe != null) {
            unregisterReceiver(this.bPe);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TbadkApplication.m251getInst().sendLaunchTime();
        TbadkApplication.m251getInst().AddResumeNum();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
            this.mHandler.postDelayed(this.bPo, 2500L);
        }
        bOF = this.bfN.getCurrentTabType();
        changeSkinType(this.mSkinType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (bOE) {
            bOE = false;
            CompatibleUtile.setAnim(this, com.baidu.tieba.p.down, com.baidu.tieba.p.hold);
        }
        TbadkApplication.m251getInst().DelResumeNum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.bfN.getCurrentTabType());
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
            aeo();
        }
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            aek();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(this, NotLoginGuideActivityConfig.FROM_ACCOUNT)));
            finish();
        } else if (intExtra == 12) {
            TbadkApplication.m251getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 4) {
            this.bfN.setCurrentTabByType(intExtra);
        }
        e(this, TbadkApplication.getIntent());
    }

    private void aeo() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (System.currentTimeMillis() - this.bOG > 2000) {
                showToast(com.baidu.tieba.y.double_back_quit);
                this.bOG = System.currentTimeMillis();
            } else {
                aeq();
                moveTaskToBack(true);
                TbadkApplication.m251getInst().notifyAppEnterBackground();
            }
            return false;
        }
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            showPopMenu();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Intent intent) {
        try {
            this.bfN.setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void aep() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.m.showToast(this, antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i == 12007) {
                LoginActivity.a(this, 1, getString(com.baidu.tieba.y.login_home_tab), 11003);
            }
            if (this.bfN.getCurrentFragment() != null) {
                this.bfN.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            aep();
        } else if (this.bfN.getCurrentFragment() != null) {
            this.bfN.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.bfN.onChangeSkinType(i);
        if (i == 1) {
            this.bfN.setBackgroundColor(-5525837);
            if (this.bPf != 0) {
                this.aEF.setBackgroundResource(this.bPf);
            }
        } else {
            this.bfN.setBackgroundColor(-5525837);
            if (this.bFD != 0) {
                this.aEF.setBackgroundResource(this.bFD);
            }
        }
        this.mNavigationBar.onChangeSkinType(i);
        this.mPopWindow.onChangeSkinType(this.bPd, i, aw.getDrawable(com.baidu.tieba.u.bg_pull_down_right_n));
        aw.c(this.bOP, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bOT, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bPa, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bPc, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bPb, com.baidu.tieba.u.icon_game_n);
        eJ(false);
    }

    private void aeq() {
        if (System.currentTimeMillis() - this.bOH >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.bOH = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.i
    public int getCurrentTabType() {
        if (this.bfN != null) {
            return this.bfN.getCurrentTabType();
        }
        return -1;
    }
}
