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
    private TextView muA;
    private TextView muC;
    private TbImageView muQ;
    private com.baidu.tieba.personPolymeric.c.e muR;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.muQ = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.muC = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.muA = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.muC, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.muA, R.color.CAM_X0109, 1);
            if (this.muR.iconUrl == null) {
                ap.setImageResource(this.muQ, R.drawable.icon_shen_mine);
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
            this.muR = eVar;
            if (eVar.iconUrl != null) {
                this.muQ.startLoad(eVar.iconUrl, 10, false);
            }
            this.muC.setText(eVar.jLw);
            this.muA.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
