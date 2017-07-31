package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView aZN;
    private TextView cQr;
    private String fil;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        S(getView());
    }

    private void S(View view) {
        this.mRootView = view.findViewById(d.h.card_null_polymeric_rootview);
        this.aZN = (ImageView) view.findViewById(d.h.card_null_polymeric_icon);
        this.cQr = (TextView) view.findViewById(d.h.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.mRootView, d.e.cp_bg_line_d);
            ai.c(this.aZN, d.g.emotion07);
            ai.c(this.cQr, d.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_null_polymeric_view;
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
        if (StringUtils.isNull(this.fil)) {
            TextView textView = this.cQr;
            String string2 = this.mContext.getString(d.l.person_polymeric_null_data);
            Object[] objArr = new Object[1];
            if (iVar.buk) {
                string = this.mContext.getString(d.l.you);
            } else if (iVar.sex == 2) {
                string = this.mContext.getString(d.l.person_identity_she);
            } else {
                string = this.mContext.getString(d.l.he);
            }
            objArr[0] = string;
            textView.setText(String.format(string2, objArr));
            return;
        }
        this.cQr.setText(this.fil);
    }

    public void setTip(String str) {
        this.fil = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
