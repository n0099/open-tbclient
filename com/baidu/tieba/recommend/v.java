package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2324a;
    final /* synthetic */ DailyRecommendBannerPagerAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter, View view) {
        this.b = dailyRecommendBannerPagerAdapter;
        this.f2324a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag;
        if (this.f2324a != null && (findViewWithTag = this.f2324a.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
