package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> {
    private TextView MN;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.MN = (TextView) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            at.c(this.MN, r.d.cp_cont_d, 1);
            at.k(this.MN, r.d.cp_bg_line_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_person_title_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.j jVar) {
        if (jVar != null) {
            this.MN.setPadding(jVar.paddingLeft, jVar.paddingTop, 0, jVar.paddingBottom);
            this.MN.setText(this.mContext.getString(jVar.eMe));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
