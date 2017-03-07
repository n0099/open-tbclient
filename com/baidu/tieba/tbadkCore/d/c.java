package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, f> fvh;

    static {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        fvh = new HashMap<>();
    }

    public static void j(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!fvh.containsKey(str3)) {
            fvh.put(str3, new f(str, str2, z));
        }
    }

    public static f k(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!fvh.containsKey(str3)) {
            fvh.put(str3, new f(str, str2, z));
        }
        return fvh.get(str3);
    }

    public static void bhV() {
    }

    public static void rV(int i) {
        for (String str : fvh.keySet()) {
            a(fvh.get(str), i);
        }
    }

    public static void a(f fVar, int i) {
        e eVar = fVar.fvl;
        e eVar2 = fVar.fvm;
        e eVar3 = fVar.fvn;
        if (eVar.num + eVar2.num + eVar3.num >= i) {
            com.baidu.adp.lib.stats.c cVar = new com.baidu.adp.lib.stats.c("dbg");
            cVar.p("act", fVar.type);
            cVar.p("httpTimeCost", String.valueOf(eVar.fvi));
            cVar.p("httpNum", String.valueOf(eVar.num));
            cVar.p("httpFailnum", String.valueOf(eVar.fvj));
            cVar.p("httpSize", String.valueOf(eVar.size));
            cVar.p("socketTimeCost", String.valueOf(eVar2.fvi));
            cVar.p("socketNum", String.valueOf(eVar2.num));
            cVar.p("socketFailnum", String.valueOf(eVar2.fvj));
            cVar.p("socketSize", String.valueOf(eVar2.size));
            cVar.p("abortTimeCost", String.valueOf(eVar3.fvi));
            cVar.p("abortNum", String.valueOf(eVar3.num));
            cVar.p("netType", fVar.netType);
            cVar.p("isJson", fVar.fvk ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", cVar);
            eVar.reset();
            eVar2.reset();
            eVar3.reset();
        }
    }
}
