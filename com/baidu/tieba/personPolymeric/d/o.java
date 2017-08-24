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
    private TbImageView fnF;
    private TextView fnG;
    private View mRootView;
    private TbPageContext oW;

    public o(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.oW = tbPageContext;
        this.mRootView.setTag(this);
        this.fnF = (TbImageView) this.mRootView.findViewById(d.h.gift_pic);
        this.fnG = (TextView) this.mRootView.findViewById(d.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ai.k(this.mRootView, d.e.cp_bg_line_d);
        ai.j(this.fnF, d.g.item_gift_selector);
        ai.k(this.fnG, d.e.common_color_10294);
        ai.i(this.fnG, d.e.cp_link_tip_a);
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
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        this.fnF.c(nVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (nVar.fmz > 0) {
            this.fnG.setVisibility(0);
            if (nVar.fmz > 99) {
                this.fnG.setText("99");
                return;
            } else {
                this.fnG.setText(String.valueOf(nVar.fmz));
                return;
            }
        }
        this.fnG.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
