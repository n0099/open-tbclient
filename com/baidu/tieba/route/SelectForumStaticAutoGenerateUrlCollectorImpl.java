package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes21.dex */
public final class SelectForumStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("SelectForumConfig");
        hashMap.put("com.baidu.tieba.SelectForumStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.SelectForumStatic");
        hashMap.put("3001000", "com.baidu.tieba.SelectForumStatic");
        hashMap.put("1003480", "com.baidu.tieba.SelectForumStatic");
        return hashMap;
    }
}
