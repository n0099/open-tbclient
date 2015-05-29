package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        FragmentTabWidget fragmentTabWidget;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        FragmentTabWidget fragmentTabWidget2;
        int i2;
        View view;
        FragmentTabIndicator fragmentTabIndicator3;
        FragmentTabIndicator fragmentTabIndicator4;
        View view2;
        FragmentTabIndicator fragmentTabIndicator5;
        FragmentTabWidget fragmentTabWidget3;
        FragmentTabIndicator fragmentTabIndicator6;
        FragmentTabIndicator fragmentTabIndicator7;
        if (i == 0) {
            this.bCE.hf(0);
            fragmentTabWidget3 = this.bCE.bBH;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator6 = this.bCE.bBI;
            fragmentTabIndicator6.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
            fragmentTabIndicator7 = this.bCE.bBI;
            fragmentTabIndicator7.cz(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (z) {
                i2 = this.bCE.mMode;
                if (i2 == 1) {
                    view = this.bCE.bBR;
                    if (view.getVisibility() == 0) {
                        view2 = this.bCE.bBR;
                        view2.setVisibility(8);
                        this.bCE.Yn();
                        fragmentTabIndicator5 = this.bCE.bBI;
                        fragmentTabIndicator5.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
                    } else {
                        this.bCE.Yz();
                        fragmentTabIndicator3 = this.bCE.bBI;
                        fragmentTabIndicator3.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_up);
                    }
                    fragmentTabIndicator4 = this.bCE.bBI;
                    fragmentTabIndicator4.cz(TbadkCoreApplication.m411getInst().getSkinType());
                }
            }
            this.bCE.hf(1);
            fragmentTabWidget2 = this.bCE.bBH;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bCE.hf(3);
            fragmentTabWidget = this.bCE.bBH;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.bCE.bBI;
            fragmentTabIndicator.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.bCE.bBI;
            fragmentTabIndicator2.cz(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
