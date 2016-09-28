package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TextView eKX;
    private TextView eKZ;
    private TbImageView eLm;
    private com.baidu.tieba.personPolymeric.c.d eLn;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eLm = (TbImageView) this.mRootView.findViewById(r.g.card_person_auth_icon);
        this.eKZ = (TextView) this.mRootView.findViewById(r.g.card_person_auth_bar_name);
        this.eKX = (TextView) this.mRootView.findViewById(r.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            av.k(this.mRootView, r.d.cp_bg_line_d);
            av.c(this.eKZ, r.d.cp_cont_b, 1);
            av.c(this.eKX, r.d.cp_cont_d, 1);
            if (this.eLn.iconUrl == null) {
                av.c(this.eLm, r.f.icon_shen_mine);
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
            this.eLn = dVar;
            if (dVar.iconUrl != null) {
                this.eLm.c(dVar.iconUrl, 10, false);
            }
            this.eKZ.setText(dVar.eKb);
            this.eKX.setText(dVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
