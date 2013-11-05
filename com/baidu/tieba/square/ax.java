package com.baidu.tieba.square;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.ba;
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
import com.baidu.tieba.view.az;
import com.baidu.tieba.view.bb;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    View f2356a;
    bb c;
    private SquareActivity d;
    private BdListView e;
    private ab f;
    private LinearLayout g;
    private RelativeLayout h;
    private TextView i;
    private SearchBoxView j;
    private NoNetworkView k;
    private NavigationBar l;

    public ax(SquareActivity squareActivity, View.OnKeyListener onKeyListener) {
        super(squareActivity);
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.c = null;
        this.d = squareActivity;
        squareActivity.setContentView(R.layout.square_view);
        this.g = (LinearLayout) squareActivity.findViewById(R.id.container);
        this.h = (RelativeLayout) squareActivity.findViewById(R.id.title);
        this.i = (TextView) squareActivity.findViewById(R.id.title_text);
        this.l = (NavigationBar) squareActivity.findViewById(R.id.view_navigation_bar);
        this.l.a(this.d.getResources().getString(R.string.square));
        this.f2356a = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.square_nb_item_allcat, squareActivity);
        this.j = (SearchBoxView) squareActivity.findViewById(R.id.view_searchbox);
        this.e = (BdListView) squareActivity.findViewById(R.id.bar_cat_listview);
        this.e.setOnKeyListener(onKeyListener);
        this.e.setOnItemClickListener(squareActivity);
        this.e.setOnScrollListener(squareActivity);
        this.f = new ab(squareActivity);
        this.e.setAdapter((ListAdapter) this.f);
        this.c = new bb(squareActivity);
        this.e.setPullRefresh(this.c);
        this.k = (NoNetworkView) squareActivity.findViewById(R.id.view_no_network);
    }

    public void a(ba baVar) {
        if (baVar != null) {
            try {
                this.f.a(baVar);
                this.f.notifyDataSetChanged();
            } catch (Exception e) {
                be.b(getClass().getName(), Headers.REFRESH, e.getMessage());
            }
        }
    }

    public void a() {
        this.e.a();
    }

    public void a(boolean z, String str) {
        a();
        if (!z && str != null) {
            this.d.a(str);
        }
    }

    public SearchBoxView e() {
        return this.j;
    }

    public void f() {
        this.e.b();
    }

    public View g() {
        return this.f2356a;
    }

    public void h() {
        this.k.setVisibility(0);
    }

    public void i() {
        this.k.setVisibility(8);
    }

    public void a(az azVar) {
        this.k.a(azVar);
    }

    public void b(az azVar) {
        this.k.b(azVar);
    }

    public void j() {
        this.f.notifyDataSetChanged();
    }

    public void k() {
    }

    public void l() {
        NetworkInfo activeNetworkInfo;
        be.e("SquareView", "onResume", "onResume");
        j();
        this.e.postDelayed(new ay(this), 1000L);
        if (this.k != null && this.k.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.d.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.k.setVisible(false);
        }
    }

    public void m() {
    }

    public void a(int i) {
        this.d.m().a(i == 1);
        this.d.m().a(this.g);
        com.baidu.tieba.util.bb.b(this.g, i);
        com.baidu.tieba.util.bb.d(this.h, i);
        com.baidu.tieba.util.bb.f(this.i, i);
        this.l.b(i);
        if (i == 1) {
            this.g.setBackgroundColor(-13618114);
        } else {
            this.g.setBackgroundColor(-197380);
        }
        this.f.a(i);
        this.c.a(i);
        this.k.a(i);
        this.j.a(i);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.c.a(bVar);
    }
}
