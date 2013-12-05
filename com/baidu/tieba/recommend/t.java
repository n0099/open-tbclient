package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbImageView f2424a;
    final /* synthetic */ DailyRecommendBannerPagerAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter, TbImageView tbImageView) {
        this.b = dailyRecommendBannerPagerAdapter;
        this.f2424a = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (this.f2424a != null) {
            this.f2424a.invalidate();
        }
    }
}
