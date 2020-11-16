package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.i> {
    private ImageView cdC;
    private TextView jxy;
    private View mRootView;
    private String mgQ;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_null_polymeric_rootview);
        this.cdC = (ImageView) view.findViewById(R.id.card_null_polymeric_icon);
        this.jxy = (TextView) view.findViewById(R.id.card_null_polymeric_txt);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setImageResource(this.cdC, R.drawable.new_pic_emotion_07);
            ap.setViewTextColor(this.jxy, R.color.CAM_X0108, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_null_polymeric_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.i iVar) {
        String string;
        if (iVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        if (StringUtils.isNull(this.mgQ)) {
            TextView textView = this.jxy;
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
        this.jxy.setText(this.mgQ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
