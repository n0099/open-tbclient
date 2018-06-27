package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TbImageView gbL;
    private com.baidu.tieba.personPolymeric.c.e gbM;
    private TextView gbw;
    private TextView gby;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.gbL = (TbImageView) this.mRootView.findViewById(d.g.card_person_auth_icon);
        this.gby = (TextView) this.mRootView.findViewById(d.g.card_person_auth_bar_name);
        this.gbw = (TextView) this.mRootView.findViewById(d.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.i(this.mRootView, d.C0142d.cp_bg_line_d);
            am.c(this.gby, d.C0142d.cp_cont_b, 1);
            am.c(this.gbw, d.C0142d.cp_cont_d, 1);
            if (this.gbM.iconUrl == null) {
                am.c(this.gbL, d.f.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.gbM = eVar;
            if (eVar.iconUrl != null) {
                this.gbL.startLoad(eVar.iconUrl, 10, false);
            }
            this.gby.setText(eVar.gaB);
            this.gbw.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
