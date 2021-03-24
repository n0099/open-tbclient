package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class VerifyCodeResponse implements IBeanResponse {
    public String mobile;
    public String mobile_mc;
    public String sms_length;
    public String sms_pattern;
    public String sms_type;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
