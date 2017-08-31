package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.n> {
    private TbImageView fma;
    private TextView fmb;
    private TbPageContext mF;
    private View mRootView;

    public o(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mF = tbPageContext;
        this.mRootView.setTag(this);
        this.fma = (TbImageView) this.mRootView.findViewById(d.h.gift_pic);
        this.fmb = (TextView) this.mRootView.findViewById(d.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.k(this.mRootView, d.e.cp_bg_line_d);
        aj.j(this.fma, d.g.item_gift_selector);
        aj.k(this.fmb, d.e.common_color_10294);
        aj.i(this.fmb, d.e.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        if (nVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        this.fma.c(nVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (nVar.fkU > 0) {
            this.fmb.setVisibility(0);
            if (nVar.fkU > 99) {
                this.fmb.setText("99");
                return;
            } else {
                this.fmb.setText(String.valueOf(nVar.fkU));
                return;
            }
        }
        this.fmb.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
