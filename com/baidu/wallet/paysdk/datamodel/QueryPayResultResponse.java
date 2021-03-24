package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class QueryPayResultResponse implements IBeanResponse {
    public AuthInfo auth_info;
    public O2OPayResultItemInfo pay_result;
    public String trans_err_msg;
    public O2OTransInfo trans_info;
    public int trans_status;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
