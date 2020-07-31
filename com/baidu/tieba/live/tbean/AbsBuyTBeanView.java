package com.baidu.tieba.live.tbean;

import android.view.View;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.live.tbean.data.CustomData;
import com.baidu.tieba.live.tbean.data.UserInfoData;
/* loaded from: classes4.dex */
public abstract class AbsBuyTBeanView extends BdBaseView {

    /* loaded from: classes4.dex */
    public interface OnPayClickListener {
        void onClick(IAdapterData iAdapterData, UserInfoData userInfoData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsBuyTBeanView(TbPageContext<?> tbPageContext, BuyTBeanController buyTBeanController, boolean z, boolean z2, boolean z3) {
        super(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPayClickListener(OnPayClickListener onPayClickListener) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showRootView() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideRootView() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideContainerView() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getRootView() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showContainerView() {
    }

    public void setData(BuyTBeanModel buyTBeanModel) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showPayResultView(boolean z, int i, CustomData customData) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hidePayResultView() {
    }

    public void setOtherParams(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onKeyboardVisibilityChanged(boolean z) {
    }
}
