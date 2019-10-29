package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView djP;
    private TextView geO;
    private String itJ;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_null_polymeric_rootview);
        this.djP = (ImageView) view.findViewById(R.id.card_null_polymeric_icon);
        this.geO = (TextView) view.findViewById(R.id.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setImageResource(this.djP, R.drawable.new_pic_emotion_07);
            am.setViewTextColor(this.geO, R.color.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_null_polymeric_view;
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
        if (StringUtils.isNull(this.itJ)) {
            TextView textView = this.geO;
            String string2 = this.mContext.getString(R.string.person_polymeric_null_data);
            Object[] objArr = new Object[1];
            if (iVar.isHost) {
                string = this.mContext.getString(R.string.you);
            } else if (iVar.sex == 2) {
                string = this.mContext.getString(R.string.she);
            } else {
                string = this.mContext.getString(R.string.he);
            }
            objArr[0] = string;
            textView.setText(String.format(string2, objArr));
            return;
        }
        this.geO.setText(this.itJ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
