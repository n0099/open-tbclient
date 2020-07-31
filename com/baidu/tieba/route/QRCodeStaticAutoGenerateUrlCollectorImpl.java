package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes17.dex */
public final class QRCodeStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("QRCodeScanActivityConfig");
        hashMap.put("com.baidu.tieba.qrcode.activity.QRCodeStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.qrcode.activity.QRCodeStatic");
        hashMap.put("2921388", "com.baidu.tieba.qrcode.activity.QRCodeStatic");
        hashMap.put("2921403", "com.baidu.tieba.qrcode.activity.QRCodeStatic");
        return hashMap;
    }
}
