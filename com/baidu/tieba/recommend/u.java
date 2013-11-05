package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbImageView f2290a;
    final /* synthetic */ DailyRecommendBannerPagerAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter, TbImageView tbImageView) {
        this.b = dailyRecommendBannerPagerAdapter;
        this.f2290a = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (this.f2290a != null) {
            this.f2290a.invalidate();
        }
    }
}
