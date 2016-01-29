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
    final /* synthetic */ SquareSearchActivity cwZ;
    private final /* synthetic */ TextView cxa;
    private final /* synthetic */ ImageView cxb;
    private final /* synthetic */ TextView cxc;
    private final /* synthetic */ ImageView cxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.cwZ = squareSearchActivity;
        this.cxa = textView;
        this.cxb = imageView;
        this.cxc = textView2;
        this.cxd = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        this.cwZ.cwA = false;
        this.cxa.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_a));
        this.cxb.setVisibility(0);
        this.cxc.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_c));
        this.cxd.setVisibility(8);
        view2 = this.cwZ.cwc;
        view2.setVisibility(8);
        fragmentTabIndicator = this.cwZ.cvT;
        fragmentTabIndicator.setCompoundDrawablesRightResId(t.f.icon_toolbar_arrow_down_s);
        fragmentTabIndicator2 = this.cwZ.cvT;
        fragmentTabIndicator2.dk(TbadkCoreApplication.m411getInst().getSkinType());
        this.cwZ.aks();
        if (!TextUtils.isEmpty(this.cwZ.cws)) {
            this.cwZ.K(1, this.cwZ.cws);
        }
        TiebaStatic.eventStat(this.cwZ.getPageContext().getPageActivity(), "search_2", "click", 1, new Object[0]);
    }
}
