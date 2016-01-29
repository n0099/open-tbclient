package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SquareSearchActivity squareSearchActivity) {
        this.cwZ = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        view2 = this.cwZ.cwc;
        view2.setVisibility(8);
        fragmentTabIndicator = this.cwZ.cvT;
        fragmentTabIndicator.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.cwZ.cvT;
        fragmentTabIndicator2.dk(TbadkCoreApplication.m411getInst().getSkinType());
    }
}
