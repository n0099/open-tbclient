package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class PaySetResponse implements NoProguard, IBeanResponse, Serializable {
    public static final long serialVersionUID = 1;
    public String facepay_url;
    public Fingerprint fingerprint;
    public PayFreeInfo passfree_info;
    public Paymethod_info paymethod_info;

    /* loaded from: classes5.dex */
    public static class Fingerprint implements com.baidu.wallet.core.NoProguard, Serializable {
        public static final long serialVersionUID = -78869695964888877L;
        public int device_support;
        public FingerprintProtocol fingerprint_protocol;
        public int is_otp;
        public int user_reg;
    }

    /* loaded from: classes5.dex */
    public static class FingerprintProtocol implements com.baidu.wallet.core.NoProguard, Serializable {
        public String fingerprint_protocol_msg;
        public String fingerprint_protocol_prefix;
        public String fingerprint_protocol_url;
    }

    /* loaded from: classes5.dex */
    public static class PassFreeCreditMap implements com.baidu.wallet.core.NoProguard, Serializable {
        public int credit;
        public String select_msg;
        public int selected;
    }

    /* loaded from: classes5.dex */
    public static class PassFreeProtocol implements com.baidu.wallet.core.NoProguard, Serializable {
        public String passfree_protocol_msg;
        public String passfree_protocol_prefix;
        public String passfree_protocol_url;
    }

    /* loaded from: classes5.dex */
    public static class PayFreeInfo implements com.baidu.wallet.core.NoProguard, Serializable {
        public int has_mobile_pwd;
        public String passfree_button_msg;
        public PassFreeCreditMap passfree_credit_map;
        public int passfree_flag;
        public PassFreeProtocol passfree_protocol;
    }

    /* loaded from: classes5.dex */
    public static class PayInfoBean implements com.baidu.wallet.core.NoProguard, Serializable {
        public String account_no;
        public String bank_url;
        public int card_type;
        public String icon;
        public String name;
        public String pay_type;
        public String type_name;
    }

    /* loaded from: classes5.dex */
    public static class Paymethod_info implements com.baidu.wallet.core.NoProguard, Serializable {
        public static final long serialVersionUID = 1;
        public int paymethod_type;
        public PayInfoBean[] sorted_list;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return (this.passfree_info == null || this.fingerprint == null) ? false : true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
