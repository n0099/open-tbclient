package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.view.BaseViewPager;
/* loaded from: classes.dex */
class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f2712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(GuideActivity guideActivity) {
        this.f2712a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseViewPager baseViewPager;
        int[] iArr;
        BaseViewPager baseViewPager2;
        baseViewPager = this.f2712a.i;
        int currentItem = baseViewPager.getCurrentItem();
        iArr = this.f2712a.f;
        if (currentItem != iArr.length) {
            baseViewPager2 = this.f2712a.i;
            baseViewPager2.a(currentItem + 1, true);
        }
    }
}
