package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] k = {com.baidu.tieba.u.icon_pop_key_all, com.baidu.tieba.u.icon_pop_key_f, com.baidu.tieba.u.icon_pop_key_d};
    private static final int[] l = {com.baidu.tieba.y.info_privacy_all, com.baidu.tieba.y.info_privacy_friend, com.baidu.tieba.y.info_privacy_hide};
    private static final int[] m = {1, 2, 3};
    private int[] e;
    private String g;
    private String h;
    private int i;
    private NavigationBar n;
    private ImageView p;
    private int q;
    private FragmentTabHost r;
    private d s;
    private int d = -1;
    private int f = 0;
    private boolean j = false;
    private View o = null;
    HttpMessageListener c = new a(this, 1001506);

    public abstract d a(BasePersonInfoActivity basePersonInfoActivity, boolean z);

    public abstract String g();

    public abstract String i();

    public abstract String j();

    public abstract String k();

    public abstract String l();

    public abstract String r();

    public abstract int s();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.activity_base_person_info);
        if (bundle != null) {
            this.g = bundle.getString("key_uid");
            this.i = bundle.getInt("key_sex", 0);
            this.d = bundle.getInt("key_current_tab", 0);
            this.q = bundle.getInt("tb_request_code", 0);
        } else if (getIntent() != null) {
            this.g = getIntent().getStringExtra("key_uid");
            this.i = getIntent().getIntExtra("key_sex", 0);
            this.d = getIntent().getIntExtra("key_current_tab", 0);
            this.q = getIntent().getIntExtra("tb_request_code", 0);
        } else {
            finish();
        }
        this.g = this.g == null ? "" : this.g;
        if (this.g.equals(TbadkApplication.getCurrentAccount())) {
            this.h = getString(com.baidu.tieba.y.me);
            this.j = true;
        } else {
            this.j = false;
            switch (this.i) {
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
        if (com.baidu.adp.lib.util.i.b(this.g)) {
            finish();
            return;
        }
        a(bundle);
        a(this.c);
    }

    private void a(Bundle bundle) {
        this.n = (NavigationBar) findViewById(com.baidu.tieba.v.base_person_navigation_bar);
        this.n.a(String.format(g(), this.h));
        this.o = (View) this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.o.setOnClickListener(new b(this));
        if (this.j && this.q != 23003) {
            this.p = (ImageView) this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.bk.c(this.p, k[com.baidu.tbadk.core.account.o.a(s()) - 1]);
            this.p.setOnClickListener(new c(this));
        }
        this.e = new int[]{0, 1};
        this.s = a(this, this.j);
        this.r = (FragmentTabHost) findViewById(com.baidu.tieba.v.base_person_tab_host);
        this.r.setup(getSupportFragmentManager());
        this.r.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.r.setOnPageChangeListener(this);
        this.r.b();
        w();
        if (this.j) {
            this.r.getFragmentTabWidget().setVisibility(8);
        }
        this.r.setCurrentTab(this.d);
    }

    private void w() {
        if (this.s != null) {
            int i = this.j ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.s.getItem(i2);
                int a = this.s.a(i2);
                String i3 = i();
                if (a == 1) {
                    i3 = j();
                }
                if (item != null) {
                    a(item, a, i3);
                }
            }
            this.r.a();
        }
    }

    public NavigationBar h() {
        return this.n;
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
            this.r.a(bVar);
        }
    }

    public void b(int i, int i2) {
        if (!this.j && this.s != null) {
            FragmentTabIndicator fragmentTabIndicator = this.r.a(0).b;
            if (i <= 0) {
                fragmentTabIndicator.setText(i());
            } else {
                fragmentTabIndicator.setText(String.format(k(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.r.a(1).b;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(j());
            } else {
                fragmentTabIndicator2.setText(String.format(l(), Integer.valueOf(i2)));
            }
        }
    }

    public String m() {
        return this.g;
    }

    public int n() {
        return this.i;
    }

    public String o() {
        return this.h;
    }

    public boolean p() {
        return this.j;
    }

    public int q() {
        return this.d == 0 ? 0 : 1;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.d);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.d) {
            this.d = i;
            if (!this.j && this.e[i] == 1) {
                TiebaStatic.eventStat(this, r(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.n.c(i);
        this.r.b(i);
        if (this.s != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.s.getCount()) {
                    Fragment item = this.s.getItem(i3);
                    if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                        ((com.baidu.tbadk.core.d) item).c(i);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
