package com.baidu.tieba.square;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
import com.baidu.tieba.view.by;
import com.baidu.tieba.view.cs;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class ba extends com.baidu.adp.a.e {
    cs a;
    private com.baidu.tieba.k c;
    private com.baidu.tieba.j d;
    private View e;
    private BdListView f;
    private LinearLayout g;
    private SearchBoxView h;
    private NoNetworkView i;
    private az j;

    public ba(com.baidu.tieba.k kVar, com.baidu.tieba.j jVar, View.OnKeyListener onKeyListener) {
        super(kVar);
        this.c = null;
        this.f = null;
        this.g = null;
        this.a = null;
        this.j = null;
        this.c = kVar;
        this.d = jVar;
        this.e = jVar.getView();
        this.g = (LinearLayout) this.e.findViewById(R.id.container);
        this.h = (SearchBoxView) this.e.findViewById(R.id.view_searchbox);
        this.f = (BdListView) this.e.findViewById(R.id.square_list);
        this.f.setOnKeyListener(onKeyListener);
        this.f.setOnItemClickListener(jVar);
        this.f.setOnScrollListener(jVar);
        this.j = new az(kVar);
        this.f.setAdapter((ListAdapter) this.j);
        this.a = new cs(kVar);
        this.f.setPullRefresh(this.a);
        this.i = (NoNetworkView) this.e.findViewById(R.id.view_no_network);
        com.baidu.tieba.view.ad adVar = new com.baidu.tieba.view.ad(this.b);
        adVar.setHeightDip(30);
        this.f.addFooterView(adVar);
    }

    public final void a(as asVar) {
        if (asVar != null) {
            try {
                this.j.a(asVar);
                this.j.notifyDataSetChanged();
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "refresh", e.getMessage());
            }
        }
    }

    public final void a() {
        if (this.f != null) {
            int headerViewsCount = this.f.getHeaderViewsCount() + 1;
            int firstVisiblePosition = this.f.getFirstVisiblePosition();
            int lastVisiblePosition = this.f.getLastVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition -= headerViewsCount;
                lastVisiblePosition -= headerViewsCount;
            }
            this.j.a(this.f, firstVisiblePosition, lastVisiblePosition);
        }
    }

    public final void d() {
        this.f.a();
    }

    public final SearchBoxView e() {
        return this.h;
    }

    public final void f() {
        this.f.b();
    }

    public final void g() {
        this.i.setVisibility(0);
    }

    public final void h() {
        this.i.setVisibility(8);
    }

    public final void a(by byVar) {
        this.i.a(byVar);
    }

    public final void b(by byVar) {
        this.i.b(byVar);
    }

    public final void i() {
        this.j.d();
    }

    public final void j() {
        NetworkInfo activeNetworkInfo;
        com.baidu.adp.lib.util.e.e("SquareView", "onResume", "onResume");
        this.j.a();
        if (this.i != null && this.i.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.c.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.i.setVisible(false);
        }
    }

    public final void k() {
        this.j.b();
    }

    public final void a(int i) {
        this.c.a().a(i == 1);
        this.c.a().a(this.g);
        this.j.a(i);
        this.a.a(i);
        this.i.a(i);
        this.h.a(i);
    }
}
