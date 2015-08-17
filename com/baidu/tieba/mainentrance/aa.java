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
public class aa implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bQZ;
    private final /* synthetic */ TextView bRa;
    private final /* synthetic */ ImageView bRb;
    private final /* synthetic */ TextView bRc;
    private final /* synthetic */ ImageView bRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.bQZ = squareSearchActivity;
        this.bRa = textView;
        this.bRb = imageView;
        this.bRc = textView2;
        this.bRd = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        this.bQZ.bQB = true;
        this.bRa.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
        this.bRb.setVisibility(8);
        this.bRc.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_a));
        this.bRd.setVisibility(0);
        view2 = this.bQZ.bQg;
        view2.setVisibility(8);
        fragmentTabIndicator = this.bQZ.bPX;
        fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down);
        fragmentTabIndicator2 = this.bQZ.bPX;
        fragmentTabIndicator2.cI(TbadkCoreApplication.m411getInst().getSkinType());
        this.bQZ.ZU();
        if (!TextUtils.isEmpty(this.bQZ.bQt)) {
            this.bQZ.G(1, this.bQZ.bQt);
        }
        TiebaStatic.eventStat(this.bQZ.getPageContext().getPageActivity(), "search_3", "click", 1, new Object[0]);
    }
}
