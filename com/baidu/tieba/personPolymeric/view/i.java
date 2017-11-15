package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> {
    private ImageView bbM;
    private TextView deH;
    private View mRootView;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_privacy_rootview);
        this.bbM = (ImageView) view.findViewById(d.g.card_privacy_icon);
        this.deH = (TextView) view.findViewById(d.g.card_privacy_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.C0080d.cp_bg_line_d);
            aj.c(this.bbM, d.f.icon_mine_lock);
            aj.c(this.deH, d.C0080d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_privacy_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.j jVar) {
        String string = jVar.sex == 2 ? this.mContext.getString(d.j.she) : this.mContext.getString(d.j.he);
        StringBuffer stringBuffer = new StringBuffer();
        if (jVar.fpP) {
            stringBuffer.append(this.mContext.getString(d.j.text_post));
        }
        this.deH.setText(String.format(this.mContext.getString(d.j.person_polymeric_privacry_tip), string, stringBuffer.toString()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
