package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private TbPageContext ajT;
    private TbImageView eGR;
    private TextView eGS;
    private View mRootView;

    public s(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.ajT = tbPageContext;
        this.mRootView.setTag(this);
        this.eGR = (TbImageView) this.mRootView.findViewById(w.h.gift_pic);
        this.eGS = (TextView) this.mRootView.findViewById(w.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        aq.k(this.mRootView, w.e.cp_bg_line_d);
        aq.j(this.eGR, w.g.item_gift_selector);
        aq.k(this.eGS, w.e.common_color_10294);
        aq.i(this.eGS, w.e.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        this.eGR.c(mVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (mVar.eFK > 0) {
            this.eGS.setVisibility(0);
            if (mVar.eFK > 99) {
                this.eGS.setText("99");
                return;
            } else {
                this.eGS.setText(String.valueOf(mVar.eFK));
                return;
            }
        }
        this.eGS.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
