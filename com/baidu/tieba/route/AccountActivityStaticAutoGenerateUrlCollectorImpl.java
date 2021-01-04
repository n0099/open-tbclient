package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class AccountActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("AccountRestoreActivityConfig");
        arrayList.add("NotLoginGuideActivityConfig");
        hashMap.put("com.baidu.tieba.account.AccountActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2015006", "com.baidu.tieba.account.AccountActivityStatic");
        hashMap.put("2002001", "com.baidu.tieba.account.AccountActivityStatic");
        return hashMap;
    }
}
