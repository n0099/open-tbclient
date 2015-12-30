package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cqu;
    private final /* synthetic */ TextView cqv;
    private final /* synthetic */ ImageView cqw;
    private final /* synthetic */ TextView cqx;
    private final /* synthetic */ ImageView cqy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.cqu = squareSearchActivity;
        this.cqv = textView;
        this.cqw = imageView;
        this.cqx = textView2;
        this.cqy = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        this.cqu.cpV = true;
        this.cqv.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_c));
        this.cqw.setVisibility(8);
        this.cqx.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_link_tip_a));
        this.cqy.setVisibility(0);
        view2 = this.cqu.cpw;
        view2.setVisibility(8);
        fragmentTabIndicator = this.cqu.cpn;
        fragmentTabIndicator.setCompoundDrawablesRightResId(n.f.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.cqu.cpn;
        fragmentTabIndicator2.cR(TbadkCoreApplication.m411getInst().getSkinType());
        this.cqu.agr();
        if (!TextUtils.isEmpty(this.cqu.cpN)) {
            this.cqu.I(1, this.cqu.cpN);
        }
        TiebaStatic.eventStat(this.cqu.getPageContext().getPageActivity(), "search_3", "click", 1, new Object[0]);
    }
}
