package com.baidu.wallet.fastpay.datamodel;

import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.StringUtils;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class TrafficUserModel implements NoProguard, Serializable {
    public static final long serialVersionUID = 7921286508919633280L;
    public String accountNo = "";
    public String provider = "";
    public String providerCode = "";
    public String province = "";
    public String provinceCode = "";
    public String city = "";
    public String publicTip = "";

    public String getExpressMobile() {
        if (TextUtils.isEmpty(this.accountNo)) {
            return "";
        }
        String unicodeDecode = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.accountNo));
        return TextUtils.isEmpty(unicodeDecode) ? "" : StringUtils.formatPhoneNumber(unicodeDecode);
    }
}
