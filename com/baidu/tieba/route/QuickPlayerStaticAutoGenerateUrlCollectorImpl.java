package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes13.dex */
public final class QuickPlayerStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.tieba.QuickPlayer.QuickPlayerStatic", new ArrayList());
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2007015", "com.baidu.tieba.QuickPlayer.QuickPlayerStatic");
        hashMap.put("2016490", "com.baidu.tieba.QuickPlayer.QuickPlayerStatic");
        hashMap.put("2001011", "com.baidu.tieba.QuickPlayer.QuickPlayerStatic");
        hashMap.put("2921340", "com.baidu.tieba.QuickPlayer.QuickPlayerStatic");
        return hashMap;
    }
}
