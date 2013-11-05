package com.baidu.tieba.recommend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.PinnedHeaderListView;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.view.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private DailyRecommendActivity f2294a;
    private PinnedHeaderListView c;
    private ProgressBar d;
    private View e;
    private bb f;
    private PbListView g;
    private View h;
    private TextView i;
    private h j;
    private View k;
    private ImageView l;
    private ImageView m;
    private TextView n;

    public z(DailyRecommendActivity dailyRecommendActivity, com.baidu.adp.widget.ListView.r rVar, q qVar) {
        super(dailyRecommendActivity);
        this.f2294a = dailyRecommendActivity;
        this.e = LayoutInflater.from(this.b).inflate(R.layout.daily_recommend_view, (ViewGroup) null);
        this.f2294a.setContentView(this.e);
        this.c = (PinnedHeaderListView) this.e.findViewById(R.id.pinnedHeaderListview);
        this.j = new h(dailyRecommendActivity, qVar);
        this.i = (TextView) this.e.findViewById(R.id.text_info);
        this.f = new bb(this.b);
        this.c.setPullRefresh(this.f);
        this.c.setAdapter((ListAdapter) this.j);
        this.c.setOnSrollToBottomListener(rVar);
        this.d = (ProgressBar) this.e.findViewById(R.id.progress);
        this.d.setVisibility(8);
        this.g = new PbListView(this.f2294a);
        this.g.a(new aa(this));
        this.h = this.g.b().findViewById(R.id.pb_more_view);
        this.k = this.e.findViewById(R.id.title);
        this.l = (ImageView) this.e.findViewById(R.id.back);
        this.l.setOnClickListener(new ab(this));
        this.m = (ImageView) this.e.findViewById(R.id.home);
        this.n = (TextView) this.e.findViewById(R.id.title_text);
    }

    public void a() {
        this.g.c();
    }

    public void e() {
        this.d.setVisibility(0);
    }

    public void a(boolean z, String str) {
        this.d.setVisibility(8);
        if (!z && str != null) {
            this.f2294a.a(str);
        }
    }

    public void f() {
        this.d.setVisibility(8);
        this.g.d();
    }

    public void a(com.baidu.tieba.data.o oVar) {
        this.c.a();
        this.g.d();
        if (oVar != null) {
            if (oVar.b().size() > 0) {
                this.c.setNextPage(this.g);
            }
            this.j.a(oVar);
            this.j.a();
        }
    }

    public void g() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.custom_home_text_info);
        this.i.setVisibility(0);
        loadAnimation.setAnimationListener(new ac(this));
        this.i.startAnimation(loadAnimation);
    }

    public void h() {
        int headerViewsCount = this.c.getHeaderViewsCount() + 1;
        int firstVisiblePosition = this.c.getFirstVisiblePosition();
        int lastVisiblePosition = this.c.getLastVisiblePosition();
        if (firstVisiblePosition > 0) {
            firstVisiblePosition -= headerViewsCount;
            lastVisiblePosition -= headerViewsCount;
        }
        this.j.a(this.c, firstVisiblePosition, lastVisiblePosition);
    }

    public void a(int i) {
        com.baidu.tieba.util.bb.a(this.l, i);
        com.baidu.tieba.util.bb.a(this.m, i);
        com.baidu.tieba.util.bb.d(this.k, i);
        com.baidu.tieba.util.bb.f(this.n, i);
        com.baidu.tieba.util.bb.b(this.c, i);
        this.f.a(i);
        if (this.g != null) {
            this.g.a(i);
        }
        this.i.setTextColor(i == 1 ? -3380702 : -893399);
        this.i.setBackgroundResource(i == 1 ? R.drawable.bg_update_1 : R.drawable.bg_update);
        this.j.a();
    }

    public void i() {
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.f.a(bVar);
    }
}
