package com.baidu.tieba.live.tbean.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.live.tbean.data.UserDefineTbeanWrapperData;
import com.baidu.tieba.live.tbean.view.CustomViewHolder;
import com.baidu.tieba.live.tbean.view.UserDefineTbeanItemView;
/* loaded from: classes11.dex */
public class UserDefinedTBeanAdapter extends AbsDelegateAdapter<UserDefineTbeanWrapperData, CustomViewHolder> {
    private boolean mIsFromAlaLiveRoom;
    private TbPageContext<?> mPageContext;
    private UserDefineTbeanItemView mUserDefineTbeanItemView;

    public UserDefinedTBeanAdapter(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity(), UserDefineTbeanWrapperData.TYPE);
        this.mPageContext = tbPageContext;
        this.mIsFromAlaLiveRoom = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        this.mUserDefineTbeanItemView = new UserDefineTbeanItemView(this.mPageContext, this.mIsFromAlaLiveRoom);
        return new CustomViewHolder(this.mUserDefineTbeanItemView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, UserDefineTbeanWrapperData userDefineTbeanWrapperData, CustomViewHolder customViewHolder) {
        if (customViewHolder == null || customViewHolder.getCardView() == null) {
            return null;
        }
        customViewHolder.getCardView().onBindDataToView(userDefineTbeanWrapperData);
        return customViewHolder.getView();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mUserDefineTbeanItemView != null) {
            this.mUserDefineTbeanItemView.onKeyboardVisibilityChanged(z);
        }
    }
}
