package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.bc;
import com.baidu.tieba.util.ao;
import com.baidu.tieba.util.aq;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.ax;
import com.baidu.tieba.view.ba;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.a.d {
    ImageView b;
    ba c;
    private SquareActivity d;
    private BdListView e;
    private aa f;
    private LinearLayout g;
    private RelativeLayout h;
    private TextView i;
    private LinearLayout j;
    private ImageView k;
    private LinearLayout l;
    private TextView m;
    private ProgressBar n;
    private NoNetworkView o;

    public ab(SquareActivity squareActivity, View.OnKeyListener onKeyListener) {
        super(squareActivity);
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.c = null;
        this.d = squareActivity;
        squareActivity.setContentView(R.layout.square_view);
        this.g = (LinearLayout) squareActivity.findViewById(R.id.container);
        this.h = (RelativeLayout) squareActivity.findViewById(R.id.title);
        this.i = (TextView) squareActivity.findViewById(R.id.title_text);
        this.j = (LinearLayout) squareActivity.findViewById(R.id.search_bg_layout);
        this.l = (LinearLayout) squareActivity.findViewById(R.id.search_tap_layout);
        this.m = (TextView) squareActivity.findViewById(R.id.search_bar_text);
        this.k = (ImageView) squareActivity.findViewById(R.id.search_bar_icon);
        this.j.setOnClickListener(squareActivity);
        this.e = (BdListView) squareActivity.findViewById(R.id.bar_cat_listview);
        this.e.setOnKeyListener(onKeyListener);
        this.e.setOnItemClickListener(squareActivity);
        this.e.setOnScrollListener(squareActivity);
        this.f = new aa(squareActivity);
        this.e.setAdapter((ListAdapter) this.f);
        this.c = new ba(squareActivity);
        this.e.setPullRefresh(this.c);
        this.b = (ImageView) squareActivity.findViewById(R.id.enter_forum_dir);
        this.b.setOnClickListener(squareActivity);
        this.n = (ProgressBar) squareActivity.findViewById(R.id.enter_forum_progress);
        this.o = (NoNetworkView) squareActivity.findViewById(R.id.view_no_network);
    }

    public void a(bc bcVar) {
        if (bcVar != null) {
            try {
                this.f.a(bcVar);
                this.f.notifyDataSetChanged();
            } catch (Exception e) {
                aq.b(getClass().getName(), Headers.REFRESH, e.getMessage());
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

    public void c() {
        this.e.b();
    }

    public View d() {
        return this.b;
    }

    public void e() {
        this.o.setVisibility(0);
    }

    public void f() {
        this.o.setVisibility(8);
    }

    public void a(ax axVar) {
        this.o.a(axVar);
    }

    public void b(ax axVar) {
        this.o.b(axVar);
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    public void a(int i) {
        ao.b(this.g, i);
        ao.d(this.h, i);
        ao.f(this.i, i);
        if (i == 1) {
            this.g.setBackgroundColor(-13618114);
            ao.g(this.l, (int) R.drawable.inputbox_topbg_1);
            ao.g(this.j, (int) R.drawable.inputbox_top_1);
            this.m.setHintTextColor(-11446171);
            this.k.setImageResource(R.drawable.icon_head_bar_search_1);
            this.b.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.b.setImageResource(R.drawable.icon_more_1);
        } else {
            this.g.setBackgroundColor(-197380);
            ao.g(this.l, (int) R.drawable.inputbox_topbg);
            ao.g(this.j, (int) R.drawable.inputbox_top);
            this.m.setHintTextColor(-5921112);
            this.k.setImageResource(R.drawable.icon_head_bar_search);
            this.b.setBackgroundResource(R.drawable.title_icon_bg);
            this.b.setImageResource(R.drawable.icon_more);
        }
        this.f.a(i);
        this.c.a(i);
        this.o.a(i);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.c.a(bVar);
    }
}
