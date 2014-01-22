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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.cm;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class h {
    NavigationBar a;
    Handler b;
    private BdListView c;
    private Button d;
    private cm e;
    private final View f;
    private LinearLayout g;
    private TextView h;
    private ImageView i;
    private TopRecActivity j;
    private ProgressBar l;
    private TextView m;
    private Animation o;
    private Animation p;
    private p q;
    private int k = 0;
    private boolean n = false;

    public h(TopRecActivity topRecActivity) {
        this.q = null;
        this.b = null;
        this.j = topRecActivity;
        this.b = new Handler();
        this.j.setContentView(R.layout.top_recommended_activity);
        this.c = (BdListView) this.j.findViewById(R.id.top_list);
        this.a = (NavigationBar) topRecActivity.findViewById(R.id.view_navigation_bar);
        this.a.a(topRecActivity.getString(R.string.top_recommended));
        View a = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_top_rec, (View.OnClickListener) null);
        this.d = (Button) a.findViewById(R.id.title_finish);
        this.d.setOnClickListener(this.j);
        this.m = (TextView) a.findViewById(R.id.title_finish_cover);
        this.e = new cm(this.j);
        this.g = (LinearLayout) topRecActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.f = this.g.findViewById(R.id.footer_background);
        this.h = (TextView) this.g.findViewById(R.id.footer_text);
        this.i = (ImageView) this.g.findViewById(R.id.footer_icon);
        d();
        this.o = AnimationUtils.loadAnimation(this.j, R.anim.top_recommended_finish_a);
        this.p = AnimationUtils.loadAnimation(this.j, R.anim.top_recommended_finish_b);
        this.o.setAnimationListener(new i(this));
        this.p.setAnimationListener(new j(this));
        this.d.setText(this.j.getString(R.string.done) + "(" + this.k + ")");
        this.c.setPullRefresh(this.e);
        this.l = (ProgressBar) this.j.findViewById(R.id.loading);
        if (!p.a()) {
            this.q = new p(topRecActivity);
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

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.e.a(bVar);
    }

    public void c() {
        this.c.removeFooterView(this.g);
        this.c.addFooterView(this.g);
        this.c.a();
    }

    public void a(int i) {
        this.d.invalidate();
        if (this.k < 100) {
            this.m.setText(this.j.getString(R.string.done) + "(" + this.k + ")");
        } else {
            this.m.setText(this.j.getString(R.string.done) + "(99+)");
        }
        this.d.setText(" ");
        this.m.setVisibility(0);
        this.m.setAnimation(this.o);
        this.o.start();
        this.k = i;
    }

    public void d() {
        this.h.setText(this.j.getString(R.string.flist_expand_list));
        if (TiebaApplication.h().al() == 1) {
            this.i.setBackgroundResource(R.drawable.ico_downward_1);
        } else {
            this.i.setBackgroundResource(R.drawable.ico_downward);
        }
        this.g.setOnClickListener(this.j);
    }

    public void e() {
        this.h.setText(this.j.getString(R.string.to_the_end));
        this.i.setVisibility(8);
        this.g.setClickable(false);
        this.g.setOnClickListener(null);
    }

    public void b(int i) {
        this.a.c(i);
        bs.b(this.j.findViewById(R.id.container), i);
        bs.f((TextView) this.d, i);
        bs.e((TextView) this.d, i);
        bs.e(this.m, i);
        if (TiebaApplication.h().al() == 1) {
            this.c.setDivider(new ColorDrawable(-13881543));
        } else {
            this.c.setDivider(new ColorDrawable(-1775893));
        }
        this.c.setDividerHeight(2);
        if (i == 1) {
            this.f.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.h.setTextColor(this.j.getResources().getColor(R.color.flist_text_color_night));
            if (this.e != null) {
                this.e.a(i);
            }
            if (this.n) {
                this.i.setVisibility(8);
                return;
            } else {
                this.i.setImageResource(R.drawable.ico_downward_1);
                return;
            }
        }
        this.f.setBackgroundResource(R.drawable.bg_black_banner_down);
        this.h.setTextColor(this.j.getResources().getColor(R.color.flist_text_color_day));
        if (this.n) {
            this.i.setVisibility(8);
        } else {
            this.i.setImageResource(R.drawable.ico_downward);
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
        if (this.q != null && !p.a()) {
            this.b.postDelayed(new k(this), 300L);
        }
    }
}
