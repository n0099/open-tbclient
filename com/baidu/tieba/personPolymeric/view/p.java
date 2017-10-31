package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.p> {
    private TbImageView frd;
    private TextView fre;
    private TbPageContext mPageContext;
    private View mRootView;

    public p(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.mRootView.setTag(this);
        this.frd = (TbImageView) this.mRootView.findViewById(d.g.gift_pic);
        this.fre = (TextView) this.mRootView.findViewById(d.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
        aj.j(this.frd, d.f.item_gift_selector);
        aj.k(this.fre, d.C0080d.common_color_10294);
        aj.i(this.fre, d.C0080d.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.p pVar) {
        if (pVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.frd.startLoad(pVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (pVar.fpy > 0) {
            this.fre.setVisibility(0);
            if (pVar.fpy > 99) {
                this.fre.setText("99");
                return;
            } else {
                this.fre.setText(String.valueOf(pVar.fpy));
                return;
            }
        }
        this.fre.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
