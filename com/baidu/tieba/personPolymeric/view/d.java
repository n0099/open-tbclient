package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView ilE;
    private com.baidu.tieba.personPolymeric.c.e ilF;
    private TextView ilp;
    private TextView ilr;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.ilE = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.ilr = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.ilp = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.mRootView, R.color.cp_bg_line_d);
            al.f(this.ilr, R.color.cp_cont_b, 1);
            al.f(this.ilp, R.color.cp_cont_d, 1);
            if (this.ilF.iconUrl == null) {
                al.c(this.ilE, (int) R.drawable.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.ilF = eVar;
            if (eVar.iconUrl != null) {
                this.ilE.startLoad(eVar.iconUrl, 10, false);
            }
            this.ilr.setText(eVar.iku);
            this.ilp.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
