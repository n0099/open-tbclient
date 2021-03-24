package com.baidu.wallet.fastpay.datamodel;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class SimpleOrderInfo implements NoProguard, Serializable {
    public static final long serialVersionUID = -7569032433038662694L;
    public String mFaceValue;
    public String mMobile;
    public String mOrderInfo;
    public String mOrderNo;
    public String mPayDesc;
    public String mPrice;
    public String mSpNo;
    public String mSpSuccpageRemainTime;

    public void init() {
        String[] split;
        if (TextUtils.isEmpty(this.mOrderInfo) || (split = this.mOrderInfo.split("&")) == null) {
            return;
        }
        for (String str : split) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("total_amount")) {
                    this.mPrice = str.substring(13);
                }
                if (str.contains(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID)) {
                    this.mSpNo = str.substring(6);
                }
            }
        }
    }

    public boolean isGotoResultActivity() {
        return TextUtils.isEmpty(this.mSpSuccpageRemainTime) || !this.mSpSuccpageRemainTime.equals("0");
    }

    public String toString() {
        return "SimpleOrderInfo [mMobile=" + this.mMobile + ", mFaceValue=" + this.mFaceValue + ", mOrderNo=" + this.mOrderNo + ", mPrice=" + this.mPrice + ", mOrderInfo=" + this.mOrderInfo + "]";
    }
}
