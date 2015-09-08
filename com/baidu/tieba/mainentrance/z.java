package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bRF;
    private final /* synthetic */ TextView bRG;
    private final /* synthetic */ ImageView bRH;
    private final /* synthetic */ TextView bRI;
    private final /* synthetic */ ImageView bRJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.bRF = squareSearchActivity;
        this.bRG = textView;
        this.bRH = imageView;
        this.bRI = textView2;
        this.bRJ = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        this.bRF.bRh = false;
        this.bRG.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_a));
        this.bRH.setVisibility(0);
        this.bRI.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
        this.bRJ.setVisibility(8);
        view2 = this.bRF.bQM;
        view2.setVisibility(8);
        fragmentTabIndicator = this.bRF.bQD;
        fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        fragmentTabIndicator2 = this.bRF.bQD;
        fragmentTabIndicator2.cO(TbadkCoreApplication.m411getInst().getSkinType());
        this.bRF.ZZ();
        if (!TextUtils.isEmpty(this.bRF.bQZ)) {
            this.bRF.E(1, this.bRF.bQZ);
        }
        TiebaStatic.eventStat(this.bRF.getPageContext().getPageActivity(), "search_2", "click", 1, new Object[0]);
    }
}
