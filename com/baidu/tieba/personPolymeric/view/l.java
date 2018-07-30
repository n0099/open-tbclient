package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.o> {
    private TbImageView gcT;
    private TextView gcU;
    private TbPageContext mPageContext;
    private View mRootView;

    public l(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.mRootView.setTag(this);
        this.gcT = (TbImageView) this.mRootView.findViewById(d.g.gift_pic);
        this.gcU = (TextView) this.mRootView.findViewById(d.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.j(this.mRootView, d.C0140d.cp_bg_line_d);
        am.i(this.gcT, d.f.item_gift_selector);
        am.j(this.gcU, d.C0140d.common_color_10294);
        am.h(this.gcU, d.C0140d.cp_link_tip_a);
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
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.gcT.startLoad(oVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (oVar.giftNum > 0) {
            this.gcU.setVisibility(0);
            if (oVar.giftNum > 99) {
                this.gcU.setText("99");
                return;
            } else {
                this.gcU.setText(String.valueOf(oVar.giftNum));
                return;
            }
        }
        this.gcU.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
