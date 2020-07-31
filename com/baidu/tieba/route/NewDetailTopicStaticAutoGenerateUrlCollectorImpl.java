package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public final class NewDetailTopicStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("TopicDetailActivityConfig");
        arrayList.add("http://tieba.baidu.com/mo/q/newtopic/detail");
        arrayList.add("https://tieba.baidu.com/mo/q/newtopic/detail");
        arrayList.add("com.baidu.tieba://deeplink?jump=new_hot_topic_list");
        hashMap.put("com.baidu.tieba.newdetail.NewDetailTopicStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.newdetail.NewDetailTopicStatic");
        hashMap.put("3001000", "com.baidu.tieba.newdetail.NewDetailTopicStatic");
        return hashMap;
    }
}
