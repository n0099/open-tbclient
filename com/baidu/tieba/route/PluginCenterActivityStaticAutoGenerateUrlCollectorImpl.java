package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public final class PluginCenterActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("PluginCenterActivityConfig");
        arrayList.add("PluginDetailActivityConfig");
        arrayList.add("PluginDownloadActivityConfig");
        hashMap.put("com.baidu.tieba.pluginCenter.PluginCenterActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.pluginCenter.PluginCenterActivityStatic");
        return hashMap;
    }
}
