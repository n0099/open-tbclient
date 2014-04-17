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
public final class ak extends LinearLayout {
    private final com.baidu.tbadk.core.e a;
    private final bn b;
    private View c;
    private BdExpandListView d;
    private x e;
    private Handler f;
    private com.baidu.tbadk.editortool.ab g;
    private ag h;
    private ao i;
    private boolean j;
    private final Runnable k;

    public ak(com.baidu.tbadk.core.e eVar, bn bnVar) {
        super(eVar);
        this.j = false;
        this.k = new al(this);
        this.a = eVar;
        this.b = bnVar;
        this.c = this.b.getView();
        this.d = (BdExpandListView) this.c.findViewById(com.baidu.tieba.a.h.user_info_center_lv);
        this.j = false;
        if (this.e == null) {
            i();
            j();
        }
        this.d.removeFooterView(this.i.b());
        if (1 == TbadkApplication.j().l()) {
            this.d.setBackgroundResource(com.baidu.tieba.a.e.person_center_list_no_data_bg_color_1);
        } else {
            this.d.setBackgroundResource(com.baidu.tieba.a.e.person_center_list_no_data_bg_color);
        }
        this.d.setRecyclerListener(new am(this));
        this.e.a(null, null);
        this.e.notifyDataSetChanged();
    }

    private void i() {
        this.h = this.b.e();
        this.e = new x(this.a);
        if (this.h != null) {
            this.d.addHeaderView(this.h);
            this.d.setExpandView(this.h);
        }
        this.d.setAdapter((ListAdapter) this.e);
        this.i = new ao(this, this.a);
        this.d.setNextPage(this.i);
        this.g = new com.baidu.tbadk.editortool.ab(this.a);
    }

    public final void setListItemTagClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.d.setOnItemClickListener(onItemClickListener);
    }

    public final void setScrollToBottomListener(com.baidu.adp.widget.ListView.t tVar) {
        this.d.setOnSrollToBottomListener(tVar);
    }

    public final void setLoadMoreOnClickListener(View.OnClickListener onClickListener) {
        this.i.a(onClickListener);
    }

    public final void setExpandListRefreshListener(com.baidu.adp.widget.ListView.a aVar) {
        this.d.setExpandListRefreshListener(aVar);
    }

    public final void a() {
        if (this.g != null) {
            this.g.a();
            this.g.c();
        }
    }

    public final void a(com.baidu.tieba.model.av avVar) {
        if (avVar != null) {
            if (this.e == null) {
                i();
                j();
            }
            if (avVar.a() != null && avVar.a().post_list != null && avVar.a().post_list.size() > 0) {
                this.d.setNextPage(this.i);
                this.d.setBackgroundResource(com.baidu.tieba.a.e.transparent);
            } else {
                this.d.removeFooterView(this.i.b());
                if (1 == TbadkApplication.j().l()) {
                    this.d.setBackgroundResource(com.baidu.tieba.a.e.person_center_list_no_data_bg_color_1);
                } else {
                    this.d.setBackgroundResource(com.baidu.tieba.a.e.person_center_list_no_data_bg_color);
                }
            }
            this.h.a(avVar);
            this.j = true;
            this.e.a(avVar.a(), avVar);
            this.e.notifyDataSetChanged();
            if (this.i != null) {
                this.i.d();
            }
            if (this.f != null) {
                this.f.removeCallbacks(this.k);
                this.f.postDelayed(this.k, 0L);
            }
        }
    }

    public final int getAdapterCount() {
        if (this.e != null) {
            return this.e.getCount();
        }
        return 0;
    }

    public final void b() {
        if (this.i != null) {
            this.i.f();
        }
    }

    public final void c() {
        if (this.d != null) {
            this.d.a();
        }
    }

    public final void d() {
        if (com.baidu.tbadk.core.h.a().f()) {
            com.baidu.tbadk.core.util.ac.a(this.d, this.e.a(), 0, -1);
        }
    }

    private void j() {
        this.f = new Handler();
        this.d.setOnScrollListener(new an(this));
    }

    public final void e() {
        if (this.f != null) {
            this.f.postDelayed(this.k, 300L);
        }
    }

    public final void f() {
        this.i.e();
    }

    public final void g() {
        this.i.g();
    }

    public final void a(int i) {
        this.a.b().a(i == 1);
        this.a.b().a(this.c);
        this.i.c();
    }

    public final void h() {
        this.e.notifyDataSetChanged();
    }
}
