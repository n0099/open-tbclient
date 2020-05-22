package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class PbActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("unidispatch/pb");
        arrayList.add("com.baidu.tieba://?kz=");
        arrayList.add("tieba.baidu.com/p/");
        arrayList.add("tieba.baidu.com/subp");
        arrayList.add("SubPbActivityConfig");
        arrayList.add("PbSearchEmotionActivityConfig");
        arrayList.add("PbFullScreenEditorActivityConfig");
        arrayList.add("ForbidActivityConfig");
        hashMap.put("com.baidu.tieba.pb.pb.main.PbActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2004001", "com.baidu.tieba.pb.pb.main.PbActivityStatic");
        hashMap.put("2004003", "com.baidu.tieba.pb.pb.main.PbActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.pb.pb.main.PbActivityStatic");
        hashMap.put("2921343", "com.baidu.tieba.pb.pb.main.PbActivityStatic");
        return hashMap;
    }
}
