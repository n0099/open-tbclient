package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h {
    private View aOM;
    private View cpc;
    private TextView cpd;

    public void hide() {
        this.cpd.setVisibility(8);
        this.aOM.setVisibility(8);
    }

    public void show() {
        this.cpd.setVisibility(0);
        this.aOM.setVisibility(0);
    }

    public View getView() {
        return this.cpc;
    }

    public h(TbPageContext<?> tbPageContext) {
        this.cpc = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(n.h.square_search_recommand_fourm_header, (ViewGroup) null);
        this.cpd = (TextView) this.cpc.findViewById(n.g.square_search_fourm_header_text);
        this.aOM = this.cpc.findViewById(n.g.titleDivider);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aOM.getLayoutParams();
        layoutParams.bottomMargin = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelOffset(n.e.ds10);
        this.aOM.setLayoutParams(layoutParams);
        this.cpd.setText(tbPageContext.getResources().getText(n.j.hot_forum_title));
        hide();
    }
}
