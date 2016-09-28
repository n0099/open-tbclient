package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements FragmentTabWidget.a {
    final /* synthetic */ z dtY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.dtY = zVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        bf bfVar;
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        int i2;
        int i3;
        bfVar = this.dtY.dtC;
        bfVar.azG();
        customViewPager = this.dtY.dtW;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.dtY.dtV;
        fragmentTabWidget.g(i, true);
        this.dtY.cEd = i;
        i2 = this.dtY.cEd;
        if (i2 != 0) {
            i3 = this.dtY.cEd;
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
