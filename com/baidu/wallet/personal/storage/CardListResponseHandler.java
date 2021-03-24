package com.baidu.wallet.personal.storage;

import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.beans.ResponsePrecallback;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
import com.baidu.wallet.personal.ui.BankCardListActivity;
/* loaded from: classes5.dex */
public class CardListResponseHandler extends ResponsePrecallback {
    @Override // com.baidu.wallet.core.beans.ResponsePrecallback
    public void handleResponse(int i, Object obj, String str) {
        CardListCache.getInstance().updateCardList(i, (CardListResponse) obj);
    }

    @Override // com.baidu.wallet.core.beans.ResponsePrecallback
    public void removeRequest() {
        BeanManager.getInstance().removeAllBeans(BankCardListActivity.BEAN_TAG);
    }
}
