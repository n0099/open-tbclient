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
    private View aRE;
    private View bUL;
    private TextView bUM;

    public void hide() {
        this.bUM.setVisibility(8);
        this.aRE.setVisibility(8);
    }

    public void show() {
        this.bUM.setVisibility(0);
        this.aRE.setVisibility(0);
    }

    public View getView() {
        return this.bUL;
    }

    public h(TbPageContext<?> tbPageContext) {
        this.bUL = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.square_search_recommand_fourm_header, (ViewGroup) null);
        this.bUM = (TextView) this.bUL.findViewById(i.f.square_search_fourm_header_text);
        this.aRE = this.bUL.findViewById(i.f.titleDivider);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aRE.getLayoutParams();
        layoutParams.bottomMargin = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelOffset(i.d.ds10);
        this.aRE.setLayoutParams(layoutParams);
        this.bUM.setText(tbPageContext.getResources().getText(i.h.hot_forum_title));
        hide();
    }
}
