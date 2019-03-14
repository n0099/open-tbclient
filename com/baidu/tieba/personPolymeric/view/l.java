package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.o> {
    private TbImageView hTU;
    private TextView hTV;
    private TbPageContext mPageContext;
    private View mRootView;

    public l(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.mRootView.setTag(this);
        this.hTU = (TbImageView) this.mRootView.findViewById(d.g.gift_pic);
        this.hTV = (TextView) this.mRootView.findViewById(d.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        al.k(this.hTU, d.f.item_gift_selector);
        al.l(this.hTV, d.C0277d.common_color_10294);
        al.j(this.hTV, d.C0277d.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.hTU.startLoad(oVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (oVar.giftNum > 0) {
            this.hTV.setVisibility(0);
            if (oVar.giftNum > 99) {
                this.hTV.setText("99");
                return;
            } else {
                this.hTV.setText(String.valueOf(oVar.giftNum));
                return;
            }
        }
        this.hTV.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
