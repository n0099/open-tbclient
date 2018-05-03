package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View bis;
    private com.baidu.tieba.personPolymeric.b.b fHZ;
    private TextView fLA;
    private TextView fLB;
    private ImageView fLC;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.mRootView = view2.findViewById(d.g.card_privacy_setting_rootview);
        this.bis = view2.findViewById(d.g.top_divider_line);
        this.fLC = (ImageView) view2.findViewById(d.g.lock_img);
        this.fLA = (TextView) view2.findViewById(d.g.one_public_tv);
        this.fLB = (TextView) view2.findViewById(d.g.card_hint_txt);
        this.fLA.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
            ak.i(this.bis, d.C0126d.cp_bg_line_e);
            ak.c(this.fLB, d.C0126d.cp_cont_d, 1);
            ak.c(this.fLC, d.f.pic_pop_key);
            ak.c(this.fLA, d.C0126d.cp_link_tip_c, 1);
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
        if (this.bis != null) {
            if (jVar.csE) {
                this.bis.setVisibility(8);
            } else {
                this.bis.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.fHZ = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null && this.fHZ != null && view2 == this.fLA) {
            this.fHZ.beO();
        }
    }
}
