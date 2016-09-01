package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements FragmentTabWidget.a {
    final /* synthetic */ z dsB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.dsB = zVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        bf bfVar;
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        int i2;
        int i3;
        bfVar = this.dsB.dsf;
        bfVar.azi();
        customViewPager = this.dsB.dsz;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.dsB.dsy;
        fragmentTabWidget.g(i, true);
        this.dsB.cDz = i;
        i2 = this.dsB.cDz;
        if (i2 != 0) {
            i3 = this.dsB.cDz;
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
