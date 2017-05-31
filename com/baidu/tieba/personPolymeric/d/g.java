package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView eMV;
    private TextView eMX;
    private TbImageView eNk;
    private com.baidu.tieba.personPolymeric.c.e eNl;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eNk = (TbImageView) this.mRootView.findViewById(w.h.card_person_auth_icon);
        this.eMX = (TextView) this.mRootView.findViewById(w.h.card_person_auth_bar_name);
        this.eMV = (TextView) this.mRootView.findViewById(w.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.j(this.mRootView, w.e.cp_bg_line_d);
            aq.c(this.eMX, w.e.cp_cont_b, 1);
            aq.c(this.eMV, w.e.cp_cont_d, 1);
            if (this.eNl.iconUrl == null) {
                aq.c(this.eNk, w.g.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.eNl = eVar;
            if (eVar.iconUrl != null) {
                this.eNk.c(eVar.iconUrl, 10, false);
            }
            this.eMX.setText(eVar.cDr);
            this.eMV.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
