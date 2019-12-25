package com.baidu.tieba.livesdk.k;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    public static void l(String str, Map<String, String> map) {
        if (!aq.isEmpty(str)) {
            an anVar = new an(str);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    anVar.cp(str2, map.get(str2));
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    public static void w(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            String remove = map.remove("key");
            for (String str : map.keySet()) {
                hashMap.put(str, map.get(str));
            }
            l(remove, hashMap);
        }
    }
}
