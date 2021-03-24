package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ServiceStaticInitAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2005009", "com.baidu.tbadk.core.ServiceStaticInit");
        hashMap.put("2005010", "com.baidu.tbadk.core.ServiceStaticInit");
        hashMap.put("2005011", "com.baidu.tbadk.core.ServiceStaticInit");
        hashMap.put("2005012", "com.baidu.tbadk.core.ServiceStaticInit");
        hashMap.put("2005013", "com.baidu.tbadk.core.ServiceStaticInit");
        hashMap.put("2005015", "com.baidu.tbadk.core.ServiceStaticInit");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.tbadk.core.ServiceStaticInit", new ArrayList());
        return hashMap;
    }
}
