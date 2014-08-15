package com.baidu.tieba.recommend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.PinnedHeaderListView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.view.y;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.f {
    private final DailyRecommendActivity a;
    private final PinnedHeaderListView b;
    private final ProgressBar c;
    private final View d;
    private final y e;
    private final PbListView f;
    private final View g;
    private final TextView h;
    private final i i;
    private final NavigationBar j;

    public r(DailyRecommendActivity dailyRecommendActivity, x xVar, l lVar) {
        super(dailyRecommendActivity);
        this.a = dailyRecommendActivity;
        this.d = LayoutInflater.from(this.mContext).inflate(v.daily_recommend_view, (ViewGroup) null);
        this.a.setContentView(this.d);
        this.b = (PinnedHeaderListView) this.d.findViewById(u.pinnedHeaderListview);
        this.i = new i(dailyRecommendActivity, lVar);
        this.h = (TextView) this.d.findViewById(u.text_info);
        this.e = new y(this.mContext);
        this.b.setPullRefresh(this.e);
        this.b.setAdapter((ListAdapter) this.i);
        this.b.setOnSrollToBottomListener(xVar);
        this.c = (ProgressBar) this.d.findViewById(u.progress);
        this.c.setVisibility(8);
        this.f = new PbListView(this.a);
        this.f.a(new s(this));
        this.g = this.f.b().findViewById(u.pb_more_view);
        this.j = (NavigationBar) this.a.findViewById(u.view_navigation_bar);
        this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.a(this.a.getString(com.baidu.tieba.x.dailyrecommend_title));
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

    public void a(com.baidu.tieba.data.l lVar, boolean z) {
        this.b.d();
        if (z) {
            this.f.a(this.a.getString(com.baidu.tieba.x.pb_load_more));
        } else {
            this.f.a(this.a.getString(com.baidu.tieba.x.no_more_to_load));
        }
        this.f.e();
        if (lVar != null) {
            if (lVar.a().size() > 0) {
                this.b.setNextPage(this.f);
            }
            this.i.a(lVar);
            this.i.a();
        }
    }

    public void d() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.o.custom_home_text_info);
        this.h.setVisibility(0);
        loadAnimation.setAnimationListener(new t(this));
        this.h.startAnimation(loadAnimation);
    }

    public void a(int i) {
        this.j.c(i);
        ay.f(this.b, com.baidu.tieba.r.cp_bg_line_c);
        this.e.a(i);
        if (this.f != null) {
            this.f.d(i);
        }
        ay.a(this.h, com.baidu.tieba.r.cp_link_tip_d, 1);
        ay.f((View) this.h, com.baidu.tieba.t.bg_update);
        this.i.a();
    }

    public void e() {
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.e.a(dVar);
    }
}
