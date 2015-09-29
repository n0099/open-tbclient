package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.a.a;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
/* loaded from: classes.dex */
class b implements a.b {
    final /* synthetic */ NewUserGuideActivity bRj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewUserGuideActivity newUserGuideActivity) {
        this.bRj = newUserGuideActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.a.a.b
    public void a(InterestFrsData interestFrsData) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        com.baidu.tieba.launcherGuide.a.a aVar2;
        RightSlideViewPager rightSlideViewPager;
        aVar = this.bRj.bRd;
        aVar.dI(false);
        aVar2 = this.bRj.bRd;
        aVar2.e(interestFrsData);
        rightSlideViewPager = this.bRj.bRh;
        ((k) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(1)).c(interestFrsData);
    }

    @Override // com.baidu.tieba.launcherGuide.a.a.b
    public void b(InterestFrsData interestFrsData) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        com.baidu.tieba.launcherGuide.a.a aVar2;
        aVar = this.bRj.bRd;
        aVar.dI(true);
        aVar2 = this.bRj.bRd;
        aVar2.e(null);
        this.bRj.showToast(i.h.neterror);
    }
}
