package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView mAe;
    private com.baidu.tieba.personPolymeric.c.e mAf;
    private View mRootView;
    private TextView mzO;
    private TextView mzQ;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mAe = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.mzQ = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.mzO = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ao.setViewTextColor(this.mzQ, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.mzO, R.color.CAM_X0109, 1);
            if (this.mAf.iconUrl == null) {
                ao.setImageResource(this.mAe, R.drawable.icon_shen_mine);
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
            this.mAf = eVar;
            if (eVar.iconUrl != null) {
                this.mAe.startLoad(eVar.iconUrl, 10, false);
            }
            this.mzQ.setText(eVar.jYM);
            this.mzO.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
