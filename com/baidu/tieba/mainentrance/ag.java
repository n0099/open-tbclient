package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        view2 = this.cmr.cls;
        view2.setVisibility(8);
        fragmentTabIndicator = this.cmr.clj;
        fragmentTabIndicator.setCompoundDrawablesRightResId(n.e.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.cmr.clj;
        fragmentTabIndicator2.cX(TbadkCoreApplication.m411getInst().getSkinType());
    }
}
