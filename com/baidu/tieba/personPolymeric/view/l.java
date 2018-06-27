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
    private TbImageView gcB;
    private TextView gcC;
    private TbPageContext mPageContext;
    private View mRootView;

    public l(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.mRootView.setTag(this);
        this.gcB = (TbImageView) this.mRootView.findViewById(d.g.gift_pic);
        this.gcC = (TextView) this.mRootView.findViewById(d.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.j(this.mRootView, d.C0142d.cp_bg_line_d);
        am.i(this.gcB, d.f.item_gift_selector);
        am.j(this.gcC, d.C0142d.common_color_10294);
        am.h(this.gcC, d.C0142d.cp_link_tip_a);
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
        this.gcB.startLoad(oVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (oVar.giftNum > 0) {
            this.gcC.setVisibility(0);
            if (oVar.giftNum > 99) {
                this.gcC.setText("99");
                return;
            } else {
                this.gcC.setText(String.valueOf(oVar.giftNum));
                return;
            }
        }
        this.gcC.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
