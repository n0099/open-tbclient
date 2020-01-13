package com.baidu.tieba.live.tbean.view;

import android.view.View;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.b.a;
import com.baidu.tieba.live.tbean.data.GiftBagWrapperData;
/* loaded from: classes2.dex */
public class GiftBagItemView extends a<GiftBagWrapperData> {
    private TbImageView mGiftBagPic;

    public GiftBagItemView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mGiftBagPic = (TbImageView) getView().findViewById(a.g.gift_bag_iv);
        this.mGiftBagPic.setDrawerType(1);
        this.mGiftBagPic.setRadius(tbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds5));
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.h.sdk_tbn_buy_gift_bag_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    public void onBindDataToView(GiftBagWrapperData giftBagWrapperData) {
        if (giftBagWrapperData != null && giftBagWrapperData.mData != null && !StringUtils.isNull(giftBagWrapperData.mData.package_pic)) {
            this.mGiftBagPic.startLoad(giftBagWrapperData.mData.package_pic, 10, false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
