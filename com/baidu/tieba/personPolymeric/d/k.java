package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.h> {
    private ImageView aYr;
    private TextView cvH;
    private View mRootView;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        V(getView());
    }

    private void V(View view) {
        this.mRootView = view.findViewById(w.h.card_null_polymeric_rootview);
        this.aYr = (ImageView) view.findViewById(w.h.card_null_polymeric_icon);
        this.cvH = (TextView) view.findViewById(w.h.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.mRootView, w.e.cp_bg_line_d);
            aq.c(this.aYr, w.g.emotion07);
            aq.c(this.cvH, w.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_null_polymeric_view;
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
        TextView textView = this.cvH;
        String string2 = this.mContext.getString(w.l.person_polymeric_null_data);
        Object[] objArr = new Object[1];
        if (hVar.bjW) {
            string = this.mContext.getString(w.l.you);
        } else {
            string = hVar.sex == 2 ? this.mContext.getString(w.l.person_identity_she) : this.mContext.getString(w.l.he);
        }
        objArr[0] = string;
        textView.setText(String.format(string2, objArr));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
