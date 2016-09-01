package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private TbPageContext GM;
    private TbImageView eJA;
    private TextView eJB;
    private View mRootView;

    public s(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.GM = tbPageContext;
        this.mRootView.setTag(this);
        this.eJA = (TbImageView) this.mRootView.findViewById(t.g.gift_pic);
        this.eJB = (TextView) this.mRootView.findViewById(t.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        av.l(this.mRootView, t.d.cp_bg_line_d);
        av.k(this.eJA, t.f.item_gift_selector);
        av.l(this.eJB, t.d.common_color_10294);
        av.j((View) this.eJB, t.d.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        this.eJA.c(mVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (mVar.eIr > 0) {
            this.eJB.setVisibility(0);
            if (mVar.eIr > 99) {
                this.eJB.setText("99");
                return;
            } else {
                this.eJB.setText(String.valueOf(mVar.eIr));
                return;
            }
        }
        this.eJB.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
