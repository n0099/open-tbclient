package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> bXu;

    static {
        MessageManager.getInstance().registerListener(new c(2001011));
        bXu = new HashMap<>();
    }

    public static void g(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!bXu.containsKey(str3)) {
            bXu.put(str3, new e(str, str2, z));
        }
    }

    public static e h(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!bXu.containsKey(str3)) {
            bXu.put(str3, new e(str, str2, z));
        }
        return bXu.get(str3);
    }

    public static void ahl() {
    }

    public static void hS(int i) {
        for (String str : bXu.keySet()) {
            a(bXu.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.bXy;
        d dVar2 = eVar.bXz;
        d dVar3 = eVar.bXA;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            q qVar = new q("dbg");
            qVar.r("act", eVar.type);
            qVar.r("httpTimeCost", String.valueOf(dVar.bXv));
            qVar.r("httpNum", String.valueOf(dVar.num));
            qVar.r("httpFailnum", String.valueOf(dVar.bXw));
            qVar.r("httpSize", String.valueOf(dVar.size));
            qVar.r("socketTimeCost", String.valueOf(dVar2.bXv));
            qVar.r("socketNum", String.valueOf(dVar2.num));
            qVar.r("socketFailnum", String.valueOf(dVar2.bXw));
            qVar.r("socketSize", String.valueOf(dVar2.size));
            qVar.r("abortTimeCost", String.valueOf(dVar3.bXv));
            qVar.r("abortNum", String.valueOf(dVar3.num));
            qVar.r("netType", eVar.bgd);
            qVar.r("isJson", eVar.bXx ? "1" : "0");
            f.es().a("frs", qVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
