package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView lpN;
    private com.baidu.tieba.personPolymeric.c.e lpO;
    private TextView lpx;
    private TextView lpz;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.lpN = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.lpz = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.lpx = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.lpz, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.lpx, R.color.cp_cont_d, 1);
            if (this.lpO.iconUrl == null) {
                ap.setImageResource(this.lpN, R.drawable.icon_shen_mine);
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
            this.lpO = eVar;
            if (eVar.iconUrl != null) {
                this.lpN.startLoad(eVar.iconUrl, 10, false);
            }
            this.lpz.setText(eVar.jib);
            this.lpx.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
