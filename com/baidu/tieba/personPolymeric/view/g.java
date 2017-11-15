package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView bbM;
    private TextView deH;
    private String fnf;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_null_polymeric_rootview);
        this.bbM = (ImageView) view.findViewById(d.g.card_null_polymeric_icon);
        this.deH = (TextView) view.findViewById(d.g.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.C0080d.cp_bg_line_d);
            aj.c(this.bbM, d.f.emotion07);
            aj.c(this.deH, d.C0080d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_null_polymeric_view;
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
        if (StringUtils.isNull(this.fnf)) {
            TextView textView = this.deH;
            String string2 = this.mContext.getString(d.j.person_polymeric_null_data);
            Object[] objArr = new Object[1];
            if (iVar.isHost) {
                string = this.mContext.getString(d.j.you);
            } else if (iVar.sex == 2) {
                string = this.mContext.getString(d.j.she);
            } else {
                string = this.mContext.getString(d.j.he);
            }
            objArr[0] = string;
            textView.setText(String.format(string2, objArr));
            return;
        }
        this.deH.setText(this.fnf);
    }

    public void setTip(String str) {
        this.fnf = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
