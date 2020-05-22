package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class AdStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("AdTbWebViewActivityConfig");
        arrayList.add("NewAdTbWebViewActivityConfig");
        hashMap.put("com.baidu.tieba.ad.browser.AdStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2005016", "com.baidu.tieba.ad.browser.AdStatic");
        hashMap.put("2002001", "com.baidu.tieba.ad.browser.AdStatic");
        return hashMap;
    }
}
