package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class n extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.o> {
    private TbPageContext mPageContext;
    private View mRootView;
    private TbImageView mwr;
    private TextView mws;

    public n(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRootView = getView();
        this.mPageContext = tbPageContext;
        this.mRootView.setTag(this);
        this.mwr = (TbImageView) this.mRootView.findViewById(R.id.gift_pic);
        this.mws = (TextView) this.mRootView.findViewById(R.id.gift_num_text);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setBackgroundResource(this.mwr, R.drawable.item_gift_selector);
        ao.setBackgroundColor(this.mws, R.color.common_color_10294);
        ao.setViewTextColor(this.mws, R.color.CAM_X0302);
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
        this.mwr.startLoad(oVar.picUrl, 10, false);
        this.mRootView.setOnClickListener(this);
        if (oVar.giftNum > 0) {
            this.mws.setVisibility(0);
            if (oVar.giftNum > 99) {
                this.mws.setText("99");
                return;
            } else {
                this.mws.setText(String.valueOf(oVar.giftNum));
                return;
            }
        }
        this.mws.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
