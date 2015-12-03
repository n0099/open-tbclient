package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements FragmentTabWidget.a {
    final /* synthetic */ y ceA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.ceA = yVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        bc bcVar;
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        bcVar = this.ceA.ceg;
        bcVar.adC();
        customViewPager = this.ceA.cex;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.ceA.cew;
        fragmentTabWidget.d(i, true);
        this.ceA.cez = i;
    }
}
