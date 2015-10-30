package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements FragmentTabWidget.a {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
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
            this.bVC.ib(0);
            fragmentTabWidget3 = this.bVC.bUv;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator7 = this.bVC.bUw;
            fragmentTabIndicator7.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
            fragmentTabIndicator8 = this.bVC.bUw;
            fragmentTabIndicator8.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (!z || this.bVC.mMode != 1) {
                fragmentTabIndicator3 = this.bVC.bUw;
                fragmentTabIndicator3.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down_s);
            } else {
                view = this.bVC.bUF;
                if (view.getVisibility() == 0) {
                    view2 = this.bVC.bUF;
                    view2.setVisibility(8);
                    this.bVC.abh();
                    fragmentTabIndicator6 = this.bVC.bUw;
                    fragmentTabIndicator6.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down_s);
                } else {
                    this.bVC.abv();
                    fragmentTabIndicator5 = this.bVC.bUw;
                    fragmentTabIndicator5.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_up_s);
                }
            }
            fragmentTabIndicator4 = this.bVC.bUw;
            fragmentTabIndicator4.cP(TbadkCoreApplication.m411getInst().getSkinType());
            this.bVC.ib(1);
            fragmentTabWidget2 = this.bVC.bUv;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bVC.ib(3);
            fragmentTabWidget = this.bVC.bUv;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.bVC.bUw;
            fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.bVC.bUw;
            fragmentTabIndicator2.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
