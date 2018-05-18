package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private com.baidu.tieba.personPolymeric.c.e fMA;
    private TextView fMk;
    private TextView fMm;
    private TbImageView fMz;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fMz = (TbImageView) this.mRootView.findViewById(d.g.card_person_auth_icon);
        this.fMm = (TextView) this.mRootView.findViewById(d.g.card_person_auth_bar_name);
        this.fMk = (TextView) this.mRootView.findViewById(d.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
            ak.c(this.fMm, d.C0126d.cp_cont_b, 1);
            ak.c(this.fMk, d.C0126d.cp_cont_d, 1);
            if (this.fMA.iconUrl == null) {
                ak.c(this.fMz, d.f.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.fMA = eVar;
            if (eVar.iconUrl != null) {
                this.fMz.startLoad(eVar.iconUrl, 10, false);
            }
            this.fMm.setText(eVar.fLp);
            this.fMk.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
