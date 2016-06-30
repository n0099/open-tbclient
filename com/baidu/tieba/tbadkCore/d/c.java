package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, f> eYI;

    static {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        eYI = new HashMap<>();
    }

    public static void i(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!eYI.containsKey(str3)) {
            eYI.put(str3, new f(str, str2, z));
        }
    }

    public static f j(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!eYI.containsKey(str3)) {
            eYI.put(str3, new f(str, str2, z));
        }
        return eYI.get(str3);
    }

    public static void bcJ() {
    }

    public static void qH(int i) {
        for (String str : eYI.keySet()) {
            a(eYI.get(str), i);
        }
    }

    public static void a(f fVar, int i) {
        e eVar = fVar.eYM;
        e eVar2 = fVar.eYN;
        e eVar3 = fVar.eYO;
        if (eVar.num + eVar2.num + eVar3.num >= i) {
            com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
            dVar.q("act", fVar.type);
            dVar.q("httpTimeCost", String.valueOf(eVar.eYJ));
            dVar.q("httpNum", String.valueOf(eVar.num));
            dVar.q("httpFailnum", String.valueOf(eVar.eYK));
            dVar.q("httpSize", String.valueOf(eVar.size));
            dVar.q("socketTimeCost", String.valueOf(eVar2.eYJ));
            dVar.q("socketNum", String.valueOf(eVar2.num));
            dVar.q("socketFailnum", String.valueOf(eVar2.eYK));
            dVar.q("socketSize", String.valueOf(eVar2.size));
            dVar.q("abortTimeCost", String.valueOf(eVar3.eYJ));
            dVar.q("abortNum", String.valueOf(eVar3.num));
            dVar.q("netType", fVar.cRE);
            dVar.q("isJson", fVar.eYL ? "1" : "0");
            com.baidu.adp.lib.stats.a.dO().b("frs", dVar);
            eVar.reset();
            eVar2.reset();
            eVar3.reset();
        }
    }
}
