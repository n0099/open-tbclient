package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class i extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.k> {
    private TextView dDu;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dDu = (TextView) getView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setViewTextColor(this.dDu, R.color.cp_cont_b, 1);
            an.setBackgroundResource(this.dDu, R.color.cp_bg_line_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_person_title_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.k kVar) {
        if (kVar != null) {
            this.dDu.setPadding(kVar.paddingLeft, kVar.paddingTop, 0, kVar.paddingBottom);
            this.dDu.setText(this.mContext.getString(kVar.titleId));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
