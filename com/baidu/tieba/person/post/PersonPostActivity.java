package com.baidu.tieba.person.post;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class PersonPostActivity extends com.baidu.tbadk.core.e implements ViewPager.OnPageChangeListener {
    private int[] d;
    private String e;
    private String f;
    private String g;
    private int h;
    private NavigationBar j;
    private FragmentTabHost l;
    private e m;
    private int c = -1;
    private boolean i = false;
    private View k = null;

    public static void a(Context context, String str, int i, String str2) {
        Intent intent = new Intent(context, PersonPostActivity.class);
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
        intent.putExtra("key_portrait_url", str2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.base.b, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.s.person_post_activity);
        this.g = getIntent().getStringExtra("key_portrait_url");
        this.e = getIntent().getStringExtra("key_uid");
        this.h = getIntent().getIntExtra("key_sex", 0);
        this.e = this.e == null ? "" : this.e;
        if (this.e.equals(TbadkApplication.getCurrentAccount())) {
            this.f = getString(com.baidu.tieba.u.me);
            this.i = true;
        } else {
            switch (getIntent().getIntExtra("key_sex", 0)) {
                case 1:
                    this.f = getString(com.baidu.tieba.u.he);
                    break;
                case 2:
                    this.f = getString(com.baidu.tieba.u.she);
                    break;
                default:
                    this.f = getString(com.baidu.tieba.u.ta);
                    break;
            }
        }
        if (this.e == null) {
            finish();
        } else {
            a(bundle);
        }
    }

    private void a(Bundle bundle) {
        this.j = (NavigationBar) findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.j.a(String.format(getString(com.baidu.tieba.u.person_post), this.f));
        this.k = (View) this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.k.setOnClickListener(new d(this));
        this.d = new int[]{0, 1};
        this.m = new e(this);
        this.l = (FragmentTabHost) findViewById(com.baidu.tieba.r.tab_host);
        this.l.setup(getSupportFragmentManager());
        this.l.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.o.maintab_bg));
        this.l.setOnPageChangeListener(this);
        i();
        if (bundle != null) {
            this.c = bundle.getInt("CurrTabIndex");
        } else {
            this.c = 0;
        }
        this.l.setCurrentTab(this.c);
    }

    private void a(Fragment fragment, int i, String str) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
            bVar.c = fragment;
            bVar.a = i;
            fragmentTabIndicator.setText(str);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.b = com.baidu.tieba.o.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.o.main_bottom_button_color;
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.p.fontsize32));
            bVar.b = fragmentTabIndicator;
            this.l.a(bVar);
        }
    }

    private void i() {
        if (this.m != null) {
            int count = this.m.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.m.getItem(i);
                int a = this.m.a(i);
                if (item != null) {
                    if (a == 0) {
                        a(item, 0, String.format(getString(com.baidu.tieba.u.person_post_thread), this.f));
                    } else if (a == 1) {
                        a(item, 1, String.format(getString(com.baidu.tieba.u.person_post_reply), this.f));
                    }
                }
            }
            this.l.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b(TbadkApplication.m252getInst().getSkinType());
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("CurrTabIndex", this.c);
        super.onSaveInstanceState(bundle);
    }

    public String h() {
        if (this.i) {
            return getString(com.baidu.tieba.u.person_post_lv_empty_host);
        }
        return String.format(getString(com.baidu.tieba.u.person_post_lv_empty_guest), f());
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < 2 && i != this.c) {
            this.c = i;
            if (this.d[i] == 0) {
                TiebaStatic.eventStat(this, this.i ? "pp_my_thread" : "pp_his_thread", "click", 1, new Object[0]);
            } else if (this.d[i] == 1) {
                TiebaStatic.eventStat(this, this.i ? "pp_my_reply" : "pp_his_reply", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tbadk.core.e
    protected void b(int i) {
        this.j.c(i);
        this.l.a(i);
        bc.f(this.l, com.baidu.tieba.o.cp_bg_line_c);
        if (this.m != null) {
            int count = this.m.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.m.getItem(i2);
                if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                    ((com.baidu.tbadk.core.d) item).b(i);
                }
            }
        }
    }
}
