package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.h> {
    private ImageView aRt;
    private TextView cyk;
    private View mRootView;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Y(getView());
    }

    private void Y(View view) {
        this.mRootView = view.findViewById(r.h.card_null_polymeric_rootview);
        this.aRt = (ImageView) view.findViewById(r.h.card_null_polymeric_icon);
        this.cyk = (TextView) view.findViewById(r.h.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.j(this.mRootView, r.e.cp_bg_line_d);
            ap.c(this.aRt, r.g.emotion07);
            ap.c(this.cyk, r.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_null_polymeric_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.h hVar) {
        String string;
        if (hVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        TextView textView = this.cyk;
        String string2 = this.mContext.getString(r.l.person_polymeric_null_data);
        Object[] objArr = new Object[1];
        if (hVar.baK) {
            string = this.mContext.getString(r.l.you);
        } else {
            string = hVar.sex == 2 ? this.mContext.getString(r.l.person_identity_she) : this.mContext.getString(r.l.he);
        }
        objArr[0] = string;
        textView.setText(String.format(string2, objArr));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
