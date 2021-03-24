package com.baidu.tieba.wallet;

import java.util.HashMap;
import tbclient.GetOrder.DataRes;
/* loaded from: classes5.dex */
public class WalletParamsFactory {
    public static HashMap<String, String> buildWalletParams(DataRes dataRes) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (dataRes == null) {
            return hashMap;
        }
        hashMap.put("customerId", "" + dataRes.customerId);
        hashMap.put("service", dataRes.service);
        hashMap.put("orderId", dataRes.orderId);
        hashMap.put("orderCreateTime", "" + dataRes.orderCreateTime);
        hashMap.put("deviceType", "" + dataRes.deviceType);
        hashMap.put("payAmount", "" + dataRes.payAmount);
        hashMap.put("originalAmount", "" + dataRes.originalAmount);
        hashMap.put("notifyUrl", dataRes.notifyUrl);
        hashMap.put("passuid", dataRes.passuid);
        hashMap.put("title", dataRes.title);
        hashMap.put("mobile", dataRes.mobile);
        hashMap.put("itemInfo", dataRes.itemInfo);
        hashMap.put("sdk", "" + dataRes.sdk);
        hashMap.put("sdkStyle", "" + dataRes.sdkStyle);
        hashMap.put("sign", dataRes.sign);
        hashMap.put("signType", "" + dataRes.signType);
        return hashMap;
    }
}
