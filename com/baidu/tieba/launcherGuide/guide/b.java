package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.launcherGuide.a.c {
    final /* synthetic */ NewUserGuideActivity bwC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewUserGuideActivity newUserGuideActivity) {
        this.bwC = newUserGuideActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.a.c
    public void a(InterestFrsData interestFrsData) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        com.baidu.tieba.launcherGuide.a.a aVar2;
        RightSlideViewPager rightSlideViewPager;
        aVar = this.bwC.bww;
        aVar.dp(false);
        aVar2 = this.bwC.bww;
        aVar2.e(interestFrsData);
        rightSlideViewPager = this.bwC.bwA;
        ((m) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(1)).c(interestFrsData);
    }

    @Override // com.baidu.tieba.launcherGuide.a.c
    public void b(InterestFrsData interestFrsData) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        com.baidu.tieba.launcherGuide.a.a aVar2;
        aVar = this.bwC.bww;
        aVar.dp(true);
        aVar2 = this.bwC.bww;
        aVar2.e(null);
        this.bwC.showToast(y.neterror);
    }
}
