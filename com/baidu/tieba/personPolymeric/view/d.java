package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView itD;
    private com.baidu.tieba.personPolymeric.c.e itE;
    private TextView ito;
    private TextView itq;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.itD = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.itq = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.ito = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.itq, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.ito, R.color.cp_cont_d, 1);
            if (this.itE.iconUrl == null) {
                am.setImageResource(this.itD, R.drawable.icon_shen_mine);
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
            this.itE = eVar;
            if (eVar.iconUrl != null) {
                this.itD.startLoad(eVar.iconUrl, 10, false);
            }
            this.itq.setText(eVar.ist);
            this.ito.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
