package com.baidu.wallet.util;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class StatHelper {

    /* loaded from: classes5.dex */
    public enum Key {
        orderNo,
        spNo,
        fromPkg,
        hasPwd,
        payType,
        payWay,
        orderId,
        channelId,
        passLoginStatus,
        sessionId,
        payAmount,
        precashierMark
    }

    public static void cacheChannelId(String str) {
        a.a(Key.channelId.name(), str);
    }

    public static void cacheFromPkg(String str) {
        a.a(Key.fromPkg.name(), str);
    }

    public static void cacheHasPwd(boolean z) {
        a.a(Key.hasPwd.name(), z ? "1" : "0");
    }

    public static void cacheOrderId(String str) {
        a.a(Key.orderId.name(), str);
    }

    public static void cacheOrderNo(String str) {
        a.a(Key.orderNo.name(), str);
    }

    public static void cachePassLoginStatus(String str) {
        a.a(Key.passLoginStatus.name(), str);
    }

    public static void cachePayAmount(double d2) {
        a.a(Key.payAmount.name(), Double.valueOf(d2));
    }

    public static void cachePayType(int i2) {
        a.a(Key.payType.name(), String.valueOf(i2));
    }

    public static void cachePayWay(int i2) {
        a.a(Key.payWay.name(), String.valueOf(i2));
    }

    public static void cacheSessionId(String str) {
        a.a(Key.sessionId.name(), str);
    }

    public static void cacheSpNo(String str) {
        a.a(Key.spNo.name(), str);
    }

    public static void clearPay() {
        a.a(Key.payWay.name(), null);
        a.a(Key.payType.name(), null);
        a.a(Key.hasPwd.name(), null);
    }

    public static List<String> collectData(String str, String... strArr) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        for (String str2 : strArr) {
            arrayList.add(str2);
        }
        return arrayList;
    }

    public static String getChannelId() {
        return (String) a.a(Key.channelId.name());
    }

    public static String getFromPkg() {
        return (String) a.a(Key.fromPkg.name());
    }

    public static String getHasPwd() {
        return (String) a.a(Key.hasPwd.name());
    }

    public static String getOrderId() {
        return (String) a.a(Key.orderId.name());
    }

    public static String getOrderNo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.wallet.base.a.a.a(str, "order_no");
    }

    public static String getPassLoginStatus() {
        return (String) a.a(Key.passLoginStatus.name());
    }

    public static String getPayAmount(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.wallet.base.a.a.a(str, "total_amount");
    }

    public static String getPayType() {
        return (String) a.a(Key.payType.name());
    }

    public static String getPayWay() {
        return (String) a.a(Key.payWay.name());
    }

    public static String getSessionId() {
        return (String) a.a(Key.sessionId.name());
    }

    public static String getSpNo(String str) {
        return com.baidu.wallet.base.a.a.a(str, PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID);
    }

    public static boolean isPrecashierPay(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(a.a(Key.precashierMark.name()));
    }

    public static void setPrecashierMark(String str) {
        a.a(Key.precashierMark.name(), str);
    }

    public static String getSpNo() {
        return (String) a.a(Key.spNo.name());
    }

    public static String getOrderNo() {
        return (String) a.a(Key.orderNo.name());
    }

    public static Double getPayAmount() {
        return (Double) a.a(Key.payAmount.name());
    }
}
