package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public final class SignStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("SupplementSignActivityConfig");
        arrayList.add("SignAllForumActivityConfig");
        arrayList.add("SignAllForumAdvertActivityConfig");
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_ONE_KEY_SIGN);
        hashMap.put("com.baidu.tieba.SignStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.SignStatic");
        hashMap.put("2001425", "com.baidu.tieba.SignStatic");
        hashMap.put("3001000", "com.baidu.tieba.SignStatic");
        return hashMap;
    }
}
