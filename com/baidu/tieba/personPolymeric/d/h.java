package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> {
    private ImageView aYC;
    private TextView cOY;
    private View mRootView;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        S(getView());
    }

    private void S(View view) {
        this.mRootView = view.findViewById(d.h.card_privacy_rootview);
        this.aYC = (ImageView) view.findViewById(d.h.card_privacy_icon);
        this.cOY = (TextView) view.findViewById(d.h.card_privacy_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.mRootView, d.e.cp_bg_line_d);
            ai.c(this.aYC, d.g.icon_mine_lock);
            ai.c(this.cOY, d.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_privacy_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.j jVar) {
        String string = jVar.sex == 2 ? this.mContext.getString(d.l.person_identity_she) : this.mContext.getString(d.l.he);
        StringBuffer stringBuffer = new StringBuffer();
        if (jVar.fjn) {
            stringBuffer.append(this.mContext.getString(d.l.text_post));
        }
        this.cOY.setText(String.format(this.mContext.getString(d.l.person_polymeric_privacry_tip), string, stringBuffer.toString()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
