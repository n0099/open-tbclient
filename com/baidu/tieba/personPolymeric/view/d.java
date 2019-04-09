package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView hSD;
    private TextView hSF;
    private TbImageView hSS;
    private com.baidu.tieba.personPolymeric.c.e hST;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.hSS = (TbImageView) this.mRootView.findViewById(d.g.card_person_auth_icon);
        this.hSF = (TextView) this.mRootView.findViewById(d.g.card_person_auth_bar_name);
        this.hSD = (TextView) this.mRootView.findViewById(d.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.mRootView, d.C0277d.cp_bg_line_d);
            al.d(this.hSF, d.C0277d.cp_cont_b, 1);
            al.d(this.hSD, d.C0277d.cp_cont_d, 1);
            if (this.hST.iconUrl == null) {
                al.c(this.hSS, d.f.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.hST = eVar;
            if (eVar.iconUrl != null) {
                this.hSS.startLoad(eVar.iconUrl, 10, false);
            }
            this.hSF.setText(eVar.hRI);
            this.hSD.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
