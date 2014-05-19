package com.baidu.tieba.square;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.e {
    com.baidu.tbadk.core.view.q a;
    private com.baidu.tbadk.core.e b;
    private View c;
    private BdListView d;
    private LinearLayout e;
    private SearchBoxView f;
    private NoNetworkView g;
    private ax h;

    public ay(com.baidu.tbadk.core.e eVar, com.baidu.tbadk.core.d dVar, View.OnKeyListener onKeyListener) {
        super(eVar);
        this.b = null;
        this.d = null;
        this.e = null;
        this.a = null;
        this.h = null;
        this.b = eVar;
        this.c = dVar.getView();
        this.e = (LinearLayout) this.c.findViewById(com.baidu.tieba.r.container);
        this.f = (SearchBoxView) this.c.findViewById(com.baidu.tieba.r.view_searchbox);
        this.d = (BdListView) this.c.findViewById(com.baidu.tieba.r.square_list);
        this.d.setOnKeyListener(onKeyListener);
        this.d.setOnItemClickListener(dVar);
        this.d.setOnScrollListener(dVar);
        this.h = new ax(eVar);
        this.d.setAdapter((ListAdapter) this.h);
        this.a = new com.baidu.tbadk.core.view.q(eVar);
        this.d.setPullRefresh(this.a);
        this.g = (NoNetworkView) this.c.findViewById(com.baidu.tieba.r.view_no_network);
        com.baidu.tieba.view.j jVar = new com.baidu.tieba.view.j(this.mContext);
        jVar.setHeightDip(30);
        this.d.addFooterView(jVar);
    }

    public void a(aq aqVar) {
        if (aqVar != null) {
            try {
                this.h.a(aqVar);
                this.h.notifyDataSetChanged();
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "refresh", e.getMessage());
            }
        }
    }

    public void a() {
        if (this.d != null) {
            int headerViewsCount = this.d.getHeaderViewsCount() + 1;
            int firstVisiblePosition = this.d.getFirstVisiblePosition();
            int lastVisiblePosition = this.d.getLastVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition -= headerViewsCount;
                lastVisiblePosition -= headerViewsCount;
            }
            this.h.a(this.d, firstVisiblePosition, lastVisiblePosition);
        }
    }

    public void b() {
        this.d.c();
    }

    public void a(boolean z, String str) {
        b();
        if (!z && str != null) {
            this.b.a(str);
        }
    }

    public SearchBoxView c() {
        return this.f;
    }

    public void d() {
        this.d.d();
    }

    public void e() {
        this.g.setVisibility(0);
    }

    public void f() {
        this.g.setVisibility(8);
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.g.a(mVar);
    }

    public void b(com.baidu.tbadk.core.view.m mVar) {
        this.g.b(mVar);
    }

    public void g() {
        this.h.b();
    }

    public void h() {
        NetworkInfo activeNetworkInfo;
        BdLog.d("SquareView", "onResume", "onResume");
        this.h.a();
        if (this.g != null && this.g.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.g.setVisible(false);
        }
    }

    public void i() {
        this.h.c();
    }

    public void j() {
    }

    public void a(int i) {
        this.b.a().a(i == 1);
        this.b.a().a((View) this.e);
        this.h.a(i);
        this.a.a(i);
        this.g.a(i);
        this.f.a(i);
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.a.a(dVar);
    }
}
