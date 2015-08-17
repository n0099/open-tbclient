package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements FragmentTabWidget.a {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
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
            this.bQZ.hJ(0);
            fragmentTabWidget3 = this.bQZ.bPW;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator6 = this.bQZ.bPX;
            fragmentTabIndicator6.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
            fragmentTabIndicator7 = this.bQZ.bPX;
            fragmentTabIndicator7.cI(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (z && this.bQZ.mMode == 1) {
                view = this.bQZ.bQg;
                if (view.getVisibility() == 0) {
                    view2 = this.bQZ.bQg;
                    view2.setVisibility(8);
                    this.bQZ.ZU();
                    fragmentTabIndicator5 = this.bQZ.bPX;
                    fragmentTabIndicator5.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
                } else {
                    this.bQZ.aag();
                    fragmentTabIndicator3 = this.bQZ.bPX;
                    fragmentTabIndicator3.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_up);
                }
                fragmentTabIndicator4 = this.bQZ.bPX;
                fragmentTabIndicator4.cI(TbadkCoreApplication.m411getInst().getSkinType());
            }
            this.bQZ.hJ(1);
            fragmentTabWidget2 = this.bQZ.bPW;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bQZ.hJ(3);
            fragmentTabWidget = this.bQZ.bPW;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.bQZ.bPX;
            fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.bQZ.bPX;
            fragmentTabIndicator2.cI(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
