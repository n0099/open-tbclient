package com.baidu.tieba.mention;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements FragmentTabWidget.a {
    final /* synthetic */ n cao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.cao = nVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        ViewPager viewPager;
        FragmentTabWidget fragmentTabWidget;
        viewPager = this.cao.cal;
        viewPager.setCurrentItem(i);
        fragmentTabWidget = this.cao.cak;
        fragmentTabWidget.d(i, true);
        this.cao.can = i;
    }
}
