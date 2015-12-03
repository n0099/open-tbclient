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
    private View aWS;
    private View ckY;
    private TextView ckZ;

    public void hide() {
        this.ckZ.setVisibility(8);
        this.aWS.setVisibility(8);
    }

    public void show() {
        this.ckZ.setVisibility(0);
        this.aWS.setVisibility(0);
    }

    public View getView() {
        return this.ckY;
    }

    public h(TbPageContext<?> tbPageContext) {
        this.ckY = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(n.g.square_search_recommand_fourm_header, (ViewGroup) null);
        this.ckZ = (TextView) this.ckY.findViewById(n.f.square_search_fourm_header_text);
        this.aWS = this.ckY.findViewById(n.f.titleDivider);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aWS.getLayoutParams();
        layoutParams.bottomMargin = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelOffset(n.d.ds10);
        this.aWS.setLayoutParams(layoutParams);
        this.ckZ.setText(tbPageContext.getResources().getText(n.i.hot_forum_title));
        hide();
    }
}
