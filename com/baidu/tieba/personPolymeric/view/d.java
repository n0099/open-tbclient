package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView ilH;
    private com.baidu.tieba.personPolymeric.c.e ilI;
    private TextView ils;
    private TextView ilu;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.ilH = (TbImageView) this.mRootView.findViewById(R.id.card_person_auth_icon);
        this.ilu = (TextView) this.mRootView.findViewById(R.id.card_person_auth_bar_name);
        this.ils = (TextView) this.mRootView.findViewById(R.id.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.mRootView, R.color.cp_bg_line_d);
            al.f(this.ilu, R.color.cp_cont_b, 1);
            al.f(this.ils, R.color.cp_cont_d, 1);
            if (this.ilI.iconUrl == null) {
                al.c(this.ilH, (int) R.drawable.icon_shen_mine);
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
            this.ilI = eVar;
            if (eVar.iconUrl != null) {
                this.ilH.startLoad(eVar.iconUrl, 10, false);
            }
            this.ilu.setText(eVar.ikx);
            this.ils.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
