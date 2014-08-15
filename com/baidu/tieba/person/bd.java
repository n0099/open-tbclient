package com.baidu.tieba.person;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class bd extends LinearLayout {
    private final BaseFragmentActivity a;
    private final ct b;
    private View c;
    private BdExpandListView d;
    private af e;
    private an f;
    private bg g;
    private NavigationBar h;
    private View i;
    private ImageView j;
    private com.baidu.tieba.model.av k;
    private com.baidu.tbadk.core.view.m l;
    private dk m;
    private boolean n;
    private String o;
    private boolean p;

    public bd(BaseFragmentActivity baseFragmentActivity, ct ctVar) {
        super(baseFragmentActivity);
        this.l = null;
        this.m = null;
        this.n = false;
        this.a = baseFragmentActivity;
        this.b = ctVar;
        if (ctVar.f() != null) {
            this.o = ctVar.f().m();
            this.p = ctVar.f().j();
        } else {
            this.o = "";
            this.p = false;
        }
        h();
    }

    private void h() {
        this.c = this.b.getView();
        this.h = (NavigationBar) this.c.findViewById(com.baidu.tieba.u.view_navigation_bar);
        if (!this.p) {
            this.h.a(this.o);
        } else {
            this.h.a(com.baidu.tieba.x.person_info);
        }
        this.i = this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.b);
        this.j = (ImageView) this.h.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nb_item_floor_more, this.b);
        this.d = (BdExpandListView) this.c.findViewById(com.baidu.tieba.u.user_info_center_lv);
        a();
        this.m = new dk(this.a, this.b);
        this.l = new com.baidu.tbadk.core.view.m(this.a, this.m.a(), getNavigationBar(), this.a.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n), new be(this));
    }

    private void i() {
        this.f = this.b.h();
        this.e = new af(this.a);
        if (this.f != null) {
            this.d.addHeaderView(this.f);
            this.d.setExpandView(this.f);
        }
        this.d.setAdapter((ListAdapter) this.e);
        this.g = new bg(this, this.a);
        this.d.setNextPage(this.g);
    }

    public void setListItemTagClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.d.setOnItemClickListener(onItemClickListener);
    }

    public void a() {
        this.n = false;
        if (this.e == null) {
            i();
        }
        this.d.removeFooterView(this.g.b());
        com.baidu.tbadk.core.util.ay.f(this.d, com.baidu.tieba.r.cp_bg_line_c);
        this.d.setRecyclerListener(new bf(this));
        this.e.notifyDataSetChanged();
    }

    public void setScrollToBottomListener(com.baidu.adp.widget.ListView.x xVar) {
        this.d.setOnSrollToBottomListener(xVar);
    }

    public void setLoadMoreOnClickListener(View.OnClickListener onClickListener) {
        this.g.a(onClickListener);
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.a aVar) {
        this.d.setExpandListRefreshListener(aVar);
    }

    public void a(com.baidu.tieba.model.av avVar) {
        if (avVar != null) {
            this.k = avVar;
            a(this.k.j());
            if (this.e == null) {
                i();
            }
            if (avVar.b() != null && avVar.b().post_list != null && avVar.b().post_list.size() > 0) {
                this.d.setNextPage(this.g);
                this.d.setBackgroundResource(com.baidu.tieba.r.transparent);
            } else {
                this.d.removeFooterView(this.g.b());
                if (1 == TbadkApplication.m252getInst().getSkinType()) {
                    this.d.setBackgroundResource(com.baidu.tieba.r.person_center_list_no_data_bg_color_1);
                } else {
                    this.d.setBackgroundResource(com.baidu.tieba.r.person_center_list_no_data_bg_color);
                }
            }
            this.f.a(avVar);
            this.n = true;
            this.e.a(avVar.b(), avVar);
            this.e.notifyDataSetChanged();
            if (this.g != null) {
                this.g.c();
            }
        }
    }

    public int getAdapterCount() {
        if (this.e != null) {
            return this.e.getCount();
        }
        return 0;
    }

    public void b() {
        if (this.g != null) {
            this.g.e();
        }
    }

    public void c() {
        if (this.d != null) {
            this.d.b();
        }
    }

    public void d() {
        this.g.d();
    }

    public void e() {
        this.g.f();
    }

    public void a(int i) {
        this.a.c().a(i == 1);
        this.a.c().a(this.c);
        this.g.a(i);
        this.h.c(i);
        if (this.k != null) {
            a(this.k.j());
        }
        this.l.a(this.a, i, this.a.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n), this.a.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n_1));
        a(this.p);
    }

    public void f() {
        this.e.notifyDataSetChanged();
    }

    public void a(boolean z) {
        this.j.setVisibility(0);
        if (z) {
            com.baidu.tbadk.core.util.ay.c(this.j, com.baidu.tieba.t.icon_pop_edit);
        } else {
            com.baidu.tbadk.core.util.ay.c(this.j, com.baidu.tieba.t.icon_more_n);
        }
    }

    public View getBackBtn() {
        return this.i;
    }

    public View getEditBtn() {
        return this.j;
    }

    public NavigationBar getNavigationBar() {
        return this.h;
    }

    public void a(boolean z, boolean z2) {
        if (!this.a.f() && this.l != null) {
            this.m.a(z, z2);
            this.l.c();
            this.l.b();
        }
    }

    public void g() {
        com.baidu.adp.lib.e.d.a(this.l, this.a);
    }

    public View getBlackBtn() {
        return this.m.c();
    }

    public View getFriendBtn() {
        return this.m.b();
    }
}
