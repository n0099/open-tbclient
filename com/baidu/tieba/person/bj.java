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
public class bj extends LinearLayout {
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
        j();
    }

    private void j() {
        this.c = this.b.getView();
        this.d = (BdCenterListView) this.c.findViewById(R.id.user_info_center_lv);
        a();
    }

    private void k() {
        this.h = this.b.d();
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

    public void setListItemTagClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.d.setOnItemClickListener(onItemClickListener);
    }

    public void a() {
        this.j = false;
        if (this.e == null) {
            k();
            l();
        }
        this.d.removeFooterView(this.i.b());
        if (1 == TiebaApplication.g().al()) {
            this.d.setBackgroundResource(R.color.person_center_list_no_data_bg_color_1);
        } else {
            this.d.setBackgroundResource(R.color.person_center_list_no_data_bg_color);
        }
        this.d.setRecyclerListener(new bl(this));
        this.e.a((PersonPostListData) null, (com.baidu.tieba.model.bp) null);
        this.e.notifyDataSetChanged();
    }

    public void setScrollToBottomListener(com.baidu.adp.widget.ListView.r rVar) {
        this.d.setOnSrollToBottomListener(rVar);
    }

    public void setLoadMoreOnClickListener(View.OnClickListener onClickListener) {
        this.i.a(onClickListener);
    }

    public void setCoverListRefreshListener(e eVar) {
        this.d.setCoverListRefreshListener(eVar);
    }

    public void a(com.baidu.tieba.model.bp bpVar) {
        if (bpVar != null) {
            if (this.e == null) {
                k();
                l();
            }
            if (bpVar.a() != null && bpVar.a().post_list != null && bpVar.a().post_list.size() > 0) {
                this.d.setNextPage(this.i);
                this.d.setBackgroundResource(R.color.transparent);
            } else {
                this.d.removeFooterView(this.i.b());
                if (1 == TiebaApplication.g().al()) {
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

    public void b() {
        if (this.i != null) {
            this.i.e();
        }
    }

    public void c() {
        if (this.d != null) {
            this.d.e();
        }
    }

    public void d() {
        if (this.d != null) {
            this.d.d();
        }
    }

    public void e() {
        if (this.f != null) {
            this.f.removeCallbacks(this.k);
            this.f.postDelayed(this.k, 0L);
        }
    }

    public void f() {
        if (com.baidu.tieba.h.a.a().f()) {
            com.baidu.tieba.util.ap.a(this.d, this.e.a(), 0, -1);
        }
    }

    private void l() {
        this.f = new Handler();
        this.d.setOnScrollListener(new bm(this));
    }

    public void g() {
        this.i.d();
    }

    public void h() {
        this.i.f();
    }

    public void a(int i) {
        ((com.baidu.tieba.k) this.a).a().a(i == 1);
        ((com.baidu.tieba.k) this.a).a().a(this.c);
        this.i.a(i);
    }

    public void i() {
        this.e.notifyDataSetChanged();
    }
}
