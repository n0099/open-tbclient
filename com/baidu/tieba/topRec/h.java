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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.view.ab;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    Handler f2392a;
    private BdListView b;
    private RelativeLayout c;
    private TextView d;
    private Button e;
    private ab f;
    private final View g;
    private LinearLayout h;
    private TextView i;
    private ImageView j;
    private TopRecActivity k;
    private ProgressBar m;
    private TextView n;
    private Animation p;
    private Animation q;
    private p r;
    private int l = 0;
    private boolean o = false;

    public h(TopRecActivity topRecActivity) {
        this.r = null;
        this.f2392a = null;
        this.k = topRecActivity;
        this.f2392a = new Handler();
        this.k.setContentView(R.layout.top_recommended_activity);
        this.b = (BdListView) this.k.findViewById(R.id.top_list);
        this.c = (RelativeLayout) this.k.findViewById(R.id.title);
        this.d = (TextView) this.k.findViewById(R.id.title_text);
        this.e = (Button) this.k.findViewById(R.id.title_finish);
        this.e.setOnClickListener(this.k);
        this.f = new ab(this.k);
        this.h = (LinearLayout) topRecActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.g = this.h.findViewById(R.id.footer_background);
        this.i = (TextView) this.h.findViewById(R.id.footer_text);
        this.j = (ImageView) this.h.findViewById(R.id.footer_icon);
        d();
        this.n = (TextView) this.k.findViewById(R.id.title_finish_cover);
        this.p = AnimationUtils.loadAnimation(this.k, R.anim.top_recommended_finish_a);
        this.q = AnimationUtils.loadAnimation(this.k, R.anim.top_recommended_finish_b);
        this.p.setAnimationListener(new i(this));
        this.q.setAnimationListener(new j(this));
        this.e.setText(this.k.getString(R.string.done) + "(" + this.l + ")");
        this.b.setPullRefresh(this.f);
        this.m = (ProgressBar) this.k.findViewById(R.id.loading);
        if (!p.a()) {
            this.r = new p(topRecActivity);
        }
    }

    public LinearLayout a() {
        return this.h;
    }

    public Button b() {
        return this.e;
    }

    public void a(e eVar) {
        this.b.setAdapter((ListAdapter) eVar);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.f.a(bVar);
    }

    public void c() {
        this.b.removeFooterView(this.h);
        this.b.addFooterView(this.h);
        this.b.a();
    }

    public void a(int i) {
        this.e.invalidate();
        if (this.l < 100) {
            this.n.setText(this.k.getString(R.string.done) + "(" + this.l + ")");
        } else {
            this.n.setText(this.k.getString(R.string.done) + "(99+)");
        }
        this.e.setText(" ");
        this.n.setVisibility(0);
        this.n.setAnimation(this.p);
        this.p.start();
        this.l = i;
    }

    public void d() {
        this.i.setText(this.k.getString(R.string.flist_expand_list));
        if (TiebaApplication.g().as() == 1) {
            this.j.setBackgroundResource(R.drawable.ico_downward_1);
        } else {
            this.j.setBackgroundResource(R.drawable.ico_downward);
        }
        this.h.setOnClickListener(this.k);
    }

    public void e() {
        this.i.setText(this.k.getString(R.string.to_the_end));
        this.j.setVisibility(8);
        this.h.setClickable(false);
        this.h.setOnClickListener(null);
    }

    public void b(int i) {
        bb.d(this.c, i);
        bb.f(this.d, i);
        bb.b(this.k.findViewById(R.id.container), i);
        bb.g(this.e, i);
        bb.f((TextView) this.e, i);
        bb.f(this.n, i);
        if (TiebaApplication.g().as() == 1) {
            this.b.setDivider(new ColorDrawable(-13881543));
        } else {
            this.b.setDivider(new ColorDrawable(-1775893));
        }
        this.b.setDividerHeight(2);
        if (i == 1) {
            this.g.setBackgroundResource(R.drawable.bg_black_banner_down_1);
            this.i.setTextColor(this.k.getResources().getColor(R.color.flist_text_color_night));
            if (this.f != null) {
                this.f.a(i);
            }
            if (this.o) {
                this.j.setVisibility(8);
                return;
            } else {
                this.j.setImageResource(R.drawable.ico_downward_1);
                return;
            }
        }
        this.g.setBackgroundResource(R.drawable.bg_black_banner_down);
        this.i.setTextColor(this.k.getResources().getColor(R.color.flist_text_color_day));
        if (this.o) {
            this.j.setVisibility(8);
        } else {
            this.j.setImageResource(R.drawable.ico_downward);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    public void f() {
        if (this.r != null && !p.a()) {
            this.f2392a.postDelayed(new k(this), 300L);
        }
    }
}
