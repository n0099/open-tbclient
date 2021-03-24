package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class QueryBankBinResponse implements IBeanResponse, Serializable {
    public static final long serialVersionUID = -7267923736947733889L;
    public GetCardInfoResponse.CardInfo card_info;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return this.card_info != null;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
