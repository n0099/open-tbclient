package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SquareSearchActivity squareSearchActivity) {
        this.cMQ = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        view2 = this.cMQ.cLT;
        view2.setVisibility(8);
        fragmentTabIndicator = this.cMQ.cLK;
        fragmentTabIndicator.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.cMQ.cLK;
        fragmentTabIndicator2.cV(TbadkCoreApplication.m11getInst().getSkinType());
    }
}
