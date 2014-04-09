package com.baidu.tieba.recommend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.PinnedHeaderListView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.view.y;
/* loaded from: classes.dex */
public final class r extends com.baidu.adp.a.f {
    private final DailyRecommendActivity a;
    private final PinnedHeaderListView c;
    private final ProgressBar d;
    private final View e;
    private final y f;
    private final PbListView g;
    private final View h;
    private final TextView i;
    private final i j;
    private final NavigationBar k;

    public r(DailyRecommendActivity dailyRecommendActivity, com.baidu.adp.widget.ListView.t tVar, l lVar) {
        super(dailyRecommendActivity);
        this.a = dailyRecommendActivity;
        this.e = LayoutInflater.from(this.b).inflate(com.baidu.tieba.a.i.daily_recommend_view, (ViewGroup) null);
        this.a.setContentView(this.e);
        this.c = (PinnedHeaderListView) this.e.findViewById(com.baidu.tieba.a.h.pinnedHeaderListview);
        this.j = new i(dailyRecommendActivity, lVar);
        this.i = (TextView) this.e.findViewById(com.baidu.tieba.a.h.text_info);
        this.f = new y(this.b);
        this.c.setPullRefresh(this.f);
        this.c.setAdapter((ListAdapter) this.j);
        this.c.setOnSrollToBottomListener(tVar);
        this.d = (ProgressBar) this.e.findViewById(com.baidu.tieba.a.h.progress);
        this.d.setVisibility(8);
        this.g = new PbListView(this.a);
        this.g.a(new s(this));
        this.h = this.g.b().findViewById(com.baidu.tieba.a.h.pb_more_view);
        this.k = (NavigationBar) this.a.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k.a(this.a.getString(com.baidu.tieba.a.k.dailyrecommend_title));
    }

    public final void a() {
        this.g.d();
    }

    public final void d() {
        this.d.setVisibility(0);
    }

    public final void a(boolean z, String str) {
        this.d.setVisibility(8);
    }

    public final void e() {
        this.d.setVisibility(8);
        this.g.e();
    }

    public final void a(com.baidu.tieba.data.k kVar) {
        this.c.b();
        this.g.e();
        if (kVar != null) {
            if (kVar.a().size() > 0) {
                this.c.setNextPage(this.g);
            }
            this.j.a(kVar);
            this.j.a();
        }
    }

    public final void f() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, com.baidu.tieba.a.b.custom_home_text_info);
        this.i.setVisibility(0);
        loadAnimation.setAnimationListener(new t(this));
        this.i.startAnimation(loadAnimation);
    }

    public final void a(int i) {
        this.k.b(i);
        ba.f(this.c, com.baidu.tieba.a.e.cp_bg_line_c);
        this.f.a(i);
        if (this.g != null) {
            this.g.c(i);
        }
        ba.a(this.i, com.baidu.tieba.a.e.cp_link_tip_d, 1);
        ba.f((View) this.i, com.baidu.tieba.a.g.bg_update);
        this.j.a();
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.f.a(dVar);
    }
}
