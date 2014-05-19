package com.baidu.tieba.person;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.tbadk.TbadkApplication;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class aj extends LinearLayout {
    private final com.baidu.tbadk.core.e a;
    private final bm b;
    private View c;
    private BdExpandListView d;
    private x e;
    private Handler f;
    private com.baidu.tbadk.editortool.ab g;
    private af h;
    private an i;
    private boolean j;
    private final Runnable k;

    public aj(com.baidu.tbadk.core.e eVar, bm bmVar) {
        super(eVar);
        this.j = false;
        this.k = new ak(this);
        this.a = eVar;
        this.b = bmVar;
        k();
    }

    private void k() {
        this.c = this.b.getView();
        this.d = (BdExpandListView) this.c.findViewById(com.baidu.tieba.r.user_info_center_lv);
        a();
    }

    private void l() {
        this.h = this.b.g();
        this.e = new x(this.a);
        if (this.h != null) {
            this.d.addHeaderView(this.h);
            this.d.setExpandView(this.h);
        }
        this.d.setAdapter((ListAdapter) this.e);
        this.i = new an(this, this.a);
        this.d.setNextPage(this.i);
        this.g = new com.baidu.tbadk.editortool.ab(this.a);
    }

    public void setListItemTagClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.d.setOnItemClickListener(onItemClickListener);
    }

    public void a() {
        this.j = false;
        if (this.e == null) {
            l();
            m();
        }
        this.d.removeFooterView(this.i.b());
        if (1 == TbadkApplication.m252getInst().getSkinType()) {
            this.d.setBackgroundResource(com.baidu.tieba.o.person_center_list_no_data_bg_color_1);
        } else {
            this.d.setBackgroundResource(com.baidu.tieba.o.person_center_list_no_data_bg_color);
        }
        this.d.setRecyclerListener(new al(this));
        this.e.a((PersonPostListData) null, (com.baidu.tieba.model.av) null);
        this.e.notifyDataSetChanged();
    }

    public void setScrollToBottomListener(com.baidu.adp.widget.ListView.u uVar) {
        this.d.setOnSrollToBottomListener(uVar);
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

    public void a(com.baidu.tieba.model.av avVar) {
        if (avVar != null) {
            if (this.e == null) {
                l();
                m();
            }
            if (avVar.a() != null && avVar.a().post_list != null && avVar.a().post_list.size() > 0) {
                this.d.setNextPage(this.i);
                this.d.setBackgroundResource(com.baidu.tieba.o.transparent);
            } else {
                this.d.removeFooterView(this.i.b());
                if (1 == TbadkApplication.m252getInst().getSkinType()) {
                    this.d.setBackgroundResource(com.baidu.tieba.o.person_center_list_no_data_bg_color_1);
                } else {
                    this.d.setBackgroundResource(com.baidu.tieba.o.person_center_list_no_data_bg_color);
                }
            }
            this.h.a(avVar);
            this.j = true;
            this.e.a(avVar.a(), avVar);
            this.e.notifyDataSetChanged();
            if (this.i != null) {
                this.i.c();
            }
            e();
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

    public void e() {
        if (this.f != null) {
            this.f.removeCallbacks(this.k);
            this.f.postDelayed(this.k, 0L);
        }
    }

    public void f() {
        if (com.baidu.tbadk.core.h.a().f()) {
            com.baidu.tbadk.core.util.ae.a(this.d, this.e.a(), 0, -1);
        }
    }

    private void m() {
        this.f = new Handler();
        this.d.setOnScrollListener(new am(this));
    }

    public void g() {
        if (this.f != null) {
            this.f.postDelayed(this.k, 90L);
        }
    }

    public void h() {
        this.i.d();
    }

    public void i() {
        this.i.f();
    }

    public void a(int i) {
        this.a.a().a(i == 1);
        this.a.a().a(this.c);
        this.i.a(i);
    }

    public void j() {
        this.e.notifyDataSetChanged();
    }
}
