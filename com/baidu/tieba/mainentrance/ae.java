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
public class ae implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bVr;
    private final /* synthetic */ TextView bVs;
    private final /* synthetic */ ImageView bVt;
    private final /* synthetic */ TextView bVu;
    private final /* synthetic */ ImageView bVv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.bVr = squareSearchActivity;
        this.bVs = textView;
        this.bVt = imageView;
        this.bVu = textView2;
        this.bVv = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        this.bVr.bUS = false;
        this.bVs.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_link_tip_a));
        this.bVt.setVisibility(0);
        this.bVu.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_c));
        this.bVv.setVisibility(8);
        view2 = this.bVr.bUu;
        view2.setVisibility(8);
        fragmentTabIndicator = this.bVr.bUl;
        fragmentTabIndicator.setCompoundDrawablesRightResId(i.e.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.bVr.bUl;
        fragmentTabIndicator2.cP(TbadkCoreApplication.m411getInst().getSkinType());
        this.bVr.abl();
        if (!TextUtils.isEmpty(this.bVr.bUK)) {
            this.bVr.G(1, this.bVr.bUK);
        }
        TiebaStatic.eventStat(this.bVr.getPageContext().getPageActivity(), "search_2", "click", 1, new Object[0]);
    }
}
