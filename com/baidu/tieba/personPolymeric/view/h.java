package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View bsU;
    private com.baidu.tieba.personPolymeric.b.b fYT;
    private TextView gck;
    private ImageView gcl;
    private TextView mHint;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(f.g.card_privacy_setting_rootview);
        this.bsU = view.findViewById(f.g.top_divider_line);
        this.gcl = (ImageView) view.findViewById(f.g.lock_img);
        this.gck = (TextView) view.findViewById(f.g.one_public_tv);
        this.mHint = (TextView) view.findViewById(f.g.card_hint_txt);
        this.gck.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.mRootView, f.d.cp_bg_line_d);
            am.i(this.bsU, f.d.cp_bg_line_e);
            am.c(this.mHint, f.d.cp_cont_d, 1);
            am.c(this.gcl, f.C0146f.pic_pop_key);
            am.c(this.gck, f.d.cp_link_tip_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_privacy_setting_view;
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
        if (this.bsU != null) {
            if (jVar.cCO) {
                this.bsU.setVisibility(8);
            } else {
                this.bsU.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.fYT = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.fYT != null && view == this.gck) {
            this.fYT.biK();
        }
    }
}
