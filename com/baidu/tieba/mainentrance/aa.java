package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bCE;
    private final /* synthetic */ TextView bCF;
    private final /* synthetic */ ImageView bCG;
    private final /* synthetic */ TextView bCH;
    private final /* synthetic */ ImageView bCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.bCE = squareSearchActivity;
        this.bCF = textView;
        this.bCG = imageView;
        this.bCH = textView2;
        this.bCI = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        String str;
        String str2;
        this.bCE.bCo = false;
        this.bCF.setTextColor(ay.getColor(com.baidu.tieba.n.cp_link_tip_a));
        this.bCG.setVisibility(0);
        this.bCH.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        this.bCI.setVisibility(8);
        view2 = this.bCE.bBR;
        view2.setVisibility(8);
        fragmentTabIndicator = this.bCE.bBI;
        fragmentTabIndicator.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        fragmentTabIndicator2 = this.bCE.bBI;
        fragmentTabIndicator2.cz(TbadkCoreApplication.m411getInst().getSkinType());
        this.bCE.Yn();
        str = this.bCE.bCf;
        if (!TextUtils.isEmpty(str)) {
            SquareSearchActivity squareSearchActivity = this.bCE;
            str2 = this.bCE.bCf;
            squareSearchActivity.z(1, str2);
        }
        TiebaStatic.eventStat(this.bCE.getPageContext().getPageActivity(), "search_2", "click", 1, new Object[0]);
    }
}
