package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView gbO;
    private TextView gbQ;
    private TbImageView gcd;
    private com.baidu.tieba.personPolymeric.c.e gce;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.gcd = (TbImageView) this.mRootView.findViewById(f.g.card_person_auth_icon);
        this.gbQ = (TextView) this.mRootView.findViewById(f.g.card_person_auth_bar_name);
        this.gbO = (TextView) this.mRootView.findViewById(f.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.i(this.mRootView, f.d.cp_bg_line_d);
            am.c(this.gbQ, f.d.cp_cont_b, 1);
            am.c(this.gbO, f.d.cp_cont_d, 1);
            if (this.gce.iconUrl == null) {
                am.c(this.gcd, f.C0146f.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.gce = eVar;
            if (eVar.iconUrl != null) {
                this.gcd.startLoad(eVar.iconUrl, 10, false);
            }
            this.gbQ.setText(eVar.gaS);
            this.gbO.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
