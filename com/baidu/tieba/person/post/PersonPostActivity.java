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
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class PersonPostActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] q = {com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
    private static final int[] r = {com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
    private static final int[] s = {1, 2, 3};
    private int[] f;
    private String g;
    private String h;
    private String i;
    private int j;
    private NavigationBar l;
    private ImageView n;
    private FragmentTabHost o;
    private f p;
    private int e = -1;
    int c = 0;
    private boolean k = false;
    private View m = null;
    HttpMessageListener d = new c(this, 1001506);

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
        setContentView(com.baidu.tieba.w.person_post_activity);
        this.i = getIntent().getStringExtra("key_portrait_url");
        this.g = getIntent().getStringExtra("key_uid");
        this.j = getIntent().getIntExtra("key_sex", 0);
        this.g = this.g == null ? "" : this.g;
        if (this.g.equals(TbadkApplication.getCurrentAccount())) {
            this.h = getString(com.baidu.tieba.y.me);
            this.k = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.h = getString(com.baidu.tieba.y.he);
                    break;
                case 2:
                    this.h = getString(com.baidu.tieba.y.she);
                    break;
                default:
                    this.h = getString(com.baidu.tieba.y.ta);
                    break;
            }
        }
        if (this.g == null) {
            finish();
            return;
        }
        a(bundle);
        a(this.d);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.p != null) {
            int count = this.p.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.p.getItem(i3);
                if (item instanceof t) {
                    ((t) item).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    private void a(Bundle bundle) {
        this.l = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.l.a(String.format(getString(com.baidu.tieba.y.person_post), this.h));
        this.m = (View) this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.m.setOnClickListener(new d(this));
        if (this.k) {
            this.n = (ImageView) this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            bk.c(this.n, q[com.baidu.tbadk.core.account.o.a(4) - 1]);
            this.n.setOnClickListener(new e(this));
        }
        this.f = new int[]{0, 1};
        this.p = new f(this);
        this.o = (FragmentTabHost) findViewById(com.baidu.tieba.v.tab_host);
        this.o.setup(getSupportFragmentManager());
        this.o.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.o.setOnPageChangeListener(this);
        n();
        if (bundle != null) {
            this.e = bundle.getInt("CurrTabIndex");
        } else {
            this.e = 0;
        }
        this.o.setCurrentTab(this.e);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
            bVar.c = fragment;
            bVar.a = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.b = com.baidu.tieba.s.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.b = fragmentTabIndicator;
            this.o.a(bVar);
        }
    }

    private void n() {
        if (this.p != null) {
            int count = this.p.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.p.getItem(i);
                int a = this.p.a(i);
                if (item != null) {
                    if (a == 0) {
                        a(item, 0, String.format(getString(com.baidu.tieba.y.person_post_thread), this.h));
                    } else if (a == 1) {
                        a(item, 1, String.format(getString(com.baidu.tieba.y.person_post_reply), this.h));
                    }
                }
            }
            this.o.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b(TbadkApplication.m252getInst().getSkinType());
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.e);
        super.onSaveInstanceState(bundle);
    }

    public String j() {
        if (this.k) {
            return getString(com.baidu.tieba.y.person_post_lv_empty_host);
        }
        return String.format(getString(com.baidu.tieba.y.person_post_lv_empty_guest), h());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.e) {
            this.e = i;
            if (this.f[i] == 0) {
                TiebaStatic.eventStat(this, this.k ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.f[i] == 1) {
                TiebaStatic.eventStat(this, this.k ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.l.c(i);
        this.o.b(i);
        bk.f(this.o, com.baidu.tieba.s.cp_bg_line_c);
        if (this.p != null) {
            int count = this.p.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.p.getItem(i2);
                if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                    ((com.baidu.tbadk.core.d) item).b(i);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView h_() {
        if (this.p != null) {
            t a = this.p.a();
            z f = a != null ? a.f() : null;
            if (f != null) {
                return f.a();
            }
            return null;
        }
        return null;
    }
}
