package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ View a;
    final /* synthetic */ DailyRecommendBannerPagerAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter, View view) {
        this.b = dailyRecommendBannerPagerAdapter;
        this.a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag;
        if (this.a != null && (findViewWithTag = this.a.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
