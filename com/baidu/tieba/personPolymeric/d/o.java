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
    private TbImageView fnD;
    private TextView fnE;
    private View mRootView;
    private TbPageContext oV;

    public o(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.oV = tbPageContext;
        this.mRootView.setTag(this);
        this.fnD = (TbImageView) this.mRootView.findViewById(d.h.gift_pic);
        this.fnE = (TextView) this.mRootView.findViewById(d.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ai.k(this.mRootView, d.e.cp_bg_line_d);
        ai.j(this.fnD, d.g.item_gift_selector);
        ai.k(this.fnE, d.e.common_color_10294);
        ai.i(this.fnE, d.e.cp_link_tip_a);
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
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        this.fnD.c(nVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (nVar.fmx > 0) {
            this.fnE.setVisibility(0);
            if (nVar.fmx > 99) {
                this.fnE.setText("99");
                return;
            } else {
                this.fnE.setText(String.valueOf(nVar.fmx));
                return;
            }
        }
        this.fnE.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
