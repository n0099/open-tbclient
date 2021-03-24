package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class EemCardListResponse extends CardListResponse implements Serializable {
    @Override // com.baidu.wallet.paysdk.datamodel.CardListResponse, com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return this.bind_card_arr != null;
    }

    @Override // com.baidu.wallet.paysdk.datamodel.CardListResponse, com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
