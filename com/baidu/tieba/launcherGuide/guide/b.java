package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.launcherGuide.a.a;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class b implements a.b {
    final /* synthetic */ NewUserGuideActivity cib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewUserGuideActivity newUserGuideActivity) {
        this.cib = newUserGuideActivity;
    }

    @Override // com.baidu.tieba.launcherGuide.a.a.b
    public void a(InterestFrsData interestFrsData) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        com.baidu.tieba.launcherGuide.a.a aVar2;
        RightSlideViewPager rightSlideViewPager;
        aVar = this.cib.chV;
        aVar.ej(false);
        aVar2 = this.cib.chV;
        aVar2.e(interestFrsData);
        rightSlideViewPager = this.cib.chZ;
        ((k) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(1)).c(interestFrsData);
    }

    @Override // com.baidu.tieba.launcherGuide.a.a.b
    public void b(InterestFrsData interestFrsData) {
        com.baidu.tieba.launcherGuide.a.a aVar;
        com.baidu.tieba.launcherGuide.a.a aVar2;
        aVar = this.cib.chV;
        aVar.ej(true);
        aVar2 = this.cib.chV;
        aVar2.e(null);
        this.cib.showToast(n.i.neterror);
    }
}
