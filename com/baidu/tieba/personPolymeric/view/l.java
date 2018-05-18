package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.o> {
    private TbImageView fNp;
    private TextView fNq;
    private TbPageContext mPageContext;
    private View mRootView;

    public l(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.mRootView.setTag(this);
        this.fNp = (TbImageView) this.mRootView.findViewById(d.g.gift_pic);
        this.fNq = (TextView) this.mRootView.findViewById(d.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
        ak.i(this.fNp, d.f.item_gift_selector);
        ak.j(this.fNq, d.C0126d.common_color_10294);
        ak.h(this.fNq, d.C0126d.cp_link_tip_a);
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
        this.fNp.startLoad(oVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (oVar.giftNum > 0) {
            this.fNq.setVisibility(0);
            if (oVar.giftNum > 99) {
                this.fNq.setText("99");
                return;
            } else {
                this.fNq.setText(String.valueOf(oVar.giftNum));
                return;
            }
        }
        this.fNq.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
