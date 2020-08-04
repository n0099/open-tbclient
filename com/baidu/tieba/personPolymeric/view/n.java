package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class n extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.o> {
    private TbImageView laf;
    private TextView lag;
    private TbPageContext mPageContext;
    private View mRootView;

    public n(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.mRootView.setTag(this);
        this.laf = (TbImageView) this.mRootView.findViewById(R.id.gift_pic);
        this.lag = (TextView) this.mRootView.findViewById(R.id.gift_num_text);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ao.setBackgroundResource(this.laf, R.drawable.item_gift_selector);
        ao.setBackgroundColor(this.lag, R.color.common_color_10294);
        ao.setViewTextColor(this.lag, R.color.cp_link_tip_a);
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
        this.laf.startLoad(oVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (oVar.giftNum > 0) {
            this.lag.setVisibility(0);
            if (oVar.giftNum > 99) {
                this.lag.setText("99");
                return;
            } else {
                this.lag.setText(String.valueOf(oVar.giftNum));
                return;
            }
        }
        this.lag.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
