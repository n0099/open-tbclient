package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class FRSExtraStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.frs.FRSExtraStatic");
        hashMap.put("2003008", "com.baidu.tieba.frs.FRSExtraStatic");
        hashMap.put("2001616", "com.baidu.tieba.frs.FRSExtraStatic");
        hashMap.put("2016468", "com.baidu.tieba.frs.FRSExtraStatic");
        hashMap.put("3001000", "com.baidu.tieba.frs.FRSExtraStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("VideoEasterEggActivityConfig");
        arrayList.add("GameShareActivityConfig");
        arrayList.add("VideoAggregationActivityConfig");
        arrayList.add("VideoMiddlePageActivityConfig");
        arrayList.add("FrsGameCommentActivityConfig");
        arrayList.add("FrsGameSubPbActivityConfig");
        arrayList.add("FrsProfessionIntroActivityConfig");
        arrayList.add("FrsMoreFeedForumsConfig");
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_VIDEO_MIDDLE_PAGE);
        hashMap.put("com.baidu.tieba.frs.FRSExtraStatic", arrayList);
        return hashMap;
    }
}
