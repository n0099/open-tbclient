package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private TextView lNF;
    private TextView lNH;
    private TbImageView lNV;
    private com.baidu.tieba.personPolymeric.c.e lNW;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.lNV = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.lNH = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.lNF = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.lNH, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.lNF, R.color.cp_cont_d, 1);
            if (this.lNW.iconUrl == null) {
                ap.setImageResource(this.lNV, R.drawable.icon_shen_mine);
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
            this.lNW = eVar;
            if (eVar.iconUrl != null) {
                this.lNV.startLoad(eVar.iconUrl, 10, false);
            }
            this.lNH.setText(eVar.jeI);
            this.lNF.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
