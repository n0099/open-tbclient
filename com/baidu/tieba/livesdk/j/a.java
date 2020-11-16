package com.baidu.tieba.livesdk.j;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    public static void m(String str, Map<String, String> map) {
        if (!au.isEmpty(str)) {
            ar arVar = new ar(str);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    arVar.dR(str2, map.get(str2));
                }
            }
            TiebaStatic.log(arVar);
        }
    }

    public static void E(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            String remove = map.remove("key");
            for (String str : map.keySet()) {
                hashMap.put(str, map.get(str));
            }
            m(remove, hashMap);
        }
    }
}
