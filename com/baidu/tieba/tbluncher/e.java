package com.baidu.tieba.tbluncher;

import android.view.View;
import com.baidu.tbadk.core.view.BaseViewPager;
/* loaded from: classes.dex */
final class e implements View.OnClickListener {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseViewPager baseViewPager;
        int[] iArr;
        BaseViewPager baseViewPager2;
        baseViewPager = this.a.i;
        int currentItem = baseViewPager.getCurrentItem();
        iArr = this.a.f;
        if (currentItem != iArr.length) {
            baseViewPager2 = this.a.i;
            baseViewPager2.setCurrentItem(currentItem + 1, true);
        }
    }
}
