package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes23.dex */
public final class CreateBarActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("CreateBarActivityConfig");
        arrayList.add("CreateBarGuideActivityConfig");
        arrayList.add("CreateForumActivityConfig");
        arrayList.add("CreateForumSuccessActivityConfig");
        hashMap.put("com.baidu.tieba.home.CreateBarActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.home.CreateBarActivityStatic");
        return hashMap;
    }
}
