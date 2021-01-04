package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class ForumRankActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("BarFolderFirstDirActivityConfig");
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_SQUARE);
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_LIST);
        hashMap.put("com.baidu.tieba.square.flist.ForumRankActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.square.flist.ForumRankActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.square.flist.ForumRankActivityStatic");
        hashMap.put("2902025", "com.baidu.tieba.square.flist.ForumRankActivityStatic");
        hashMap.put("2902028", "com.baidu.tieba.square.flist.ForumRankActivityStatic");
        hashMap.put("2902023", "com.baidu.tieba.square.flist.ForumRankActivityStatic");
        hashMap.put("2902026", "com.baidu.tieba.square.flist.ForumRankActivityStatic");
        hashMap.put("2902029", "com.baidu.tieba.square.flist.ForumRankActivityStatic");
        return hashMap;
    }
}
