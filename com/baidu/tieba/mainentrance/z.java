package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements FragmentTabWidget.a {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.cLU = squareSearchActivity;
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
            this.cLU.kQ(0);
            fragmentTabWidget3 = this.cLU.baV;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator7 = this.cLU.cKO;
            fragmentTabIndicator7.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down);
            fragmentTabIndicator8 = this.cLU.cKO;
            fragmentTabIndicator8.dn(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (!z || this.cLU.mMode != 1) {
                fragmentTabIndicator3 = this.cLU.cKO;
                fragmentTabIndicator3.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
            } else {
                view = this.cLU.cKX;
                if (view.getVisibility() == 0) {
                    view2 = this.cLU.cKX;
                    view2.setVisibility(8);
                    this.cLU.aoB();
                    fragmentTabIndicator6 = this.cLU.cKO;
                    fragmentTabIndicator6.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
                } else {
                    this.cLU.aoP();
                    fragmentTabIndicator5 = this.cLU.cKO;
                    fragmentTabIndicator5.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_up_s);
                }
            }
            fragmentTabIndicator4 = this.cLU.cKO;
            fragmentTabIndicator4.dn(TbadkCoreApplication.m411getInst().getSkinType());
            this.cLU.kQ(1);
            fragmentTabWidget2 = this.cLU.baV;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.cLU.kQ(3);
            fragmentTabWidget = this.cLU.baV;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.cLU.cKO;
            fragmentTabIndicator.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.cLU.cKO;
            fragmentTabIndicator2.dn(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
