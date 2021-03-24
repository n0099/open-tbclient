package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class RiskControlResponseForNoPwd implements IBeanResponse {
    public String mobile;
    public int need_check_sms;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        if (isNeedSms()) {
            return !TextUtils.isEmpty(this.mobile);
        }
        return true;
    }

    public boolean isNeedSms() {
        return this.need_check_sms == 1;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
