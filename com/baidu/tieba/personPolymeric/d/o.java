package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.n> {
    private TbPageContext ako;
    private TbImageView fky;
    private TextView fkz;
    private View mRootView;

    public o(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.ako = tbPageContext;
        this.mRootView.setTag(this);
        this.fky = (TbImageView) this.mRootView.findViewById(d.h.gift_pic);
        this.fkz = (TextView) this.mRootView.findViewById(d.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ai.k(this.mRootView, d.e.cp_bg_line_d);
        ai.j(this.fky, d.g.item_gift_selector);
        ai.k(this.fkz, d.e.common_color_10294);
        ai.i(this.fkz, d.e.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.n nVar) {
        if (nVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        this.fky.c(nVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (nVar.fjs > 0) {
            this.fkz.setVisibility(0);
            if (nVar.fjs > 99) {
                this.fkz.setText("99");
                return;
            } else {
                this.fkz.setText(String.valueOf(nVar.fjs));
                return;
            }
        }
        this.fkz.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
