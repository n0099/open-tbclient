package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class UserMuteAddAndDelStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic", new ArrayList());
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2001431", "com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic");
        hashMap.put("2001429", "com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic");
        hashMap.put("2001430", "com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic");
        return hashMap;
    }
}
