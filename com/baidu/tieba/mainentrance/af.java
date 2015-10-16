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
    final /* synthetic */ SquareSearchActivity bVC;
    private final /* synthetic */ TextView bVD;
    private final /* synthetic */ ImageView bVE;
    private final /* synthetic */ TextView bVF;
    private final /* synthetic */ ImageView bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.bVC = squareSearchActivity;
        this.bVD = textView;
        this.bVE = imageView;
        this.bVF = textView2;
        this.bVG = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        this.bVC.bVd = true;
        this.bVD.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_c));
        this.bVE.setVisibility(8);
        this.bVF.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_a));
        this.bVG.setVisibility(0);
        view2 = this.bVC.bUF;
        view2.setVisibility(8);
        fragmentTabIndicator = this.bVC.bUw;
        fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.bVC.bUw;
        fragmentTabIndicator2.cP(TbadkCoreApplication.m411getInst().getSkinType());
        this.bVC.abl();
        if (!TextUtils.isEmpty(this.bVC.bUV)) {
            this.bVC.G(1, this.bVC.bUV);
        }
        TiebaStatic.eventStat(this.bVC.getPageContext().getPageActivity(), "search_3", "click", 1, new Object[0]);
    }
}
