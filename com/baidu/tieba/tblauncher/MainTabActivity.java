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
import com.baidu.tbadk.core.atomData.aj;
import com.baidu.tbadk.core.atomData.ap;
import com.baidu.tbadk.core.atomData.as;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity {
    public static boolean c = true;
    private static boolean g = false;
    private static int h = -1;
    private View A;
    private TextView B;
    private ImageView C;
    private View D;
    private ImageView E;
    private MainTabActivity F;
    private int I;
    private int J;
    private boolean K;
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
    private Drawable s = null;
    private View t = null;
    private ImageView u = null;
    private View v = null;
    private ImageView w = null;
    private TextView x = null;
    private TextView y = null;
    private TextView z = null;
    private com.baidu.tbadk.editortool.ab G = null;
    private aa H = null;
    private Handler L = null;
    final Runnable d = new j(this);
    final CustomMessageListener e = new t(this, MessageTypes.CMD_MESSAGE_NOTIFY_LOCAL);
    final CustomMessageListener f = new u(this, 2009002);
    private final CustomMessageListener M = new v(this, 2009006);
    private final CustomMessageListener N = new w(this, CmdConfig.MSG_READ);
    private final CustomMessageListener O = new x(this, 2009005);
    private int P = 0;
    private int Q = 0;
    private boolean R = false;
    private final CustomMessageListener S = new y(this, MessageTypes.CMD_ENTER_PERSONINFO_FROM_NOTIFI_LOCAL);
    private final CustomMessageListener T = new z(this, MessageTypes.CMD_MESSAGE_NOTIFY_LOCAL);

    static {
        j();
        k();
        MessageManager.getInstance().registerListener(new s(2003004));
    }

    private static void j() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2017001, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void k() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfig.MSG_NEW, new l());
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
            this.I = com.baidu.tieba.u.icon_news_head_prompt_one;
            this.J = com.baidu.tieba.u.icon_news_head_prompt_one_1;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.I = com.baidu.tieba.u.icon_news_head_prompt_two;
            this.J = com.baidu.tieba.u.icon_news_head_prompt_two_1;
        } else {
            textView.setText("   ");
            this.I = com.baidu.tieba.u.icon_news_head_prompt_more;
            this.J = com.baidu.tieba.u.icon_news_head_prompt_more_1;
        }
        textView.setBackgroundResource(z ? this.J : this.I);
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

    protected void e() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2009002, new com.baidu.tbadk.mainTab.e(this)));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.K = TbadkApplication.m252getInst().isFirstGoMaintab();
        this.F = this;
        this.L = new Handler();
        com.baidu.tbadk.core.b.b.a(new ab());
        if (h()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        BdLog.i(getClass().toString(), "onCreate", "debug");
        setContentView(com.baidu.tieba.w.maintabs_activity);
        AccountLoginHelper.getInstance().reLoginByCacheAccount(this);
        this.m = (FragmentTabHost) findViewById(com.baidu.tieba.v.tab_host);
        this.m.setup(getSupportFragmentManager());
        this.m.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        n();
        e();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, null));
        if (TbadkApplication.getFrom() != null && TbadkApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007013, null));
        MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.START));
        a((Context) this, TbadkApplication.getIntent());
        String installOtherApp = TbadkApplication.m252getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkApplication.m252getInst().getApp(), installOtherApp);
            TbadkApplication.m252getInst().setInstallOtherApp(null);
        }
        g();
        if (this.K) {
            TbadkApplication.m252getInst().setFirstGoMaintab(false);
            this.L.postDelayed(this.d, 3000L);
        }
        com.baidu.tbadk.core.log.a.c();
    }

    public void f() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.n).a(0).b(false);
        gVar.a(new m(this));
        gVar.a().a(this.F);
    }

    public void g() {
        this.n = (NavigationBar) this.F.findViewById(com.baidu.tieba.v.view_navigation_bar);
        if (this.n != null) {
            this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.widget_nb_item_logo, (View.OnClickListener) null);
            this.n.a(this.F.getResources().getString(com.baidu.tieba.y.app_name));
            View a = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_maintab_message, (View.OnClickListener) null);
            this.A = a.findViewById(com.baidu.tieba.v.maintab_message_button);
            this.A.setOnClickListener(new n(this));
            this.B = (TextView) a.findViewById(com.baidu.tieba.v.maintab_message_text);
            this.C = (ImageView) this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_search, (View.OnClickListener) null);
            this.C.setOnClickListener(new o(this));
            this.D = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.more_with_red_tag, this);
            this.E = (ImageView) this.D.findViewById(com.baidu.tieba.v.more_with_red_tag_msg);
            View inflate = this.F.getLayoutInflater().inflate(com.baidu.tieba.w.main_tab_more_pop_window, (ViewGroup) null);
            this.p = inflate.findViewById(com.baidu.tieba.v.more_pop_item_account);
            this.p.setOnClickListener(this);
            this.q = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_account_head);
            this.r = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_account_name);
            this.t = inflate.findViewById(com.baidu.tieba.v.more_pop_item_mark);
            this.t.setOnClickListener(this);
            this.u = (ImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_mark_msg);
            this.v = inflate.findViewById(com.baidu.tieba.v.more_pop_item_setting);
            this.v.setOnClickListener(this);
            this.w = (ImageView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_setting_msg);
            this.x = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_feedback);
            this.x.setOnClickListener(this);
            this.y = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_switchaccount);
            this.y.setOnClickListener(this);
            this.z = (TextView) inflate.findViewById(com.baidu.tieba.v.more_pop_item_exitapp);
            this.z.setOnClickListener(this);
            this.o = new com.baidu.tbadk.core.view.i(this.F, inflate, this.n, getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.o != null) {
            if (this.G == null) {
                this.G = new com.baidu.tbadk.editortool.ab(this.F);
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
        if (view == this.D) {
            l();
            a(true);
        } else if (view == this.p) {
            this.o.dismiss();
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new as(this.F, currentAccountObj.getID(), currentAccountObj.getAccount())));
            }
            this.P = 0;
            a(true);
        } else if (view == this.t) {
            this.o.dismiss();
            a(new CustomMessage(2017005, new com.baidu.tbadk.core.frameworkData.a(this.F)));
            this.Q = 0;
            a(true);
        } else if (view == this.v) {
            this.o.dismiss();
            a(new CustomMessage(2017004, new com.baidu.tbadk.core.frameworkData.a(this.F)));
            this.R = false;
            a(true);
        } else if (view == this.x) {
            this.o.dismiss();
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData != null && antiData.getIfpost() == 0) {
                com.baidu.adp.lib.util.k.a((Context) this.F, antiData.getForbid_info());
                return;
            }
            antiData.setIfVoice(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(this.F, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null)));
        } else if (view == this.y) {
            this.o.dismiss();
            a(new CustomMessage(2017006, new com.baidu.tbadk.core.frameworkData.a(this.F)));
        } else if (view == this.z) {
            this.o.dismiss();
            m().show();
        }
    }

    private AlertDialog m() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.baidu.tieba.y.del_post_tip);
        builder.setMessage(com.baidu.tieba.y.exit_tip);
        builder.setPositiveButton(com.baidu.tieba.y.alert_yes_button, new q(this));
        builder.setNegativeButton(com.baidu.tieba.y.alert_no_button, new r(this));
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2 = true;
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.s = getResources().getDrawable(com.baidu.tieba.u.icon_news_down_bar_one_1);
            this.u.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
            this.w.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
            this.E.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
        } else {
            this.s = getResources().getDrawable(com.baidu.tieba.u.icon_news_down_bar_one);
            this.u.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
            this.w.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
            this.E.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
        }
        if (com.baidu.tbadk.tbplugin.m.a() == null || !com.baidu.tbadk.tbplugin.m.a().n()) {
            z2 = false;
        }
        if (z2 || this.R || this.P > 0 || this.Q > 0) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(4);
        }
        if (z) {
            this.E.setVisibility(4);
        }
        if (this.P > 0) {
            this.r.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.a((Context) this.F, 4.0f));
            this.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.s, (Drawable) null);
        } else {
            this.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.Q > 0) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(4);
        }
        if (this.R || z2) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.START));
    }

    public static void d(int i) {
        h = i;
    }

    public boolean h() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BdLog.i(getClass().getName(), "onDestroy", "");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007012, null));
        o();
        com.baidu.tbadk.coreExtra.messageCenter.a.a().i();
        MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.STOP));
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
            BdLog.e(getClass(), "onRestoreInstanceState", th);
        }
    }

    private void a(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkApplication.setIntent(null);
    }

    private void n() {
        MessageManager.getInstance().registerListener(this.S);
        MessageManager.getInstance().registerListener(this.T);
        MessageManager.getInstance().registerListener(this.e);
        this.f.setPriority(100);
        MessageManager.getInstance().registerListener(this.f);
        MessageManager.getInstance().registerListener(this.O);
        MessageManager.getInstance().registerListener(this.M);
        MessageManager.getInstance().registerListener(this.N);
        this.H = new aa(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.H, intentFilter);
    }

    private void o() {
        MessageManager.getInstance().unRegisterListener(this.S);
        MessageManager.getInstance().unRegisterListener(this.T);
        MessageManager.getInstance().unRegisterListener(this.e);
        MessageManager.getInstance().unRegisterListener(this.f);
        MessageManager.getInstance().unRegisterListener(this.O);
        MessageManager.getInstance().unRegisterListener(this.M);
        MessageManager.getInstance().unRegisterListener(this.N);
        if (this.H != null) {
            unregisterReceiver(this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BdLog.d("MainTabActivity", "onResume", "onResume");
        TbadkApplication.m252getInst().sendLaunchTime();
        TbadkApplication.m252getInst().AddResumeNum();
        h = this.m.getCurrentTabType();
        a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        aj.a = false;
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
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        BdLog.i(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("close_dialog", false)) {
            p();
        }
        if (intent.getBooleanExtra("refresh_all", false)) {
            e();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new ap(this, ap.b)));
            finish();
        } else if (intExtra == 12) {
            TbadkApplication.m252getInst().notifyAppEnterBackground();
            com.baidu.tbadk.core.log.a.b();
            TbadkApplication.m252getInst().clearHasShowAppForums();
            finish();
        } else if (intExtra == 1) {
            this.m.setCurrentTabByType(intExtra);
        }
        a((Context) this, TbadkApplication.getIntent());
    }

    private void p() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            BdLog.d(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            if (System.currentTimeMillis() - this.i > 2000) {
                c(com.baidu.tieba.y.double_back_quit);
                this.i = System.currentTimeMillis();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.STOP));
                q();
                moveTaskToBack(true);
                TbadkApplication.m252getInst().notifyAppEnterBackground();
                com.baidu.tbadk.core.log.a.b();
            }
            return false;
        }
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            l();
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

    protected void i() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.k.a((Context) this, antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bh(this, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null)));
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
            i();
        } else if (this.m.getCurrentFragment() != null) {
            this.m.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.m.a(i);
        if (i == 1) {
            this.m.setBackgroundColor(-5525837);
            if (this.J != 0) {
                this.B.setBackgroundResource(this.J);
            }
        } else {
            this.m.setBackgroundColor(-5525837);
            if (this.I != 0) {
                this.B.setBackgroundResource(this.I);
            }
        }
        this.n.c(i);
        this.o.a(this.F, i, getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n_1));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.s = getResources().getDrawable(com.baidu.tieba.u.icon_news_down_bar_one_1);
            this.u.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
            this.w.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
            this.E.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one_1);
        } else {
            this.s = getResources().getDrawable(com.baidu.tieba.u.icon_news_down_bar_one);
            this.u.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
            this.w.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
            this.E.setImageResource(com.baidu.tieba.u.icon_news_down_bar_one);
        }
        a(false);
    }

    private void q() {
        if (System.currentTimeMillis() - this.j >= 7200000) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2008003, com.baidu.tbadk.core.frameworkData.a.START));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, null));
            this.j = System.currentTimeMillis();
        }
    }
}
