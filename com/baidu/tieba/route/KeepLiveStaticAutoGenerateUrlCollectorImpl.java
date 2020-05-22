package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class KeepLiveStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.tieba.keepLive.KeepLiveStatic", new ArrayList());
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2921300", "com.baidu.tieba.keepLive.KeepLiveStatic");
        hashMap.put("2921301", "com.baidu.tieba.keepLive.KeepLiveStatic");
        hashMap.put("2016523", "com.baidu.tieba.keepLive.KeepLiveStatic");
        hashMap.put("2001011", "com.baidu.tieba.keepLive.KeepLiveStatic");
        return hashMap;
    }
}
