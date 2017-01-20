package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TextView eEO;
    private TextView eEQ;
    private TbImageView eFd;
    private com.baidu.tieba.personPolymeric.c.d eFe;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eFd = (TbImageView) this.mRootView.findViewById(r.h.card_person_auth_icon);
        this.eEQ = (TextView) this.mRootView.findViewById(r.h.card_person_auth_bar_name);
        this.eEO = (TextView) this.mRootView.findViewById(r.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.j(this.mRootView, r.e.cp_bg_line_d);
            ap.c(this.eEQ, r.e.cp_cont_b, 1);
            ap.c(this.eEO, r.e.cp_cont_d, 1);
            if (this.eFe.iconUrl == null) {
                ap.c(this.eFd, r.g.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.d dVar) {
        if (dVar != null) {
            this.eFe = dVar;
            if (dVar.iconUrl != null) {
                this.eFd.c(dVar.iconUrl, 10, false);
            }
            this.eEQ.setText(dVar.eDS);
            this.eEO.setText(dVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
