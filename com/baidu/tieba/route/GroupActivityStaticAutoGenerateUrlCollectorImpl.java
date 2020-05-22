package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class GroupActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("GroupSettingActivityConfig");
        arrayList.add("CreateGroupMainActivityConfig");
        arrayList.add("CreateGroupStepActivityConfig");
        arrayList.add("GroupAddressEditActivityConfig");
        arrayList.add("GroupAddressLocateActivityConfig");
        arrayList.add("GroupAddressLocateActivityConfig");
        arrayList.add("GroupLevelActivityConfig");
        arrayList.add("CreateGroupActivityActivityConfig");
        arrayList.add("GroupActivityActivityConfig");
        arrayList.add("GroupCardActivityConfig");
        arrayList.add("GroupImageActivityConfig");
        arrayList.add("UpdateGroupActivityConfig");
        arrayList.add("FrsGroupActivityConfig");
        arrayList.add("tieba.baidu.com/group/index?id=");
        hashMap.put("com.baidu.tieba.group.GroupActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.group.GroupActivityStatic");
        hashMap.put("2008011", "com.baidu.tieba.group.GroupActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.group.GroupActivityStatic");
        hashMap.put("2003011", "com.baidu.tieba.group.GroupActivityStatic");
        hashMap.put("2003008", "com.baidu.tieba.group.GroupActivityStatic");
        hashMap.put("2001102", "com.baidu.tieba.group.GroupActivityStatic");
        hashMap.put("2001123", "com.baidu.tieba.group.GroupActivityStatic");
        hashMap.put("2001280", "com.baidu.tieba.group.GroupActivityStatic");
        hashMap.put("2008014", "com.baidu.tieba.group.GroupActivityStatic");
        return hashMap;
    }
}
