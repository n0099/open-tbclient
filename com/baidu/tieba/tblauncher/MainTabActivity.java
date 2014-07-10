package com.baidu.tieba.tblauncher;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.atomData.ao;
import com.baidu.tbadk.core.atomData.au;
import com.baidu.tbadk.core.atomData.ax;
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.atomData.bv;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements k {
    public static boolean c = true;
    private static boolean g = false;
    private static int h = -1;
    private View B;
    private TextView C;
    private ImageView D;
    private View E;
    private ImageView F;
    private MainTabActivity G;
    private int J;
    private int K;
    private boolean L;
    private FragmentTabHost m;
    private NavigationBar n;
    private long i = 0;
    private long j = 0;
    private final long k = 2000;
    private final long l = 7200000;
    private com.baidu.tbadk.core.view.i o = null;
    private View p = null;
    private HeadImageView q = null;
    private TextView r = null;
    private View s = null;
    private ImageView t = null;
    private View u = null;
    private View v = null;
    private View w = null;
    private ImageView x = null;
    private TextView y = null;
    private TextView z = null;
    private TextView A = null;
    private com.baidu.tbadk.editortool.aa H = null;
    private ad I = null;
    private Handler M = null;
    final Runnable d = new l(this);
    final CustomMessageListener e = new w(this, 2001124);
    final CustomMessageListener f = new x(this, 2007002);
    private final CustomMessageListener N = new y(this, 2007006);
    private final CustomMessageListener O = new z(this, 2012112);
    private final CustomMessageListener P = new aa(this, 2007005);
    private int Q = 0;
    private boolean R = false;
    private final CustomMessageListener S = new ab(this, 2001124);

    static {
        l();
        n();
        m();
        MessageManager.getInstance().registerListener(new v(2002004));
    }

    private static void l() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new ac());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void m() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new m());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void n() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012111, new n());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, int i) {
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        textView.setTextColor(TbadkApplication.m252getInst().getApp().getResources().getColor(z ? com.baidu.tieba.s.top_msg_num_night : com.baidu.tieba.s.top_msg_num_day));
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.J = com.baidu.tieba.u.icon_news_head_prompt_one;
            this.K = com.baidu.tieba.u.icon_news_head_prompt_one_1;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.J = com.baidu.tieba.u.icon_news_head_prompt_two;
            this.K = com.baidu.tieba.u.icon_news_head_prompt_two_1;
        } else {
            textView.setText("   ");
            this.J = com.baidu.tieba.u.icon_news_head_prompt_more;
            this.K = com.baidu.tieba.u.icon_news_head_prompt_more_1;
        }
        textView.setBackgroundResource(z ? this.K : this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.c = dVar.a;
            bVar.a = dVar.c;
            fragmentTabIndicator.setText(dVar.b);
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.t.ds32));
            fragmentTabIndicator.b = com.baidu.tieba.s.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.s.main_bottom_button_color;
            bVar.b = fragmentTabIndicator;
            this.m.a(bVar);
        }
    }

    protected void g() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.e(this)));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getIntExtra("locate_type", 0) == 200) {
            finish();
            return;
        }
        this.L = TbadkApplication.m252getInst().isFirstGoMaintab();
        this.G = this;
        this.M = new Handler();
        ae aeVar = new ae();
        com.baidu.tbadk.core.b.b.a(aeVar);
        aeVar.a((k) this.G);
        if (j()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        setContentView(com.baidu.tieba.w.maintabs_activity);
        AccountLoginHelper.getInstance().reLoginByCacheAccount(this);
        this.m = (FragmentTabHost) findViewById(com.baidu.tieba.v.tab_host);
        this.m.setup(getSupportFragmentManager());
        this.m.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        q();
        g();
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
        a((Context) this, TbadkApplication.getIntent());
        String installOtherApp = TbadkApplication.m252getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkApplication.m252getInst().getApp(), installOtherApp);
            TbadkApplication.m252getInst().setInstallOtherApp(null);
        }
        i();
        if (this.L) {
            TbadkApplication.m252getInst().setFirstGoMaintab(false);
        }
        com.baidu.tbadk.core.log.a.c();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bh(this)));
    }

    public void h() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.n).a(0).b(false);
        gVar.a(new o(this));
        gVar.a().a(this.G);
    }

    public void i() {
        this.n = (NavigationBar) this.G.findViewById(com.baidu.tieba.v.view_navigation_bar);
        if (this.n != null) {
            this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.widget_nb_item_logo, (View.OnClickListener) null);
            this.n.a(this.G.getResources().getString(com.baidu.tieba.y.app_name));
            View a = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_maintab_message, (View.OnClickListener) null);
            this.B = a.findViewById(com.baidu.tieba.v.maintab_message_button);
            this.B.setOnClickListener(new p(this));
            this.C = (TextView) a.findViewById(com.baidu.tieba.v.maintab_message_text);
            this.D = (ImageView) this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_search, (View.OnClickListener) null);
            this.D.setOnClickListener(new q(this));
            this.E = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.more_with_red_tag, this);
            this.F = (ImageView) this.E.findViewById(com.baidu.tieba.v.more_with_red_tag_msg);
            View inflate = this.G.getLayoutInflater().inflate(com.baidu.tieba.w.main_tab_more_pop_window, (ViewGroup) null);
            this.p = inflate.findViewById(com.baidu.tieba.v.more_pop_item_account);
            this.p.setOnClickListener(this);
            this.q = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_account_head);
            this.r = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_account_name);
            this.s = inflate.findViewById(com.baidu.tieba.v.more_pop_item_mark);
            this.s.setOnClickListener(this);
            this.t = (ImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_mark_msg);
            this.u = inflate.findViewById(com.baidu.tieba.v.more_pop_item_history);
            this.u.setOnClickListener(this);
            this.v = inflate.findViewById(com.baidu.tieba.v.more_pop_item_mylive);
            this.v.setOnClickListener(new r(this));
            this.w = inflate.findViewById(com.baidu.tieba.v.more_pop_item_setting);
            this.w.setOnClickListener(this);
            this.x = (ImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_setting_msg);
            this.y = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_feedback);
            this.y.setOnClickListener(this);
            this.z = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_switchaccount);
            this.z.setOnClickListener(this);
            this.A = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_exitapp);
            this.A.setOnClickListener(this);
            this.o = new com.baidu.tbadk.core.view.i(this.G, inflate, this.n, getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new s(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.o != null) {
            if (this.H == null) {
                this.H = new com.baidu.tbadk.editortool.aa(this.G);
            }
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                this.q.a(currentAccountObj.getPortrait(), 12, false);
                this.r.setText(currentAccountObj.getAccount());
            }
            this.o.b();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.E) {
            o();
            a(true);
        } else if (view == this.p) {
            this.o.dismiss();
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new bb(this.G, currentAccountObj.getID(), currentAccountObj.getAccount())));
            }
            a(true);
        } else if (view == this.s) {
            this.o.dismiss();
            a(new CustomMessage(2015005, new com.baidu.tbadk.core.frameworkData.a(this.G)));
            this.Q = 0;
            a(true);
        } else if (view == this.u) {
            this.o.dismiss();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ax(this.G)));
        } else if (view == this.w) {
            this.o.dismiss();
            a(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.a(this.G)));
            this.R = false;
            a(true);
        } else if (view == this.y) {
            this.o.dismiss();
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData != null && antiData.getIfpost() == 0) {
                com.baidu.adp.lib.util.j.a((Context) this.G, antiData.getForbid_info());
                return;
            }
            antiData.setIfVoice(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bv(this.G, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
        } else if (view == this.z) {
            this.o.dismiss();
            a(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.a(this.G)));
        } else if (view == this.A) {
            this.o.dismiss();
            p().show();
        }
    }

    private AlertDialog p() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.baidu.tieba.y.del_post_tip);
        builder.setMessage(com.baidu.tieba.y.exit_tip);
        builder.setPositiveButton(com.baidu.tieba.y.alert_yes_button, new t(this));
        builder.setNegativeButton(com.baidu.tieba.y.alert_no_button, new u(this));
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.t.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
            this.x.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
            this.F.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
        } else {
            this.t.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
            this.x.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
            this.F.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
        }
        if (this.R || this.Q > 0) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(4);
        }
        if (z) {
            this.F.setVisibility(4);
        }
        if (this.Q > 0) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(4);
        }
        if (this.R) {
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public static void d(int i) {
        h = i;
    }

    public boolean j() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        r();
        com.baidu.tbadk.coreExtra.messageCenter.a.a().h();
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(false);
        com.baidu.tbadk.imageManager.e.a().c();
        if (this.a != null) {
            this.a.dismiss();
            this.a = null;
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

    private void a(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkApplication.setIntent(null);
    }

    private void q() {
        MessageManager.getInstance().registerListener(this.S);
        MessageManager.getInstance().registerListener(this.e);
        this.f.setPriority(100);
        MessageManager.getInstance().registerListener(this.f);
        MessageManager.getInstance().registerListener(this.P);
        MessageManager.getInstance().registerListener(this.N);
        MessageManager.getInstance().registerListener(this.O);
        this.I = new ad(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.I, intentFilter);
    }

    private void r() {
        MessageManager.getInstance().unRegisterListener(this.S);
        MessageManager.getInstance().unRegisterListener(this.e);
        MessageManager.getInstance().unRegisterListener(this.f);
        MessageManager.getInstance().unRegisterListener(this.P);
        MessageManager.getInstance().unRegisterListener(this.N);
        MessageManager.getInstance().unRegisterListener(this.O);
        if (this.I != null) {
            unregisterReceiver(this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TbadkApplication.m252getInst().sendLaunchTime();
        TbadkApplication.m252getInst().AddResumeNum();
        if (this.L) {
            this.L = false;
            this.M.postDelayed(this.d, 2500L);
        }
        h = this.m.getCurrentTabType();
        a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ao.a = false;
        if (g) {
            g = false;
            CompatibleUtile.setAnim(this, com.baidu.tieba.p.down, com.baidu.tieba.p.hold);
        }
        TbadkApplication.m252getInst().DelResumeNum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("locate_type", this.m.getCurrentTabType());
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
            s();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            g();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new au(this, au.b)));
            finish();
        } else if (intExtra == 12) {
            TbadkApplication.m252getInst().notifyAppEnterBackground();
            com.baidu.tbadk.core.log.a.b();
            TbadkApplication.m252getInst().clearHasShowAppForums();
            finish();
        } else if (intExtra == 1 || intExtra == 3) {
            this.m.setCurrentTabByType(intExtra);
        }
        a((Context) this, TbadkApplication.getIntent());
    }

    private void s() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (System.currentTimeMillis() - this.i > 2000) {
                c(com.baidu.tieba.y.double_back_quit);
                this.i = System.currentTimeMillis();
            } else {
                t();
                moveTaskToBack(true);
                TbadkApplication.m252getInst().notifyAppEnterBackground();
                com.baidu.tbadk.core.log.a.b();
            }
            return false;
        }
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            o();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        try {
            this.m.setCurrentTabByType(intent.getIntExtra("locate_type", 1));
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

    @Override // android.app.Activity, android.view.KeyEvent.Callback
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

    protected void k() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.j.a((Context) this, antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bv(this, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i == 12007) {
                LoginActivity.a(this, 1, getString(com.baidu.tieba.y.login_home_tab), 11003);
            }
            if (this.m.getCurrentFragment() != null) {
                this.m.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            k();
        } else if (this.m.getCurrentFragment() != null) {
            this.m.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.m.b(i);
        if (i == 1) {
            this.m.setBackgroundColor(-5525837);
            if (this.K != 0) {
                this.C.setBackgroundResource(this.K);
            }
        } else {
            this.m.setBackgroundColor(-5525837);
            if (this.J != 0) {
                this.C.setBackgroundResource(this.J);
            }
        }
        this.n.c(i);
        this.o.a(this.G, i, getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n_1));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.t.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
            this.x.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
            this.F.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
        } else {
            this.t.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
            this.x.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
            this.F.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
        }
        a(false);
    }

    private void t() {
        if (System.currentTimeMillis() - this.j >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.j = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.k
    public int a() {
        if (this.m != null) {
            return this.m.getCurrentTabType();
        }
        return -1;
    }
}
