package com.baidu.tieba.mention;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements FragmentTabWidget.a {
    final /* synthetic */ n cba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.cba = nVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        ViewPager viewPager;
        FragmentTabWidget fragmentTabWidget;
        viewPager = this.cba.caX;
        viewPager.setCurrentItem(i);
        fragmentTabWidget = this.cba.caW;
        fragmentTabWidget.d(i, true);
        this.cba.caZ = i;
    }
}
