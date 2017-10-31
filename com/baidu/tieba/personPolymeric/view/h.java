package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.k> implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.b.b fmK;
    private TextView fqs;
    private TextView fqt;
    private TextView fqu;
    private ImageView fqv;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_privacy_setting_rootview);
        this.fqv = (ImageView) view.findViewById(d.g.lock_img);
        this.fqs = (TextView) view.findViewById(d.g.one_public_tv);
        this.fqt = (TextView) view.findViewById(d.g.privacy_setting_tv);
        this.fqu = (TextView) view.findViewById(d.g.card_hint_txt);
        this.fqs.setOnClickListener(this);
        this.fqt.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.C0080d.cp_bg_line_d);
            aj.c(this.fqu, d.C0080d.cp_cont_d, 1);
            aj.c(this.fqv, d.f.pic_pop_key);
            aj.c(this.fqs, d.C0080d.cp_link_tip_c, 1);
            aj.c(this.fqt, d.C0080d.cp_link_tip_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_privacy_setting_view;
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
        this.fmK = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.fmK != null) {
            if (view == this.fqs) {
                this.fmK.aZw();
            } else if (view == this.fqt) {
                this.fmK.aZx();
            }
        }
    }
}
