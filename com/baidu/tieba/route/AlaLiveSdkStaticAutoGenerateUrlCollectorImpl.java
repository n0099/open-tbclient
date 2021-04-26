package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class AlaLiveSdkStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2007002", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        hashMap.put("2921431", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        hashMap.put("2921364", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        hashMap.put("2001115", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        hashMap.put("3001000", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        hashMap.put("2921545", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("/ala/share");
        arrayList.add(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
        arrayList.add(UrlSchemaHelper.SCHEMA_LIVE_SDK);
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM);
        hashMap.put("com.baidu.tieba.livesdk.AlaLiveSdkStatic", arrayList);
        return hashMap;
    }
}
