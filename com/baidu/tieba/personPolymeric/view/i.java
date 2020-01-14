package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class i extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.k> {
    private TextView cGN;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cGN = (TextView) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.cGN, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.cGN, R.color.cp_bg_line_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_person_title_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.k kVar) {
        if (kVar != null) {
            this.cGN.setPadding(kVar.paddingLeft, kVar.fMd, 0, kVar.job);
            this.cGN.setText(this.mContext.getString(kVar.titleId));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
