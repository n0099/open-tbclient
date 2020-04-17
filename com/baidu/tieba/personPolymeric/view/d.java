package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView kdb;
    private TextView kdd;
    private TbImageView kdr;
    private com.baidu.tieba.personPolymeric.c.e kds;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.kdr = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.kdd = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.kdb = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kdd, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kdb, R.color.cp_cont_d, 1);
            if (this.kds.iconUrl == null) {
                am.setImageResource(this.kdr, R.drawable.icon_shen_mine);
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
            this.kds = eVar;
            if (eVar.iconUrl != null) {
                this.kdr.startLoad(eVar.iconUrl, 10, false);
            }
            this.kdd.setText(eVar.kaH);
            this.kdb.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
