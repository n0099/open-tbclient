package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView mEE;
    private com.baidu.tieba.personPolymeric.c.e mEF;
    private TextView mEo;
    private TextView mEq;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mEE = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.mEq = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.mEo = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.mEq, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mEo, R.color.CAM_X0109, 1);
            if (this.mEF.iconUrl == null) {
                ap.setImageResource(this.mEE, R.drawable.icon_shen_mine);
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
            this.mEF = eVar;
            if (eVar.iconUrl != null) {
                this.mEE.startLoad(eVar.iconUrl, 10, false);
            }
            this.mEq.setText(eVar.kbI);
            this.mEo.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
