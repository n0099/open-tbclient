package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.view.BaseViewPager;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseViewPager baseViewPager;
        int[] iArr;
        BaseViewPager baseViewPager2;
        baseViewPager = this.a.f;
        int currentItem = baseViewPager.getCurrentItem();
        iArr = this.a.c;
        if (currentItem != iArr.length - 1) {
            baseViewPager2 = this.a.f;
            baseViewPager2.a(currentItem + 1, true);
        }
    }
}
