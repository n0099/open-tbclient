package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        view2 = this.bVC.bUF;
        view2.setVisibility(8);
        fragmentTabIndicator = this.bVC.bUw;
        fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.bVC.bUw;
        fragmentTabIndicator2.cP(TbadkCoreApplication.m411getInst().getSkinType());
    }
}
