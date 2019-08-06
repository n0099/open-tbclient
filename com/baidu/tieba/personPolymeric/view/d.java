package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView isO;
    private TextView isQ;
    private TbImageView itd;
    private com.baidu.tieba.personPolymeric.c.e ite;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.itd = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.isQ = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.isO = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.k(this.mRootView, R.color.cp_bg_line_d);
            am.f(this.isQ, R.color.cp_cont_b, 1);
            am.f(this.isO, R.color.cp_cont_d, 1);
            if (this.ite.iconUrl == null) {
                am.c(this.itd, (int) R.drawable.icon_shen_mine);
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
            this.ite = eVar;
            if (eVar.iconUrl != null) {
                this.itd.startLoad(eVar.iconUrl, 10, false);
            }
            this.isQ.setText(eVar.irU);
            this.isO.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
