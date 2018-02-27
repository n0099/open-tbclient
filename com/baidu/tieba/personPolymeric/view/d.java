package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView gqF;
    private com.baidu.tieba.personPolymeric.c.e gqG;
    private TextView gqq;
    private TextView gqs;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.gqF = (TbImageView) this.mRootView.findViewById(d.g.card_person_auth_icon);
        this.gqs = (TextView) this.mRootView.findViewById(d.g.card_person_auth_bar_name);
        this.gqq = (TextView) this.mRootView.findViewById(d.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
            aj.e(this.gqs, d.C0141d.cp_cont_b, 1);
            aj.e(this.gqq, d.C0141d.cp_cont_d, 1);
            if (this.gqG.iconUrl == null) {
                aj.c(this.gqF, d.f.icon_shen_mine);
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
            this.gqG = eVar;
            if (eVar.iconUrl != null) {
                this.gqF.startLoad(eVar.iconUrl, 10, false);
            }
            this.gqs.setText(eVar.gpu);
            this.gqq.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
