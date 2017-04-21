package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> {
    private TextView Ru;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Ru = (TextView) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aq.c(this.Ru, w.e.cp_cont_d, 1);
            aq.j(this.Ru, w.e.cp_bg_line_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_person_title_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.j jVar) {
        if (jVar != null) {
            this.Ru.setPadding(jVar.paddingLeft, jVar.paddingTop, 0, jVar.paddingBottom);
            this.Ru.setText(this.mContext.getString(jVar.titleId));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
