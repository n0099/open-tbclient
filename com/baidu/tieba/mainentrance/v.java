package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ SquareSearchActivity bCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SquareSearchActivity squareSearchActivity) {
        this.bCF = squareSearchActivity;
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
            this.bCF.hf(0);
            fragmentTabWidget3 = this.bCF.bBI;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator6 = this.bCF.bBJ;
            fragmentTabIndicator6.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
            fragmentTabIndicator7 = this.bCF.bBJ;
            fragmentTabIndicator7.cz(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (z) {
                i2 = this.bCF.mMode;
                if (i2 == 1) {
                    view = this.bCF.bBS;
                    if (view.getVisibility() == 0) {
                        view2 = this.bCF.bBS;
                        view2.setVisibility(8);
                        this.bCF.Yo();
                        fragmentTabIndicator5 = this.bCF.bBJ;
                        fragmentTabIndicator5.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
                    } else {
                        this.bCF.YA();
                        fragmentTabIndicator3 = this.bCF.bBJ;
                        fragmentTabIndicator3.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_up);
                    }
                    fragmentTabIndicator4 = this.bCF.bBJ;
                    fragmentTabIndicator4.cz(TbadkCoreApplication.m411getInst().getSkinType());
                }
            }
            this.bCF.hf(1);
            fragmentTabWidget2 = this.bCF.bBI;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bCF.hf(3);
            fragmentTabWidget = this.bCF.bBI;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.bCF.bBJ;
            fragmentTabIndicator.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.bCF.bBJ;
            fragmentTabIndicator2.cz(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
