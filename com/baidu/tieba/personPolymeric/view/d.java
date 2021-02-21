package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private TextView mED;
    private TextView mEF;
    private TbImageView mET;
    private com.baidu.tieba.personPolymeric.c.e mEU;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mET = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.mEF = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.mED = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.mEF, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mED, R.color.CAM_X0109, 1);
            if (this.mEU.iconUrl == null) {
                ap.setImageResource(this.mET, R.drawable.icon_shen_mine);
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
            this.mEU = eVar;
            if (eVar.iconUrl != null) {
                this.mET.startLoad(eVar.iconUrl, 10, false);
            }
            this.mEF.setText(eVar.kbW);
            this.mED.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
