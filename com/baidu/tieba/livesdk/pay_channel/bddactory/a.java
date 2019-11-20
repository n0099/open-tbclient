package com.baidu.tieba.livesdk.pay_channel.bddactory;

import android.text.TextUtils;
import com.baidu.live.data.ah;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {
    public static HashMap<String, String> b(ah ahVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (ahVar != null) {
            hashMap.put("customerId", "" + ahVar.TY);
            hashMap.put("service", ahVar.service);
            hashMap.put("orderId", ahVar.orderId);
            hashMap.put("orderCreateTime", "" + ahVar.TZ);
            hashMap.put("deviceType", "" + ahVar.Ua);
            hashMap.put("payAmount", "" + ahVar.Ub);
            hashMap.put("originalAmount", "" + ahVar.Uc);
            hashMap.put("notifyUrl", ahVar.notifyUrl);
            hashMap.put("passuid", ahVar.passuid);
            hashMap.put("title", ahVar.title);
            hashMap.put("mobile", ahVar.mobile);
            hashMap.put("itemInfo", ahVar.itemInfo);
            hashMap.put("sdk", "" + ahVar.Ud);
            hashMap.put("sdkStyle", "" + ahVar.Ue);
            hashMap.put("sign", ahVar.sign);
            hashMap.put("signType", "" + ahVar.Uf);
            if (!TextUtils.isEmpty(ahVar.tag)) {
                hashMap.put("tag", "" + ahVar.tag);
            }
        }
        return hashMap;
    }
}
