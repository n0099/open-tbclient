package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class SearchLocationActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("SelectLocationActivityConfig");
        hashMap.put("com.baidu.tieba.location.selectpoi.SearchLocationActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002012", "com.baidu.tieba.location.selectpoi.SearchLocationActivityStatic");
        hashMap.put("2002001", "com.baidu.tieba.location.selectpoi.SearchLocationActivityStatic");
        return hashMap;
    }
}
