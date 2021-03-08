package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class HotTopicStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("HotTopicActivityConfig");
        arrayList.add("RelateTopicForumActivityConfig");
        arrayList.add("HotRanklistActivityConfig");
        arrayList.add(UrlSchemaHelper.JUMP_TO_HOT_TOPIC);
        arrayList.add(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW);
        arrayList.add(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC);
        arrayList.add(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW);
        hashMap.put("com.baidu.tieba.hottopic.controller.HotTopicStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.hottopic.controller.HotTopicStatic");
        hashMap.put("2003008", "com.baidu.tieba.hottopic.controller.HotTopicStatic");
        hashMap.put("2001623", "com.baidu.tieba.hottopic.controller.HotTopicStatic");
        hashMap.put("3001000", "com.baidu.tieba.hottopic.controller.HotTopicStatic");
        return hashMap;
    }
}
