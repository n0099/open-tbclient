package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView fmN;
    private TextView fmP;
    private TbImageView fnc;
    private com.baidu.tieba.personPolymeric.c.e fnd;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fnc = (TbImageView) this.mRootView.findViewById(d.h.card_person_auth_icon);
        this.fmP = (TextView) this.mRootView.findViewById(d.h.card_person_auth_bar_name);
        this.fmN = (TextView) this.mRootView.findViewById(d.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ai.j(this.mRootView, d.e.cp_bg_line_d);
            ai.c(this.fmP, d.e.cp_cont_b, 1);
            ai.c(this.fmN, d.e.cp_cont_d, 1);
            if (this.fnd.iconUrl == null) {
                ai.c(this.fnc, d.g.icon_shen_mine);
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
            this.fnd = eVar;
            if (eVar.iconUrl != null) {
                this.fnc.c(eVar.iconUrl, 10, false);
            }
            this.fmP.setText(eVar.cXk);
            this.fmN.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
