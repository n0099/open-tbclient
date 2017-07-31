package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView fkS;
    private TextView fkU;
    private TbImageView flh;
    private com.baidu.tieba.personPolymeric.c.e fli;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.flh = (TbImageView) this.mRootView.findViewById(d.h.card_person_auth_icon);
        this.fkU = (TextView) this.mRootView.findViewById(d.h.card_person_auth_bar_name);
        this.fkS = (TextView) this.mRootView.findViewById(d.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ai.j(this.mRootView, d.e.cp_bg_line_d);
            ai.c(this.fkU, d.e.cp_cont_b, 1);
            ai.c(this.fkS, d.e.cp_cont_d, 1);
            if (this.fli.iconUrl == null) {
                ai.c(this.flh, d.g.icon_shen_mine);
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
            this.fli = eVar;
            if (eVar.iconUrl != null) {
                this.flh.c(eVar.iconUrl, 10, false);
            }
            this.fkU.setText(eVar.cVl);
            this.fkS.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
