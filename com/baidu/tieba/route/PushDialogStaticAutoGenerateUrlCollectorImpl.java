package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public final class PushDialogStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("PushDialogActivityConfig");
        hashMap.put("com.baidu.tieba.pushdialog.PushDialogStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.pushdialog.PushDialogStatic");
        hashMap.put("2921359", "com.baidu.tieba.pushdialog.PushDialogStatic");
        hashMap.put("2921360", "com.baidu.tieba.pushdialog.PushDialogStatic");
        return hashMap;
    }
}
