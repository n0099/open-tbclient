package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> implements View.OnClickListener {
    private View djv;
    private com.baidu.tieba.personPolymeric.b.b iiz;
    private TextView ilP;
    private ImageView ilQ;
    private TextView mHint;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_privacy_setting_rootview);
        this.djv = view.findViewById(R.id.top_divider_line);
        this.ilQ = (ImageView) view.findViewById(R.id.lock_img);
        this.ilP = (TextView) view.findViewById(R.id.one_public_tv);
        this.mHint = (TextView) view.findViewById(R.id.card_hint_txt);
        this.ilP.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, R.color.cp_bg_line_d);
            al.k(this.djv, R.color.cp_bg_line_e);
            al.f(this.mHint, R.color.cp_cont_d, 1);
            al.c(this.ilQ, (int) R.drawable.pic_pop_key);
            al.f(this.ilP, R.color.cp_link_tip_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_privacy_setting_view;
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
        if (this.djv != null) {
            if (jVar.eBO) {
                this.djv.setVisibility(8);
            } else {
                this.djv.setVisibility(0);
            }
        }
    }

    public void b(com.baidu.tieba.personPolymeric.b.b bVar) {
        this.iiz = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.iiz != null && view == this.ilP) {
            this.iiz.bZH();
        }
    }
}
