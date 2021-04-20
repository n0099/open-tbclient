package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class SquareSearchActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
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

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_SEARCH);
        arrayList.add("create_forum");
        hashMap.put("com.baidu.tieba.mainentrance.SquareSearchActivityStatic", arrayList);
        return hashMap;
    }
}
