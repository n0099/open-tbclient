package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements FragmentTabWidget.a {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.cwZ = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        FragmentTabWidget fragmentTabWidget;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        FragmentTabIndicator fragmentTabIndicator3;
        FragmentTabIndicator fragmentTabIndicator4;
        FragmentTabWidget fragmentTabWidget2;
        View view;
        FragmentTabIndicator fragmentTabIndicator5;
        View view2;
        FragmentTabIndicator fragmentTabIndicator6;
        FragmentTabWidget fragmentTabWidget3;
        FragmentTabIndicator fragmentTabIndicator7;
        FragmentTabIndicator fragmentTabIndicator8;
        if (i == 0) {
            this.cwZ.kh(0);
            fragmentTabWidget3 = this.cwZ.aWm;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator7 = this.cwZ.cvT;
            fragmentTabIndicator7.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down);
            fragmentTabIndicator8 = this.cwZ.cvT;
            fragmentTabIndicator8.dk(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (!z || this.cwZ.mMode != 1) {
                fragmentTabIndicator3 = this.cwZ.cvT;
                fragmentTabIndicator3.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
            } else {
                view = this.cwZ.cwc;
                if (view.getVisibility() == 0) {
                    view2 = this.cwZ.cwc;
                    view2.setVisibility(8);
                    this.cwZ.aks();
                    fragmentTabIndicator6 = this.cwZ.cvT;
                    fragmentTabIndicator6.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
                } else {
                    this.cwZ.akG();
                    fragmentTabIndicator5 = this.cwZ.cvT;
                    fragmentTabIndicator5.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_up_s);
                }
            }
            fragmentTabIndicator4 = this.cwZ.cvT;
            fragmentTabIndicator4.dk(TbadkCoreApplication.m411getInst().getSkinType());
            this.cwZ.kh(1);
            fragmentTabWidget2 = this.cwZ.aWm;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.cwZ.kh(3);
            fragmentTabWidget = this.cwZ.aWm;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.cwZ.cvT;
            fragmentTabIndicator.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.cwZ.cvT;
            fragmentTabIndicator2.dk(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
