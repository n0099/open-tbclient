package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView gqG;
    private TextView gqI;
    private TbImageView gqV;
    private com.baidu.tieba.personPolymeric.c.e gqW;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.gqV = (TbImageView) this.mRootView.findViewById(d.g.card_person_auth_icon);
        this.gqI = (TextView) this.mRootView.findViewById(d.g.card_person_auth_bar_name);
        this.gqG = (TextView) this.mRootView.findViewById(d.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
            aj.e(this.gqI, d.C0141d.cp_cont_b, 1);
            aj.e(this.gqG, d.C0141d.cp_cont_d, 1);
            if (this.gqW.iconUrl == null) {
                aj.c(this.gqV, d.f.icon_shen_mine);
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
            this.gqW = eVar;
            if (eVar.iconUrl != null) {
                this.gqV.startLoad(eVar.iconUrl, 10, false);
            }
            this.gqI.setText(eVar.gpK);
            this.gqG.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
