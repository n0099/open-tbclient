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
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.a.d {
    private DailyRecommendFragment b;
    private PinnedHeaderListView c;
    private ProgressBar d;
    private View e;
    private com.baidu.tieba.view.bb f;
    private com.baidu.tieba.view.ba g;
    private View h;
    private TextView i;
    private c j;

    public ab(DailyRecommendFragment dailyRecommendFragment, com.baidu.adp.widget.ListView.r rVar, l lVar) {
        super(dailyRecommendFragment.g());
        this.b = dailyRecommendFragment;
        this.e = LayoutInflater.from(this.f343a).inflate(R.layout.daily_recommend_view, (ViewGroup) null);
        this.c = (PinnedHeaderListView) this.e.findViewById(R.id.pinnedHeaderListview);
        this.j = new c(dailyRecommendFragment.g(), lVar);
        this.i = (TextView) this.e.findViewById(R.id.text_info);
        this.f = new com.baidu.tieba.view.bb(this.f343a);
        this.c.setPullRefresh(this.f);
        this.c.setAdapter((ListAdapter) this.j);
        this.c.setOnSrollToBottomListener(rVar);
        this.d = (ProgressBar) this.e.findViewById(R.id.progress);
        this.d.setVisibility(8);
        this.g = new com.baidu.tieba.view.ba(this.b.g());
        this.g.a(new ac(this));
        this.h = this.g.b().findViewById(R.id.pb_more_view);
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
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f343a, R.anim.custom_home_text_info);
        this.i.setVisibility(0);
        loadAnimation.setAnimationListener(new ad(this));
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
        com.baidu.tieba.util.ah.b(this.c, i);
        this.f.a(i);
        com.baidu.tieba.util.ah.h(this.h, i == 1 ? R.drawable.bg_list_all_1 : R.drawable.bg_list_all);
        this.i.setTextColor(i == 1 ? -3380702 : -893399);
        this.i.setBackgroundResource(i == 1 ? R.drawable.bg_update_1 : R.drawable.bg_update);
        this.j.a();
    }

    public View g() {
        return this.e;
    }

    public void h() {
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.f.a(bVar);
    }
}
