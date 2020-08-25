package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class n extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.o> {
    private TbImageView lqu;
    private TextView lqv;
    private TbPageContext mPageContext;
    private View mRootView;

    public n(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.mRootView.setTag(this);
        this.lqu = (TbImageView) this.mRootView.findViewById(R.id.gift_pic);
        this.lqv = (TextView) this.mRootView.findViewById(R.id.gift_num_text);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.lqu, R.drawable.item_gift_selector);
        ap.setBackgroundColor(this.lqv, R.color.common_color_10294);
        ap.setViewTextColor(this.lqv, R.color.cp_link_tip_a);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.item_gift_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.lqu.startLoad(oVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (oVar.giftNum > 0) {
            this.lqv.setVisibility(0);
            if (oVar.giftNum > 99) {
                this.lqv.setText("99");
                return;
            } else {
                this.lqv.setText(String.valueOf(oVar.giftNum));
                return;
            }
        }
        this.lqv.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
