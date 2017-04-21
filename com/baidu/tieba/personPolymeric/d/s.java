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
    private TbPageContext ajU;
    private TbImageView eJh;
    private TextView eJi;
    private View mRootView;

    public s(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.ajU = tbPageContext;
        this.mRootView.setTag(this);
        this.eJh = (TbImageView) this.mRootView.findViewById(w.h.gift_pic);
        this.eJi = (TextView) this.mRootView.findViewById(w.h.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        aq.k(this.mRootView, w.e.cp_bg_line_d);
        aq.j(this.eJh, w.g.item_gift_selector);
        aq.k(this.eJi, w.e.common_color_10294);
        aq.i(this.eJi, w.e.cp_link_tip_a);
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
        onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        this.eJh.c(mVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (mVar.eIa > 0) {
            this.eJi.setVisibility(0);
            if (mVar.eIa > 99) {
                this.eJi.setText("99");
                return;
            } else {
                this.eJi.setText(String.valueOf(mVar.eIa));
                return;
            }
        }
        this.eJi.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
