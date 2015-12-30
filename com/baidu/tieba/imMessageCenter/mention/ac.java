package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements FragmentTabWidget.a {
    final /* synthetic */ z ciC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.ciC = zVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        bd bdVar;
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        int i2;
        int i3;
        bdVar = this.ciC.cih;
        bdVar.aeK();
        customViewPager = this.ciC.ciz;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.ciC.ciy;
        fragmentTabWidget.d(i, true);
        this.ciC.ciB = i;
        i2 = this.ciC.ciB;
        if (i2 != 0) {
            i3 = this.ciC.ciB;
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
