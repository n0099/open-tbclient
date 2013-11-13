package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbImageView f2323a;
    final /* synthetic */ DailyRecommendBannerPagerAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter, TbImageView tbImageView) {
        this.b = dailyRecommendBannerPagerAdapter;
        this.f2323a = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (this.f2323a != null) {
            this.f2323a.invalidate();
        }
    }
}
