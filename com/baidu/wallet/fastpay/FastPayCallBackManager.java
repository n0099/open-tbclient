package com.baidu.wallet.fastpay;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.wallet.fastpay.datamodel.QueryLocationResponse;
import com.baidu.wallet.fastpay.datamodel.SimpleOrderInfo;
import com.baidu.wallet.fastpay.sdk.a;
import java.io.Serializable;
/* loaded from: classes5.dex */
public final class FastPayCallBackManager {

    /* loaded from: classes5.dex */
    public static class PayStateContent implements Serializable {
        public static final long serialVersionUID = 8703238535820968744L;
        public String notify = "";
        public String order_no = "";

        public String toString() {
            return "PayStateContent [notify=" + this.notify + ", order_no=" + this.order_no + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    /* loaded from: classes5.dex */
    public static class PayStateModle implements Serializable {
        public static final int PAY_STATUS_CANCEL = 2;
        public static final int PAY_STATUS_PAYING = 3;
        public static final int PAY_STATUS_SUCCESS = 1;
        public static final long serialVersionUID = 393136306694361260L;
        public PayStateContent content;
        public SimpleOrderInfo orderInfo;
        public int statecode;
    }

    public static void a(int i2, int i3, SimpleOrderInfo simpleOrderInfo, PayStateContent payStateContent) {
        a.b a2 = a.a().a(i2);
        if (a2 == null) {
            return;
        }
        a2.onFastPaySuccess(i2, 1, a(i3, simpleOrderInfo, payStateContent));
        a.a().b(i2);
    }

    public static void a(int i2, Object obj) {
        a.b a2 = a.a().a(i2);
        if (a2 == null) {
            return;
        }
        a2.onFastPaySuccess(i2, 0, obj);
        if (obj instanceof QueryLocationResponse) {
            a.a().b(i2);
        }
    }

    public static void a(int i2, int i3, int i4, String str, SimpleOrderInfo simpleOrderInfo) {
        a.b a2 = a.a().a(i2);
        if (a2 == null) {
            return;
        }
        a2.onFastPayFail(i2, i3, new a.C0238a(i4, str, simpleOrderInfo));
        a.a().b(i2);
    }

    public static PayStateModle a(int i2, SimpleOrderInfo simpleOrderInfo, PayStateContent payStateContent) {
        PayStateModle payStateModle = new PayStateModle();
        payStateModle.orderInfo = simpleOrderInfo;
        payStateContent.order_no = simpleOrderInfo.mOrderNo;
        payStateModle.content = payStateContent;
        payStateModle.statecode = i2;
        return payStateModle;
    }
}
