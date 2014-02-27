package com.baidu.tieba.person;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class bj extends LinearLayout {
    private Context a;
    private cm b;
    private View c;
    private BdCenterListView d;
    private ay e;
    private Handler f;
    private com.baidu.tieba.util.i g;
    private bg h;
    private bn i;
    private boolean j;
    private Runnable k;

    public bj(Context context, cm cmVar) {
        super(context);
        this.j = false;
        this.k = new bk(this);
        this.a = context;
        this.b = cmVar;
        this.c = this.b.getView();
        this.d = (BdCenterListView) this.c.findViewById(R.id.user_info_center_lv);
        this.j = false;
        if (this.e == null) {
            h();
            i();
        }
        this.d.removeFooterView(this.i.b());
        if (1 == TiebaApplication.g().ae()) {
            this.d.setBackgroundResource(R.color.person_center_list_no_data_bg_color_1);
        } else {
            this.d.setBackgroundResource(R.color.person_center_list_no_data_bg_color);
        }
        this.d.setRecyclerListener(new bl(this));
        this.e.a(null, null);
        this.e.notifyDataSetChanged();
    }

    private void h() {
        this.h = this.b.c();
        this.e = new ay(this.a);
        if (this.h != null) {
            this.d.addHeaderView(this.h);
            this.d.setHeaderView(this.h);
        }
        this.d.setAdapter((ListAdapter) this.e);
        this.i = new bn(this, (com.baidu.tieba.k) this.a);
        this.d.setNextPage(this.i);
        this.g = new com.baidu.tieba.util.i(this.a);
    }

    public final void setListItemTagClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.d.setOnItemClickListener(onItemClickListener);
    }

    public final void setScrollToBottomListener(com.baidu.adp.widget.ListView.r rVar) {
        this.d.setOnSrollToBottomListener(rVar);
    }

    public final void setLoadMoreOnClickListener(View.OnClickListener onClickListener) {
        this.i.a(onClickListener);
    }

    public final void setCoverListRefreshListener(e eVar) {
        this.d.setCoverListRefreshListener(eVar);
    }

    public final void a(com.baidu.tieba.model.bp bpVar) {
        if (bpVar != null) {
            if (this.e == null) {
                h();
                i();
            }
            if (bpVar.a() != null && bpVar.a().post_list != null && bpVar.a().post_list.size() > 0) {
                this.d.setNextPage(this.i);
                this.d.setBackgroundResource(R.color.transparent);
            } else {
                this.d.removeFooterView(this.i.b());
                if (1 == TiebaApplication.g().ae()) {
                    this.d.setBackgroundResource(R.color.person_center_list_no_data_bg_color_1);
                } else {
                    this.d.setBackgroundResource(R.color.person_center_list_no_data_bg_color);
                }
            }
            this.h.a(bpVar);
            this.j = true;
            this.e.a(bpVar.a(), bpVar);
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
            this.d.d();
        }
    }

    public final void c() {
        if (this.d != null) {
            this.d.c();
        }
    }

    public final void d() {
        if (com.baidu.tieba.h.a.a().f()) {
            com.baidu.tieba.util.ap.a(this.d, this.e.a(), 0, -1);
        }
    }

    private void i() {
        this.f = new Handler();
        this.d.setOnScrollListener(new bm(this));
    }

    public final void e() {
        this.i.e();
    }

    public final void f() {
        this.i.g();
    }

    public final void a(int i) {
        ((com.baidu.tieba.k) this.a).a().a(i == 1);
        ((com.baidu.tieba.k) this.a).a().a(this.c);
        this.i.c();
    }

    public final void g() {
        this.e.notifyDataSetChanged();
    }
}
