package com.baidu.tieba.livesdk.j;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    public static void n(String str, Map<String, String> map) {
        if (!ar.isEmpty(str)) {
            ao aoVar = new ao(str);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    aoVar.dk(str2, map.get(str2));
                }
            }
            TiebaStatic.log(aoVar);
        }
    }

    public static void u(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            String remove = map.remove("key");
            for (String str : map.keySet()) {
                hashMap.put(str, map.get(str));
            }
            n(remove, hashMap);
        }
    }
}
