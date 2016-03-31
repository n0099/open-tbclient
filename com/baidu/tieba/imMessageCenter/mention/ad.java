package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements FragmentTabWidget.a {
    final /* synthetic */ z cxE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar) {
        this.cxE = zVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        be beVar;
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        int i2;
        int i3;
        beVar = this.cxE.cxj;
        beVar.aln();
        customViewPager = this.cxE.cxB;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.cxE.cxA;
        fragmentTabWidget.d(i, true);
        this.cxE.cxD = i;
        i2 = this.cxE.cxD;
        if (i2 != 0) {
            i3 = this.cxE.cxD;
            if (i3 == 1) {
                TiebaStatic.log("c10526");
                return;
            } else {
                TiebaStatic.log("c10527");
                return;
            }
        }
        TiebaStatic.log("c10525");
    }
}
