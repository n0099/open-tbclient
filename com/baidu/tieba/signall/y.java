package com.baidu.tieba.signall;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.c {
    public static int a;
    private BaseActivity b;
    private NavigationBar c;
    private RelativeLayout d;
    private u e;
    private ProgressBar f;
    private BdListView g;
    private com.baidu.tbadk.core.view.q h;
    private k i;
    private a j;
    private View k;
    private TextView l;
    private TextView m;
    private TextView n;

    public y(BaseActivity baseActivity) {
        super(baseActivity);
        this.h = null;
        this.b = baseActivity;
        this.b.setContentView(com.baidu.tieba.w.signallforum_view);
        this.d = (RelativeLayout) this.b.findViewById(com.baidu.tieba.v.parent);
        this.c = (NavigationBar) this.b.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.c.a(this.b.getString(com.baidu.tieba.y.signallforum));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new z(this));
        this.g = (BdListView) this.b.findViewById(com.baidu.tieba.v.signallforum_list);
        this.g.setOnItemClickListener(baseActivity);
        this.h = new com.baidu.tbadk.core.view.q(baseActivity);
        this.g.setPullRefresh(this.h);
        this.n = (TextView) this.b.getLayoutInflater().inflate(com.baidu.tieba.w.signallforum_maxcount_warning, (ViewGroup) null);
        this.g.addFooterView(this.n);
        this.e = new u(this.b);
        this.f = this.e.getProgressBar();
        this.f.setOnClickListener(this.b);
        this.g.addHeaderView(this.e);
        this.e.setVisibility(8);
        this.k = this.b.getLayoutInflater().inflate(com.baidu.tieba.w.signallforum_header, (ViewGroup) null);
        this.l = (TextView) this.k.findViewById(com.baidu.tieba.v.signallforum_head_title);
        this.m = (TextView) this.k.findViewById(com.baidu.tieba.v.signallforum_head_res);
        this.g.addHeaderView(this.k);
        this.k.setVisibility(8);
        this.i = new k(this.b, this.m);
        this.g.setAdapter((ListAdapter) this.i);
        this.g.setOnScrollListener(this.i);
    }

    public void a(int i) {
        Resources resources = this.b.getResources();
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a((View) this.d);
        this.b.getLayoutMode().a(this.n);
        if (i == 1) {
            this.d.setBackgroundColor(-13618114);
        } else {
            this.d.setBackgroundColor(-197380);
        }
        this.c.c(i);
        this.h.a(i);
        int i2 = i == 1 ? com.baidu.tieba.u.bg_ba_catalogue_1 : com.baidu.tieba.u.bg_ba_catalogue;
        int i3 = i == 1 ? com.baidu.tieba.s.forum_detail_ht_title_color_1 : com.baidu.tieba.s.forum_detail_ht_title_color;
        this.k.setBackgroundResource(i2);
        this.l.setTextColor(resources.getColor(i3));
        this.m.setTextColor(resources.getColor(i3));
        this.i.notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.j = aVar;
        h();
        ArrayList<b> j = aVar.j();
        this.i.a(this.j);
        if (j.size() == a) {
            this.n.setVisibility(0);
            this.n.setText(aVar.f());
            return;
        }
        this.n.setVisibility(8);
    }

    private void h() {
        if (this.j.i() == 0 || this.j.l().size() == this.j.j().size()) {
            this.e.a();
            int size = this.j.j().size();
            int size2 = this.j.l().size();
            this.m.setText(this.b.getString(com.baidu.tieba.y.signallforum_res, new Object[]{Integer.valueOf(size2), Integer.valueOf(size - size2)}));
        } else {
            this.m.setText(String.format(this.b.getString(com.baidu.tieba.y.signallforum_count), Integer.valueOf(this.j.j().size())));
        }
        TextView message1 = this.e.getMessage1();
        SpannableString spannableString = new SpannableString(String.valueOf(this.j.b()) + this.j.c() + this.j.d());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#56aeff"));
        int length = this.j.b().length();
        spannableString.setSpan(foregroundColorSpan, length, this.j.c().length() + length, 33);
        message1.setText(spannableString);
        this.e.getMessage2().setText(this.j.e());
        this.l.setText(this.j.a());
        this.k.setVisibility(0);
        this.e.setVisibility(0);
    }

    public void a() {
        this.g.d();
    }

    public void b() {
        this.g.c();
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.h.a(dVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.g.setOnItemClickListener(onItemClickListener);
    }

    public u c() {
        return this.e;
    }

    public ProgressBar d() {
        return this.f;
    }

    public a e() {
        return this.j;
    }

    public k f() {
        return this.i;
    }

    public TextView g() {
        return this.m;
    }
}
