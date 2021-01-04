package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class TaskRegisterStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("AddressListActivityConfig");
        arrayList.add("NewFriendsActivityConfig");
        hashMap.put("com.baidu.tieba.addresslist.TaskRegisterStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.addresslist.TaskRegisterStatic");
        hashMap.put("2001322", "com.baidu.tieba.addresslist.TaskRegisterStatic");
        return hashMap;
    }
}
