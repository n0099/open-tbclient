package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> {
    private ImageView aVT;
    private TextView bvI;
    private View mRootView;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        R(getView());
    }

    private void R(View view) {
        this.mRootView = view.findViewById(w.h.card_privacy_rootview);
        this.aVT = (ImageView) view.findViewById(w.h.card_privacy_icon);
        this.bvI = (TextView) view.findViewById(w.h.card_privacy_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.mRootView, w.e.cp_bg_line_d);
            aq.c(this.aVT, w.g.icon_mine_lock);
            aq.c(this.bvI, w.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_privacy_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.j jVar) {
        String string = jVar.sex == 2 ? this.mContext.getString(w.l.person_identity_she) : this.mContext.getString(w.l.he);
        StringBuffer stringBuffer = new StringBuffer();
        if (jVar.eMC) {
            stringBuffer.append(this.mContext.getString(w.l.text_post));
        }
        this.bvI.setText(String.format(this.mContext.getString(w.l.person_polymeric_privacry_tip), string, stringBuffer.toString()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
