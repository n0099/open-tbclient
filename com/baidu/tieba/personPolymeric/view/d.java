package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView fLh;
    private TextView fLj;
    private TbImageView fLw;
    private com.baidu.tieba.personPolymeric.c.e fLx;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fLw = (TbImageView) this.mRootView.findViewById(d.g.card_person_auth_icon);
        this.fLj = (TextView) this.mRootView.findViewById(d.g.card_person_auth_bar_name);
        this.fLh = (TextView) this.mRootView.findViewById(d.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
            ak.c(this.fLj, d.C0126d.cp_cont_b, 1);
            ak.c(this.fLh, d.C0126d.cp_cont_d, 1);
            if (this.fLx.iconUrl == null) {
                ak.c(this.fLw, d.f.icon_shen_mine);
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
            this.fLx = eVar;
            if (eVar.iconUrl != null) {
                this.fLw.startLoad(eVar.iconUrl, 10, false);
            }
            this.fLj.setText(eVar.fKm);
            this.fLh.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
