package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.game.GameInfoData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> coq;

    static {
        MessageManager.getInstance().registerListener(new c(2001011));
        coq = new HashMap<>();
    }

    public static void g(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!coq.containsKey(str3)) {
            coq.put(str3, new e(str, str2, z));
        }
    }

    public static e h(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!coq.containsKey(str3)) {
            coq.put(str3, new e(str, str2, z));
        }
        return coq.get(str3);
    }

    public static void it(int i) {
        for (String str : coq.keySet()) {
            a(coq.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.cou;
        d dVar2 = eVar.cov;
        d dVar3 = eVar.cow;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            q qVar = new q("dbg");
            qVar.r("act", eVar.type);
            qVar.r("httpTimeCost", String.valueOf(dVar.cor));
            qVar.r("httpNum", String.valueOf(dVar.num));
            qVar.r("httpFailnum", String.valueOf(dVar.cos));
            qVar.r("httpSize", String.valueOf(dVar.size));
            qVar.r("socketTimeCost", String.valueOf(dVar2.cor));
            qVar.r("socketNum", String.valueOf(dVar2.num));
            qVar.r("socketFailnum", String.valueOf(dVar2.cos));
            qVar.r("socketSize", String.valueOf(dVar2.size));
            qVar.r("abortTimeCost", String.valueOf(dVar3.cor));
            qVar.r("abortNum", String.valueOf(dVar3.num));
            qVar.r("netType", eVar.biK);
            qVar.r("isJson", eVar.cot ? "1" : GameInfoData.NOT_FROM_DETAIL);
            f.hP().a("frs", qVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
