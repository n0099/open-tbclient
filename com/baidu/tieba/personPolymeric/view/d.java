package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private TextView kuW;
    private TextView kuY;
    private TbImageView kvm;
    private com.baidu.tieba.personPolymeric.c.e kvn;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.kvm = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.kuY = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.kuW = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kuY, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kuW, R.color.cp_cont_d, 1);
            if (this.kvn.iconUrl == null) {
                am.setImageResource(this.kvm, R.drawable.icon_shen_mine);
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
            this.kvn = eVar;
            if (eVar.iconUrl != null) {
                this.kvm.startLoad(eVar.iconUrl, 10, false);
            }
            this.kuY.setText(eVar.ksD);
            this.kuW.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
