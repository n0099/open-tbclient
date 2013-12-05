package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.square.CarouselRecommendView;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ au f2539a;
    final /* synthetic */ int b;
    final /* synthetic */ CarouselRecommendView.CarouselRecommendPagerAdapter c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(CarouselRecommendView.CarouselRecommendPagerAdapter carouselRecommendPagerAdapter, au auVar, int i) {
        this.c = carouselRecommendPagerAdapter;
        this.f2539a = auVar;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String b = this.f2539a.b();
        String a2 = SquareActivity.a("carousel_recommend", String.valueOf(this.b));
        context = this.c.f;
        UtilHelper.a(context, b, null, a2);
    }
}
