package com.baidu.tieba.live.tbean.adapter;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.live.tbean.data.GiftBagWrapperData;
import com.baidu.tieba.live.tbean.view.CustomViewHolder;
import com.baidu.tieba.live.tbean.view.GiftBagItemView;
/* loaded from: classes3.dex */
public class GiftBagAdapter extends AbsDelegateAdapter<GiftBagWrapperData, CustomViewHolder> {
    private GiftBagItemView mGiftBagItemView;
    private TbPageContext<?> mPageContext;

    public GiftBagAdapter(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), GiftBagWrapperData.TYPE);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        this.mGiftBagItemView = new GiftBagItemView(this.mPageContext);
        return new CustomViewHolder(this.mGiftBagItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, GiftBagWrapperData giftBagWrapperData, CustomViewHolder customViewHolder) {
        if (customViewHolder == null || customViewHolder.getCardView() == null) {
            return null;
        }
        customViewHolder.getCardView().onBindDataToView(giftBagWrapperData);
        return customViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    public View getView(int i, View view, ViewGroup viewGroup, GiftBagWrapperData giftBagWrapperData) {
        if (TbadkCoreApplication.getInst().isHaokan() && (Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20)) {
            BdUtilHelper.clearFocus(this.mContext);
        }
        return super.getView(i, view, viewGroup, (ViewGroup) giftBagWrapperData);
    }
}
