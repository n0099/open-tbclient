package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, f> fwQ;

    static {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        fwQ = new HashMap<>();
    }

    public static void k(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!fwQ.containsKey(str3)) {
            fwQ.put(str3, new f(str, str2, z));
        }
    }

    public static f l(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!fwQ.containsKey(str3)) {
            fwQ.put(str3, new f(str, str2, z));
        }
        return fwQ.get(str3);
    }

    public static void biG() {
    }

    public static void rT(int i) {
        for (String str : fwQ.keySet()) {
            a(fwQ.get(str), i);
        }
    }

    public static void a(f fVar, int i) {
        e eVar = fVar.fwU;
        e eVar2 = fVar.fwV;
        e eVar3 = fVar.fwW;
        if (eVar.num + eVar2.num + eVar3.num >= i) {
            com.baidu.adp.lib.stats.c cVar = new com.baidu.adp.lib.stats.c("dbg");
            cVar.p("act", fVar.type);
            cVar.p("httpTimeCost", String.valueOf(eVar.fwR));
            cVar.p("httpNum", String.valueOf(eVar.num));
            cVar.p("httpFailnum", String.valueOf(eVar.fwS));
            cVar.p("httpSize", String.valueOf(eVar.size));
            cVar.p("socketTimeCost", String.valueOf(eVar2.fwR));
            cVar.p("socketNum", String.valueOf(eVar2.num));
            cVar.p("socketFailnum", String.valueOf(eVar2.fwS));
            cVar.p("socketSize", String.valueOf(eVar2.size));
            cVar.p("abortTimeCost", String.valueOf(eVar3.fwR));
            cVar.p("abortNum", String.valueOf(eVar3.num));
            cVar.p("netType", fVar.netType);
            cVar.p("isJson", fVar.fwT ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", cVar);
            eVar.reset();
            eVar2.reset();
            eVar3.reset();
        }
    }
}
