package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView iuN;
    private TextView iuP;
    private TbImageView ivc;
    private com.baidu.tieba.personPolymeric.c.e ivd;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.ivc = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.iuP = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.iuN = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.k(this.mRootView, R.color.cp_bg_line_d);
            am.f(this.iuP, R.color.cp_cont_b, 1);
            am.f(this.iuN, R.color.cp_cont_d, 1);
            if (this.ivd.iconUrl == null) {
                am.c(this.ivc, (int) R.drawable.icon_shen_mine);
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
            this.ivd = eVar;
            if (eVar.iconUrl != null) {
                this.ivc.startLoad(eVar.iconUrl, 10, false);
            }
            this.iuP.setText(eVar.itT);
            this.iuN.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
