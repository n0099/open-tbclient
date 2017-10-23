package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.k> implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.b.b feu;
    private TextView fhT;
    private TextView fhU;
    private TextView fhV;
    private ImageView fhW;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.card_privacy_setting_rootview);
        this.fhW = (ImageView) view.findViewById(d.h.lock_img);
        this.fhT = (TextView) view.findViewById(d.h.one_public_tv);
        this.fhU = (TextView) view.findViewById(d.h.privacy_setting_tv);
        this.fhV = (TextView) view.findViewById(d.h.card_hint_txt);
        this.fhT.setOnClickListener(this);
        this.fhU.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.e.cp_bg_line_d);
            aj.c(this.fhV, d.e.cp_cont_d, 1);
            aj.c(this.fhW, d.g.pic_pop_key);
            aj.c(this.fhT, d.e.cp_link_tip_c, 1);
            aj.c(this.fhU, d.e.cp_link_tip_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_privacy_setting_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.k kVar) {
        if (kVar == null) {
            this.mRootView.setVisibility(8);
        } else if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.feu = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.feu != null) {
            if (view == this.fhT) {
                this.feu.aWt();
            } else if (view == this.fhU) {
                this.feu.aWu();
            }
        }
    }
}
