package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.view.BaseViewPager;
/* loaded from: classes.dex */
class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f2401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(GuideActivity guideActivity) {
        this.f2401a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseViewPager baseViewPager;
        int[] iArr;
        BaseViewPager baseViewPager2;
        baseViewPager = this.f2401a.f;
        int currentItem = baseViewPager.getCurrentItem();
        iArr = this.f2401a.c;
        if (currentItem != iArr.length - 1) {
            baseViewPager2 = this.f2401a.f;
            baseViewPager2.a(currentItem + 1, true);
        }
    }
}
