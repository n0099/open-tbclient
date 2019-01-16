package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView gCQ;
    private TextView gCS;
    private TbImageView gDf;
    private com.baidu.tieba.personPolymeric.c.e gDg;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.gDf = (TbImageView) this.mRootView.findViewById(e.g.card_person_auth_icon);
        this.gCS = (TextView) this.mRootView.findViewById(e.g.card_person_auth_bar_name);
        this.gCQ = (TextView) this.mRootView.findViewById(e.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.gCS, e.d.cp_cont_b, 1);
            al.c(this.gCQ, e.d.cp_cont_d, 1);
            if (this.gDg.iconUrl == null) {
                al.c(this.gDf, e.f.icon_shen_mine);
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
            this.gDg = eVar;
            if (eVar.iconUrl != null) {
                this.gDf.startLoad(eVar.iconUrl, 10, false);
            }
            this.gCS.setText(eVar.gBV);
            this.gCQ.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
