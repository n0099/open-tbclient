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
    final /* synthetic */ SquareSearchActivity cMQ;
    private final /* synthetic */ TextView cMR;
    private final /* synthetic */ ImageView cMS;
    private final /* synthetic */ TextView cMT;
    private final /* synthetic */ ImageView cMU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.cMQ = squareSearchActivity;
        this.cMR = textView;
        this.cMS = imageView;
        this.cMT = textView2;
        this.cMU = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        this.cMQ.cMr = false;
        this.cMR.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_a));
        this.cMS.setVisibility(0);
        this.cMT.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_c));
        this.cMU.setVisibility(8);
        view2 = this.cMQ.cLT;
        view2.setVisibility(8);
        fragmentTabIndicator = this.cMQ.cLK;
        fragmentTabIndicator.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.cMQ.cLK;
        fragmentTabIndicator2.cW(TbadkCoreApplication.m11getInst().getSkinType());
        this.cMQ.aoF();
        if (!TextUtils.isEmpty(this.cMQ.cMj)) {
            this.cMQ.C(1, this.cMQ.cMj);
        }
        TiebaStatic.eventStat(this.cMQ.getPageContext().getPageActivity(), "search_2", "click", 1, new Object[0]);
    }
}
