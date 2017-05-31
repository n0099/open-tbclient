package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.n> {
    private TbPageContext ajh;
    private TbImageView eNE;
    private TextView eNF;
    private View mRootView;

    public u(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.ajh = tbPageContext;
        this.mRootView.setTag(this);
        this.eNE = (TbImageView) this.mRootView.findViewById(w.h.gift_pic);
        this.eNF = (TextView) this.mRootView.findViewById(w.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aq.k(this.mRootView, w.e.cp_bg_line_d);
        aq.j(this.eNE, w.g.item_gift_selector);
        aq.k(this.eNF, w.e.common_color_10294);
        aq.i(this.eNF, w.e.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        if (nVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        this.eNE.c(nVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (nVar.eMH > 0) {
            this.eNF.setVisibility(0);
            if (nVar.eMH > 99) {
                this.eNF.setText("99");
                return;
            } else {
                this.eNF.setText(String.valueOf(nVar.eMH));
                return;
            }
        }
        this.eNF.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
