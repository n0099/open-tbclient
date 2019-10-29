package com.baidu.tieba.live.tbean.adapter;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.live.tbean.data.IconInfoWrapperData;
import com.baidu.tieba.live.tbean.view.BuyTbeanItemView;
import com.baidu.tieba.live.tbean.view.CustomViewHolder;
/* loaded from: classes6.dex */
public class BuyTBeanAdapter extends AbsDelegateAdapter<IconInfoWrapperData, CustomViewHolder> {
    private BuyTbeanItemView mBuyTbeanItemView;
    private boolean mIsFromAlaLiveRoom;
    private TbPageContext<?> mPageContext;

    public BuyTBeanAdapter(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity(), IconInfoWrapperData.TYPE);
        this.mPageContext = tbPageContext;
        this.mIsFromAlaLiveRoom = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        this.mBuyTbeanItemView = new BuyTbeanItemView(this.mPageContext, this.mIsFromAlaLiveRoom);
        return new CustomViewHolder(this.mBuyTbeanItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, IconInfoWrapperData iconInfoWrapperData, CustomViewHolder customViewHolder) {
        if (customViewHolder == null || customViewHolder.getCardView() == null) {
            return null;
        }
        customViewHolder.getCardView().onBindDataToView(iconInfoWrapperData);
        return customViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    public View getView(int i, View view, ViewGroup viewGroup, IconInfoWrapperData iconInfoWrapperData) {
        if (TbadkCoreApplication.getInst().isHaokan() && (Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20)) {
            BdUtilHelper.clearFocus(this.mContext);
        }
        return super.getView(i, view, viewGroup, (ViewGroup) iconInfoWrapperData);
    }
}
