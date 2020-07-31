package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private TextView kYV;
    private TextView kYX;
    private TbImageView kZl;
    private com.baidu.tieba.personPolymeric.c.e kZm;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.kZl = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.kYX = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.kYV = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.kYX, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.kYV, R.color.cp_cont_d, 1);
            if (this.kZm.iconUrl == null) {
                ao.setImageResource(this.kZl, R.drawable.icon_shen_mine);
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
            this.kZm = eVar;
            if (eVar.iconUrl != null) {
                this.kZl.startLoad(eVar.iconUrl, 10, false);
            }
            this.kYX.setText(eVar.iSW);
            this.kYV.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
