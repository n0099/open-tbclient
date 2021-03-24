package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class SupportBankResponse implements IBeanResponse {
    public Bank[] bank;
    public Bank[] bank_hot;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
