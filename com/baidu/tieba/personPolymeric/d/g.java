package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TextView euU;
    private TextView euW;
    private TbImageView evj;
    private com.baidu.tieba.personPolymeric.c.d evk;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.evj = (TbImageView) this.mRootView.findViewById(r.g.card_person_auth_icon);
        this.euW = (TextView) this.mRootView.findViewById(r.g.card_person_auth_bar_name);
        this.euU = (TextView) this.mRootView.findViewById(r.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ar.k(this.mRootView, r.d.cp_bg_line_d);
            ar.c(this.euW, r.d.cp_cont_b, 1);
            ar.c(this.euU, r.d.cp_cont_d, 1);
            if (this.evk.iconUrl == null) {
                ar.c(this.evj, r.f.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.d dVar) {
        if (dVar != null) {
            this.evk = dVar;
            if (dVar.iconUrl != null) {
                this.evj.c(dVar.iconUrl, 10, false);
            }
            this.euW.setText(dVar.etY);
            this.euU.setText(dVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
