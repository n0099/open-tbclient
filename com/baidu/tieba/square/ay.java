package com.baidu.tieba.square;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
/* loaded from: classes.dex */
public final class ay extends com.baidu.adp.a.f {
    com.baidu.tbadk.core.view.q a;
    private com.baidu.tbadk.core.e c;
    private View d;
    private BdListView e;
    private LinearLayout f;
    private SearchBoxView g;
    private NoNetworkView h;
    private ax i;

    public ay(com.baidu.tbadk.core.e eVar, com.baidu.tbadk.core.d dVar, View.OnKeyListener onKeyListener) {
        super(eVar);
        this.c = null;
        this.e = null;
        this.f = null;
        this.a = null;
        this.i = null;
        this.c = eVar;
        this.d = dVar.getView();
        this.f = (LinearLayout) this.d.findViewById(com.baidu.tieba.a.h.container);
        this.g = (SearchBoxView) this.d.findViewById(com.baidu.tieba.a.h.view_searchbox);
        this.e = (BdListView) this.d.findViewById(com.baidu.tieba.a.h.square_list);
        this.e.setOnKeyListener(onKeyListener);
        this.e.setOnItemClickListener(dVar);
        this.e.setOnScrollListener(dVar);
        this.i = new ax(eVar);
        this.e.setAdapter((ListAdapter) this.i);
        this.a = new com.baidu.tbadk.core.view.q(eVar);
        this.e.setPullRefresh(this.a);
        this.h = (NoNetworkView) this.d.findViewById(com.baidu.tieba.a.h.view_no_network);
        com.baidu.tieba.view.i iVar = new com.baidu.tieba.view.i(this.b);
        iVar.setHeightDip(30);
        this.e.addFooterView(iVar);
    }

    public final void a(aq aqVar) {
        if (aqVar != null) {
            try {
                this.i.a(aqVar);
                this.i.notifyDataSetChanged();
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "refresh", e.getMessage());
            }
        }
    }

    public final void a() {
        if (this.e != null) {
            int headerViewsCount = this.e.getHeaderViewsCount() + 1;
            int firstVisiblePosition = this.e.getFirstVisiblePosition();
            int lastVisiblePosition = this.e.getLastVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition -= headerViewsCount;
                lastVisiblePosition -= headerViewsCount;
            }
            this.i.a(this.e, firstVisiblePosition, lastVisiblePosition);
        }
    }

    public final void d() {
        this.e.b();
    }

    public final SearchBoxView e() {
        return this.g;
    }

    public final void f() {
        this.e.c();
    }

    public final void g() {
        this.h.setVisibility(0);
    }

    public final void h() {
        this.h.setVisibility(8);
    }

    public final void a(com.baidu.tbadk.core.view.m mVar) {
        this.h.a(mVar);
    }

    public final void b(com.baidu.tbadk.core.view.m mVar) {
        this.h.b(mVar);
    }

    public final void i() {
        this.i.b();
    }

    public final void j() {
        NetworkInfo activeNetworkInfo;
        com.baidu.adp.lib.util.f.e("SquareView", "onResume", "onResume");
        this.i.a();
        if (this.h != null && this.h.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.c.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.h.setVisible(false);
        }
    }

    public final void k() {
        this.i.c();
    }

    public final void a(int i) {
        this.c.b().a(i == 1);
        this.c.b().a(this.f);
        this.i.a(i);
        this.a.a(i);
        this.h.a(i);
        this.g.a(i);
    }
}
