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
    private TbImageView fiu;
    private TextView fiv;
    private TbPageContext mH;
    private View mRootView;

    public o(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mH = tbPageContext;
        this.mRootView.setTag(this);
        this.fiu = (TbImageView) this.mRootView.findViewById(d.h.gift_pic);
        this.fiv = (TextView) this.mRootView.findViewById(d.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.k(this.mRootView, d.e.cp_bg_line_d);
        aj.j(this.fiu, d.g.item_gift_selector);
        aj.k(this.fiv, d.e.common_color_10294);
        aj.i(this.fiv, d.e.cp_link_tip_a);
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
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        this.fiu.c(pVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (pVar.fgZ > 0) {
            this.fiv.setVisibility(0);
            if (pVar.fgZ > 99) {
                this.fiv.setText("99");
                return;
            } else {
                this.fiv.setText(String.valueOf(pVar.fgZ));
                return;
            }
        }
        this.fiv.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
