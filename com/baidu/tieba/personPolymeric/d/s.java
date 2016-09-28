package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private TbPageContext GM;
    private TbImageView eLD;
    private TextView eLE;
    private View mRootView;

    public s(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.GM = tbPageContext;
        this.mRootView.setTag(this);
        this.eLD = (TbImageView) this.mRootView.findViewById(r.g.gift_pic);
        this.eLE = (TextView) this.mRootView.findViewById(r.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        av.l(this.mRootView, r.d.cp_bg_line_d);
        av.k(this.eLD, r.f.item_gift_selector);
        av.l(this.eLE, r.d.common_color_10294);
        av.j((View) this.eLE, r.d.cp_link_tip_a);
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
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        this.eLD.c(mVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (mVar.eKv > 0) {
            this.eLE.setVisibility(0);
            if (mVar.eKv > 99) {
                this.eLE.setText("99");
                return;
            } else {
                this.eLE.setText(String.valueOf(mVar.eKv));
                return;
            }
        }
        this.eLE.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
