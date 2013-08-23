package com.baidu.tieba.recommend;

import android.view.View;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendBannerPagerAdapter f1696a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter, View view) {
        this.f1696a = dailyRecommendBannerPagerAdapter;
        this.b = view;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        View findViewWithTag;
        if (this.b != null && (findViewWithTag = this.b.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
