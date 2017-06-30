package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.n> {
    private TbPageContext ajP;
    private TbImageView eXN;
    private TextView eXO;
    private View mRootView;

    public u(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.ajP = tbPageContext;
        this.mRootView.setTag(this);
        this.eXN = (TbImageView) this.mRootView.findViewById(w.h.gift_pic);
        this.eXO = (TextView) this.mRootView.findViewById(w.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        as.k(this.mRootView, w.e.cp_bg_line_d);
        as.j(this.eXN, w.g.item_gift_selector);
        as.k(this.eXO, w.e.common_color_10294);
        as.i(this.eXO, w.e.cp_link_tip_a);
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
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        this.eXN.c(nVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (nVar.eWQ > 0) {
            this.eXO.setVisibility(0);
            if (nVar.eWQ > 99) {
                this.eXO.setText("99");
                return;
            } else {
                this.eXO.setText(String.valueOf(nVar.eWQ));
                return;
            }
        }
        this.eXO.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
