package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.launcherGuide.a.a;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements a.b {
    final /* synthetic */ NewUserGuideActivity cDm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewUserGuideActivity newUserGuideActivity) {
        this.cDm = newUserGuideActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.a.a.b
    public void a(InterestFrsData interestFrsData) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        com.baidu.tieba.launcherGuide.a.a aVar2;
        RightSlideViewPager rightSlideViewPager;
        aVar = this.cDm.cDg;
        aVar.eT(false);
        aVar2 = this.cDm.cDg;
        aVar2.e(interestFrsData);
        rightSlideViewPager = this.cDm.cDk;
        ((k) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(1)).c(interestFrsData);
    }

    @Override // com.baidu.tieba.launcherGuide.a.a.b
    public void b(InterestFrsData interestFrsData) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        com.baidu.tieba.launcherGuide.a.a aVar2;
        aVar = this.cDm.cDg;
        aVar.eT(true);
        aVar2 = this.cDm.cDg;
        aVar2.e(null);
        this.cDm.showToast(t.j.neterror);
    }
}
