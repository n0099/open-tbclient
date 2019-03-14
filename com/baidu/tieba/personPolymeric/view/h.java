package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View cYJ;
    private com.baidu.tieba.personPolymeric.b.b hPW;
    private TextView hTm;
    private ImageView hTn;
    private TextView mHint;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_privacy_setting_rootview);
        this.cYJ = view.findViewById(d.g.top_divider_line);
        this.hTn = (ImageView) view.findViewById(d.g.lock_img);
        this.hTm = (TextView) view.findViewById(d.g.one_public_tv);
        this.mHint = (TextView) view.findViewById(d.g.card_hint_txt);
        this.hTm.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, d.C0277d.cp_bg_line_d);
            al.k(this.cYJ, d.C0277d.cp_bg_line_e);
            al.d(this.mHint, d.C0277d.cp_cont_d, 1);
            al.c(this.hTn, d.f.pic_pop_key);
            al.d(this.hTm, d.C0277d.cp_link_tip_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_privacy_setting_view;
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
        if (this.cYJ != null) {
            if (jVar.emn) {
                this.cYJ.setVisibility(8);
            } else {
                this.cYJ.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.hPW = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.hPW != null && view == this.hTm) {
            this.hPW.bRB();
        }
    }
}
