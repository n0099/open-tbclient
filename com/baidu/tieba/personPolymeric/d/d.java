package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView fmb;
    private TextView fmd;
    private TbImageView fmq;
    private com.baidu.tieba.personPolymeric.c.e fmr;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fmq = (TbImageView) this.mRootView.findViewById(d.h.card_person_auth_icon);
        this.fmd = (TextView) this.mRootView.findViewById(d.h.card_person_auth_bar_name);
        this.fmb = (TextView) this.mRootView.findViewById(d.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.j(this.mRootView, d.e.cp_bg_line_d);
            aj.c(this.fmd, d.e.cp_cont_b, 1);
            aj.c(this.fmb, d.e.cp_cont_d, 1);
            if (this.fmr.iconUrl == null) {
                aj.c(this.fmq, d.g.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.fmr = eVar;
            if (eVar.iconUrl != null) {
                this.fmq.c(eVar.iconUrl, 10, false);
            }
            this.fmd.setText(eVar.deN);
            this.fmb.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
