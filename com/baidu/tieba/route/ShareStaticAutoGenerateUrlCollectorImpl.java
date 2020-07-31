package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public final class ShareStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.tieba.sharesdk.ShareStatic", new ArrayList());
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2001445", "com.baidu.tieba.sharesdk.ShareStatic");
        hashMap.put("2001276", "com.baidu.tieba.sharesdk.ShareStatic");
        hashMap.put("1003473", "com.baidu.tieba.sharesdk.ShareStatic");
        hashMap.put("2016567", "com.baidu.tieba.sharesdk.ShareStatic");
        return hashMap;
    }
}
