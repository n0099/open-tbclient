package com.baidu.tieba.recommend;

import com.baidu.tieba.view.ADImageViewDrawer;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendBannerPagerAdapter f1674a;
    private final /* synthetic */ ADImageViewDrawer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter, ADImageViewDrawer aDImageViewDrawer) {
        this.f1674a = dailyRecommendBannerPagerAdapter;
        this.b = aDImageViewDrawer;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (this.b != null) {
            this.b.invalidate();
        }
    }
}
