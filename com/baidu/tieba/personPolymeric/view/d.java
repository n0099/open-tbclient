package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView fpX;
    private TextView fpZ;
    private TbImageView fqm;
    private com.baidu.tieba.personPolymeric.c.e fqn;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fqm = (TbImageView) this.mRootView.findViewById(d.g.card_person_auth_icon);
        this.fpZ = (TextView) this.mRootView.findViewById(d.g.card_person_auth_bar_name);
        this.fpX = (TextView) this.mRootView.findViewById(d.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.j(this.mRootView, d.C0080d.cp_bg_line_d);
            aj.c(this.fpZ, d.C0080d.cp_cont_b, 1);
            aj.c(this.fpX, d.C0080d.cp_cont_d, 1);
            if (this.fqn.iconUrl == null) {
                aj.c(this.fqm, d.f.icon_shen_mine);
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
            this.fqn = eVar;
            if (eVar.iconUrl != null) {
                this.fqm.startLoad(eVar.iconUrl, 10, false);
            }
            this.fpZ.setText(eVar.fpb);
            this.fpX.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
