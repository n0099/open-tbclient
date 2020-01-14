package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView jqd;
    private TextView jqf;
    private TbImageView jqt;
    private com.baidu.tieba.personPolymeric.c.e jqu;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.jqt = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.jqf = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.jqd = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jqf, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jqd, R.color.cp_cont_d, 1);
            if (this.jqu.iconUrl == null) {
                am.setImageResource(this.jqt, R.drawable.icon_shen_mine);
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
            this.jqu = eVar;
            if (eVar.iconUrl != null) {
                this.jqt.startLoad(eVar.iconUrl, 10, false);
            }
            this.jqf.setText(eVar.jnL);
            this.jqd.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
