package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> bZn;

    static {
        MessageManager.getInstance().registerListener(new c(2001011));
        bZn = new HashMap<>();
    }

    public static void g(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!bZn.containsKey(str3)) {
            bZn.put(str3, new e(str, str2, z));
        }
    }

    public static e h(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!bZn.containsKey(str3)) {
            bZn.put(str3, new e(str, str2, z));
        }
        return bZn.get(str3);
    }

    public static void ib(int i) {
        for (String str : bZn.keySet()) {
            a(bZn.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.bZr;
        d dVar2 = eVar.bZs;
        d dVar3 = eVar.bZt;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            q qVar = new q("dbg");
            qVar.r("act", eVar.type);
            qVar.r("httpTimeCost", String.valueOf(dVar.bZo));
            qVar.r("httpNum", String.valueOf(dVar.num));
            qVar.r("httpFailnum", String.valueOf(dVar.bZp));
            qVar.r("httpSize", String.valueOf(dVar.size));
            qVar.r("socketTimeCost", String.valueOf(dVar2.bZo));
            qVar.r("socketNum", String.valueOf(dVar2.num));
            qVar.r("socketFailnum", String.valueOf(dVar2.bZp));
            qVar.r("socketSize", String.valueOf(dVar2.size));
            qVar.r("abortTimeCost", String.valueOf(dVar3.bZo));
            qVar.r("abortNum", String.valueOf(dVar3.num));
            qVar.r("netType", eVar.bhv);
            qVar.r("isJson", eVar.bZq ? "1" : "0");
            f.eq().a("frs", qVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
