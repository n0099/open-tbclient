package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements FragmentTabWidget.a {
    final /* synthetic */ SquareSearchActivity cqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.cqu = squareSearchActivity;
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
            this.cqu.jH(0);
            fragmentTabWidget3 = this.cqu.aUf;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator7 = this.cqu.cpn;
            fragmentTabIndicator7.setCompoundDrawablesRightResId(n.f.icon_toolbar_arrow_down);
            fragmentTabIndicator8 = this.cqu.cpn;
            fragmentTabIndicator8.cR(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (!z || this.cqu.mMode != 1) {
                fragmentTabIndicator3 = this.cqu.cpn;
                fragmentTabIndicator3.setCompoundDrawablesRightResId(n.f.icon_toolbar_arrow_down_s);
            } else {
                view = this.cqu.cpw;
                if (view.getVisibility() == 0) {
                    view2 = this.cqu.cpw;
                    view2.setVisibility(8);
                    this.cqu.agr();
                    fragmentTabIndicator6 = this.cqu.cpn;
                    fragmentTabIndicator6.setCompoundDrawablesRightResId(n.f.icon_toolbar_arrow_down_s);
                } else {
                    this.cqu.agF();
                    fragmentTabIndicator5 = this.cqu.cpn;
                    fragmentTabIndicator5.setCompoundDrawablesRightResId(n.f.icon_toolbar_arrow_up_s);
                }
            }
            fragmentTabIndicator4 = this.cqu.cpn;
            fragmentTabIndicator4.cR(TbadkCoreApplication.m411getInst().getSkinType());
            this.cqu.jH(1);
            fragmentTabWidget2 = this.cqu.aUf;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.cqu.jH(3);
            fragmentTabWidget = this.cqu.aUf;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.cqu.cpn;
            fragmentTabIndicator.setCompoundDrawablesRightResId(n.f.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.cqu.cpn;
            fragmentTabIndicator2.cR(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
