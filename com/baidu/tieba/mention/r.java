package com.baidu.tieba.mention;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements FragmentTabWidget.a {
    final /* synthetic */ n bWC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.bWC = nVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        ViewPager viewPager;
        FragmentTabWidget fragmentTabWidget;
        viewPager = this.bWC.bWz;
        viewPager.setCurrentItem(i);
        fragmentTabWidget = this.bWC.bWy;
        fragmentTabWidget.d(i, true);
        this.bWC.bWB = i;
    }
}
