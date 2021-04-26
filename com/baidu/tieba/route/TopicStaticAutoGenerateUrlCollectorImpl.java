package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class TopicStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.homepage.topic.TopicStatic");
        hashMap.put("3001000", "com.baidu.tieba.homepage.topic.TopicStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UrlSchemaHelper.HTTP_JUMP_TOPIC_DETAIL);
        arrayList.add(UrlSchemaHelper.HTTPS_JUMP_TOPIC_DETAIL);
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC);
        hashMap.put("com.baidu.tieba.homepage.topic.TopicStatic", arrayList);
        return hashMap;
    }
}
