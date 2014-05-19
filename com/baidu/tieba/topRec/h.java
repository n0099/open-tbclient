package com.baidu.tieba.topRec;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h {
    NavigationBar a;
    Handler b;
    private BdListView c;
    private Button d;
    private com.baidu.tbadk.core.view.q e;
    private final View f;
    private LinearLayout g;
    private TextView h;
    private ImageView i;
    private TopRecActivity j;
    private ProgressBar l;
    private TextView m;
    private Animation o;
    private Animation p;
    private o q;
    private int k = 0;
    private boolean n = false;

    public h(TopRecActivity topRecActivity) {
        this.q = null;
        this.b = null;
        this.j = topRecActivity;
        this.b = new Handler();
        this.j.setContentView(s.top_recommended_activity);
        this.c = (BdListView) this.j.findViewById(r.top_list);
        this.a = (NavigationBar) topRecActivity.findViewById(r.view_navigation_bar);
        this.a.a(topRecActivity.getString(u.top_recommended));
        View a = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, s.nb_item_top_rec, (View.OnClickListener) null);
        this.d = (Button) a.findViewById(r.title_finish);
        this.d.setOnClickListener(this.j);
        this.m = (TextView) a.findViewById(r.title_finish_cover);
        this.e = new com.baidu.tbadk.core.view.q(this.j);
        this.g = (LinearLayout) topRecActivity.getLayoutInflater().inflate(s.forum_list_forum_footer, (ViewGroup) null);
        this.f = this.g.findViewById(r.footer_background);
        this.h = (TextView) this.g.findViewById(r.footer_text);
        this.i = (ImageView) this.g.findViewById(r.footer_icon);
        d();
        this.o = AnimationUtils.loadAnimation(this.j, com.baidu.tieba.l.top_recommended_finish_a);
        this.p = AnimationUtils.loadAnimation(this.j, com.baidu.tieba.l.top_recommended_finish_b);
        this.o.setAnimationListener(new i(this));
        this.p.setAnimationListener(new j(this));
        this.d.setText(String.valueOf(this.j.getString(u.done)) + "(" + this.k + ")");
        this.c.setPullRefresh(this.e);
        this.l = (ProgressBar) this.j.findViewById(r.loading);
        if (!o.a()) {
            this.q = new o(topRecActivity);
        }
    }

    public LinearLayout a() {
        return this.g;
    }

    public Button b() {
        return this.d;
    }

    public void a(e eVar) {
        this.c.setAdapter((ListAdapter) eVar);
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.e.a(dVar);
    }

    public void c() {
        this.c.removeFooterView(this.g);
        this.c.addFooterView(this.g);
        this.c.c();
    }

    public void a(int i) {
        this.d.invalidate();
        if (this.k < 100) {
            this.m.setText(String.valueOf(this.j.getString(u.done)) + "(" + this.k + ")");
        } else {
            this.m.setText(String.valueOf(this.j.getString(u.done)) + "(99+)");
        }
        this.d.setText(" ");
        this.m.setVisibility(0);
        this.m.setAnimation(this.o);
        this.o.start();
        this.k = i;
    }

    public void d() {
        this.h.setText(this.j.getString(u.flist_expand_list));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.i.setBackgroundResource(com.baidu.tieba.q.ico_downward_1);
        } else {
            this.i.setBackgroundResource(com.baidu.tieba.q.ico_downward);
        }
        this.g.setOnClickListener(this.j);
    }

    public void e() {
        this.h.setText(this.j.getString(u.to_the_end));
        this.i.setVisibility(8);
        this.g.setClickable(false);
        this.g.setOnClickListener(null);
    }

    public void b(int i) {
        this.a.c(i);
        bc.b(this.j.findViewById(r.container), i);
        bc.e((TextView) this.d, i);
        bc.d((TextView) this.d, i);
        bc.d(this.m, i);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.c.setDivider(new ColorDrawable(-13881543));
        } else {
            this.c.setDivider(new ColorDrawable(-1775893));
        }
        this.c.setDividerHeight(2);
        if (i == 1) {
            this.f.setBackgroundResource(com.baidu.tieba.q.bg_black_banner_down_1);
            this.h.setTextColor(this.j.getResources().getColor(com.baidu.tieba.o.flist_text_color_night));
            if (this.e != null) {
                this.e.a(i);
            }
            if (this.n) {
                this.i.setVisibility(8);
                return;
            } else {
                this.i.setImageResource(com.baidu.tieba.q.ico_downward_1);
                return;
            }
        }
        this.f.setBackgroundResource(com.baidu.tieba.q.bg_black_banner_down);
        this.h.setTextColor(this.j.getResources().getColor(com.baidu.tieba.o.flist_text_color_day));
        if (this.n) {
            this.i.setVisibility(8);
        } else {
            this.i.setImageResource(com.baidu.tieba.q.ico_downward);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    public void f() {
        if (this.q != null && !o.a()) {
            this.b.postDelayed(new k(this), 300L);
        }
    }
}
