package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class SearchFriendActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivityStatic");
        hashMap.put("2001265", "com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivityStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("SearchFriendActivityConfig");
        hashMap.put("com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivityStatic", arrayList);
        return hashMap;
    }
}
