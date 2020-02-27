package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView jqY;
    private TextView jra;
    private TbImageView jro;
    private com.baidu.tieba.personPolymeric.c.e jrp;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.jro = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.jra = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.jqY = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jra, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jqY, R.color.cp_cont_d, 1);
            if (this.jrp.iconUrl == null) {
                am.setImageResource(this.jro, R.drawable.icon_shen_mine);
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
            this.jrp = eVar;
            if (eVar.iconUrl != null) {
                this.jro.startLoad(eVar.iconUrl, 10, false);
            }
            this.jra.setText(eVar.joF);
            this.jqY.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
