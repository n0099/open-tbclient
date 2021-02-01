package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class BuyTBeanActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("BuyTBeanActivityConfig");
        arrayList.add("tdoudiscount:");
        arrayList.add("jump_tieba_native=1");
        hashMap.put("com.baidu.tieba.tbean.BuyTBeanActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.tbean.BuyTBeanActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.tbean.BuyTBeanActivityStatic");
        return hashMap;
    }
}
