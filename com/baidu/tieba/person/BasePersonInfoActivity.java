package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public abstract class BasePersonInfoActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private static final int[] l = {com.baidu.tieba.t.icon_pop_key_all, com.baidu.tieba.t.icon_pop_key_f, com.baidu.tieba.t.icon_pop_key_d};
    private static final int[] m = {com.baidu.tieba.x.info_privacy_all, com.baidu.tieba.x.info_privacy_friend, com.baidu.tieba.x.info_privacy_hide};
    private static final int[] n = {1, 2, 3};
    private int[] f;
    private String h;
    private String i;
    private int j;
    private NavigationBar o;
    private ImageView q;
    private int r;
    private FragmentTabHost s;
    private d t;
    private int e = -1;
    private int g = 0;
    private boolean k = false;
    private View p = null;
    HttpMessageListener d = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);

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
        setContentView(com.baidu.tieba.v.activity_base_person_info);
        if (bundle != null) {
            this.h = bundle.getString("key_uid");
            this.j = bundle.getInt("key_sex", 0);
            this.e = bundle.getInt("key_current_tab", 0);
            this.r = bundle.getInt("tb_request_code", 0);
        } else if (getIntent() != null) {
            this.h = getIntent().getStringExtra("key_uid");
            this.j = getIntent().getIntExtra("key_sex", 0);
            this.e = getIntent().getIntExtra("key_current_tab", 0);
            this.r = getIntent().getIntExtra("tb_request_code", 0);
        } else {
            finish();
        }
        this.h = this.h == null ? "" : this.h;
        if (this.h.equals(TbadkApplication.getCurrentAccount())) {
            this.i = getString(com.baidu.tieba.x.me);
            this.k = true;
        } else {
            this.k = false;
            switch (this.j) {
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
        if (com.baidu.adp.lib.util.i.c(this.h)) {
            finish();
            return;
        }
        a(bundle);
        a(this.d);
    }

    private void a(Bundle bundle) {
        this.o = (NavigationBar) findViewById(com.baidu.tieba.u.base_person_navigation_bar);
        this.o.a(String.format(g(), this.i));
        this.p = (View) this.o.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.p.setOnClickListener(new b(this));
        if (this.k && this.r != 23003) {
            this.q = (ImageView) this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_privacy, (View.OnClickListener) null);
            com.baidu.tbadk.core.util.ay.c(this.q, l[com.baidu.tbadk.core.account.o.a(s()) - 1]);
            this.q.setOnClickListener(new c(this));
        }
        this.f = new int[]{0, 1};
        this.t = a(this, this.k);
        this.s = (FragmentTabHost) findViewById(com.baidu.tieba.u.base_person_tab_host);
        this.s.setup(getSupportFragmentManager());
        this.s.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.r.maintab_bg));
        this.s.setOnPageChangeListener(this);
        this.s.b();
        w();
        if (this.k) {
            this.s.getFragmentTabWidget().setVisibility(8);
        }
        this.s.setCurrentTab(this.e);
    }

    private void w() {
        if (this.t != null) {
            int i = this.k ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                Fragment item = this.t.getItem(i2);
                int a = this.t.a(i2);
                String i3 = i();
                if (a == 1) {
                    i3 = j();
                }
                if (item != null) {
                    a(item, a, i3);
                }
            }
            this.s.a();
        }
    }

    public NavigationBar h() {
        return this.o;
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
            this.s.a(bVar);
        }
    }

    public void b(int i, int i2) {
        if (!this.k && this.t != null) {
            FragmentTabIndicator fragmentTabIndicator = this.s.a(0).b;
            if (i <= 0) {
                fragmentTabIndicator.setText(i());
            } else {
                fragmentTabIndicator.setText(String.format(k(), Integer.valueOf(i)));
            }
            FragmentTabIndicator fragmentTabIndicator2 = this.s.a(1).b;
            if (i2 <= 0) {
                fragmentTabIndicator2.setText(j());
            } else {
                fragmentTabIndicator2.setText(String.format(l(), Integer.valueOf(i2)));
            }
        }
    }

    public String m() {
        return this.h;
    }

    public int n() {
        return this.j;
    }

    public String o() {
        return this.i;
    }

    public boolean p() {
        return this.k;
    }

    public int q() {
        return this.e == 0 ? 0 : 1;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.e);
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
        if (i >= 0 && i < 2 && i != this.e) {
            this.e = i;
            if (!this.k && this.f[i] == 1) {
                TiebaStatic.eventStat(this, r(), "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.o.c(i);
        this.s.b(i);
        if (this.t != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.t.getCount()) {
                    Fragment item = this.t.getItem(i3);
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
