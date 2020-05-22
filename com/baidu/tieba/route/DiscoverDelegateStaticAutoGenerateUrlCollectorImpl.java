package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public final class DiscoverDelegateStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.tieba.discover.DiscoverDelegateStatic", new ArrayList());
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2007013", "com.baidu.tieba.discover.DiscoverDelegateStatic");
        hashMap.put("2921010", "com.baidu.tieba.discover.DiscoverDelegateStatic");
        return hashMap;
    }
}
