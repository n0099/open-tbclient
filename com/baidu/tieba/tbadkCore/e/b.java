package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> cZo;

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        cZo = new HashMap<>();
    }

    public static void j(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!cZo.containsKey(str3)) {
            cZo.put(str3, new e(str, str2, z));
        }
    }

    public static e k(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!cZo.containsKey(str3)) {
            cZo.put(str3, new e(str, str2, z));
        }
        return cZo.get(str3);
    }

    public static void awP() {
    }

    public static void kW(int i) {
        for (String str : cZo.keySet()) {
            a(cZo.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.cZs;
        d dVar2 = eVar.cZt;
        d dVar3 = eVar.cZu;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            com.baidu.adp.lib.stats.d dVar4 = new com.baidu.adp.lib.stats.d("dbg");
            dVar4.q("act", eVar.type);
            dVar4.q("httpTimeCost", String.valueOf(dVar.cZp));
            dVar4.q("httpNum", String.valueOf(dVar.num));
            dVar4.q("httpFailnum", String.valueOf(dVar.cZq));
            dVar4.q("httpSize", String.valueOf(dVar.size));
            dVar4.q("socketTimeCost", String.valueOf(dVar2.cZp));
            dVar4.q("socketNum", String.valueOf(dVar2.num));
            dVar4.q("socketFailnum", String.valueOf(dVar2.cZq));
            dVar4.q("socketSize", String.valueOf(dVar2.size));
            dVar4.q("abortTimeCost", String.valueOf(dVar3.cZp));
            dVar4.q("abortNum", String.valueOf(dVar3.num));
            dVar4.q("netType", eVar.bCZ);
            dVar4.q("isJson", eVar.cZr ? "1" : "0");
            com.baidu.adp.lib.stats.a.hi().b("frs", dVar4);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
