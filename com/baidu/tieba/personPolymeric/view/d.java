package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private View mRootView;
    private TextView mab;
    private TextView mae;
    private TbImageView mat;
    private com.baidu.tieba.personPolymeric.c.e mau;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mat = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.mae = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.mab = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.mae, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mab, R.color.cp_cont_d, 1);
            if (this.mau.iconUrl == null) {
                ap.setImageResource(this.mat, R.drawable.icon_shen_mine);
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
            this.mau = eVar;
            if (eVar.iconUrl != null) {
                this.mat.startLoad(eVar.iconUrl, 10, false);
            }
            this.mae.setText(eVar.jrg);
            this.mab.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
