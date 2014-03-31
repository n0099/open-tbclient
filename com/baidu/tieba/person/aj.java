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
public final class aj extends LinearLayout {
    private final com.baidu.tbadk.core.e a;
    private final PersonInfoActivity b;
    private View c;
    private BdExpandListView d;
    private x e;
    private Handler f;
    private com.baidu.tbadk.editortool.aa g;
    private af h;
    private an i;
    private boolean j;
    private final Runnable k;

    public aj(com.baidu.tbadk.core.e eVar, PersonInfoActivity personInfoActivity) {
        super(eVar);
        this.j = false;
        this.k = new ak(this);
        this.a = eVar;
        this.b = personInfoActivity;
        this.c = this.b.getView();
        this.d = (BdExpandListView) this.c.findViewById(com.baidu.tieba.a.h.user_info_center_lv);
        this.j = false;
        if (this.e == null) {
            g();
            h();
        }
        this.d.removeFooterView(this.i.b());
        if (1 == TbadkApplication.j().l()) {
            this.d.setBackgroundResource(com.baidu.tieba.a.e.person_center_list_no_data_bg_color_1);
        } else {
            this.d.setBackgroundResource(com.baidu.tieba.a.e.person_center_list_no_data_bg_color);
        }
        this.d.setRecyclerListener(new al(this));
        this.e.a(null, null);
        this.e.notifyDataSetChanged();
    }

    private void g() {
        this.h = this.b.getHeadView();
        this.e = new x(this.a);
        if (this.h != null) {
            this.d.addHeaderView(this.h);
            this.d.setExpandView(this.h);
        }
        this.d.setAdapter((ListAdapter) this.e);
        this.i = new an(this, this.a);
        this.d.setNextPage(this.i);
        this.g = new com.baidu.tbadk.editortool.aa(this.a);
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

    public final void a(com.baidu.tieba.model.av avVar) {
        if (avVar != null) {
            if (this.e == null) {
                g();
                h();
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

    public final void a() {
        if (this.i != null) {
            this.i.f();
        }
    }

    public final void b() {
        if (this.d != null) {
            this.d.a();
        }
    }

    public final void c() {
        if (com.baidu.tbadk.core.h.a().f()) {
            com.baidu.tbadk.core.util.ac.a(this.d, this.e.a(), 0, -1);
        }
    }

    private void h() {
        this.f = new Handler();
        this.d.setOnScrollListener(new am(this));
    }

    public final void d() {
        this.i.e();
    }

    public final void e() {
        this.i.g();
    }

    public final void a(int i) {
        this.a.b().a(i == 1);
        this.a.b().a(this.c);
        this.i.c();
    }

    public final void f() {
        this.e.notifyDataSetChanged();
    }
}
