package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TextView eIU;
    private TextView eIW;
    private TbImageView eJj;
    private com.baidu.tieba.personPolymeric.c.d eJk;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eJj = (TbImageView) this.mRootView.findViewById(t.g.card_person_auth_icon);
        this.eIW = (TextView) this.mRootView.findViewById(t.g.card_person_auth_bar_name);
        this.eIU = (TextView) this.mRootView.findViewById(t.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            av.k(this.mRootView, t.d.cp_bg_line_d);
            av.c(this.eIW, t.d.cp_cont_b, 1);
            av.c(this.eIU, t.d.cp_cont_d, 1);
            if (this.eJk.iconUrl == null) {
                av.c(this.eJj, t.f.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.d dVar) {
        if (dVar != null) {
            this.eJk = dVar;
            if (dVar.iconUrl != null) {
                this.eJj.c(dVar.iconUrl, 10, false);
            }
            this.eIW.setText(dVar.eHX);
            this.eIU.setText(dVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
