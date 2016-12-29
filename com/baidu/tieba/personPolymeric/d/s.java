package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.m> {
    private TbPageContext GO;
    private TbImageView evA;
    private TextView evB;
    private View mRootView;

    public s(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.GO = tbPageContext;
        this.mRootView.setTag(this);
        this.evA = (TbImageView) this.mRootView.findViewById(r.g.gift_pic);
        this.evB = (TextView) this.mRootView.findViewById(r.g.gift_num_text);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ar.l(this.mRootView, r.d.cp_bg_line_d);
        ar.k(this.evA, r.f.item_gift_selector);
        ar.l(this.evB, r.d.common_color_10294);
        ar.j((View) this.evB, r.d.cp_link_tip_a);
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
        this.evA.c(mVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (mVar.eut > 0) {
            this.evB.setVisibility(0);
            if (mVar.eut > 99) {
                this.evB.setText("99");
                return;
            } else {
                this.evB.setText(String.valueOf(mVar.eut));
                return;
            }
        }
        this.evB.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
