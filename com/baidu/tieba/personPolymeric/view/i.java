package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.k> {
    private TextView abq;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.abq = (TextView) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.c(this.abq, d.C0141d.cp_cont_d, 1);
            al.i(this.abq, d.C0141d.cp_bg_line_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_person_title_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.k kVar) {
        if (kVar != null) {
            this.abq.setPadding(kVar.paddingLeft, kVar.paddingTop, 0, kVar.paddingBottom);
            this.abq.setText(this.mContext.getString(kVar.titleId));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
