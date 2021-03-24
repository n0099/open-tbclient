package com.baidu.wallet.personal.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class UnBindSmSResponse implements IBeanResponse {
    public String send_sms_phone;
    public String sms_length;
    public String sms_type;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
