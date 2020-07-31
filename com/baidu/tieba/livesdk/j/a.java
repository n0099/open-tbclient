package com.baidu.tieba.livesdk.j;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    public static void o(String str, Map<String, String> map) {
        if (!as.isEmpty(str)) {
            ap apVar = new ap(str);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    apVar.dn(str2, map.get(str2));
                }
            }
            TiebaStatic.log(apVar);
        }
    }

    public static void u(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            String remove = map.remove("key");
            for (String str : map.keySet()) {
                hashMap.put(str, map.get(str));
            }
            o(remove, hashMap);
        }
    }
}
