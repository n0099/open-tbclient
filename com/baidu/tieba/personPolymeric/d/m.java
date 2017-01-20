package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.j> {
    private TextView LX;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.LX = (TextView) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.c(this.LX, r.e.cp_cont_d, 1);
            ap.j((View) this.LX, r.e.cp_bg_line_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_person_title_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.j jVar) {
        if (jVar != null) {
            this.LX.setPadding(jVar.paddingLeft, jVar.paddingTop, 0, jVar.paddingBottom);
            this.LX.setText(this.mContext.getString(jVar.eEj));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
