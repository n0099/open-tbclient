package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView fXL;
    private com.baidu.tieba.personPolymeric.c.e fXM;
    private TextView fXw;
    private TextView fXy;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.fXL = (TbImageView) this.mRootView.findViewById(d.g.card_person_auth_icon);
        this.fXy = (TextView) this.mRootView.findViewById(d.g.card_person_auth_bar_name);
        this.fXw = (TextView) this.mRootView.findViewById(d.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.mRootView, d.C0141d.cp_bg_line_d);
            al.c(this.fXy, d.C0141d.cp_cont_b, 1);
            al.c(this.fXw, d.C0141d.cp_cont_d, 1);
            if (this.fXM.iconUrl == null) {
                al.c(this.fXL, d.f.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.fXM = eVar;
            if (eVar.iconUrl != null) {
                this.fXL.startLoad(eVar.iconUrl, 10, false);
            }
            this.fXy.setText(eVar.fWB);
            this.fXw.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
