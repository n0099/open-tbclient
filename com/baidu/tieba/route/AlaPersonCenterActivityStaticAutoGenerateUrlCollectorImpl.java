package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class AlaPersonCenterActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("AlaPersonCenterActivityConfig");
        arrayList.add("AlaPrivilegeListActivityConfig");
        hashMap.put("com.baidu.tieba.ala.personcenter.AlaPersonCenterActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.ala.personcenter.AlaPersonCenterActivityStatic");
        hashMap.put("2001616", "com.baidu.tieba.ala.personcenter.AlaPersonCenterActivityStatic");
        return hashMap;
    }
}
