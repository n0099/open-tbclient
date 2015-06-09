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
public class ab implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bCF;
    private final /* synthetic */ TextView bCG;
    private final /* synthetic */ ImageView bCH;
    private final /* synthetic */ TextView bCI;
    private final /* synthetic */ ImageView bCJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SquareSearchActivity squareSearchActivity, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.bCF = squareSearchActivity;
        this.bCG = textView;
        this.bCH = imageView;
        this.bCI = textView2;
        this.bCJ = imageView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        FragmentTabIndicator fragmentTabIndicator;
        FragmentTabIndicator fragmentTabIndicator2;
        String str;
        String str2;
        this.bCF.bCp = true;
        this.bCG.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        this.bCH.setVisibility(8);
        this.bCI.setTextColor(ay.getColor(com.baidu.tieba.n.cp_link_tip_a));
        this.bCJ.setVisibility(0);
        view2 = this.bCF.bBS;
        view2.setVisibility(8);
        fragmentTabIndicator = this.bCF.bBJ;
        fragmentTabIndicator.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        fragmentTabIndicator2 = this.bCF.bBJ;
        fragmentTabIndicator2.cz(TbadkCoreApplication.m411getInst().getSkinType());
        this.bCF.Yo();
        str = this.bCF.bCg;
        if (!TextUtils.isEmpty(str)) {
            SquareSearchActivity squareSearchActivity = this.bCF;
            str2 = this.bCF.bCg;
            squareSearchActivity.z(1, str2);
        }
        TiebaStatic.eventStat(this.bCF.getPageContext().getPageActivity(), "search_3", "click", 1, new Object[0]);
    }
}
