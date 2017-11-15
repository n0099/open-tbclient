package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView fqJ;
    private com.baidu.tieba.personPolymeric.c.e fqK;
    private TextView fqu;
    private TextView fqw;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fqJ = (TbImageView) this.mRootView.findViewById(d.g.card_person_auth_icon);
        this.fqw = (TextView) this.mRootView.findViewById(d.g.card_person_auth_bar_name);
        this.fqu = (TextView) this.mRootView.findViewById(d.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.j(this.mRootView, d.C0080d.cp_bg_line_d);
            aj.c(this.fqw, d.C0080d.cp_cont_b, 1);
            aj.c(this.fqu, d.C0080d.cp_cont_d, 1);
            if (this.fqK.iconUrl == null) {
                aj.c(this.fqJ, d.f.icon_shen_mine);
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
            this.fqK = eVar;
            if (eVar.iconUrl != null) {
                this.fqJ.startLoad(eVar.iconUrl, 10, false);
            }
            this.fqw.setText(eVar.fpz);
            this.fqu.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
