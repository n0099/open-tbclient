package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.o> {
    private TbImageView gtj;
    private TextView gtk;
    private TbPageContext mPageContext;
    private View mRootView;

    public l(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.mRootView.setTag(this);
        this.gtj = (TbImageView) this.mRootView.findViewById(e.g.gift_pic);
        this.gtk = (TextView) this.mRootView.findViewById(e.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
        al.i(this.gtj, e.f.item_gift_selector);
        al.j(this.gtk, e.d.common_color_10294);
        al.h(this.gtk, e.d.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.gtj.startLoad(oVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (oVar.giftNum > 0) {
            this.gtk.setVisibility(0);
            if (oVar.giftNum > 99) {
                this.gtk.setText("99");
                return;
            } else {
                this.gtk.setText(String.valueOf(oVar.giftNum));
                return;
            }
        }
        this.gtk.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
