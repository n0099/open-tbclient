package com.baidu.tieba.square;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.bc;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
import com.baidu.tieba.view.az;
import com.baidu.tieba.view.bb;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.a.d {
    View b;
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
        this.b = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.square_nb_item_allcat, squareActivity);
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

    public void a(bc bcVar) {
        if (bcVar != null) {
            try {
                this.f.a(bcVar);
                this.f.notifyDataSetChanged();
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), Headers.REFRESH, e.getMessage());
            }
        }
    }

    public void b() {
        this.e.a();
    }

    public void a(boolean z, String str) {
        b();
        if (!z && str != null) {
            this.d.a(str);
        }
    }

    public SearchBoxView c() {
        return this.j;
    }

    public void d() {
        this.e.b();
    }

    public View e() {
        return this.b;
    }

    public void f() {
        this.k.setVisibility(0);
    }

    public void g() {
        this.k.setVisibility(8);
    }

    public void a(az azVar) {
        this.k.a(azVar);
    }

    public void b(az azVar) {
        this.k.b(azVar);
    }

    public void h() {
        this.f.notifyDataSetChanged();
    }

    public void i() {
    }

    public void j() {
        com.baidu.tieba.util.av.e("SquareView", "onResume", "onResume");
        h();
        this.e.postDelayed(new ay(this), 1000L);
    }

    public void k() {
    }

    public void a(int i) {
        this.d.l().a(i == 1);
        this.d.l().a(this.g);
        com.baidu.tieba.util.as.b(this.g, i);
        com.baidu.tieba.util.as.d(this.h, i);
        com.baidu.tieba.util.as.f(this.i, i);
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
