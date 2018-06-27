package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View bsm;
    private com.baidu.tieba.personPolymeric.b.b fYC;
    private TextView gbS;
    private TextView gbT;
    private ImageView gbU;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_privacy_setting_rootview);
        this.bsm = view.findViewById(d.g.top_divider_line);
        this.gbU = (ImageView) view.findViewById(d.g.lock_img);
        this.gbS = (TextView) view.findViewById(d.g.one_public_tv);
        this.gbT = (TextView) view.findViewById(d.g.card_hint_txt);
        this.gbS.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.mRootView, d.C0142d.cp_bg_line_d);
            am.i(this.bsm, d.C0142d.cp_bg_line_e);
            am.c(this.gbT, d.C0142d.cp_cont_d, 1);
            am.c(this.gbU, d.f.pic_pop_key);
            am.c(this.gbS, d.C0142d.cp_link_tip_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_privacy_setting_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.j jVar) {
        if (jVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        if (this.bsm != null) {
            if (jVar.cAm) {
                this.bsm.setVisibility(8);
            } else {
                this.bsm.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.fYC = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.fYC != null && view == this.gbS) {
            this.fYC.bku();
        }
    }
}
