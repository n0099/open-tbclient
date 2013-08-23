package com.baidu.tieba.recommend;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ChildViewPager;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.view.f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1684a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f1684a = hVar;
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
        dailyRecommendBannerPagerAdapter = this.f1684a.g;
        if (dailyRecommendBannerPagerAdapter != null) {
            dailyRecommendBannerPagerAdapter2 = this.f1684a.g;
            int size = dailyRecommendBannerPagerAdapter2.f1670a.size();
            childViewPager = this.f1684a.f;
            if (size > childViewPager.getCurrentItem()) {
                dailyRecommendBannerPagerAdapter3 = this.f1684a.g;
                ArrayList arrayList = dailyRecommendBannerPagerAdapter3.f1670a;
                childViewPager2 = this.f1684a.f;
                String str = (String) ((View) arrayList.get(childViewPager2.getCurrentItem())).getTag();
                if (!TextUtils.isEmpty(str)) {
                    activity = this.f1684a.i;
                    UtilHelper.a(activity, str, (String) null);
                    if (TiebaApplication.g().u()) {
                        activity2 = this.f1684a.i;
                        StatService.onEvent(activity2, "recommend_banner", "click");
                    }
                }
            }
        }
    }
}
