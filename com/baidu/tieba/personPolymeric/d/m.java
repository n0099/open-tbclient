package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.k> {
    private TextView Qy;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Qy = (TextView) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.c(this.Qy, w.e.cp_cont_d, 1);
            aq.j(this.Qy, w.e.cp_bg_line_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_person_title_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.k kVar) {
        if (kVar != null) {
            this.Qy.setPadding(kVar.paddingLeft, kVar.paddingTop, 0, kVar.paddingBottom);
            this.Qy.setText(this.mContext.getString(kVar.titleId));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
