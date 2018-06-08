package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView bmJ;
    private TextView dNr;
    private String fXR;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_null_polymeric_rootview);
        this.bmJ = (ImageView) view.findViewById(d.g.card_null_polymeric_icon);
        this.dNr = (TextView) view.findViewById(d.g.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, d.C0141d.cp_bg_line_d);
            al.c(this.bmJ, d.f.emotion07);
            al.c(this.dNr, d.C0141d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_null_polymeric_view;
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
        if (StringUtils.isNull(this.fXR)) {
            TextView textView = this.dNr;
            String string2 = this.mContext.getString(d.k.person_polymeric_null_data);
            Object[] objArr = new Object[1];
            if (iVar.isHost) {
                string = this.mContext.getString(d.k.you);
            } else if (iVar.sex == 2) {
                string = this.mContext.getString(d.k.she);
            } else {
                string = this.mContext.getString(d.k.he);
            }
            objArr[0] = string;
            textView.setText(String.format(string2, objArr));
            return;
        }
        this.dNr.setText(this.fXR);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
