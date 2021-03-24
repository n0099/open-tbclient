package com.baidu.wallet.paysdk.banksign.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class PollingResponse implements IBeanResponse {
    public int has_sign_result;
    public String toast_msg;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
