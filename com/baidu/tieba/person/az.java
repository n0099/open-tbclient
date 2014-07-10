package com.baidu.tieba.person;

import android.annotation.SuppressLint;
import android.os.Handler;
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
public class az extends LinearLayout {
    private final BaseFragmentActivity a;
    private final cr b;
    private View c;
    private BdExpandListView d;
    private ag e;
    private Handler f;
    private com.baidu.tbadk.editortool.aa g;
    private ao h;
    private bd i;
    private NavigationBar j;
    private View k;
    private ImageView l;
    private com.baidu.tieba.model.au m;
    private com.baidu.tbadk.core.view.i n;
    private df o;
    private boolean p;

    public az(BaseFragmentActivity baseFragmentActivity, cr crVar) {
        super(baseFragmentActivity);
        this.n = null;
        this.o = null;
        this.p = false;
        this.a = baseFragmentActivity;
        this.b = crVar;
        i();
    }

    private void i() {
        this.c = this.b.getView();
        this.j = (NavigationBar) this.c.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.j.a(com.baidu.tieba.y.person_info);
        this.k = this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.b);
        this.l = (ImageView) this.j.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_floor_more, this.b);
        this.d = (BdExpandListView) this.c.findViewById(com.baidu.tieba.v.user_info_center_lv);
        a();
        this.o = new df(this.a, this.b);
        this.n = new com.baidu.tbadk.core.view.i(this.a, this.o.a(), getNavigationBar(), this.a.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new ba(this));
    }

    private void j() {
        this.h = this.b.g();
        this.e = new ag(this.a);
        if (this.h != null) {
            this.d.addHeaderView(this.h);
            this.d.setExpandView(this.h);
        }
        this.d.setAdapter((ListAdapter) this.e);
        this.i = new bd(this, this.a);
        this.d.setNextPage(this.i);
        this.g = new com.baidu.tbadk.editortool.aa(this.a);
    }

    public void setListItemTagClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.d.setOnItemClickListener(onItemClickListener);
    }

    public void a() {
        this.p = false;
        if (this.e == null) {
            j();
            k();
        }
        this.d.removeFooterView(this.i.b());
        com.baidu.tbadk.core.util.bk.f(this.d, com.baidu.tieba.s.cp_bg_line_c);
        this.d.setRecyclerListener(new bb(this));
        this.e.notifyDataSetChanged();
    }

    public void setScrollToBottomListener(com.baidu.adp.widget.ListView.x xVar) {
        this.d.setOnSrollToBottomListener(xVar);
    }

    public void setLoadMoreOnClickListener(View.OnClickListener onClickListener) {
        this.i.a(onClickListener);
    }

    public void setExpandListRefreshListener(com.baidu.adp.widget.ListView.a aVar) {
        this.d.setExpandListRefreshListener(aVar);
    }

    public void b() {
        if (this.g != null) {
            this.g.a();
            this.g.d();
        }
    }

    public void a(com.baidu.tieba.model.au auVar) {
        if (auVar != null) {
            this.m = auVar;
            a(this.m.i());
            if (this.e == null) {
                j();
                k();
            }
            if (auVar.b() != null && auVar.b().post_list != null && auVar.b().post_list.size() > 0) {
                this.d.setNextPage(this.i);
                this.d.setBackgroundResource(com.baidu.tieba.s.transparent);
            } else {
                this.d.removeFooterView(this.i.b());
                if (1 == TbadkApplication.m252getInst().getSkinType()) {
                    this.d.setBackgroundResource(com.baidu.tieba.s.person_center_list_no_data_bg_color_1);
                } else {
                    this.d.setBackgroundResource(com.baidu.tieba.s.person_center_list_no_data_bg_color);
                }
            }
            this.h.a(auVar);
            this.p = true;
            this.e.a(auVar.b(), auVar);
            this.e.notifyDataSetChanged();
            if (this.i != null) {
                this.i.c();
            }
        }
    }

    public int getAdapterCount() {
        if (this.e != null) {
            return this.e.getCount();
        }
        return 0;
    }

    public void c() {
        if (this.i != null) {
            this.i.e();
        }
    }

    public void d() {
        if (this.d != null) {
            this.d.b();
        }
    }

    private void k() {
        this.f = new Handler();
        this.d.setOnScrollListener(new bc(this));
    }

    public void e() {
        this.i.d();
    }

    public void f() {
        this.i.f();
    }

    public void a(int i) {
        this.a.c().a(i == 1);
        this.a.c().a(this.c);
        this.i.a(i);
        this.j.c(i);
        if (this.m != null) {
            a(this.m.i());
        }
        this.n.a(this.a, i, this.a.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), this.a.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n_1));
    }

    public void g() {
        this.e.notifyDataSetChanged();
    }

    public void a(boolean z) {
        this.l.setVisibility(0);
        if (z) {
            com.baidu.tbadk.core.util.bk.c(this.l, com.baidu.tieba.u.icon_pop_edit);
        } else {
            com.baidu.tbadk.core.util.bk.c(this.l, com.baidu.tieba.u.icon_more_n);
        }
    }

    public View getBackBtn() {
        return this.k;
    }

    public View getEditBtn() {
        return this.l;
    }

    public NavigationBar getNavigationBar() {
        return this.j;
    }

    public void a(boolean z, boolean z2) {
        if (!this.a.f() && this.n != null) {
            this.o.a(z, z2);
            this.n.c();
            this.n.b();
        }
    }

    public void h() {
        this.n.dismiss();
    }

    public View getBlackBtn() {
        return this.o.c();
    }

    public View getFriendBtn() {
        return this.o.b();
    }
}
