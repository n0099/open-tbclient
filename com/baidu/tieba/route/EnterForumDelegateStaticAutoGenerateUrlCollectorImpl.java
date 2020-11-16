package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes21.dex */
public final class EnterForumDelegateStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("ForumTestActivityConfig");
        hashMap.put("com.baidu.tieba.enterForum.home.EnterForumDelegateStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2007002", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic");
        hashMap.put("2921341", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic");
        hashMap.put("2002001", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic");
        hashMap.put("2001323", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic");
        hashMap.put("2016562", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic");
        hashMap.put("2016562", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic");
        return hashMap;
    }
}
