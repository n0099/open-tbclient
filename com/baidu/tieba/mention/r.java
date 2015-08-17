package com.baidu.tieba.mention;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements FragmentTabWidget.a {
    final /* synthetic */ n bVW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.bVW = nVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        ViewPager viewPager;
        FragmentTabWidget fragmentTabWidget;
        viewPager = this.bVW.bVT;
        viewPager.setCurrentItem(i);
        fragmentTabWidget = this.bVW.bVS;
        fragmentTabWidget.d(i, true);
        this.bVW.bVV = i;
    }
}
