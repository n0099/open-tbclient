package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.e> {
    private TextView gsf;
    private TextView gsh;
    private TbImageView gsu;
    private com.baidu.tieba.personPolymeric.c.e gsv;
    private View mRootView;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.gsu = (TbImageView) this.mRootView.findViewById(e.g.card_person_auth_icon);
        this.gsh = (TextView) this.mRootView.findViewById(e.g.card_person_auth_bar_name);
        this.gsf = (TextView) this.mRootView.findViewById(e.g.card_person_auth_des);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.gsh, e.d.cp_cont_b, 1);
            al.c(this.gsf, e.d.cp_cont_d, 1);
            if (this.gsv.iconUrl == null) {
                al.c(this.gsu, e.f.icon_shen_mine);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_person_auth_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.e eVar) {
        if (eVar != null) {
            this.gsv = eVar;
            if (eVar.iconUrl != null) {
                this.gsu.startLoad(eVar.iconUrl, 10, false);
            }
            this.gsh.setText(eVar.grk);
            this.gsf.setText(eVar.des);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
