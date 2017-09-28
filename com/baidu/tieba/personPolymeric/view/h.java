package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.k> implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.b.b feJ;
    private TextView fij;
    private TextView fik;
    private TextView fil;
    private ImageView fim;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.card_privacy_setting_rootview);
        this.fim = (ImageView) view.findViewById(d.h.lock_img);
        this.fij = (TextView) view.findViewById(d.h.one_public_tv);
        this.fik = (TextView) view.findViewById(d.h.privacy_setting_tv);
        this.fil = (TextView) view.findViewById(d.h.card_hint_txt);
        this.fij.setOnClickListener(this);
        this.fik.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.e.cp_bg_line_d);
            aj.c(this.fil, d.e.cp_cont_d, 1);
            aj.c(this.fim, d.g.pic_pop_key);
            aj.c(this.fij, d.e.cp_link_tip_c, 1);
            aj.c(this.fik, d.e.cp_link_tip_c, 1);
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
        this.feJ = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.feJ != null) {
            if (view == this.fij) {
                this.feJ.aWz();
            } else if (view == this.fik) {
                this.feJ.aWA();
            }
        }
    }
}
