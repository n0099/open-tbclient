package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.l> {
    private TextView Rz;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Rz = (TextView) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.c(this.Rz, d.C0080d.cp_cont_d, 1);
            aj.j(this.Rz, d.C0080d.cp_bg_line_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_person_title_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.l lVar) {
        if (lVar != null) {
            this.Rz.setPadding(lVar.paddingLeft, lVar.paddingTop, 0, lVar.paddingBottom);
            this.Rz.setText(this.mContext.getString(lVar.titleId));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
