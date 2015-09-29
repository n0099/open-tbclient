package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements FragmentTabWidget.a {
    final /* synthetic */ SquareSearchActivity bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.bVr = squareSearchActivity;
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
            this.bVr.ib(0);
            fragmentTabWidget3 = this.bVr.bUk;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator7 = this.bVr.bUl;
            fragmentTabIndicator7.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
            fragmentTabIndicator8 = this.bVr.bUl;
            fragmentTabIndicator8.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (!z || this.bVr.mMode != 1) {
                fragmentTabIndicator3 = this.bVr.bUl;
                fragmentTabIndicator3.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down_s);
            } else {
                view = this.bVr.bUu;
                if (view.getVisibility() == 0) {
                    view2 = this.bVr.bUu;
                    view2.setVisibility(8);
                    this.bVr.abl();
                    fragmentTabIndicator6 = this.bVr.bUl;
                    fragmentTabIndicator6.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down_s);
                } else {
                    this.bVr.abz();
                    fragmentTabIndicator5 = this.bVr.bUl;
                    fragmentTabIndicator5.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_up_s);
                }
            }
            fragmentTabIndicator4 = this.bVr.bUl;
            fragmentTabIndicator4.cP(TbadkCoreApplication.m411getInst().getSkinType());
            this.bVr.ib(1);
            fragmentTabWidget2 = this.bVr.bUk;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bVr.ib(3);
            fragmentTabWidget = this.bVr.bUk;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.bVr.bUl;
            fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.bVr.bUl;
            fragmentTabIndicator2.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
