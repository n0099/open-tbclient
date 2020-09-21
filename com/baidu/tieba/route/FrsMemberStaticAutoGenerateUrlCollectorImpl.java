package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes22.dex */
public final class FrsMemberStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("ForumMemberActivityConfig");
        hashMap.put("com.baidu.tieba.forumMember.member.FrsMemberStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2003008", "com.baidu.tieba.forumMember.member.FrsMemberStatic");
        hashMap.put("2003011", "com.baidu.tieba.forumMember.member.FrsMemberStatic");
        hashMap.put("2002001", "com.baidu.tieba.forumMember.member.FrsMemberStatic");
        return hashMap;
    }
}
