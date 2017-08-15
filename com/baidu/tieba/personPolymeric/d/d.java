package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView fmL;
    private TextView fmN;
    private TbImageView fna;
    private com.baidu.tieba.personPolymeric.c.e fnb;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fna = (TbImageView) this.mRootView.findViewById(d.h.card_person_auth_icon);
        this.fmN = (TextView) this.mRootView.findViewById(d.h.card_person_auth_bar_name);
        this.fmL = (TextView) this.mRootView.findViewById(d.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ai.j(this.mRootView, d.e.cp_bg_line_d);
            ai.c(this.fmN, d.e.cp_cont_b, 1);
            ai.c(this.fmL, d.e.cp_cont_d, 1);
            if (this.fnb.iconUrl == null) {
                ai.c(this.fna, d.g.icon_shen_mine);
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
            this.fnb = eVar;
            if (eVar.iconUrl != null) {
                this.fna.c(eVar.iconUrl, 10, false);
            }
            this.fmN.setText(eVar.cXk);
            this.fmL.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
