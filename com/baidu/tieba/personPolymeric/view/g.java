package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView beA;
    private TextView dBg;
    private String fLC;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.mRootView = view2.findViewById(d.g.card_null_polymeric_rootview);
        this.beA = (ImageView) view2.findViewById(d.g.card_null_polymeric_icon);
        this.dBg = (TextView) view2.findViewById(d.g.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
            ak.c(this.beA, d.f.emotion07);
            ak.c(this.dBg, d.C0126d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_null_polymeric_view;
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
        if (StringUtils.isNull(this.fLC)) {
            TextView textView = this.dBg;
            String string2 = this.mContext.getString(d.k.person_polymeric_null_data);
            Object[] objArr = new Object[1];
            if (iVar.isHost) {
                string = this.mContext.getString(d.k.you);
            } else if (iVar.sex == 2) {
                string = this.mContext.getString(d.k.she);
            } else {
                string = this.mContext.getString(d.k.he);
            }
            objArr[0] = string;
            textView.setText(String.format(string2, objArr));
            return;
        }
        this.dBg.setText(this.fLC);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
