package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements FragmentTabWidget.a {
    final /* synthetic */ z cyD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.cyD = zVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void e(int i, boolean z) {
        bf bfVar;
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        int i2;
        int i3;
        bfVar = this.cyD.cyh;
        bfVar.alu();
        customViewPager = this.cyD.cyA;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.cyD.cyz;
        fragmentTabWidget.f(i, true);
        this.cyD.cyC = i;
        i2 = this.cyD.cyC;
        if (i2 != 0) {
            i3 = this.cyD.cyC;
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
