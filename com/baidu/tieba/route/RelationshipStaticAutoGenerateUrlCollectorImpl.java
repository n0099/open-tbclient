package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
public final class RelationshipStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("CMD_GET_ADDRESSLIST");
        arrayList.add("CMD_QUERY_LOCAL_ADDRESSLIST");
        arrayList.add("CMD_QUERY_CONTACT_LIST");
        arrayList.add("CMD_INSERT_CONTACT");
        arrayList.add("CMD_DELETE_CONTACT");
        hashMap.put("com.baidu.tieba.addresslist.relationship.RelationshipStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.addresslist.relationship.RelationshipStatic");
        hashMap.put("2001174", "com.baidu.tieba.addresslist.relationship.RelationshipStatic");
        hashMap.put("2002014", "com.baidu.tieba.addresslist.relationship.RelationshipStatic");
        return hashMap;
    }
}
