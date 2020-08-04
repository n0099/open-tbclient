package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private TextView kYX;
    private TextView kYZ;
    private TbImageView kZn;
    private com.baidu.tieba.personPolymeric.c.e kZo;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.kZn = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.kYZ = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.kYX = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.kYZ, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.kYX, R.color.cp_cont_d, 1);
            if (this.kZo.iconUrl == null) {
                ao.setImageResource(this.kZn, R.drawable.icon_shen_mine);
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
            this.kZo = eVar;
            if (eVar.iconUrl != null) {
                this.kZn.startLoad(eVar.iconUrl, 10, false);
            }
            this.kYZ.setText(eVar.iSY);
            this.kYX.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
