package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class AlaLiveSdkStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("/ala/share");
        arrayList.add(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
        arrayList.add("bdtiebalive://");
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM);
        hashMap.put("com.baidu.tieba.livesdk.AlaLiveSdkStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2007002", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        hashMap.put("2921431", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        hashMap.put("2921364", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        hashMap.put("2001115", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        hashMap.put("3001000", "com.baidu.tieba.livesdk.AlaLiveSdkStatic");
        return hashMap;
    }
}
