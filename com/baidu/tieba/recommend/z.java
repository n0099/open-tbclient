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
import com.baidu.tieba.util.ao;
import com.baidu.tieba.view.az;
import com.baidu.tieba.view.ba;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.a.d {
    private DailyRecommendActivity b;
    private PinnedHeaderListView c;
    private ProgressBar d;
    private View e;
    private ba f;
    private az g;
    private View h;
    private TextView i;
    private h j;
    private View k;
    private ImageView l;
    private ImageView m;
    private TextView n;

    public z(DailyRecommendActivity dailyRecommendActivity, com.baidu.adp.widget.ListView.r rVar, q qVar) {
        super(dailyRecommendActivity);
        this.b = dailyRecommendActivity;
        this.e = LayoutInflater.from(this.f347a).inflate(R.layout.daily_recommend_view, (ViewGroup) null);
        this.b.setContentView(this.e);
        this.c = (PinnedHeaderListView) this.e.findViewById(R.id.pinnedHeaderListview);
        this.j = new h(dailyRecommendActivity, qVar);
        this.i = (TextView) this.e.findViewById(R.id.text_info);
        this.f = new ba(this.f347a);
        this.c.setPullRefresh(this.f);
        this.c.setAdapter((ListAdapter) this.j);
        this.c.setOnSrollToBottomListener(rVar);
        this.d = (ProgressBar) this.e.findViewById(R.id.progress);
        this.d.setVisibility(8);
        this.g = new az(this.b);
        this.g.a(new aa(this));
        this.h = this.g.b().findViewById(R.id.pb_more_view);
        this.k = this.e.findViewById(R.id.title);
        this.l = (ImageView) this.e.findViewById(R.id.back);
        this.l.setOnClickListener(new ab(this));
        this.m = (ImageView) this.e.findViewById(R.id.home);
        this.n = (TextView) this.e.findViewById(R.id.title_text);
    }

    public void b() {
        this.g.c();
    }

    public void c() {
        this.d.setVisibility(0);
    }

    public void a(boolean z, String str) {
        this.d.setVisibility(8);
        if (!z && str != null) {
            this.b.a(str);
        }
    }

    public void d() {
        this.d.setVisibility(8);
        this.g.d();
    }

    public void a(com.baidu.tieba.data.n nVar) {
        this.c.a();
        this.g.d();
        if (nVar != null) {
            if (nVar.b().size() > 0) {
                this.c.setNextPage(this.g);
            }
            this.j.a(nVar);
            this.j.a();
        }
    }

    public void e() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f347a, R.anim.custom_home_text_info);
        this.i.setVisibility(0);
        loadAnimation.setAnimationListener(new ac(this));
        this.i.startAnimation(loadAnimation);
    }

    public void f() {
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
        ao.a(this.l, i);
        ao.a(this.m, i);
        ao.d(this.k, i);
        ao.f(this.n, i);
        ao.b(this.c, i);
        this.f.a(i);
        ao.g(this.h, i == 1 ? R.drawable.bg_list_all_1 : R.drawable.bg_list_all);
        this.i.setTextColor(i == 1 ? -3380702 : -893399);
        this.i.setBackgroundResource(i == 1 ? R.drawable.bg_update_1 : R.drawable.bg_update);
        this.j.a();
    }

    public void g() {
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.f.a(bVar);
    }
}
