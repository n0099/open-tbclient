package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView aVT;
    private TextView crg;
    private View mRootView;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        W(getView());
    }

    private void W(View view) {
        this.mRootView = view.findViewById(r.g.card_privacy_rootview);
        this.aVT = (ImageView) view.findViewById(r.g.card_privacy_icon);
        this.crg = (TextView) view.findViewById(r.g.card_privacy_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ar.k(this.mRootView, r.d.cp_bg_line_d);
            ar.c(this.aVT, r.f.icon_mine_lock);
            ar.c(this.crg, r.d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_privacy_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.i iVar) {
        String string = iVar.sex == 2 ? this.mContext.getString(r.j.person_identity_she) : this.mContext.getString(r.j.he);
        StringBuffer stringBuffer = new StringBuffer();
        if (iVar.eun) {
            stringBuffer.append(this.mContext.getString(r.j.person_polymeric_privacry_post));
        }
        if (!StringUtils.isNull(stringBuffer.toString()) && iVar.eum) {
            stringBuffer.append(this.mContext.getString(r.j.person_polymeric_privacry_and));
        }
        if (iVar.eum) {
            stringBuffer.append(this.mContext.getString(r.j.person_polymeric_privacry_bar));
        }
        this.crg.setText(String.format(this.mContext.getString(r.j.person_polymeric_privacry_tip), string, stringBuffer.toString()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
