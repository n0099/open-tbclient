package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.h> {
    private ImageView aTH;
    private TextView cFX;
    private View mRootView;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        V(getView());
    }

    private void V(View view) {
        this.mRootView = view.findViewById(t.g.card_null_polymeric_rootview);
        this.aTH = (ImageView) view.findViewById(t.g.card_null_polymeric_icon);
        this.cFX = (TextView) view.findViewById(t.g.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(this.mRootView, t.d.cp_bg_line_d);
            av.c(this.aTH, t.f.emotion07);
            av.c(this.cFX, t.d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_null_polymeric_view;
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
        TextView textView = this.cFX;
        String string2 = this.mContext.getString(t.j.person_polymeric_null_data);
        Object[] objArr = new Object[1];
        if (hVar.bcA) {
            string = this.mContext.getString(t.j.person_identity_you);
        } else {
            string = hVar.sex == 2 ? this.mContext.getString(t.j.person_identity_she) : this.mContext.getString(t.j.person_identity_he);
        }
        objArr[0] = string;
        textView.setText(String.format(string2, objArr));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
