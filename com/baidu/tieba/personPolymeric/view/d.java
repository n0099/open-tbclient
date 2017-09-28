package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView fhN;
    private TextView fhP;
    private TbImageView fic;
    private com.baidu.tieba.personPolymeric.c.e fie;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fic = (TbImageView) this.mRootView.findViewById(d.h.card_person_auth_icon);
        this.fhP = (TextView) this.mRootView.findViewById(d.h.card_person_auth_bar_name);
        this.fhN = (TextView) this.mRootView.findViewById(d.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.j(this.mRootView, d.e.cp_bg_line_d);
            aj.c(this.fhP, d.e.cp_cont_b, 1);
            aj.c(this.fhN, d.e.cp_cont_d, 1);
            if (this.fie.iconUrl == null) {
                aj.c(this.fic, d.g.icon_shen_mine);
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
            this.fie = eVar;
            if (eVar.iconUrl != null) {
                this.fic.c(eVar.iconUrl, 10, false);
            }
            this.fhP.setText(eVar.fgS);
            this.fhN.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
