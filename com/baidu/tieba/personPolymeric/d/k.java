package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.h> {
    private ImageView aVT;
    private TextView crg;
    private View mRootView;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        W(getView());
    }

    private void W(View view) {
        this.mRootView = view.findViewById(r.g.card_null_polymeric_rootview);
        this.aVT = (ImageView) view.findViewById(r.g.card_null_polymeric_icon);
        this.crg = (TextView) view.findViewById(r.g.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ar.k(this.mRootView, r.d.cp_bg_line_d);
            ar.c(this.aVT, r.f.emotion07);
            ar.c(this.crg, r.d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_null_polymeric_view;
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
        TextView textView = this.crg;
        String string2 = this.mContext.getString(r.j.person_polymeric_null_data);
        Object[] objArr = new Object[1];
        if (hVar.bfj) {
            string = this.mContext.getString(r.j.you);
        } else {
            string = hVar.sex == 2 ? this.mContext.getString(r.j.person_identity_she) : this.mContext.getString(r.j.he);
        }
        objArr[0] = string;
        textView.setText(String.format(string2, objArr));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
