package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.n> {
    private TbPageContext alI;
    private TbImageView flK;
    private TextView flL;
    private View mRootView;

    public o(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.alI = tbPageContext;
        this.mRootView.setTag(this);
        this.flK = (TbImageView) this.mRootView.findViewById(d.h.gift_pic);
        this.flL = (TextView) this.mRootView.findViewById(d.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ai.k(this.mRootView, d.e.cp_bg_line_d);
        ai.j(this.flK, d.g.item_gift_selector);
        ai.k(this.flL, d.e.common_color_10294);
        ai.i(this.flL, d.e.cp_link_tip_a);
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
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        this.flK.c(nVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (nVar.fkE > 0) {
            this.flL.setVisibility(0);
            if (nVar.fkE > 99) {
                this.flL.setText("99");
                return;
            } else {
                this.flL.setText(String.valueOf(nVar.fkE));
                return;
            }
        }
        this.flL.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
