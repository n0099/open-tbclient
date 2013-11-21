package com.baidu.tieba.recommend;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ChildViewPager;
import java.util.ArrayList;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.view.f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f2297a = hVar;
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
        dailyRecommendBannerPagerAdapter = this.f2297a.g;
        if (dailyRecommendBannerPagerAdapter != null) {
            dailyRecommendBannerPagerAdapter2 = this.f2297a.g;
            int size = dailyRecommendBannerPagerAdapter2.f2285a.size();
            childViewPager = this.f2297a.f;
            if (size > childViewPager.getCurrentItem()) {
                dailyRecommendBannerPagerAdapter3 = this.f2297a.g;
                ArrayList<View> arrayList = dailyRecommendBannerPagerAdapter3.f2285a;
                childViewPager2 = this.f2297a.f;
                String str = (String) arrayList.get(childViewPager2.getCurrentItem()).getTag();
                if (!TextUtils.isEmpty(str)) {
                    activity = this.f2297a.i;
                    UtilHelper.a(activity, str, null, null);
                    if (TiebaApplication.g().s()) {
                        activity2 = this.f2297a.i;
                        StatService.onEvent(activity2, "recommend_banner", "click");
                    }
                }
            }
        }
    }
}
