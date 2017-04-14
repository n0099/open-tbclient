package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TbImageView eGA;
    private com.baidu.tieba.personPolymeric.c.d eGB;
    private TextView eGl;
    private TextView eGn;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eGA = (TbImageView) this.mRootView.findViewById(w.h.card_person_auth_icon);
        this.eGn = (TextView) this.mRootView.findViewById(w.h.card_person_auth_bar_name);
        this.eGl = (TextView) this.mRootView.findViewById(w.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.j(this.mRootView, w.e.cp_bg_line_d);
            aq.c(this.eGn, w.e.cp_cont_b, 1);
            aq.c(this.eGl, w.e.cp_cont_d, 1);
            if (this.eGB.iconUrl == null) {
                aq.c(this.eGA, w.g.icon_shen_mine);
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
            this.eGB = dVar;
            if (dVar.iconUrl != null) {
                this.eGA.c(dVar.iconUrl, 10, false);
            }
            this.eGn.setText(dVar.eFq);
            this.eGl.setText(dVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
