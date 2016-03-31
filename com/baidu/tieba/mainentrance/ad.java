package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cLU;
    private final /* synthetic */ TextView cLV;
    private final /* synthetic */ ImageView cLW;
    private final /* synthetic */ TextView cLX;
    private final /* synthetic */ ImageView cLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.cLU = squareSearchActivity;
        this.cLV = textView;
        this.cLW = imageView;
        this.cLX = textView2;
        this.cLY = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        this.cLU.cLv = false;
        this.cLV.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_a));
        this.cLW.setVisibility(0);
        this.cLX.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_c));
        this.cLY.setVisibility(8);
        view2 = this.cLU.cKX;
        view2.setVisibility(8);
        fragmentTabIndicator = this.cLU.cKO;
        fragmentTabIndicator.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.cLU.cKO;
        fragmentTabIndicator2.dn(TbadkCoreApplication.m411getInst().getSkinType());
        this.cLU.aoB();
        if (!TextUtils.isEmpty(this.cLU.cLn)) {
            this.cLU.D(1, this.cLU.cLn);
        }
        TiebaStatic.eventStat(this.cLU.getPageContext().getPageActivity(), "search_2", "click", 1, new Object[0]);
    }
}
