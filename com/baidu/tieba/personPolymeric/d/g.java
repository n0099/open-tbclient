package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TbImageView eRK;
    private com.baidu.tieba.personPolymeric.c.d eRL;
    private TextView eRv;
    private TextView eRx;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eRK = (TbImageView) this.mRootView.findViewById(r.g.card_person_auth_icon);
        this.eRx = (TextView) this.mRootView.findViewById(r.g.card_person_auth_bar_name);
        this.eRv = (TextView) this.mRootView.findViewById(r.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            at.k(this.mRootView, r.d.cp_bg_line_d);
            at.c(this.eRx, r.d.cp_cont_b, 1);
            at.c(this.eRv, r.d.cp_cont_d, 1);
            if (this.eRL.iconUrl == null) {
                at.c(this.eRK, r.f.icon_shen_mine);
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
            this.eRL = dVar;
            if (dVar.iconUrl != null) {
                this.eRK.c(dVar.iconUrl, 10, false);
            }
            this.eRx.setText(dVar.eQz);
            this.eRv.setText(dVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
