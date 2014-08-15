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
import com.baidu.tbadk.core.atomData.ar;
import com.baidu.tbadk.core.atomData.az;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tbadk.core.atomData.bg;
import com.baidu.tbadk.core.atomData.ce;
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
public class MainTabActivity extends BaseFragmentActivity implements i {
    public static boolean d = true;
    private static boolean h = false;
    private static int i = -1;
    private View D;
    private TextView E;
    private ImageView F;
    private View G;
    private ImageView H;
    private MainTabActivity I;
    private int K;
    private int L;
    private boolean M;
    private FragmentTabHost n;
    private NavigationBar o;
    private long j = 0;
    private long k = 0;
    private final long l = 2000;
    private final long m = 7200000;
    private com.baidu.tbadk.core.view.m p = null;
    private View q = null;
    private HeadImageView r = null;
    private TextView s = null;
    private Drawable t = null;
    private View u = null;
    private ImageView v = null;
    private View w = null;
    private View x = null;
    private View y = null;
    private ImageView z = null;
    private TextView A = null;
    private TextView B = null;
    private TextView C = null;
    private ad J = null;
    private int N = 0;
    private int O = 0;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = false;
    private boolean S = false;
    private Handler T = null;
    final Runnable e = new j(this);
    final CustomMessageListener f = new w(this, 2001124);
    final CustomMessageListener g = new x(this, 2007002);
    private final CustomMessageListener U = new y(this, 2007006);
    private final CustomMessageListener V = new z(this, 2012112);
    private final CustomMessageListener W = new aa(this, 2007005);
    private final Runnable X = new ab(this);
    private final CustomMessageListener Y = new ac(this, 2001158);
    private final CustomMessageListener Z = new k(this, 2001124);

    static {
        l();
        n();
        m();
        MessageManager.getInstance().registerListener(new u(2002004));
    }

    private static void l() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new l());
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
    public void a(TextView textView, int i2) {
        if (i2 <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        textView.setTextColor(TbadkApplication.m252getInst().getApp().getResources().getColor(z ? com.baidu.tieba.r.top_msg_num_night : com.baidu.tieba.r.top_msg_num_day));
        if (i2 < 10) {
            textView.setText(String.valueOf(i2));
            this.K = com.baidu.tieba.t.icon_news_head_prompt_one;
            this.L = com.baidu.tieba.t.icon_news_head_prompt_one_1;
        } else if (i2 < 100) {
            textView.setText(String.valueOf(i2));
            this.K = com.baidu.tieba.t.icon_news_head_prompt_two;
            this.L = com.baidu.tieba.t.icon_news_head_prompt_two_1;
        } else {
            textView.setText("   ");
            this.K = com.baidu.tieba.t.icon_news_head_prompt_more;
            this.L = com.baidu.tieba.t.icon_news_head_prompt_more_1;
        }
        textView.setBackgroundResource(z ? this.L : this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.c = dVar.a;
            bVar.a = dVar.c;
            fragmentTabIndicator.setText(dVar.b);
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.s.ds32));
            fragmentTabIndicator.b = com.baidu.tieba.r.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.r.main_bottom_button_color;
            bVar.b = fragmentTabIndicator;
            this.n.a(bVar);
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
        this.M = TbadkApplication.m252getInst().isFirstGoMaintab();
        this.I = this;
        this.T = new Handler();
        ae aeVar = new ae();
        com.baidu.tbadk.core.b.b.a(aeVar);
        aeVar.a((i) this.I);
        if (j()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        setContentView(com.baidu.tieba.v.maintabs_activity);
        AccountLoginHelper.getInstance().reLoginByCacheAccount(this);
        this.n = (FragmentTabHost) findViewById(com.baidu.tieba.u.tab_host);
        this.n.setup(getSupportFragmentManager());
        this.n.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.r.maintab_bg));
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
        if (this.M) {
            TbadkApplication.m252getInst().setFirstGoMaintab(false);
        }
        this.T.postDelayed(this.X, 10000L);
    }

    public void h() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.o).a(0).b(false);
        gVar.a(new o(this));
        gVar.a().a(this.I);
    }

    public void i() {
        this.o = (NavigationBar) this.I.findViewById(com.baidu.tieba.u.view_navigation_bar);
        if (this.o != null) {
            this.o.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.v.widget_nb_item_logo, (View.OnClickListener) null);
            this.o.a(this.I.getResources().getString(com.baidu.tieba.x.app_name));
            View a = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nb_item_maintab_message, (View.OnClickListener) null);
            this.D = a.findViewById(com.baidu.tieba.u.maintab_message_button);
            this.D.setOnClickListener(new p(this));
            this.E = (TextView) a.findViewById(com.baidu.tieba.u.maintab_message_text);
            this.F = (ImageView) this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_search, (View.OnClickListener) null);
            this.F.setOnClickListener(new q(this));
            this.G = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.more_with_red_tag, this);
            this.H = (ImageView) this.G.findViewById(com.baidu.tieba.u.more_with_red_tag_msg);
            View inflate = this.I.getLayoutInflater().inflate(com.baidu.tieba.v.main_tab_more_pop_window, (ViewGroup) null);
            this.q = inflate.findViewById(com.baidu.tieba.u.more_pop_item_account);
            this.q.setOnClickListener(this);
            this.r = (HeadImageView) inflate.findViewById(com.baidu.tieba.u.more_pop_item_account_head);
            this.s = (TextView) inflate.findViewById(com.baidu.tieba.u.more_pop_item_account_name);
            this.u = inflate.findViewById(com.baidu.tieba.u.more_pop_item_mark);
            this.u.setOnClickListener(this);
            this.v = (ImageView) inflate.findViewById(com.baidu.tieba.u.more_pop_item_mark_msg);
            this.w = inflate.findViewById(com.baidu.tieba.u.more_pop_item_history);
            this.w.setOnClickListener(this);
            this.x = inflate.findViewById(com.baidu.tieba.u.more_pop_item_mylive);
            this.x.setOnClickListener(new r(this));
            this.y = inflate.findViewById(com.baidu.tieba.u.more_pop_item_setting);
            this.y.setOnClickListener(this);
            this.z = (ImageView) inflate.findViewById(com.baidu.tieba.u.more_pop_item_setting_msg);
            this.A = (TextView) inflate.findViewById(com.baidu.tieba.u.more_pop_item_feedback);
            this.A.setOnClickListener(this);
            this.B = (TextView) inflate.findViewById(com.baidu.tieba.u.more_pop_item_switchaccount);
            this.B.setOnClickListener(this);
            this.C = (TextView) inflate.findViewById(com.baidu.tieba.u.more_pop_item_exitapp);
            this.C.setOnClickListener(this);
            this.p = new com.baidu.tbadk.core.view.m(this.I, inflate, this.o, getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n), new s(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.p != null) {
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                this.r.a(currentAccountObj.getPortrait(), 12, false);
                this.s.setText(currentAccountObj.getAccount());
            }
            this.p.b();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.G) {
            o();
            a(true);
        } else if (view == this.q) {
            this.p.dismiss();
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new bg(this.I, currentAccountObj.getID(), currentAccountObj.getAccount())));
            }
            this.R = false;
            a(true);
        } else if (view == this.u) {
            this.p.dismiss();
            a(new CustomMessage(2015005, new com.baidu.tbadk.core.frameworkData.a(this.I)));
            this.S = false;
            a(true);
        } else if (view == this.w) {
            this.p.dismiss();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bc(this.I)));
        } else if (view == this.y) {
            this.p.dismiss();
            a(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.a(this.I)));
            this.P = false;
            a(true);
        } else if (view == this.A) {
            this.p.dismiss();
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData != null && antiData.getIfpost() == 0) {
                com.baidu.adp.lib.util.j.a((Context) this.I, antiData.getForbid_info());
                return;
            }
            antiData.setIfVoice(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ce(this.I, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
        } else if (view == this.B) {
            this.p.dismiss();
            a(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.a(this.I)));
        } else if (view == this.C) {
            this.p.dismiss();
            p().show();
        }
    }

    private AlertDialog p() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.baidu.tieba.x.del_post_tip);
        builder.setMessage(com.baidu.tieba.x.exit_tip);
        builder.setPositiveButton(com.baidu.tieba.x.alert_yes_button, new t(this));
        builder.setNegativeButton(com.baidu.tieba.x.alert_no_button, new v(this));
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.t = getResources().getDrawable(com.baidu.tieba.t.icon_news_down_bar_one_1);
            this.v.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one_1);
            this.z.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one_1);
            this.H.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one_1);
        } else {
            this.t = getResources().getDrawable(com.baidu.tieba.t.icon_news_down_bar_one);
            this.v.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one);
            this.z.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one);
            this.H.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one);
        }
        if (this.P || this.N > 0 || this.O <= 0) {
        }
        if (this.Q) {
            this.H.setVisibility(0);
        } else {
            this.H.setVisibility(4);
        }
        if (z) {
            this.H.setVisibility(4);
            this.Q = false;
        }
        if (this.N > 0 && this.R) {
            this.s.setCompoundDrawablePadding(com.baidu.adp.lib.util.j.a((Context) this.I, 4.0f));
            this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.t, (Drawable) null);
        } else {
            this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.O > 0 && this.S) {
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(4);
        }
        if (this.P) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public static void d(int i2) {
        i = i2;
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
        com.baidu.tbadk.coreExtra.messageCenter.a.a().i();
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(false);
        com.baidu.tbadk.imageManager.e.a().c();
        if (this.b != null) {
            this.b.dismiss();
            this.b = null;
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
        a(this.Y);
        a(this.Z);
        a(this.f);
        this.g.setPriority(100);
        a(this.g);
        a(this.W);
        a(this.U);
        a(this.V);
        this.J = new ad(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.J, intentFilter);
    }

    private void r() {
        if (this.J != null) {
            unregisterReceiver(this.J);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TbadkApplication.m252getInst().sendLaunchTime();
        TbadkApplication.m252getInst().AddResumeNum();
        if (this.M) {
            this.M = false;
            this.T.postDelayed(this.e, 2500L);
        }
        i = this.n.getCurrentTabType();
        a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ar.a = false;
        if (h) {
            h = false;
            CompatibleUtile.setAnim(this, com.baidu.tieba.o.down, com.baidu.tieba.o.hold);
        }
        TbadkApplication.m252getInst().DelResumeNum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.n.getCurrentTabType());
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new az(this, az.b)));
            finish();
        } else if (intExtra == 12) {
            TbadkApplication.m252getInst().notifyAppEnterBackground();
            TbadkApplication.m252getInst().clearHasShowAppForums();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 4) {
            this.n.setCurrentTabByType(intExtra);
        }
        a((Context) this, TbadkApplication.getIntent());
    }

    private void s() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            if (System.currentTimeMillis() - this.j > 2000) {
                c(com.baidu.tieba.x.double_back_quit);
                this.j = System.currentTimeMillis();
            } else {
                t();
                moveTaskToBack(true);
                TbadkApplication.m252getInst().notifyAppEnterBackground();
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
            this.n.setCurrentTabByType(intent.getIntExtra("locate_type", 1));
        } catch (Throwable th) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        try {
            return super.onKeyDown(i2, keyEvent);
        } catch (IllegalStateException e) {
            if (i2 == 4) {
                finish();
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i2, keyEvent);
        } catch (IllegalStateException e) {
            if (i2 == 4) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ce(this, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != -1) {
            if (i2 == 12007) {
                LoginActivity.a(this, 1, getString(com.baidu.tieba.x.login_home_tab), 11003);
            }
            if (this.n.getCurrentFragment() != null) {
                this.n.getCurrentFragment().onActivityResult(i2, i3, intent);
            }
        } else if (i2 == 11001) {
            k();
        } else if (this.n.getCurrentFragment() != null) {
            this.n.getCurrentFragment().onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i2) {
        this.n.b(i2);
        if (i2 == 1) {
            this.n.setBackgroundColor(-5525837);
            if (this.L != 0) {
                this.E.setBackgroundResource(this.L);
            }
        } else {
            this.n.setBackgroundColor(-5525837);
            if (this.K != 0) {
                this.E.setBackgroundResource(this.K);
            }
        }
        this.o.c(i2);
        this.p.a(this.I, i2, getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n), getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n_1));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.v.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one_1);
            this.z.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one_1);
            this.H.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one_1);
        } else {
            this.v.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one);
            this.z.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one);
            this.H.setImageResource(com.baidu.tieba.t.icon_news_down_bar_one);
        }
        a(false);
    }

    private void t() {
        if (System.currentTimeMillis() - this.k >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.k = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.i
    public int a() {
        if (this.n != null) {
            return this.n.getCurrentTabType();
        }
        return -1;
    }
}
