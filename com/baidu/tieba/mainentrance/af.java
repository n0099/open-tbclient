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
    final /* synthetic */ SquareSearchActivity cmr;
    private final /* synthetic */ TextView cms;
    private final /* synthetic */ ImageView cmt;
    private final /* synthetic */ TextView cmu;
    private final /* synthetic */ ImageView cmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.cmr = squareSearchActivity;
        this.cms = textView;
        this.cmt = imageView;
        this.cmu = textView2;
        this.cmv = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        this.cmr.clR = true;
        this.cms.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_c));
        this.cmt.setVisibility(8);
        this.cmu.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_link_tip_a));
        this.cmv.setVisibility(0);
        view2 = this.cmr.cls;
        view2.setVisibility(8);
        fragmentTabIndicator = this.cmr.clj;
        fragmentTabIndicator.setCompoundDrawablesRightResId(n.e.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.cmr.clj;
        fragmentTabIndicator2.cX(TbadkCoreApplication.m411getInst().getSkinType());
        this.cmr.afi();
        if (!TextUtils.isEmpty(this.cmr.clJ)) {
            this.cmr.I(1, this.cmr.clJ);
        }
        TiebaStatic.eventStat(this.cmr.getPageContext().getPageActivity(), "search_3", "click", 1, new Object[0]);
    }
}
