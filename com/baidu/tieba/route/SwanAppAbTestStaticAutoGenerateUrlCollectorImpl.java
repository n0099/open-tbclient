package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class SwanAppAbTestStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2921361", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic");
        hashMap.put("2921377", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic");
        hashMap.put("2921410", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic");
        hashMap.put("3001000", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic");
        hashMap.put("2921512", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("tbcfrom=web_search");
        hashMap.put("com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic", arrayList);
        return hashMap;
    }
}
