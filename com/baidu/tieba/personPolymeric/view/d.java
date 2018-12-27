package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView gBM;
    private TextView gBO;
    private TbImageView gCb;
    private com.baidu.tieba.personPolymeric.c.e gCc;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.gCb = (TbImageView) this.mRootView.findViewById(e.g.card_person_auth_icon);
        this.gBO = (TextView) this.mRootView.findViewById(e.g.card_person_auth_bar_name);
        this.gBM = (TextView) this.mRootView.findViewById(e.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.gBO, e.d.cp_cont_b, 1);
            al.c(this.gBM, e.d.cp_cont_d, 1);
            if (this.gCc.iconUrl == null) {
                al.c(this.gCb, e.f.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.gCc = eVar;
            if (eVar.iconUrl != null) {
                this.gCb.startLoad(eVar.iconUrl, 10, false);
            }
            this.gBO.setText(eVar.gAR);
            this.gBM.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
