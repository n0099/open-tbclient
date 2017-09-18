package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView aZy;
    private TextView cZI;
    private String fjt;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.card_null_polymeric_rootview);
        this.aZy = (ImageView) view.findViewById(d.h.card_null_polymeric_icon);
        this.cZI = (TextView) view.findViewById(d.h.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.e.cp_bg_line_d);
            aj.c(this.aZy, d.g.emotion07);
            aj.c(this.cZI, d.e.cp_cont_c, 1);
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
        if (StringUtils.isNull(this.fjt)) {
            TextView textView = this.cZI;
            String string2 = this.mContext.getString(d.l.person_polymeric_null_data);
            Object[] objArr = new Object[1];
            if (iVar.bwa) {
                string = this.mContext.getString(d.l.you);
            } else if (iVar.sex == 2) {
                string = this.mContext.getString(d.l.she);
            } else {
                string = this.mContext.getString(d.l.he);
            }
            objArr[0] = string;
            textView.setText(String.format(string2, objArr));
            return;
        }
        this.cZI.setText(this.fjt);
    }

    public void setTip(String str) {
        this.fjt = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
