package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class FindPWDFromOldCardSendSmsResponse implements IBeanResponse {
    public String mobile;
    public String mobile_ec;
    public String sms_length;
    public String sms_pattern;
    public String sms_type;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public void decrypt() {
        try {
            if (TextUtils.isEmpty(this.mobile_ec)) {
                return;
            }
            this.mobile = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.mobile_ec));
        } catch (Exception e2) {
            if (BeanConstants.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
