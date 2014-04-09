package com.baidu.tieba.tbluncher;

import android.app.Activity;
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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.ad;
import com.baidu.tbadk.core.b.ag;
import com.baidu.tbadk.core.b.av;
import com.baidu.tbadk.core.b.z;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class MainTabActivity extends com.baidu.tbadk.core.e {
    public static boolean c = true;
    private static boolean g = false;
    private static int h = -1;
    private TextView A;
    private ImageView B;
    private View C;
    private ImageView D;
    private MainTabActivity E;
    private int H;
    private int I;
    private boolean J;
    private FragmentTabHost m;
    private NavigationBar n;
    private View z;
    private long i = 0;
    private long j = 0;
    private final long k = 2000;
    private final long l = 7200000;
    private com.baidu.tbadk.core.view.i o = null;
    private View p = null;
    private HeadImageView q = null;
    private TextView r = null;
    private ImageView s = null;
    private View t = null;
    private ImageView u = null;
    private View v = null;
    private ImageView w = null;
    private TextView x = null;
    private TextView y = null;
    private ab F = null;
    private x G = null;
    private Handler K = null;
    final Runnable d = new i(this);
    final com.baidu.adp.framework.c.a e = new q(this, 2001124);
    final com.baidu.adp.framework.c.a f = new r(this, 2007002);
    private final com.baidu.adp.framework.c.a L = new s(this, 2007006);
    private final com.baidu.adp.framework.c.a M = new t(this, 2007005);
    private int N = 0;
    private int O = 0;
    private boolean P = false;
    private final com.baidu.adp.framework.c.a Q = new u(this, 2001158);
    private final com.baidu.adp.framework.c.a R = new v(this, 2001124);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new w());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2012111, new j());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask2);
        com.baidu.adp.framework.c.a().a(new p(2001004));
    }

    public static /* synthetic */ void a(MainTabActivity mainTabActivity, TextView textView, int i) {
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        boolean z = TbadkApplication.j().l() == 1;
        textView.setTextColor(TbadkApplication.j().b().getResources().getColor(z ? com.baidu.b.a.c.top_msg_num_night : com.baidu.b.a.c.top_msg_num_day));
        if (i < 10) {
            textView.setText(String.valueOf(i));
            mainTabActivity.H = com.baidu.b.a.e.icon_news_head_prompt_one;
            mainTabActivity.I = com.baidu.b.a.e.icon_news_head_prompt_one_1;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            mainTabActivity.H = com.baidu.b.a.e.icon_news_head_prompt_two;
            mainTabActivity.I = com.baidu.b.a.e.icon_news_head_prompt_two_1;
        } else {
            textView.setText("   ");
            mainTabActivity.H = com.baidu.b.a.e.icon_news_head_prompt_more;
            mainTabActivity.I = com.baidu.b.a.e.icon_news_head_prompt_more_1;
        }
        textView.setBackgroundResource(z ? mainTabActivity.I : mainTabActivity.H);
    }

    public static /* synthetic */ void a(MainTabActivity mainTabActivity, com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.c = dVar.a;
            bVar.a = dVar.c;
            fragmentTabIndicator.setText(dVar.b);
            fragmentTabIndicator.a(0, mainTabActivity.getResources().getDimension(com.baidu.b.a.d.ds32));
            fragmentTabIndicator.b = com.baidu.b.a.c.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.b.a.c.main_bottom_button_color;
            bVar.b = fragmentTabIndicator;
            mainTabActivity.m.a(bVar);
        }
    }

    private void g() {
        com.baidu.adp.framework.c.a().b(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.e(this)));
    }

    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.E = this;
        this.K = new Handler();
        com.baidu.tbadk.core.d.b.a(new y());
        if (TbadkApplication.j().az()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.adp.lib.util.f.a(getClass().toString(), "onCreate", "debug");
        setContentView(com.baidu.b.a.g.maintabs_activity);
        com.baidu.tbadk.core.a.a.a().a((Activity) this, false);
        this.m = (FragmentTabHost) findViewById(com.baidu.b.a.f.tab_host);
        this.m.setup(getSupportFragmentManager());
        this.m.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.b.a.c.maintab_bg));
        com.baidu.adp.framework.c.a().a(this.Q);
        com.baidu.adp.framework.c.a().a(this.R);
        com.baidu.adp.framework.c.a().a(this.e);
        this.f.a(100);
        com.baidu.adp.framework.c.a().a(this.f);
        com.baidu.adp.framework.c.a().a(this.M);
        com.baidu.adp.framework.c.a().a(this.L);
        this.G = new x(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tbadk.core.data.n.z());
        registerReceiver(this.G, intentFilter);
        g();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
        }
        com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005009, null));
        if (TbadkApplication.I() != null && TbadkApplication.I().equals("aishide")) {
            com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005011, null));
        }
        com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005013, null));
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
        a((Context) this, TbadkApplication.i());
        TbadkApplication.j();
        String ay = TbadkApplication.ay();
        if (ay != null && ay.length() > 0) {
            UtilHelper.b(TbadkApplication.j().b(), ay);
            TbadkApplication.j();
            TbadkApplication.p(null);
        }
        this.n = (NavigationBar) this.E.findViewById(com.baidu.b.a.f.view_navigation_bar);
        if (this.n != null) {
            this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.b.a.g.widget_nb_item_logo, (View.OnClickListener) null);
            this.n.a(this.E.getResources().getString(com.baidu.b.a.h.app_name));
            View a = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.b.a.g.nb_item_maintab_message, (View.OnClickListener) null);
            this.z = a.findViewById(com.baidu.b.a.f.maintab_message_button);
            this.z.setOnClickListener(new l(this));
            this.A = (TextView) a.findViewById(com.baidu.b.a.f.maintab_message_text);
            this.B = (ImageView) this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.b.a.g.widget_nb_item_search, (View.OnClickListener) null);
            this.B.setOnClickListener(new m(this));
            this.C = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.b.a.g.more_with_red_tag, this);
            this.D = (ImageView) this.C.findViewById(com.baidu.b.a.f.more_with_red_tag_msg);
            View inflate = this.E.getLayoutInflater().inflate(com.baidu.b.a.g.main_tab_more_pop_window, (ViewGroup) null);
            this.p = inflate.findViewById(com.baidu.b.a.f.more_pop_item_account);
            this.p.setOnClickListener(this);
            this.q = (HeadImageView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_account_head);
            this.r = (TextView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_account_name);
            this.s = (ImageView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_account_msg);
            this.t = inflate.findViewById(com.baidu.b.a.f.more_pop_item_mark);
            this.t.setOnClickListener(this);
            this.u = (ImageView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_mark_msg);
            this.v = inflate.findViewById(com.baidu.b.a.f.more_pop_item_setting);
            this.v.setOnClickListener(this);
            this.w = (ImageView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_setting_msg);
            this.x = (TextView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_feedback);
            this.x.setOnClickListener(this);
            this.y = (TextView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_switchaccount);
            this.y.setOnClickListener(this);
            this.o = new com.baidu.tbadk.core.view.i(this.E, inflate, this.n, getResources().getDrawable(com.baidu.b.a.e.bg_pull_down_right_n), new n(this));
        }
        this.J = TbadkApplication.j().ad();
        if (this.J) {
            TbadkApplication.j().g(false);
            this.K.postDelayed(this.d, 3000L);
        }
        com.baidu.tbadk.core.log.a.c();
    }

    public final void f() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.n).a(0).b(false);
        gVar.a(new k(this));
        gVar.a().a(this.E);
    }

    public void h() {
        if (this.o != null) {
            if (this.F == null) {
                this.F = new ab(this.E);
            }
            AccountData N = TbadkApplication.N();
            if (N != null) {
                String portrait = N.getPortrait();
                if (portrait != null) {
                    ab abVar = this.F;
                    com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                    if (b != null) {
                        b.a(this.q);
                    } else {
                        this.F.c(portrait, new o(this));
                    }
                }
                this.r.setText(N.getAccount());
            }
            this.o.b();
        }
    }

    @Override // com.baidu.adp.a.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.C) {
            h();
            a(true);
        } else if (view == this.p) {
            this.o.dismiss();
            AccountData N = TbadkApplication.N();
            if (N != null) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new ag(this.E, N.getID(), N.getAccount())));
            }
            this.N = 0;
            a(true);
        } else if (view == this.t) {
            this.o.dismiss();
            a(new com.baidu.adp.framework.message.a(2015005, new com.baidu.tbadk.core.frameworkData.a(this.E)));
            this.O = 0;
            a(true);
        } else if (view == this.v) {
            this.o.dismiss();
            a(new com.baidu.adp.framework.message.a(2015004, new com.baidu.tbadk.core.frameworkData.a(this.E)));
            this.P = false;
            a(true);
        } else if (view == this.x) {
            this.o.dismiss();
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData.getIfpost() == 0) {
                com.baidu.adp.lib.util.i.a((Context) this.E, antiData.getForbid_info());
                return;
            }
            antiData.setIfVoice(false);
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(this.E, 0, com.baidu.tbadk.core.data.n.y(), com.baidu.tbadk.core.data.n.x(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null)));
        } else if (view == this.y) {
            this.o.dismiss();
            a(new com.baidu.adp.framework.message.a(2015006, new com.baidu.tbadk.core.frameworkData.a(this.E)));
        }
    }

    public void a(boolean z) {
        if (TbadkApplication.j().l() == 1) {
            this.s.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one_1);
            this.u.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one_1);
            this.w.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one_1);
            this.D.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one_1);
        } else {
            this.s.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one);
            this.u.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one);
            this.w.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one);
            this.D.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one);
        }
        if (this.P || this.N > 0 || this.O > 0) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(4);
        }
        if (z) {
            this.D.setVisibility(4);
        }
        if (this.N > 0) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(4);
        }
        if (this.O > 0) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(4);
        }
        if (this.P) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(4);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
    }

    public static void d(int i) {
        h = 2;
    }

    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.adp.lib.util.f.a(getClass().getName(), "onDestroy", "");
        com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005010, null));
        com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005012, null));
        com.baidu.adp.framework.c.a().b(this.Q);
        com.baidu.adp.framework.c.a().b(this.R);
        com.baidu.adp.framework.c.a().b(this.e);
        com.baidu.adp.framework.c.a().b(this.f);
        com.baidu.adp.framework.c.a().b(this.M);
        com.baidu.adp.framework.c.a().b(this.L);
        if (this.G != null) {
            unregisterReceiver(this.G);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.a().g();
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
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
            com.baidu.adp.lib.util.f.a(getClass(), "onRestoreInstanceState", th);
        }
    }

    private static void a(Context context, Intent intent) {
        UtilHelper.a(context, intent);
        TbadkApplication.a((Intent) null);
    }

    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.util.f.e("MainTabActivity", "onResume", "onResume");
        TbadkApplication.j().h();
        TbadkApplication.j().n();
        if (h != 10) {
            if (h == -1) {
                com.baidu.tbadk.core.a.a.a().a(this, 1);
            } else {
                com.baidu.tbadk.core.a.a.a().a(this, h);
            }
        }
        h = this.m.getCurrentTabType();
        a(this.b);
    }

    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        z.a = false;
        if (g) {
            g = false;
            CompatibleUtile.setAnim(this, com.baidu.b.a.b.down, com.baidu.b.a.b.hold);
        }
        TbadkApplication.j().o();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("locate_type", this.m.getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        com.baidu.adp.lib.util.f.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        setIntent(intent);
        intent.getBooleanExtra("close_dialog", false);
        if (intent.getBooleanExtra("refresh_all", false)) {
            g();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new ad(this, ad.b)));
            finish();
        } else if (intExtra == 12) {
            TbadkApplication.j().r();
            com.baidu.tbadk.core.log.a.b();
            TbadkApplication.j().w();
            finish();
        }
        a((Context) this, TbadkApplication.i());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            com.baidu.adp.lib.util.f.e(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            if ((TbadkApplication.E() == null && this.m.getCurrentTabType() == 0) || (TbadkApplication.E() != null && this.m.getCurrentTabType() == 1)) {
                if (System.currentTimeMillis() - this.i > 2000) {
                    com.baidu.adp.lib.util.i.a((Context) this, com.baidu.b.a.h.double_back_quit);
                    this.i = System.currentTimeMillis();
                    return false;
                }
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
                if (System.currentTimeMillis() - this.j >= 7200000) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006003, "start"));
                    com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005013, null));
                    com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005009, null));
                    this.j = System.currentTimeMillis();
                }
                moveTaskToBack(true);
                TbadkApplication.j().r();
                com.baidu.tbadk.core.log.a.b();
                return false;
            } else if (TbadkApplication.E() == null) {
                com.baidu.tbadk.core.tabHost.b b = this.m.b(0);
                if (b != null) {
                    b.b.performClick();
                    return false;
                }
                return false;
            } else {
                com.baidu.tbadk.core.tabHost.b b2 = this.m.b(1);
                if (b2 != null) {
                    b2.b.performClick();
                    return false;
                }
                return false;
            }
        }
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            h();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public static /* synthetic */ void a(MainTabActivity mainTabActivity, Intent intent) {
        try {
            mainTabActivity.m.setCurrentTabByType(intent.getIntExtra("locate_type", 1));
        } catch (Throwable th) {
            mainTabActivity.finish();
        }
    }

    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
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

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i == 12007) {
                LoginActivity.a(this, 1, getString(com.baidu.b.a.h.login_home_tab), 11003);
            }
            if (this.m.getCurrentFragment() != null) {
                this.m.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData.getIfpost() == 0) {
                com.baidu.adp.lib.util.i.a((Context) this, antiData.getForbid_info());
                return;
            }
            antiData.setIfVoice(false);
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(this, 0, com.baidu.tbadk.core.data.n.y(), com.baidu.tbadk.core.data.n.x(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null)));
        } else if (this.m.getCurrentFragment() != null) {
            this.m.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.e
    protected final void b(int i) {
        this.m.c(i);
        if (i == 1) {
            this.m.setBackgroundColor(-5525837);
            if (this.I != 0) {
                this.A.setBackgroundResource(this.I);
            }
        } else {
            this.m.setBackgroundColor(-5525837);
            if (this.H != 0) {
                this.A.setBackgroundResource(this.H);
            }
        }
        this.n.b(i);
        this.o.a(this.E, i, getResources().getDrawable(com.baidu.b.a.e.bg_pull_down_right_n), getResources().getDrawable(com.baidu.b.a.e.bg_pull_down_right_n_1));
        if (TbadkApplication.j().l() == 1) {
            this.s.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one_1);
            this.u.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one_1);
            this.w.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one_1);
            this.D.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one_1);
            return;
        }
        this.s.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one);
        this.u.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one);
        this.w.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one);
        this.D.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one);
    }
}
