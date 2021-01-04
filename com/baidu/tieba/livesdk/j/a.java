package com.baidu.tieba.livesdk.j;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    public static void m(String str, Map<String, String> map) {
        if (!at.isEmpty(str)) {
            aq aqVar = new aq(str);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    aqVar.dX(str2, map.get(str2));
                }
            }
            TiebaStatic.log(aqVar);
        }
    }

    public static void F(Map<String, String> map) {
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
