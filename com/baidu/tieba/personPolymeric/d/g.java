package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TbImageView eIF;
    private com.baidu.tieba.personPolymeric.c.d eIG;
    private TextView eIq;
    private TextView eIs;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eIF = (TbImageView) this.mRootView.findViewById(w.h.card_person_auth_icon);
        this.eIs = (TextView) this.mRootView.findViewById(w.h.card_person_auth_bar_name);
        this.eIq = (TextView) this.mRootView.findViewById(w.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.j(this.mRootView, w.e.cp_bg_line_d);
            aq.c(this.eIs, w.e.cp_cont_b, 1);
            aq.c(this.eIq, w.e.cp_cont_d, 1);
            if (this.eIG.iconUrl == null) {
                aq.c(this.eIF, w.g.icon_shen_mine);
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
            this.eIG = dVar;
            if (dVar.iconUrl != null) {
                this.eIF.c(dVar.iconUrl, 10, false);
            }
            this.eIs.setText(dVar.eHu);
            this.eIq.setText(dVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
