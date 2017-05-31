package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView aVT;
    private TextView bvI;
    private String eKB;
    private View mRootView;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        R(getView());
    }

    private void R(View view) {
        this.mRootView = view.findViewById(w.h.card_null_polymeric_rootview);
        this.aVT = (ImageView) view.findViewById(w.h.card_null_polymeric_icon);
        this.bvI = (TextView) view.findViewById(w.h.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.mRootView, w.e.cp_bg_line_d);
            aq.c(this.aVT, w.g.emotion07);
            aq.c(this.bvI, w.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_null_polymeric_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.i iVar) {
        String string;
        if (iVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        if (StringUtils.isNull(this.eKB)) {
            TextView textView = this.bvI;
            String string2 = this.mContext.getString(w.l.person_polymeric_null_data);
            Object[] objArr = new Object[1];
            if (iVar.bld) {
                string = this.mContext.getString(w.l.you);
            } else {
                string = iVar.sex == 2 ? this.mContext.getString(w.l.person_identity_she) : this.mContext.getString(w.l.he);
            }
            objArr[0] = string;
            textView.setText(String.format(string2, objArr));
            return;
        }
        this.bvI.setText(this.eKB);
    }

    public void setTip(String str) {
        this.eKB = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
