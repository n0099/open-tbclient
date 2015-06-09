package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.game.GameInfoData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> csI;

    static {
        MessageManager.getInstance().registerListener(new c(2001011));
        csI = new HashMap<>();
    }

    public static void g(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!csI.containsKey(str3)) {
            csI.put(str3, new e(str, str2, z));
        }
    }

    public static e h(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!csI.containsKey(str3)) {
            csI.put(str3, new e(str, str2, z));
        }
        return csI.get(str3);
    }

    public static void iS(int i) {
        for (String str : csI.keySet()) {
            a(csI.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.csM;
        d dVar2 = eVar.csN;
        d dVar3 = eVar.csO;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            q qVar = new q("dbg");
            qVar.r("act", eVar.type);
            qVar.r("httpTimeCost", String.valueOf(dVar.csJ));
            qVar.r("httpNum", String.valueOf(dVar.num));
            qVar.r("httpFailnum", String.valueOf(dVar.csK));
            qVar.r("httpSize", String.valueOf(dVar.size));
            qVar.r("socketTimeCost", String.valueOf(dVar2.csJ));
            qVar.r("socketNum", String.valueOf(dVar2.num));
            qVar.r("socketFailnum", String.valueOf(dVar2.csK));
            qVar.r("socketSize", String.valueOf(dVar2.size));
            qVar.r("abortTimeCost", String.valueOf(dVar3.csJ));
            qVar.r("abortNum", String.valueOf(dVar3.num));
            qVar.r("netType", eVar.blE);
            qVar.r("isJson", eVar.csL ? "1" : GameInfoData.NOT_FROM_DETAIL);
            f.hz().a("frs", qVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
