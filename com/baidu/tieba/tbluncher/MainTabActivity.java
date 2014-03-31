package com.baidu.tieba.tbluncher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.x;
import com.baidu.tbadk.core.voice.z;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class MainTabActivity extends com.baidu.tbadk.core.e implements z {
    private static boolean e = false;
    private static int f = -1;
    private ImageView A;
    private View B;
    private ImageView C;
    private MainTabActivity D;
    private int G;
    private int H;
    private VoiceManager k;
    private FragmentTabHost l;
    private NavigationBar m;
    private View y;
    private TextView z;
    private long g = 0;
    private long h = 0;
    private final long i = 2000;
    private final long j = 7200000;
    private com.baidu.tbadk.core.view.i n = null;
    private View o = null;
    private HeadImageView p = null;
    private TextView q = null;
    private ImageView r = null;
    private View s = null;
    private ImageView t = null;
    private View u = null;
    private ImageView v = null;
    private TextView w = null;
    private TextView x = null;
    private aa E = null;
    private t F = null;
    final com.baidu.adp.framework.c.a c = new l(this, 2001124);
    final com.baidu.adp.framework.c.a d = new m(this, 2007002);
    private final com.baidu.adp.framework.c.a I = new n(this, 2007006);
    private final com.baidu.adp.framework.c.a J = new o(this, 2007005);
    private int K = 0;
    private int L = 0;
    private boolean M = false;
    private final com.baidu.adp.framework.c.a N = new p(this, 2001124);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new q());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
        com.baidu.adp.framework.c.a().a(new i(2001004));
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
            mainTabActivity.l.a(bVar);
        }
    }

    private void f() {
        com.baidu.adp.framework.c.a().b(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.e(this)));
    }

    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.D = this;
        com.baidu.tbadk.core.d.b.a(new u());
        if (TbadkApplication.j().ax()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.adp.lib.util.f.a(getClass().toString(), "onCreate", "debug");
        setContentView(com.baidu.b.a.g.maintabs_activity);
        com.baidu.tbadk.core.a.a.a().a((Activity) this, false);
        this.l = (FragmentTabHost) findViewById(com.baidu.b.a.f.tab_host);
        this.l.setup(getSupportFragmentManager());
        this.l.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.b.a.c.maintab_bg));
        com.baidu.adp.framework.c.a().a(this.N);
        com.baidu.adp.framework.c.a().a(this.c);
        this.d.a(100);
        com.baidu.adp.framework.c.a().a(this.d);
        com.baidu.adp.framework.c.a().a(this.J);
        com.baidu.adp.framework.c.a().a(this.I);
        this.F = new t(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tbadk.core.data.n.z());
        registerReceiver(this.F, intentFilter);
        f();
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
        String aw = TbadkApplication.aw();
        if (aw != null && aw.length() > 0) {
            UtilHelper.b(TbadkApplication.j().b(), aw);
            TbadkApplication.j();
            TbadkApplication.p(null);
        }
        this.m = (NavigationBar) this.D.findViewById(com.baidu.b.a.f.view_navigation_bar);
        if (this.m != null) {
            this.m.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.b.a.g.widget_nb_item_logo, (View.OnClickListener) null);
            this.m.a(this.D.getResources().getString(com.baidu.b.a.h.app_name));
            View a = this.m.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.b.a.g.nb_item_maintab_message, (View.OnClickListener) null);
            this.y = a.findViewById(com.baidu.b.a.f.maintab_message_button);
            this.y.setOnClickListener(new r(this));
            this.z = (TextView) a.findViewById(com.baidu.b.a.f.maintab_message_text);
            this.A = (ImageView) this.m.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.b.a.g.widget_nb_item_search, (View.OnClickListener) null);
            this.A.setOnClickListener(new s(this));
            this.B = this.m.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.b.a.g.more_with_red_tag, this);
            this.C = (ImageView) this.B.findViewById(com.baidu.b.a.f.more_with_red_tag_msg);
            View inflate = this.D.getLayoutInflater().inflate(com.baidu.b.a.g.main_tab_more_pop_window, (ViewGroup) null);
            this.o = inflate.findViewById(com.baidu.b.a.f.more_pop_item_account);
            this.o.setOnClickListener(this);
            this.p = (HeadImageView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_account_head);
            this.q = (TextView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_account_name);
            this.r = (ImageView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_account_msg);
            this.s = inflate.findViewById(com.baidu.b.a.f.more_pop_item_mark);
            this.s.setOnClickListener(this);
            this.t = (ImageView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_mark_msg);
            this.u = inflate.findViewById(com.baidu.b.a.f.more_pop_item_setting);
            this.u.setOnClickListener(this);
            this.v = (ImageView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_setting_msg);
            this.w = (TextView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_feedback);
            this.w.setOnClickListener(this);
            this.x = (TextView) inflate.findViewById(com.baidu.b.a.f.more_pop_item_switchaccount);
            this.x.setOnClickListener(this);
            this.n = new com.baidu.tbadk.core.view.i(this.D, inflate, this.m, getResources().getDrawable(com.baidu.b.a.e.bg_pull_down_left_n), new j(this));
        }
        this.k = d();
        this.k.a((Activity) this);
        com.baidu.tbadk.core.log.a.c();
    }

    public void g() {
        if (this.n != null) {
            if (this.E == null) {
                this.E = new aa(this.D);
            }
            AccountData N = TbadkApplication.N();
            if (N != null) {
                String portrait = N.getPortrait();
                if (portrait != null) {
                    aa aaVar = this.E;
                    com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                    if (b != null) {
                        b.a(this.p);
                    } else {
                        this.E.c(portrait, new k(this));
                    }
                }
                this.q.setText(N.getAccount());
            }
            this.n.b();
        }
    }

    @Override // com.baidu.adp.a.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.B) {
            g();
        } else if (view == this.o) {
            AccountData N = TbadkApplication.N();
            if (N != null) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new ag(this.D, N.getID(), N.getAccount())));
            }
            this.n.dismiss();
            this.K = 0;
            h();
        } else if (view == this.s) {
            a(new com.baidu.adp.framework.message.a(2015005, new com.baidu.tbadk.core.frameworkData.a(this.D)));
            this.n.dismiss();
            this.L = 0;
            h();
        } else if (view == this.u) {
            a(new com.baidu.adp.framework.message.a(2015004, new com.baidu.tbadk.core.frameworkData.a(this.D)));
            this.n.dismiss();
            this.M = false;
            h();
        } else if (view == this.w) {
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData.getIfpost() == 0) {
                com.baidu.adp.lib.util.i.a((Context) this.D, antiData.getForbid_info());
                return;
            }
            antiData.setIfVoice(false);
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(this.D, 0, com.baidu.tbadk.core.data.n.y(), com.baidu.tbadk.core.data.n.x(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null)));
            this.n.dismiss();
        } else if (view == this.x) {
            a(new com.baidu.adp.framework.message.a(2015006, new com.baidu.tbadk.core.frameworkData.a(this.D)));
            this.n.dismiss();
        }
    }

    public void h() {
        if (TbadkApplication.j().l() == 1) {
            this.r.setImageResource(com.baidu.b.a.e.icon_news_list_prompt_1);
            this.t.setImageResource(com.baidu.b.a.e.icon_news_list_prompt_1);
            this.v.setImageResource(com.baidu.b.a.e.icon_news_list_prompt_1);
            this.C.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one_1);
        } else {
            this.r.setImageResource(com.baidu.b.a.e.icon_news_list_prompt);
            this.t.setImageResource(com.baidu.b.a.e.icon_news_list_prompt);
            this.v.setImageResource(com.baidu.b.a.e.icon_news_list_prompt);
            this.C.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one);
        }
        if (this.M || this.K > 0 || this.L > 0) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(4);
        }
        if (this.K > 0) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(4);
        }
        if (this.L > 0) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(4);
        }
        if (this.M) {
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(4);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.k != null) {
            VoiceManager voiceManager = this.k;
            VoiceManager.g();
        }
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
    }

    public static void e(int i) {
        f = 2;
    }

    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.adp.lib.util.f.a(getClass().getName(), "onDestroy", "");
        com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005010, null));
        com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005012, null));
        com.baidu.adp.framework.c.a().b(this.N);
        com.baidu.adp.framework.c.a().b(this.c);
        com.baidu.adp.framework.c.a().b(this.d);
        com.baidu.adp.framework.c.a().b(this.J);
        com.baidu.adp.framework.c.a().b(this.I);
        if (this.F != null) {
            unregisterReceiver(this.F);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.a().g();
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(false);
        com.baidu.tbadk.imageManager.e.a().c();
        if (this.a != null) {
            this.a.dismiss();
            this.a = null;
        }
        if (this.k != null) {
            this.k.d(this);
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
        if (f != 10) {
            if (f == -1) {
                com.baidu.tbadk.core.a.a.a().a(this, 1);
            } else {
                com.baidu.tbadk.core.a.a.a().a(this, f);
            }
        }
        f = this.l.getCurrentTabType();
        a(this.b);
    }

    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.tbadk.core.b.z.a = false;
        if (e) {
            e = false;
            CompatibleUtile.setAnim(this, com.baidu.b.a.b.down, com.baidu.b.a.b.hold);
        }
        TbadkApplication.j().o();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("locate_type", this.l.getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.k != null) {
            this.k.j();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        com.baidu.adp.lib.util.f.a(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        setIntent(intent);
        intent.getBooleanExtra("close_dialog", false);
        if (intent.getBooleanExtra("refresh_all", false)) {
            f();
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
            if ((TbadkApplication.E() == null && this.l.getCurrentTabType() == 0) || (TbadkApplication.E() != null && this.l.getCurrentTabType() == 1)) {
                if (System.currentTimeMillis() - this.g > 2000) {
                    com.baidu.adp.lib.util.i.a((Context) this, com.baidu.b.a.h.double_back_quit);
                    this.g = System.currentTimeMillis();
                    return false;
                }
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
                if (System.currentTimeMillis() - this.h >= 7200000) {
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006003, "start"));
                    com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005013, null));
                    com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2005009, null));
                    this.h = System.currentTimeMillis();
                }
                moveTaskToBack(true);
                TbadkApplication.j().r();
                com.baidu.tbadk.core.log.a.b();
                return false;
            } else if (TbadkApplication.E() == null) {
                com.baidu.tbadk.core.tabHost.b b = this.l.b(0);
                if (b != null) {
                    b.b.performClick();
                    return false;
                }
                return false;
            } else {
                com.baidu.tbadk.core.tabHost.b b2 = this.l.b(1);
                if (b2 != null) {
                    b2.b.performClick();
                    return false;
                }
                return false;
            }
        }
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            g();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public static /* synthetic */ void a(MainTabActivity mainTabActivity, Intent intent) {
        try {
            mainTabActivity.l.setCurrentTabByType(intent.getIntExtra("locate_type", 1));
        } catch (Throwable th) {
            mainTabActivity.finish();
        }
    }

    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyDown(i, keyEvent);
        } catch (IllegalStateException e2) {
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
        } catch (IllegalStateException e2) {
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
            if (this.l.getCurrentFragment() != null) {
                this.l.getCurrentFragment().onActivityResult(i, i2, intent);
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
        } else if (this.l.getCurrentFragment() != null) {
            this.l.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.e
    protected final void c(int i) {
        this.l.c(i);
        if (i == 1) {
            this.l.setBackgroundColor(-5525837);
            if (this.H != 0) {
                this.z.setBackgroundResource(this.H);
            }
        } else {
            this.l.setBackgroundColor(-5525837);
            if (this.G != 0) {
                this.z.setBackgroundResource(this.G);
            }
        }
        this.m.b(i);
        this.n.a(this.D, i, getResources().getDrawable(com.baidu.b.a.e.bg_pull_down_left_n), getResources().getDrawable(com.baidu.b.a.e.bg_pull_down_left_n_1));
        if (TbadkApplication.j().l() == 1) {
            this.r.setImageResource(com.baidu.b.a.e.icon_news_list_prompt_1);
            this.t.setImageResource(com.baidu.b.a.e.icon_news_list_prompt_1);
            this.v.setImageResource(com.baidu.b.a.e.icon_news_list_prompt_1);
            this.C.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one_1);
            return;
        }
        this.r.setImageResource(com.baidu.b.a.e.icon_news_list_prompt);
        this.t.setImageResource(com.baidu.b.a.e.icon_news_list_prompt);
        this.v.setImageResource(com.baidu.b.a.e.icon_news_list_prompt);
        this.C.setImageResource(com.baidu.b.a.e.icon_news_down_bar_one);
    }

    @Override // com.baidu.tbadk.core.voice.z
    public final VoiceManager d() {
        if (this.k == null) {
            this.k = new VoiceManager();
        }
        return this.k;
    }

    @Override // com.baidu.tbadk.core.voice.z
    public final x a(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
