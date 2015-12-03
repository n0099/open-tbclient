package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements FragmentTabWidget.a {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
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
            this.cmr.jj(0);
            fragmentTabWidget3 = this.cmr.aQn;
            fragmentTabWidget3.d(i, true);
            fragmentTabIndicator7 = this.cmr.clj;
            fragmentTabIndicator7.setCompoundDrawablesRightResId(n.e.icon_toolbar_arrow_down);
            fragmentTabIndicator8 = this.cmr.clj;
            fragmentTabIndicator8.cX(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (i == 1) {
            if (!z || this.cmr.mMode != 1) {
                fragmentTabIndicator3 = this.cmr.clj;
                fragmentTabIndicator3.setCompoundDrawablesRightResId(n.e.icon_toolbar_arrow_down_s);
            } else {
                view = this.cmr.cls;
                if (view.getVisibility() == 0) {
                    view2 = this.cmr.cls;
                    view2.setVisibility(8);
                    this.cmr.afi();
                    fragmentTabIndicator6 = this.cmr.clj;
                    fragmentTabIndicator6.setCompoundDrawablesRightResId(n.e.icon_toolbar_arrow_down_s);
                } else {
                    this.cmr.afw();
                    fragmentTabIndicator5 = this.cmr.clj;
                    fragmentTabIndicator5.setCompoundDrawablesRightResId(n.e.icon_toolbar_arrow_up_s);
                }
            }
            fragmentTabIndicator4 = this.cmr.clj;
            fragmentTabIndicator4.cX(TbadkCoreApplication.m411getInst().getSkinType());
            this.cmr.jj(1);
            fragmentTabWidget2 = this.cmr.aQn;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.cmr.jj(3);
            fragmentTabWidget = this.cmr.aQn;
            fragmentTabWidget.d(i, true);
            fragmentTabIndicator = this.cmr.clj;
            fragmentTabIndicator.setCompoundDrawablesRightResId(n.e.icon_toolbar_arrow_down);
            fragmentTabIndicator2 = this.cmr.clj;
            fragmentTabIndicator2.cX(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
