package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> {
    private ImageView aXm;
    private TextView cJY;
    private View mRootView;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        S(getView());
    }

    private void S(View view) {
        this.mRootView = view.findViewById(w.h.card_privacy_rootview);
        this.aXm = (ImageView) view.findViewById(w.h.card_privacy_icon);
        this.cJY = (TextView) view.findViewById(w.h.card_privacy_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.j(this.mRootView, w.e.cp_bg_line_d);
            as.c(this.aXm, w.g.icon_mine_lock);
            as.c(this.cJY, w.e.cp_cont_c, 1);
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
        if (jVar.eWL) {
            stringBuffer.append(this.mContext.getString(w.l.text_post));
        }
        this.cJY.setText(String.format(this.mContext.getString(w.l.person_polymeric_privacry_tip), string, stringBuffer.toString()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
