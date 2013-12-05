package com.baidu.tieba.square;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    public static String f2517a = "top_nav_all_folder";
    com.baidu.tieba.view.bk c;
    private BaseFragmentActivity d;
    private BaseFragment e;
    private View f;
    private BdListView g;
    private LinearLayout h;
    private SearchBoxView i;
    private NoNetworkView j;
    private ay k;

    public bu(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity);
        this.d = null;
        this.g = null;
        this.h = null;
        this.c = null;
        this.k = null;
        this.d = baseFragmentActivity;
        this.e = baseFragment;
        this.f = baseFragment.q();
        this.h = (LinearLayout) this.f.findViewById(R.id.container);
        this.i = (SearchBoxView) this.f.findViewById(R.id.view_searchbox);
        this.g = (BdListView) this.f.findViewById(R.id.square_list);
        this.g.setOnKeyListener(onKeyListener);
        this.g.setOnItemClickListener(baseFragment);
        this.g.setOnScrollListener(baseFragment);
        this.k = new ay(baseFragmentActivity);
        this.g.setAdapter((ListAdapter) this.k);
        this.c = new com.baidu.tieba.view.bk(baseFragmentActivity);
        this.g.setPullRefresh(this.c);
        this.j = (NoNetworkView) this.f.findViewById(R.id.view_no_network);
        com.baidu.tieba.view.r rVar = new com.baidu.tieba.view.r(this.b);
        rVar.setHeightDip(30);
        this.g.addFooterView(rVar);
    }

    public void a(ar arVar) {
        if (arVar != null) {
            try {
                this.k.a(arVar);
                this.k.notifyDataSetChanged();
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b(getClass().getName(), Headers.REFRESH, e.getMessage());
            }
        }
    }

    public void a() {
        if (this.g != null) {
            int headerViewsCount = this.g.getHeaderViewsCount() + 1;
            int firstVisiblePosition = this.g.getFirstVisiblePosition();
            int lastVisiblePosition = this.g.getLastVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition -= headerViewsCount;
                lastVisiblePosition -= headerViewsCount;
            }
            this.k.a(this.g, firstVisiblePosition, lastVisiblePosition);
        }
    }

    public void e() {
        this.g.a();
    }

    public void a(boolean z, String str) {
        e();
        if (!z && str != null) {
            this.d.b(str);
        }
    }

    public SearchBoxView f() {
        return this.i;
    }

    public void g() {
        this.g.b();
    }

    public void h() {
        this.j.setVisibility(0);
    }

    public void i() {
        this.j.setVisibility(8);
    }

    public void a(com.baidu.tieba.view.ba baVar) {
        this.j.a(baVar);
    }

    public void b(com.baidu.tieba.view.ba baVar) {
        this.j.b(baVar);
    }

    public void j() {
        this.k.d();
    }

    public void k() {
        NetworkInfo activeNetworkInfo;
        com.baidu.tieba.util.bd.e("SquareView", "onResume", "onResume");
        this.k.a();
        if (this.j != null && this.j.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.d.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.j.setVisible(false);
        }
    }

    public void l() {
        this.k.b();
    }

    public void m() {
    }

    public void a(int i) {
        this.d.a().a(i == 1);
        this.d.a().a(this.h);
        this.k.a(i);
        this.c.a(i);
        this.j.a(i);
        this.i.a(i);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.c.a(bVar);
    }
}
