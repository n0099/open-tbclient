package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.view.BaseViewPager;
/* loaded from: classes.dex */
class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f2652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(GuideActivity guideActivity) {
        this.f2652a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseViewPager baseViewPager;
        int[] iArr;
        BaseViewPager baseViewPager2;
        baseViewPager = this.f2652a.h;
        int currentItem = baseViewPager.getCurrentItem();
        iArr = this.f2652a.e;
        if (currentItem != iArr.length - 1) {
            baseViewPager2 = this.f2652a.h;
            baseViewPager2.a(currentItem + 1, true);
        }
    }
}
