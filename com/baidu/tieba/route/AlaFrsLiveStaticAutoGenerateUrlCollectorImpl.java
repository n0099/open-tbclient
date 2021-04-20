package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class AlaFrsLiveStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic");
        hashMap.put("2001619", "com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic");
        hashMap.put("2001616", "com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic");
        hashMap.put("2001620", "com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic");
        hashMap.put("2913032", "com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("AlaFrsStoryLiveGatherActivityConfig");
        arrayList.add("AlaGameFrsLiveListActivityConfig");
        hashMap.put("com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic", arrayList);
        return hashMap;
    }
}
