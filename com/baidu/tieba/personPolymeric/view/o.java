package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.p> {
    private TbImageView fiJ;
    private TextView fiK;
    private TbPageContext mG;
    private View mRootView;

    public o(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mG = tbPageContext;
        this.mRootView.setTag(this);
        this.fiJ = (TbImageView) this.mRootView.findViewById(d.h.gift_pic);
        this.fiK = (TextView) this.mRootView.findViewById(d.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.k(this.mRootView, d.e.cp_bg_line_d);
        aj.j(this.fiJ, d.g.item_gift_selector);
        aj.k(this.fiK, d.e.common_color_10294);
        aj.i(this.fiK, d.e.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.p pVar) {
        if (pVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        this.fiJ.c(pVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (pVar.fhn > 0) {
            this.fiK.setVisibility(0);
            if (pVar.fhn > 99) {
                this.fiK.setText("99");
                return;
            } else {
                this.fiK.setText(String.valueOf(pVar.fhn));
                return;
            }
        }
        this.fiK.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
