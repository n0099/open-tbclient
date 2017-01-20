package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private TbPageContext FY;
    private TbImageView eFu;
    private TextView eFv;
    private View mRootView;

    public s(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.FY = tbPageContext;
        this.mRootView.setTag(this);
        this.eFu = (TbImageView) this.mRootView.findViewById(r.h.gift_pic);
        this.eFv = (TextView) this.mRootView.findViewById(r.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.k(this.mRootView, r.e.cp_bg_line_d);
        ap.j(this.eFu, r.g.item_gift_selector);
        ap.k(this.eFv, r.e.common_color_10294);
        ap.i((View) this.eFv, r.e.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.m mVar) {
        if (mVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        this.eFu.c(mVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (mVar.eEn > 0) {
            this.eFv.setVisibility(0);
            if (mVar.eEn > 99) {
                this.eFv.setText("99");
                return;
            } else {
                this.eFv.setText(String.valueOf(mVar.eEn));
                return;
            }
        }
        this.eFv.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
