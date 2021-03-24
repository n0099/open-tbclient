package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class VerifyByBankResponse implements IBeanResponse {
    public String channel_no;
    public String send_sms_by_bfb;
    public String send_sms_desc;
    public String send_sms_descript;
    public String send_sms_phone;
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
