package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView fLe;
    private TextView fLg;
    private TbImageView fLt;
    private com.baidu.tieba.personPolymeric.c.e fLu;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fLt = (TbImageView) this.mRootView.findViewById(d.g.card_person_auth_icon);
        this.fLg = (TextView) this.mRootView.findViewById(d.g.card_person_auth_bar_name);
        this.fLe = (TextView) this.mRootView.findViewById(d.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
            ak.c(this.fLg, d.C0126d.cp_cont_b, 1);
            ak.c(this.fLe, d.C0126d.cp_cont_d, 1);
            if (this.fLu.iconUrl == null) {
                ak.c(this.fLt, d.f.icon_shen_mine);
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
            this.fLu = eVar;
            if (eVar.iconUrl != null) {
                this.fLt.startLoad(eVar.iconUrl, 10, false);
            }
            this.fLg.setText(eVar.fKj);
            this.fLe.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
