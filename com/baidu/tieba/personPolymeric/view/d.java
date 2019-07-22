package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView irL;
    private TextView irN;
    private TbImageView isa;
    private com.baidu.tieba.personPolymeric.c.e isb;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.isa = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.irN = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.irL = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.k(this.mRootView, R.color.cp_bg_line_d);
            am.f(this.irN, R.color.cp_cont_b, 1);
            am.f(this.irL, R.color.cp_cont_d, 1);
            if (this.isb.iconUrl == null) {
                am.c(this.isa, (int) R.drawable.icon_shen_mine);
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
            this.isb = eVar;
            if (eVar.iconUrl != null) {
                this.isa.startLoad(eVar.iconUrl, 10, false);
            }
            this.irN.setText(eVar.iqQ);
            this.irL.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
