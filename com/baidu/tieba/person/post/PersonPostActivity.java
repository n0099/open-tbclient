package com.baidu.tieba.person.post;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] r;
    private static final int[] s;
    private static final int[] t;
    private int[] g;
    private String h;
    private String i;
    private String j;
    private int k;
    private NavigationBar m;
    private ImageView o;
    private FragmentTabHost p;
    private f q;
    private int f = -1;
    int d = 0;
    private boolean l = false;
    private View n = null;
    HttpMessageListener e = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);

    static {
        TbadkApplication.m252getInst().RegisterIntent(bi.class, PersonPostActivity.class);
        r = new int[]{com.baidu.tieba.t.icon_pop_key_all, com.baidu.tieba.t.icon_pop_key_f, com.baidu.tieba.t.icon_pop_key_d};
        s = new int[]{com.baidu.tieba.x.info_privacy_all, com.baidu.tieba.x.info_privacy_friend, com.baidu.tieba.x.info_privacy_hide};
        t = new int[]{1, 2, 3};
    }

    public static void a(Context context, String str, int i, String str2) {
        Intent intent = new Intent(context, PersonPostActivity.class);
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
        intent.putExtra("key_portrait_url", str2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.person_post_activity);
        this.j = getIntent().getStringExtra("key_portrait_url");
        this.h = getIntent().getStringExtra("key_uid");
        this.k = getIntent().getIntExtra("key_sex", 0);
        this.h = this.h == null ? "" : this.h;
        if (this.h.equals(TbadkApplication.getCurrentAccount())) {
            this.i = getString(com.baidu.tieba.x.me);
            this.l = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.i = getString(com.baidu.tieba.x.he);
                    break;
                case 2:
                    this.i = getString(com.baidu.tieba.x.she);
                    break;
                default:
                    this.i = getString(com.baidu.tieba.x.ta);
                    break;
            }
        }
        if (this.h == null) {
            finish();
            return;
        }
        a(bundle);
        a(this.e);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.q != null) {
            int count = this.q.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.q.getItem(i3);
                if (item instanceof t) {
                    ((t) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void a(Bundle bundle) {
        this.m = (NavigationBar) findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.m.a(String.format(getString(com.baidu.tieba.x.person_post), this.i));
        this.n = (View) this.m.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.n.setOnClickListener(new d(this));
        if (this.l) {
            this.o = (ImageView) this.m.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_privacy, (View.OnClickListener) null);
            ay.c(this.o, r[com.baidu.tbadk.core.account.o.a(4) - 1]);
            this.o.setOnClickListener(new e(this));
        }
        this.g = new int[]{0, 1};
        this.q = new f(this);
        this.p = (FragmentTabHost) findViewById(com.baidu.tieba.u.tab_host);
        this.p.setup(getSupportFragmentManager());
        this.p.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.r.maintab_bg));
        this.p.setOnPageChangeListener(this);
        n();
        if (bundle != null) {
            this.f = bundle.getInt("CurrTabIndex");
        } else {
            this.f = 0;
        }
        this.p.setCurrentTab(this.f);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
            bVar.c = fragment;
            bVar.a = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.b = com.baidu.tieba.r.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.r.main_bottom_button_color;
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.s.fontsize32));
            bVar.b = fragmentTabIndicator;
            this.p.a(bVar);
        }
    }

    private void n() {
        if (this.q != null) {
            int count = this.q.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.q.getItem(i);
                int a = this.q.a(i);
                if (item != null) {
                    if (a == 0) {
                        a(item, 0, String.format(getString(com.baidu.tieba.x.person_post_thread), this.i));
                    } else if (a == 1) {
                        a(item, 1, String.format(getString(com.baidu.tieba.x.person_post_reply), this.i));
                    }
                }
            }
            this.p.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b(TbadkApplication.m252getInst().getSkinType());
    }

    public String g() {
        return this.h;
    }

    public String h() {
        return this.i;
    }

    public String i() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.f);
        super.onSaveInstanceState(bundle);
    }

    public String j() {
        if (this.l) {
            return getString(com.baidu.tieba.x.person_post_lv_empty_host);
        }
        return String.format(getString(com.baidu.tieba.x.person_post_lv_empty_guest), h());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.f) {
            this.f = i;
            if (this.g[i] == 0) {
                TiebaStatic.eventStat(this, this.l ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.g[i] == 1) {
                TiebaStatic.eventStat(this, this.l ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.m.c(i);
        this.p.b(i);
        ay.f(this.p, com.baidu.tieba.r.cp_bg_line_c);
        if (this.q != null) {
            int count = this.q.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.q.getItem(i2);
                if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                    ((com.baidu.tbadk.core.d) item).b(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView p_() {
        if (this.q != null) {
            t a = this.q.a();
            z f = a != null ? a.f() : null;
            if (f != null) {
                return f.a();
            }
            return null;
        }
        return null;
    }
}
