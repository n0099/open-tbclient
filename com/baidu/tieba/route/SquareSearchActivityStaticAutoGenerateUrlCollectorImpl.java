package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class SquareSearchActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_SEARCH);
        arrayList.add("create_forum");
        hashMap.put("com.baidu.tieba.mainentrance.SquareSearchActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2015003", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
        hashMap.put("2009002", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
        hashMap.put("2009001", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
        hashMap.put("2001190", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
        hashMap.put("2001191", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic");
        return hashMap;
    }
}
