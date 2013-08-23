package com.baidu.tieba.recommend;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendBannerPagerAdapter f1695a;
    private final /* synthetic */ TbImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter, TbImageView tbImageView) {
        this.f1695a = dailyRecommendBannerPagerAdapter;
        this.b = tbImageView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (this.b != null) {
            this.b.invalidate();
        }
    }
}
