package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View bYp;
    private com.baidu.tieba.personPolymeric.b.b gno;
    private TextView gqM;
    private TextView gqN;
    private ImageView gqO;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_privacy_setting_rootview);
        this.bYp = view.findViewById(d.g.top_divider_line);
        this.gqO = (ImageView) view.findViewById(d.g.lock_img);
        this.gqM = (TextView) view.findViewById(d.g.one_public_tv);
        this.gqN = (TextView) view.findViewById(d.g.card_hint_txt);
        this.gqM.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
            aj.s(this.bYp, d.C0141d.cp_bg_line_e);
            aj.e(this.gqN, d.C0141d.cp_cont_d, 1);
            aj.c(this.gqO, d.f.pic_pop_key);
            aj.e(this.gqM, d.C0141d.cp_link_tip_c, 1);
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
        if (this.bYp != null) {
            if (jVar.daM) {
                this.bYp.setVisibility(8);
            } else {
                this.bYp.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.gno = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gno != null && view == this.gqM) {
            this.gno.bjL();
        }
    }
}
