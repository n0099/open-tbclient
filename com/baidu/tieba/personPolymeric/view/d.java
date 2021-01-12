package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private View mRootView;
    private TbImageView mvA;
    private com.baidu.tieba.personPolymeric.c.e mvB;
    private TextView mvk;
    private TextView mvm;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mvA = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.mvm = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.mvk = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ao.setViewTextColor(this.mvm, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.mvk, R.color.CAM_X0109, 1);
            if (this.mvB.iconUrl == null) {
                ao.setImageResource(this.mvA, R.drawable.icon_shen_mine);
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
            this.mvB = eVar;
            if (eVar.iconUrl != null) {
                this.mvA.startLoad(eVar.iconUrl, 10, false);
            }
            this.mvm.setText(eVar.jUh);
            this.mvk.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
