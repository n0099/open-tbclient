package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements FragmentTabWidget.a {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.bWd = squareSearchActivity;
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
            this.bWd.ip(0);
            fragmentTabWidget3 = this.bWd.bUW;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator7 = this.bWd.bUX;
            fragmentTabIndicator7.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
            fragmentTabIndicator8 = this.bWd.bUX;
            fragmentTabIndicator8.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (!z || this.bWd.mMode != 1) {
                fragmentTabIndicator3 = this.bWd.bUX;
                fragmentTabIndicator3.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down_s);
            } else {
                view = this.bWd.bVg;
                if (view.getVisibility() == 0) {
                    view2 = this.bWd.bVg;
                    view2.setVisibility(8);
                    this.bWd.abC();
                    fragmentTabIndicator6 = this.bWd.bUX;
                    fragmentTabIndicator6.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down_s);
                } else {
                    this.bWd.abQ();
                    fragmentTabIndicator5 = this.bWd.bUX;
                    fragmentTabIndicator5.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_up_s);
                }
            }
            fragmentTabIndicator4 = this.bWd.bUX;
            fragmentTabIndicator4.cP(TbadkCoreApplication.m411getInst().getSkinType());
            this.bWd.ip(1);
            fragmentTabWidget2 = this.bWd.bUW;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bWd.ip(3);
            fragmentTabWidget = this.bWd.bUW;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.bWd.bUX;
            fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.bWd.bUX;
            fragmentTabIndicator2.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
