package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class StaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.myCollection.Static");
        hashMap.put("2015005", "com.baidu.tieba.myCollection.Static");
        hashMap.put("2001278", "com.baidu.tieba.myCollection.Static");
        hashMap.put("2001279", "com.baidu.tieba.myCollection.Static");
        hashMap.put("2921318", "com.baidu.tieba.myCollection.Static");
        hashMap.put("2001011", "com.baidu.tieba.myCollection.Static");
        hashMap.put("2005016", "com.baidu.tieba.myCollection.Static");
        hashMap.put("2001120", "com.baidu.tieba.myCollection.Static");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("PbHistoryActivityConfig");
        hashMap.put("com.baidu.tieba.myCollection.Static", arrayList);
        return hashMap;
    }
}
