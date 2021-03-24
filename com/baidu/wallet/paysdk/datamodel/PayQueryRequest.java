package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class PayQueryRequest extends BeanRequestBase implements Serializable {
    public static final String CRDDITPAY_NAME = "get_credit_pay_android_result";
    public static final String EASYPAY_NAME = "get_easypay_trans_state_android";
    public static final long serialVersionUID = 7544071473932477587L;
    public String mBankNo;
    public String mName = EASYPAY_NAME;
    public String mOrderNo;

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        if (this.mBankNo == null) {
            this.mBankNo = "";
        }
        return !TextUtils.isEmpty(this.mOrderNo);
    }

    public String getMd5Sign() {
        if (this.mBankNo == null) {
            this.mBankNo = "";
        }
        return Md5Utils.toMD5("order_no=" + this.mOrderNo + "&name=get_easypay_trans_state_android&bank_no=" + this.mBankNo + "&key=baifubaowallet");
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        setBelongPaySdk();
        return BeanConstants.REQUEST_ID_PAY_QUERY;
    }
}
