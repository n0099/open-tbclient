package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView bzu;
    private TextView ejX;
    private String gsA;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.card_null_polymeric_rootview);
        this.bzu = (ImageView) view.findViewById(e.g.card_null_polymeric_icon);
        this.ejX = (TextView) view.findViewById(e.g.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.bzu, e.f.emotion07);
            al.c(this.ejX, e.d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_null_polymeric_view;
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
        if (StringUtils.isNull(this.gsA)) {
            TextView textView = this.ejX;
            String string2 = this.mContext.getString(e.j.person_polymeric_null_data);
            Object[] objArr = new Object[1];
            if (iVar.isHost) {
                string = this.mContext.getString(e.j.you);
            } else if (iVar.sex == 2) {
                string = this.mContext.getString(e.j.she);
            } else {
                string = this.mContext.getString(e.j.he);
            }
            objArr[0] = string;
            textView.setText(String.format(string2, objArr));
            return;
        }
        this.ejX.setText(this.gsA);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
