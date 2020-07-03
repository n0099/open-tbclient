package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private TextView kPZ;
    private TextView kQb;
    private TbImageView kQp;
    private com.baidu.tieba.personPolymeric.c.e kQq;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.kQp = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.kQb = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.kPZ = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            an.setViewTextColor(this.kQb, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.kPZ, R.color.cp_cont_d, 1);
            if (this.kQq.iconUrl == null) {
                an.setImageResource(this.kQp, R.drawable.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.kQq = eVar;
            if (eVar.iconUrl != null) {
                this.kQp.startLoad(eVar.iconUrl, 10, false);
            }
            this.kQb.setText(eVar.kNG);
            this.kPZ.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
