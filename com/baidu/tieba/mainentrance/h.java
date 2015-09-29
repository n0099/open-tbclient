package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h {
    private View aRl;
    private View bTZ;
    private TextView bUa;

    public void hide() {
        this.bUa.setVisibility(8);
        this.aRl.setVisibility(8);
    }

    public void show() {
        this.bUa.setVisibility(0);
        this.aRl.setVisibility(0);
    }

    public View getView() {
        return this.bTZ;
    }

    public h(TbPageContext<?> tbPageContext) {
        this.bTZ = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.square_search_recommand_fourm_header, (ViewGroup) null);
        this.bUa = (TextView) this.bTZ.findViewById(i.f.square_search_fourm_header_text);
        this.aRl = this.bTZ.findViewById(i.f.titleDivider);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aRl.getLayoutParams();
        layoutParams.bottomMargin = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelOffset(i.d.ds10);
        this.aRl.setLayoutParams(layoutParams);
        this.bUa.setText(tbPageContext.getResources().getText(i.h.hot_forum_title));
        hide();
    }
}
