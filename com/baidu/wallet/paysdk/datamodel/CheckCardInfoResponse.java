package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import java.util.Map;
/* loaded from: classes5.dex */
public class CheckCardInfoResponse implements IBeanResponse {
    public Map<String, String> cashdesk;
    public String channel_no;
    public String need_verify_sms;
    public int send_sms_by_bfb;
    public String send_sms_phone;
    public String sms_length;
    public String sms_pattern;
    public String sms_type;
    public String update_mobile_desc;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
