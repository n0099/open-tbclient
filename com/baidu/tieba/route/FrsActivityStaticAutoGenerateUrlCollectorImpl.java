package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes21.dex */
public final class FrsActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("FrsActivityConfig");
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_FRS);
        arrayList.add("tname");
        hashMap.put("com.baidu.tieba.frs.FrsActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2003000", "com.baidu.tieba.frs.FrsActivityStatic");
        hashMap.put("2003001", "com.baidu.tieba.frs.FrsActivityStatic");
        hashMap.put("2001012", "com.baidu.tieba.frs.FrsActivityStatic");
        hashMap.put("2016501", "com.baidu.tieba.frs.FrsActivityStatic");
        hashMap.put("309602", "com.baidu.tieba.frs.FrsActivityStatic");
        hashMap.put("2920336", "com.baidu.tieba.frs.FrsActivityStatic");
        hashMap.put("2002001", "com.baidu.tieba.frs.FrsActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.frs.FrsActivityStatic");
        return hashMap;
    }
}
