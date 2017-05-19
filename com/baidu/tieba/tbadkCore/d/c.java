package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, f> fvp;

    static {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        fvp = new HashMap<>();
    }

    public static void j(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!fvp.containsKey(str3)) {
            fvp.put(str3, new f(str, str2, z));
        }
    }

    public static f k(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!fvp.containsKey(str3)) {
            fvp.put(str3, new f(str, str2, z));
        }
        return fvp.get(str3);
    }

    public static void bhe() {
    }

    public static void rR(int i) {
        for (String str : fvp.keySet()) {
            a(fvp.get(str), i);
        }
    }

    public static void a(f fVar, int i) {
        e eVar = fVar.fvt;
        e eVar2 = fVar.fvu;
        e eVar3 = fVar.fvv;
        if (eVar.num + eVar2.num + eVar3.num >= i) {
            com.baidu.adp.lib.stats.c cVar = new com.baidu.adp.lib.stats.c("dbg");
            cVar.p("act", fVar.type);
            cVar.p("httpTimeCost", String.valueOf(eVar.fvq));
            cVar.p("httpNum", String.valueOf(eVar.num));
            cVar.p("httpFailnum", String.valueOf(eVar.fvr));
            cVar.p("httpSize", String.valueOf(eVar.size));
            cVar.p("socketTimeCost", String.valueOf(eVar2.fvq));
            cVar.p("socketNum", String.valueOf(eVar2.num));
            cVar.p("socketFailnum", String.valueOf(eVar2.fvr));
            cVar.p("socketSize", String.valueOf(eVar2.size));
            cVar.p("abortTimeCost", String.valueOf(eVar3.fvq));
            cVar.p("abortNum", String.valueOf(eVar3.num));
            cVar.p("netType", fVar.netType);
            cVar.p("isJson", fVar.fvs ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", cVar);
            eVar.reset();
            eVar2.reset();
            eVar3.reset();
        }
    }
}
