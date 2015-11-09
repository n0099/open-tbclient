package com.baidu.tieba.tbadkCore.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> dby;

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        dby = new HashMap<>();
    }

    public static void j(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!dby.containsKey(str3)) {
            dby.put(str3, new e(str, str2, z));
        }
    }

    public static e k(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!dby.containsKey(str3)) {
            dby.put(str3, new e(str, str2, z));
        }
        return dby.get(str3);
    }

    public static void axL() {
    }

    public static void lm(int i) {
        for (String str : dby.keySet()) {
            a(dby.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.dbC;
        d dVar2 = eVar.dbD;
        d dVar3 = eVar.dbE;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            com.baidu.adp.lib.stats.d dVar4 = new com.baidu.adp.lib.stats.d("dbg");
            dVar4.q("act", eVar.type);
            dVar4.q("httpTimeCost", String.valueOf(dVar.dbz));
            dVar4.q("httpNum", String.valueOf(dVar.num));
            dVar4.q("httpFailnum", String.valueOf(dVar.dbA));
            dVar4.q("httpSize", String.valueOf(dVar.size));
            dVar4.q("socketTimeCost", String.valueOf(dVar2.dbz));
            dVar4.q("socketNum", String.valueOf(dVar2.num));
            dVar4.q("socketFailnum", String.valueOf(dVar2.dbA));
            dVar4.q("socketSize", String.valueOf(dVar2.size));
            dVar4.q("abortTimeCost", String.valueOf(dVar3.dbz));
            dVar4.q("abortNum", String.valueOf(dVar3.num));
            dVar4.q("netType", eVar.bDF);
            dVar4.q("isJson", eVar.dbB ? "1" : "0");
            com.baidu.adp.lib.stats.a.hj().b("frs", dVar4);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
