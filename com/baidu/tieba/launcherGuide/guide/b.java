package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.launcherGuide.a.c {
    final /* synthetic */ NewUserGuideActivity bwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewUserGuideActivity newUserGuideActivity) {
        this.bwm = newUserGuideActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.a.c
    public void a(InterestFrsData interestFrsData) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        com.baidu.tieba.launcherGuide.a.a aVar2;
        RightSlideViewPager rightSlideViewPager;
        aVar = this.bwm.bwg;
        aVar.dr(false);
        aVar2 = this.bwm.bwg;
        aVar2.e(interestFrsData);
        rightSlideViewPager = this.bwm.bwk;
        ((m) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(1)).c(interestFrsData);
    }

    @Override // com.baidu.tieba.launcherGuide.a.c
    public void b(InterestFrsData interestFrsData) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        com.baidu.tieba.launcherGuide.a.a aVar2;
        aVar = this.bwm.bwg;
        aVar.dr(true);
        aVar2 = this.bwm.bwg;
        aVar2.e(null);
        this.bwm.showToast(y.neterror);
    }
}
