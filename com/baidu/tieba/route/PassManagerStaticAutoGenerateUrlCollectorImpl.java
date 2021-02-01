package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class PassManagerStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("LoginActivityConfig");
        arrayList.add(UrlSchemaHelper.GOTO_LOGIN);
        hashMap.put("com.baidu.tieba.passaccount.framework.PassManagerStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2001268", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2001293", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2016301", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2921530", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2921438", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2921328", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2921329", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2921332", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2921351", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2921339", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("2921352", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        hashMap.put("3001000", "com.baidu.tieba.passaccount.framework.PassManagerStatic");
        return hashMap;
    }
}
