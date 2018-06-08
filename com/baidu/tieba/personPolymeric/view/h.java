package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View bqM;
    private com.baidu.tieba.personPolymeric.b.b fUA;
    private TextView fXS;
    private TextView fXT;
    private ImageView fXU;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_privacy_setting_rootview);
        this.bqM = view.findViewById(d.g.top_divider_line);
        this.fXU = (ImageView) view.findViewById(d.g.lock_img);
        this.fXS = (TextView) view.findViewById(d.g.one_public_tv);
        this.fXT = (TextView) view.findViewById(d.g.card_hint_txt);
        this.fXS.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, d.C0141d.cp_bg_line_d);
            al.i(this.bqM, d.C0141d.cp_bg_line_e);
            al.c(this.fXT, d.C0141d.cp_cont_d, 1);
            al.c(this.fXU, d.f.pic_pop_key);
            al.c(this.fXS, d.C0141d.cp_link_tip_c, 1);
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
        if (this.bqM != null) {
            if (jVar.cCs) {
                this.bqM.setVisibility(8);
            } else {
                this.bqM.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.fUA = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.fUA != null && view == this.fXS) {
            this.fUA.bjO();
        }
    }
}
