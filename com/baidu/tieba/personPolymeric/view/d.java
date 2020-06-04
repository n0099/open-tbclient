package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private TextView kwc;
    private TextView kwe;
    private TbImageView kws;
    private com.baidu.tieba.personPolymeric.c.e kwt;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.kws = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.kwe = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.kwc = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kwe, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kwc, R.color.cp_cont_d, 1);
            if (this.kwt.iconUrl == null) {
                am.setImageResource(this.kws, R.drawable.icon_shen_mine);
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
            this.kwt = eVar;
            if (eVar.iconUrl != null) {
                this.kws.startLoad(eVar.iconUrl, 10, false);
            }
            this.kwe.setText(eVar.ktJ);
            this.kwc.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
