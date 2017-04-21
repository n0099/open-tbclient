package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TextView eIB;
    private TextView eID;
    private TbImageView eIQ;
    private com.baidu.tieba.personPolymeric.c.d eIR;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eIQ = (TbImageView) this.mRootView.findViewById(w.h.card_person_auth_icon);
        this.eID = (TextView) this.mRootView.findViewById(w.h.card_person_auth_bar_name);
        this.eIB = (TextView) this.mRootView.findViewById(w.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.j(this.mRootView, w.e.cp_bg_line_d);
            aq.c(this.eID, w.e.cp_cont_b, 1);
            aq.c(this.eIB, w.e.cp_cont_d, 1);
            if (this.eIR.iconUrl == null) {
                aq.c(this.eIQ, w.g.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.d dVar) {
        if (dVar != null) {
            this.eIR = dVar;
            if (dVar.iconUrl != null) {
                this.eIQ.c(dVar.iconUrl, 10, false);
            }
            this.eID.setText(dVar.eHG);
            this.eIB.setText(dVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
