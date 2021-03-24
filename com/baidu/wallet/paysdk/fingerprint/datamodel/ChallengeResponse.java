package com.baidu.wallet.paysdk.fingerprint.datamodel;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public class ChallengeResponse extends a {
    public String description;
    public long lifetimeMillis;
    public String uafRequest;

    @Override // com.baidu.wallet.paysdk.fingerprint.datamodel.a, com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return !TextUtils.isEmpty(this.uafRequest);
    }

    public String getUafRequest() {
        if (this.uafRequest == null) {
            return null;
        }
        return "{\"uafRequest\":" + this.uafRequest + "}";
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.datamodel.a, com.baidu.apollon.beans.IBeanResponse
    public /* bridge */ /* synthetic */ void storeResponse(Context context) {
        super.storeResponse(context);
    }
}
