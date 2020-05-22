package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class RecommendsStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("PbChosenActivityConfig");
        arrayList.add("http://tieba.baidu.com/mo/q/recommendpb");
        hashMap.put("com.baidu.tieba.pb.chosen.RecommendsStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.pb.chosen.RecommendsStatic");
        hashMap.put("3001000", "com.baidu.tieba.pb.chosen.RecommendsStatic");
        return hashMap;
    }
}
