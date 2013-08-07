package com.baidu.tieba.recommend;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.ChildViewPager;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.view.f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1661a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1661a = cVar;
    }

    @Override // com.baidu.tieba.view.f
    public void a() {
        DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter;
        DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter2;
        ChildViewPager childViewPager;
        DailyRecommendBannerPagerAdapter dailyRecommendBannerPagerAdapter3;
        ChildViewPager childViewPager2;
        Activity activity;
        Activity activity2;
        dailyRecommendBannerPagerAdapter = this.f1661a.g;
        if (dailyRecommendBannerPagerAdapter != null) {
            dailyRecommendBannerPagerAdapter2 = this.f1661a.g;
            int size = dailyRecommendBannerPagerAdapter2.f1623a.size();
            childViewPager = this.f1661a.f;
            if (size > childViewPager.getCurrentItem()) {
                dailyRecommendBannerPagerAdapter3 = this.f1661a.g;
                ArrayList arrayList = dailyRecommendBannerPagerAdapter3.f1623a;
                childViewPager2 = this.f1661a.f;
                String str = (String) ((View) arrayList.get(childViewPager2.getCurrentItem())).getTag();
                if (!TextUtils.isEmpty(str)) {
                    activity = this.f1661a.i;
                    com.baidu.tieba.util.am.a(activity, str, (String) null);
                    if (TiebaApplication.f().t()) {
                        activity2 = this.f1661a.i;
                        StatService.onEvent(activity2, "recommend_banner", "click");
                    }
                }
            }
        }
    }
}
