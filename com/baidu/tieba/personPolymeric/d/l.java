package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView aTH;
    private TextView cFX;
    private View mRootView;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        V(getView());
    }

    private void V(View view) {
        this.mRootView = view.findViewById(t.g.card_privacy_rootview);
        this.aTH = (ImageView) view.findViewById(t.g.card_privacy_icon);
        this.cFX = (TextView) view.findViewById(t.g.card_privacy_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(this.mRootView, t.d.cp_bg_line_d);
            av.c(this.aTH, t.f.icon_mine_lock);
            av.c(this.cFX, t.d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_privacy_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.i iVar) {
        String string = iVar.sex == 2 ? this.mContext.getString(t.j.person_identity_she) : this.mContext.getString(t.j.person_identity_he);
        StringBuffer stringBuffer = new StringBuffer();
        if (iVar.eIm) {
            stringBuffer.append(this.mContext.getString(t.j.person_polymeric_privacry_post));
        }
        if (!StringUtils.isNull(stringBuffer.toString()) && iVar.eIl) {
            stringBuffer.append(this.mContext.getString(t.j.person_polymeric_privacry_and));
        }
        if (iVar.eIl) {
            stringBuffer.append(this.mContext.getString(t.j.person_polymeric_privacry_bar));
        }
        this.cFX.setText(String.format(this.mContext.getString(t.j.person_polymeric_privacry_tip), string, stringBuffer.toString()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
