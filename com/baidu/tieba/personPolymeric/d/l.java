package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView aXV;
    private TextView cAx;
    private View mRootView;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        W(getView());
    }

    private void W(View view) {
        this.mRootView = view.findViewById(w.h.card_privacy_rootview);
        this.aXV = (ImageView) view.findViewById(w.h.card_privacy_icon);
        this.cAx = (TextView) view.findViewById(w.h.card_privacy_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.mRootView, w.e.cp_bg_line_d);
            aq.c(this.aXV, w.g.icon_mine_lock);
            aq.c(this.cAx, w.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_privacy_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.i iVar) {
        String string = iVar.sex == 2 ? this.mContext.getString(w.l.person_identity_she) : this.mContext.getString(w.l.he);
        StringBuffer stringBuffer = new StringBuffer();
        if (iVar.eHV) {
            stringBuffer.append(this.mContext.getString(w.l.text_post));
        }
        if (!StringUtils.isNull(stringBuffer.toString()) && iVar.eHU) {
            stringBuffer.append(this.mContext.getString(w.l.person_polymeric_privacry_and));
        }
        if (iVar.eHU) {
            stringBuffer.append(this.mContext.getString(w.l.forum));
        }
        this.cAx.setText(String.format(this.mContext.getString(w.l.person_polymeric_privacry_tip), string, stringBuffer.toString()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
