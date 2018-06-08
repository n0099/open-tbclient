package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.o> {
    private TbImageView fYB;
    private TextView fYC;
    private TbPageContext mPageContext;
    private View mRootView;

    public l(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.mRootView.setTag(this);
        this.fYB = (TbImageView) this.mRootView.findViewById(d.g.gift_pic);
        this.fYC = (TextView) this.mRootView.findViewById(d.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.j(this.mRootView, d.C0141d.cp_bg_line_d);
        al.i(this.fYB, d.f.item_gift_selector);
        al.j(this.fYC, d.C0141d.common_color_10294);
        al.h(this.fYC, d.C0141d.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.fYB.startLoad(oVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (oVar.giftNum > 0) {
            this.fYC.setVisibility(0);
            if (oVar.giftNum > 99) {
                this.fYC.setText("99");
                return;
            } else {
                this.fYC.setText(String.valueOf(oVar.giftNum));
                return;
            }
        }
        this.fYC.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
