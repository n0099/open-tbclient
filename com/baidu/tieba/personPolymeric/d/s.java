package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private TbPageContext GO;
    private TbImageView eSb;
    private TextView eSc;
    private View mRootView;

    public s(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.GO = tbPageContext;
        this.mRootView.setTag(this);
        this.eSb = (TbImageView) this.mRootView.findViewById(r.g.gift_pic);
        this.eSc = (TextView) this.mRootView.findViewById(r.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        at.l(this.mRootView, r.d.cp_bg_line_d);
        at.k(this.eSb, r.f.item_gift_selector);
        at.l(this.eSc, r.d.common_color_10294);
        at.j((View) this.eSc, r.d.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        this.eSb.c(mVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (mVar.eQT > 0) {
            this.eSc.setVisibility(0);
            if (mVar.eQT > 99) {
                this.eSc.setText("99");
                return;
            } else {
                this.eSc.setText(String.valueOf(mVar.eQT));
                return;
            }
        }
        this.eSc.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
