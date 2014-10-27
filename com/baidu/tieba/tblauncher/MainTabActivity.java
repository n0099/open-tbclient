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
    public static boolean bOo = true;
    private static boolean bOp = false;
    private static int bOq = -1;
    private TextView aEv;
    private int bFp;
    private View bOI;
    private ImageView bOJ;
    private View bOK;
    private ImageView bOL;
    private ImageView bOM;
    private ImageView bON;
    private MainTabActivity bOO;
    private int bOQ;
    private FragmentTabHost bfz;
    private boolean isFirstGoMaintab;
    private NavigationBar mNavigationBar;
    private long bOr = 0;
    private long bOs = 0;
    private final long bOt = 2000;
    private final long bOu = 7200000;
    private MorePopupWindow mPopWindow = null;
    private View bOv = null;
    private HeadImageView bOw = null;
    private TextView bOx = null;
    private Drawable bOy = null;
    private View bOz = null;
    private ImageView bOA = null;
    private View bOB = null;
    private View bOC = null;
    private View bOD = null;
    private ImageView bOE = null;
    private TextView bOF = null;
    private TextView bOG = null;
    private TextView bOH = null;
    private ah bOP = null;
    private int bOR = 0;
    private int bOS = 0;
    private int bOT = 0;
    private boolean adx = false;
    private boolean bOU = false;
    private boolean bOV = false;
    private boolean bOW = false;
    private boolean bOX = false;
    private boolean bOY = false;
    private Handler mHandler = null;
    final Runnable bOZ = new j(this);
    final CustomMessageListener bPa = new aa(this, 2001124);
    private final CustomMessageListener bPb = new ab(this, 2001236);
    final CustomMessageListener bPc = new ac(this, 2007002);
    private final CustomMessageListener bPd = new ad(this, 2001237);
    private final CustomMessageListener bPe = new ae(this, 2007006);
    private final CustomMessageListener aAR = new af(this, 2012112);
    private final CustomMessageListener bPf = new ag(this, 2007005);
    private final Runnable bPg = new k(this);
    private final CustomMessageListener bPh = new l(this, 2001158);
    private final CustomMessageListener bPi = new m(this, 2001124);
    private final CustomMessageListener bPj = new n(this, 2001230);

    static {
        Fk();
        aeg();
        aef();
        MessageManager.getInstance().registerListener(new u(2002004));
    }

    private static void Fk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new o());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aef() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new p());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aeg() {
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
            this.bFp = com.baidu.tieba.u.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.bFp = com.baidu.tieba.u.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.bFp = com.baidu.tieba.u.icon_news_head_prompt_more;
        }
        aw.h((View) textView, this.bFp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.Cy = dVar.VU;
            bVar.mType = dVar.type;
            fragmentTabIndicator.setText(dVar.VV);
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
            fragmentTabIndicator.VN = com.baidu.tieba.s.main_bottom_button_color;
            bVar.Cx = fragmentTabIndicator;
            this.bfz.a(bVar);
        }
    }

    protected void aeh() {
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
        this.bOO = this;
        this.mHandler = new Handler();
        ai aiVar = new ai();
        com.baidu.tbadk.core.b.b.a(aiVar);
        aiVar.a(this.bOO);
        if (aek()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        if (!com.baidu.adp.lib.g.b.ek().a(this, com.baidu.tieba.w.maintabs_activity)) {
            finish();
            return;
        }
        AccountLoginHelper.getInstance().reLoginByCacheAccount(this);
        this.bfz = (FragmentTabHost) findViewById(com.baidu.tieba.v.tab_host);
        this.bfz.setup(getSupportFragmentManager());
        this.bfz.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        nY();
        aeh();
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
        Hf();
        if (this.isFirstGoMaintab) {
            TbadkApplication.m251getInst().setFirstGoMaintab(false);
        }
        if (PluginCenter.getInstance().isTipUpdate()) {
            this.bOY = true;
        }
        this.mHandler.postDelayed(this.bPg, 10000L);
    }

    public void aei() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(this.mNavigationBar).A(0).r(false);
        gVar.a(new r(this));
        gVar.dA().c(this.bOO);
    }

    public void Hf() {
        this.mNavigationBar = (NavigationBar) this.bOO.findViewById(com.baidu.tieba.v.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.widget_nb_item_logo, (View.OnClickListener) null);
            this.mNavigationBar.setTitleText(this.bOO.getResources().getString(com.baidu.tieba.y.app_name));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.game_tip_view, (View.OnClickListener) null);
            this.bOM = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.game_button_iv);
            this.bON = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.game_tip_msg_iv);
            if (com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("game_is_show_tip", false)) {
                this.bON.setVisibility(0);
            } else {
                this.bON.setVisibility(4);
            }
            this.bOM.setOnClickListener(new s(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_maintab_message, (View.OnClickListener) null);
            this.bOI = addCustomView2.findViewById(com.baidu.tieba.v.maintab_message_button);
            this.bOI.setOnClickListener(new t(this));
            this.aEv = (TextView) addCustomView2.findViewById(com.baidu.tieba.v.maintab_message_text);
            this.bOJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_search, (View.OnClickListener) null);
            this.bOJ.setOnClickListener(new v(this));
            this.bOK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.more_with_red_tag, this);
            this.bOL = (ImageView) this.bOK.findViewById(com.baidu.tieba.v.more_with_red_tag_msg);
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bOO, com.baidu.tieba.w.main_tab_more_pop_window, null);
            this.bOv = inflate.findViewById(com.baidu.tieba.v.more_pop_item_account);
            this.bOv.setOnClickListener(this);
            this.bOw = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_account_head);
            this.bOx = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_account_name);
            this.bOz = inflate.findViewById(com.baidu.tieba.v.more_pop_item_mark);
            this.bOz.setOnClickListener(this);
            this.bOA = (ImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_mark_msg);
            this.bOB = inflate.findViewById(com.baidu.tieba.v.more_pop_item_history);
            this.bOB.setOnClickListener(this);
            this.bOC = inflate.findViewById(com.baidu.tieba.v.more_pop_item_mylive);
            this.bOC.setOnClickListener(new w(this));
            this.bOD = inflate.findViewById(com.baidu.tieba.v.more_pop_item_setting);
            this.bOD.setOnClickListener(this);
            this.bOE = (ImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_setting_msg);
            this.bOF = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_feedback);
            this.bOF.setOnClickListener(this);
            this.bOG = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_switchaccount);
            this.bOG.setOnClickListener(this);
            this.bOH = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_exitapp);
            this.bOH.setOnClickListener(this);
            this.mPopWindow = new MorePopupWindow(this.bOO, inflate, this.mNavigationBar, getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new x(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopMenu() {
        if (this.mPopWindow != null) {
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                this.bOw.c(currentAccountObj.getPortrait(), 12, false);
                this.bOx.setText(currentAccountObj.getAccount());
            }
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bOK) {
            showPopMenu();
            eJ(true);
        } else if (view == this.bOv) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bOO, currentAccountObj.getID(), currentAccountObj.getAccount())));
            }
            this.bOV = false;
            this.bOX = false;
            eJ(true);
        } else if (view == this.bOz) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            sendMessage(new CustomMessage(2015005, new com.baidu.tbadk.core.frameworkData.a(this.bOO)));
            this.bOW = false;
            eJ(true);
        } else if (view == this.bOB) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.bOO)));
        } else if (view == this.bOD) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            sendMessage(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.a(this.bOO)));
            this.adx = false;
            this.bOY = false;
            eJ(true);
        } else if (view == this.bOF) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData != null && antiData.getIfpost() == 0) {
                com.baidu.adp.lib.util.m.showToast(this.bOO, antiData.getForbid_info());
                return;
            }
            antiData.setIfVoice(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this.bOO, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
        } else if (view == this.bOG) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            sendMessage(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.a(this.bOO)));
        } else if (view == this.bOH) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
            aej().show();
        }
    }

    private AlertDialog aej() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.baidu.tieba.y.del_post_tip);
        builder.setMessage(com.baidu.tieba.y.exit_tip);
        builder.setPositiveButton(com.baidu.tieba.y.alert_yes_button, new y(this));
        builder.setNegativeButton(com.baidu.tieba.y.alert_no_button, new z(this));
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(boolean z) {
        this.bOy = aw.getDrawable(com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bOA, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bOE, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bOL, com.baidu.tieba.u.icon_news_down_bar_one);
        if (this.bOY || this.adx || this.bOR > 0 || this.bOT > 0 || this.bOS <= 0) {
        }
        if (this.bOU) {
            this.bOL.setVisibility(0);
        } else {
            this.bOL.setVisibility(4);
        }
        if (z) {
            this.bOL.setVisibility(4);
            this.bOU = false;
        }
        if ((this.bOR > 0 && this.bOV) || (this.bOS > 0 && this.bOX)) {
            this.bOx.setCompoundDrawablePadding(com.baidu.adp.lib.util.m.dip2px(this.bOO, 4.0f));
            this.bOx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.bOy, (Drawable) null);
        } else {
            this.bOx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.bOT > 0 && this.bOW) {
            this.bOA.setVisibility(0);
        } else {
            this.bOA.setVisibility(4);
        }
        if (this.adx || this.bOY) {
            this.bOE.setVisibility(0);
        } else {
            this.bOE.setVisibility(4);
        }
        this.bOU = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public static void ht(int i) {
        bOq = i;
    }

    public boolean aek() {
        return TbadkApplication.m251getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        Jt();
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().oN();
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().oH();
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().ac(false);
        com.baidu.tbadk.imageManager.e.sg().si();
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
        registerListener(this.bPh);
        registerListener(this.bPi);
        registerListener(this.bPa);
        this.bPc.setPriority(100);
        registerListener(this.bPc);
        registerListener(this.bPf);
        registerListener(this.bPe);
        registerListener(this.bPd);
        registerListener(this.aAR);
        registerListener(this.bPj);
        registerListener(this.bPb);
        this.bOP = new ah(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.bOP, intentFilter);
    }

    private void Jt() {
        if (this.bOP != null) {
            unregisterReceiver(this.bOP);
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
            this.mHandler.postDelayed(this.bOZ, 2500L);
        }
        bOq = this.bfz.getCurrentTabType();
        changeSkinType(this.mSkinType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (bOp) {
            bOp = false;
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
        bundle.putInt("locate_type", this.bfz.getCurrentTabType());
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
            ael();
        }
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            aeh();
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
            this.bfz.setCurrentTabByType(intExtra);
        }
        e(this, TbadkApplication.getIntent());
    }

    private void ael() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (System.currentTimeMillis() - this.bOr > 2000) {
                showToast(com.baidu.tieba.y.double_back_quit);
                this.bOr = System.currentTimeMillis();
            } else {
                aen();
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
            this.bfz.setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    protected void aem() {
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
            if (this.bfz.getCurrentFragment() != null) {
                this.bfz.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            aem();
        } else if (this.bfz.getCurrentFragment() != null) {
            this.bfz.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.bfz.onChangeSkinType(i);
        if (i == 1) {
            this.bfz.setBackgroundColor(-5525837);
            if (this.bOQ != 0) {
                this.aEv.setBackgroundResource(this.bOQ);
            }
        } else {
            this.bfz.setBackgroundColor(-5525837);
            if (this.bFp != 0) {
                this.aEv.setBackgroundResource(this.bFp);
            }
        }
        this.mNavigationBar.onChangeSkinType(i);
        this.mPopWindow.onChangeSkinType(this.bOO, i, aw.getDrawable(com.baidu.tieba.u.bg_pull_down_right_n));
        aw.c(this.bOA, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bOE, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bOL, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bON, com.baidu.tieba.u.icon_news_down_bar_one);
        aw.c(this.bOM, com.baidu.tieba.u.icon_game_n);
        eJ(false);
    }

    private void aen() {
        if (System.currentTimeMillis() - this.bOs >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.bOs = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.i
    public int getCurrentTabType() {
        if (this.bfz != null) {
            return this.bfz.getCurrentTabType();
        }
        return -1;
    }
}
