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
public class af implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bWd;
    private final /* synthetic */ TextView bWe;
    private final /* synthetic */ ImageView bWf;
    private final /* synthetic */ TextView bWg;
    private final /* synthetic */ ImageView bWh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.bWd = squareSearchActivity;
        this.bWe = textView;
        this.bWf = imageView;
        this.bWg = textView2;
        this.bWh = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        this.bWd.bVE = true;
        this.bWe.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_c));
        this.bWf.setVisibility(8);
        this.bWg.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_a));
        this.bWh.setVisibility(0);
        view2 = this.bWd.bVg;
        view2.setVisibility(8);
        fragmentTabIndicator = this.bWd.bUX;
        fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.bWd.bUX;
        fragmentTabIndicator2.cP(TbadkCoreApplication.m411getInst().getSkinType());
        this.bWd.abC();
        if (!TextUtils.isEmpty(this.bWd.bVw)) {
            this.bWd.H(1, this.bWd.bVw);
        }
        TiebaStatic.eventStat(this.bWd.getPageContext().getPageActivity(), "search_3", "click", 1, new Object[0]);
    }
}
