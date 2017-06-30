package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView eXe;
    private TextView eXg;
    private TbImageView eXt;
    private com.baidu.tieba.personPolymeric.c.e eXu;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.eXt = (TbImageView) this.mRootView.findViewById(w.h.card_person_auth_icon);
        this.eXg = (TextView) this.mRootView.findViewById(w.h.card_person_auth_bar_name);
        this.eXe = (TextView) this.mRootView.findViewById(w.h.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            as.j(this.mRootView, w.e.cp_bg_line_d);
            as.c(this.eXg, w.e.cp_cont_b, 1);
            as.c(this.eXe, w.e.cp_cont_d, 1);
            if (this.eXu.iconUrl == null) {
                as.c(this.eXt, w.g.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.eXu = eVar;
            if (eVar.iconUrl != null) {
                this.eXt.c(eVar.iconUrl, 10, false);
            }
            this.eXg.setText(eVar.cLo);
            this.eXe.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
