package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView isM;
    private com.baidu.tieba.personPolymeric.c.e isN;
    private TextView isx;
    private TextView isz;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.isM = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.isz = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.isx = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.isz, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.isx, R.color.cp_cont_d, 1);
            if (this.isN.iconUrl == null) {
                am.setImageResource(this.isM, R.drawable.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.isN = eVar;
            if (eVar.iconUrl != null) {
                this.isM.startLoad(eVar.iconUrl, 10, false);
            }
            this.isz.setText(eVar.irC);
            this.isx.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
