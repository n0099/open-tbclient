package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements FragmentTabWidget.a {
    final /* synthetic */ SquareSearchActivity cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.cMQ = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void e(int i, boolean z) {
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
            this.cMQ.kx(0);
            fragmentTabWidget3 = this.cMQ.aXd;
            fragmentTabWidget3.f(i, true);
            fragmentTabIndicator7 = this.cMQ.cLK;
            fragmentTabIndicator7.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down);
            fragmentTabIndicator8 = this.cMQ.cLK;
            fragmentTabIndicator8.cV(TbadkCoreApplication.m11getInst().getSkinType());
        }
        if (i == 1) {
            if (!z || this.cMQ.mMode != 1) {
                fragmentTabIndicator3 = this.cMQ.cLK;
                fragmentTabIndicator3.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
            } else {
                view = this.cMQ.cLT;
                if (view.getVisibility() == 0) {
                    view2 = this.cMQ.cLT;
                    view2.setVisibility(8);
                    this.cMQ.aoI();
                    fragmentTabIndicator6 = this.cMQ.cLK;
                    fragmentTabIndicator6.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
                } else {
                    this.cMQ.aoW();
                    fragmentTabIndicator5 = this.cMQ.cLK;
                    fragmentTabIndicator5.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_up_s);
                }
            }
            fragmentTabIndicator4 = this.cMQ.cLK;
            fragmentTabIndicator4.cV(TbadkCoreApplication.m11getInst().getSkinType());
            this.cMQ.kx(1);
            fragmentTabWidget2 = this.cMQ.aXd;
            fragmentTabWidget2.f(i, true);
        }
        if (i == 2) {
            this.cMQ.kx(3);
            fragmentTabWidget = this.cMQ.aXd;
            fragmentTabWidget.f(i, true);
            fragmentTabIndicator = this.cMQ.cLK;
            fragmentTabIndicator.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.cMQ.cLK;
            fragmentTabIndicator2.cV(TbadkCoreApplication.m11getInst().getSkinType());
        }
    }
}
