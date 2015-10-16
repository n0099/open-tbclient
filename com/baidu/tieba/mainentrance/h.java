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
    private View aRw;
    private View bUk;
    private TextView bUl;

    public void hide() {
        this.bUl.setVisibility(8);
        this.aRw.setVisibility(8);
    }

    public void show() {
        this.bUl.setVisibility(0);
        this.aRw.setVisibility(0);
    }

    public View getView() {
        return this.bUk;
    }

    public h(TbPageContext<?> tbPageContext) {
        this.bUk = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.square_search_recommand_fourm_header, (ViewGroup) null);
        this.bUl = (TextView) this.bUk.findViewById(i.f.square_search_fourm_header_text);
        this.aRw = this.bUk.findViewById(i.f.titleDivider);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aRw.getLayoutParams();
        layoutParams.bottomMargin = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelOffset(i.d.ds10);
        this.aRw.setLayoutParams(layoutParams);
        this.bUl.setText(tbPageContext.getResources().getText(i.h.hot_forum_title));
        hide();
    }
}
