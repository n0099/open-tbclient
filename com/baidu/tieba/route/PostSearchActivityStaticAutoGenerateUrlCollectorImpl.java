package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class PostSearchActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.postsearch.PostSearchActivityStatic");
        hashMap.put("2009003", "com.baidu.tieba.postsearch.PostSearchActivityStatic");
        hashMap.put("2009004", "com.baidu.tieba.postsearch.PostSearchActivityStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("PostSearchActivityConfig");
        hashMap.put("com.baidu.tieba.postsearch.PostSearchActivityStatic", arrayList);
        return hashMap;
    }
}
