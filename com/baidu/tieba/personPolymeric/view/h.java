package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View bMJ;
    private TextView gDm;
    private ImageView gDn;
    private com.baidu.tieba.personPolymeric.b.b gzW;
    private TextView mHint;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.card_privacy_setting_rootview);
        this.bMJ = view.findViewById(e.g.top_divider_line);
        this.gDn = (ImageView) view.findViewById(e.g.lock_img);
        this.gDm = (TextView) view.findViewById(e.g.one_public_tv);
        this.mHint = (TextView) view.findViewById(e.g.card_hint_txt);
        this.gDm.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.i(this.bMJ, e.d.cp_bg_line_e);
            al.c(this.mHint, e.d.cp_cont_d, 1);
            al.c(this.gDn, e.f.pic_pop_key);
            al.c(this.gDm, e.d.cp_link_tip_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_privacy_setting_view;
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
        if (this.bMJ != null) {
            if (jVar.dcp) {
                this.bMJ.setVisibility(8);
            } else {
                this.bMJ.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.gzW = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gzW != null && view == this.gDm) {
            this.gzW.bre();
        }
    }
}
