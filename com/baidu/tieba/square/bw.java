package com.baidu.tieba.square;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bw extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    public static String f2417a = "top_nav_all_folder";
    View c;
    com.baidu.tieba.view.bi d;
    private BaseFragmentActivity e;
    private BaseFragment f;
    private View g;
    private BdListView h;
    private LinearLayout i;
    private SearchBoxView j;
    private NoNetworkView k;
    private NavigationBar l;
    private ba m;

    public bw(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity);
        this.e = null;
        this.h = null;
        this.i = null;
        this.d = null;
        this.m = null;
        this.e = baseFragmentActivity;
        this.f = baseFragment;
        this.g = baseFragment.q();
        this.i = (LinearLayout) this.g.findViewById(R.id.container);
        this.l = (NavigationBar) this.g.findViewById(R.id.view_navigation_bar);
        this.l.a(this.e.getResources().getString(R.string.square));
        this.c = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.square_nb_item_allcat, baseFragment);
        this.j = (SearchBoxView) this.g.findViewById(R.id.view_searchbox);
        this.h = (BdListView) this.g.findViewById(R.id.square_list);
        this.h.setOnKeyListener(onKeyListener);
        this.h.setOnItemClickListener(baseFragment);
        this.h.setOnScrollListener(baseFragment);
        this.m = new ba(baseFragmentActivity);
        this.h.setAdapter((ListAdapter) this.m);
        this.d = new com.baidu.tieba.view.bi(baseFragmentActivity);
        this.h.setPullRefresh(this.d);
        this.k = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        com.baidu.tieba.view.q qVar = new com.baidu.tieba.view.q(this.b);
        qVar.setHeightDip(30);
        this.h.addFooterView(qVar);
    }

    public void a(ar arVar) {
        if (arVar != null) {
            try {
                this.m.a(arVar);
                this.m.notifyDataSetChanged();
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b(getClass().getName(), Headers.REFRESH, e.getMessage());
            }
        }
    }

    public void a() {
        if (this.h != null) {
            int headerViewsCount = this.h.getHeaderViewsCount() + 1;
            int firstVisiblePosition = this.h.getFirstVisiblePosition();
            int lastVisiblePosition = this.h.getLastVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition -= headerViewsCount;
                lastVisiblePosition -= headerViewsCount;
            }
            this.m.a(this.h, firstVisiblePosition, lastVisiblePosition);
        }
    }

    public void e() {
        this.h.a();
    }

    public void a(boolean z, String str) {
        e();
        if (!z && str != null) {
            this.e.a(str);
        }
    }

    public SearchBoxView f() {
        return this.j;
    }

    public void g() {
        this.h.b();
    }

    public View h() {
        return this.c;
    }

    public void i() {
        this.k.setVisibility(0);
    }

    public void j() {
        this.k.setVisibility(8);
    }

    public void a(com.baidu.tieba.view.az azVar) {
        this.k.a(azVar);
    }

    public void b(com.baidu.tieba.view.az azVar) {
        this.k.b(azVar);
    }

    public void k() {
        this.m.d();
    }

    public void l() {
        NetworkInfo activeNetworkInfo;
        com.baidu.tieba.util.bg.e("SquareView", "onResume", "onResume");
        this.m.a();
        if (this.k != null && this.k.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.e.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.k.setVisible(false);
        }
    }

    public void m() {
        this.m.b();
    }

    public void n() {
    }

    public void a(int i) {
        this.e.a().a(i == 1);
        this.e.a().a(this.i);
        this.l.c(i);
        this.m.a(i);
        this.d.a(i);
        this.k.a(i);
        this.j.a(i);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.d.a(bVar);
    }
}
