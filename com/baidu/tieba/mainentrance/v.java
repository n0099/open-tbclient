package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements FragmentTabWidget.a {
    final /* synthetic */ SquareSearchActivity bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SquareSearchActivity squareSearchActivity) {
        this.bRF = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        FragmentTabWidget fragmentTabWidget;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        FragmentTabWidget fragmentTabWidget2;
        View view;
        FragmentTabIndicator fragmentTabIndicator3;
        FragmentTabIndicator fragmentTabIndicator4;
        View view2;
        FragmentTabIndicator fragmentTabIndicator5;
        FragmentTabWidget fragmentTabWidget3;
        FragmentTabIndicator fragmentTabIndicator6;
        FragmentTabIndicator fragmentTabIndicator7;
        if (i == 0) {
            this.bRF.hT(0);
            fragmentTabWidget3 = this.bRF.bQC;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator6 = this.bRF.bQD;
            fragmentTabIndicator6.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
            fragmentTabIndicator7 = this.bRF.bQD;
            fragmentTabIndicator7.cO(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (z && this.bRF.mMode == 1) {
                view = this.bRF.bQM;
                if (view.getVisibility() == 0) {
                    view2 = this.bRF.bQM;
                    view2.setVisibility(8);
                    this.bRF.ZZ();
                    fragmentTabIndicator5 = this.bRF.bQD;
                    fragmentTabIndicator5.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
                } else {
                    this.bRF.aal();
                    fragmentTabIndicator3 = this.bRF.bQD;
                    fragmentTabIndicator3.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_up);
                }
                fragmentTabIndicator4 = this.bRF.bQD;
                fragmentTabIndicator4.cO(TbadkCoreApplication.m411getInst().getSkinType());
            }
            this.bRF.hT(1);
            fragmentTabWidget2 = this.bRF.bQC;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bRF.hT(3);
            fragmentTabWidget = this.bRF.bQC;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.bRF.bQD;
            fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.bRF.bQD;
            fragmentTabIndicator2.cO(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
