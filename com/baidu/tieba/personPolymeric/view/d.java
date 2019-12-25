package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView jmM;
    private com.baidu.tieba.personPolymeric.c.e jmN;
    private TextView jmw;
    private TextView jmy;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.jmM = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.jmy = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.jmw = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jmy, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jmw, R.color.cp_cont_d, 1);
            if (this.jmN.iconUrl == null) {
                am.setImageResource(this.jmM, R.drawable.icon_shen_mine);
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
            this.jmN = eVar;
            if (eVar.iconUrl != null) {
                this.jmM.startLoad(eVar.iconUrl, 10, false);
            }
            this.jmy.setText(eVar.jke);
            this.jmw.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
