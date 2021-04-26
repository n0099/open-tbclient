package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class QRCodeStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.qrcode.activity.QRCodeStatic");
        hashMap.put("2921388", "com.baidu.tieba.qrcode.activity.QRCodeStatic");
        hashMap.put("2921403", "com.baidu.tieba.qrcode.activity.QRCodeStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("QRCodeScanActivityConfig");
        hashMap.put("com.baidu.tieba.qrcode.activity.QRCodeStatic", arrayList);
        return hashMap;
    }
}
