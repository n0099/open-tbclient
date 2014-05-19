package com.baidu.tieba.recommend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.adp.widget.PinnedHeaderListView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.view.z;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e {
    private final DailyRecommendActivity a;
    private final PinnedHeaderListView b;
    private final ProgressBar c;
    private final View d;
    private final z e;
    private final PbListView f;
    private final View g;
    private final TextView h;
    private final i i;
    private final NavigationBar j;

    public r(DailyRecommendActivity dailyRecommendActivity, u uVar, l lVar) {
        super(dailyRecommendActivity);
        this.a = dailyRecommendActivity;
        this.d = LayoutInflater.from(this.mContext).inflate(com.baidu.tieba.s.daily_recommend_view, (ViewGroup) null);
        this.a.setContentView(this.d);
        this.b = (PinnedHeaderListView) this.d.findViewById(com.baidu.tieba.r.pinnedHeaderListview);
        this.i = new i(dailyRecommendActivity, lVar);
        this.h = (TextView) this.d.findViewById(com.baidu.tieba.r.text_info);
        this.e = new z(this.mContext);
        this.b.setPullRefresh(this.e);
        this.b.setAdapter((ListAdapter) this.i);
        this.b.setOnSrollToBottomListener(uVar);
        this.c = (ProgressBar) this.d.findViewById(com.baidu.tieba.r.progress);
        this.c.setVisibility(8);
        this.f = new PbListView(this.a);
        this.f.a(new s(this));
        this.g = this.f.b().findViewById(com.baidu.tieba.r.pb_more_view);
        this.j = (NavigationBar) this.a.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.a(this.a.getString(com.baidu.tieba.u.dailyrecommend_title));
    }

    public void a() {
        this.f.d();
    }

    public void b() {
        this.c.setVisibility(0);
    }

    public void a(boolean z, String str) {
        this.c.setVisibility(8);
        if (!z && str != null) {
            this.a.showToast(str);
        }
    }

    public void c() {
        this.c.setVisibility(8);
        this.f.e();
    }

    public void a(com.baidu.tieba.data.k kVar) {
        this.b.c();
        this.f.e();
        if (kVar != null) {
            if (kVar.a().size() > 0) {
                this.b.setNextPage(this.f);
            }
            this.i.a(kVar);
            this.i.a();
        }
    }

    public void d() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.l.custom_home_text_info);
        this.h.setVisibility(0);
        loadAnimation.setAnimationListener(new t(this));
        this.h.startAnimation(loadAnimation);
    }

    public void a(int i) {
        this.j.c(i);
        bc.f(this.b, com.baidu.tieba.o.cp_bg_line_c);
        this.e.a(i);
        if (this.f != null) {
            this.f.d(i);
        }
        bc.a(this.h, com.baidu.tieba.o.cp_link_tip_d, 1);
        bc.f((View) this.h, com.baidu.tieba.q.bg_update);
        this.i.a();
    }

    public void e() {
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.e.a(dVar);
    }
}
