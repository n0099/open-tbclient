package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView aRt;
    private TextView cyk;
    private View mRootView;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Y(getView());
    }

    private void Y(View view) {
        this.mRootView = view.findViewById(r.h.card_privacy_rootview);
        this.aRt = (ImageView) view.findViewById(r.h.card_privacy_icon);
        this.cyk = (TextView) view.findViewById(r.h.card_privacy_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.j(this.mRootView, r.e.cp_bg_line_d);
            ap.c(this.aRt, r.g.icon_mine_lock);
            ap.c(this.cyk, r.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_privacy_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.i iVar) {
        String string = iVar.sex == 2 ? this.mContext.getString(r.l.person_identity_she) : this.mContext.getString(r.l.he);
        StringBuffer stringBuffer = new StringBuffer();
        if (iVar.eEh) {
            stringBuffer.append(this.mContext.getString(r.l.text_post));
        }
        if (!StringUtils.isNull(stringBuffer.toString()) && iVar.eEg) {
            stringBuffer.append(this.mContext.getString(r.l.person_polymeric_privacry_and));
        }
        if (iVar.eEg) {
            stringBuffer.append(this.mContext.getString(r.l.person_polymeric_privacry_bar));
        }
        this.cyk.setText(String.format(this.mContext.getString(r.l.person_polymeric_privacry_tip), string, stringBuffer.toString()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
