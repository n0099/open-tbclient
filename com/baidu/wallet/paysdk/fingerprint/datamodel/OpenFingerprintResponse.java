package com.baidu.wallet.paysdk.fingerprint.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class OpenFingerprintResponse implements IBeanResponse {
    public String token_info;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return !TextUtils.isEmpty(this.token_info);
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
