package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private static HashMap<String, e> dHR;

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        dHR = new HashMap<>();
    }

    public static void h(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!dHR.containsKey(str3)) {
            dHR.put(str3, new e(str, str2, z));
        }
    }

    public static e i(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!dHR.containsKey(str3)) {
            dHR.put(str3, new e(str, str2, z));
        }
        return dHR.get(str3);
    }

    public static void aFJ() {
    }

    public static void na(int i) {
        for (String str : dHR.keySet()) {
            a(dHR.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.dHV;
        d dVar2 = eVar.dHW;
        d dVar3 = eVar.dHX;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            com.baidu.adp.lib.stats.d dVar4 = new com.baidu.adp.lib.stats.d("dbg");
            dVar4.q("act", eVar.type);
            dVar4.q("httpTimeCost", String.valueOf(dVar.dHS));
            dVar4.q("httpNum", String.valueOf(dVar.num));
            dVar4.q("httpFailnum", String.valueOf(dVar.dHT));
            dVar4.q("httpSize", String.valueOf(dVar.size));
            dVar4.q("socketTimeCost", String.valueOf(dVar2.dHS));
            dVar4.q("socketNum", String.valueOf(dVar2.num));
            dVar4.q("socketFailnum", String.valueOf(dVar2.dHT));
            dVar4.q("socketSize", String.valueOf(dVar2.size));
            dVar4.q("abortTimeCost", String.valueOf(dVar3.dHS));
            dVar4.q("abortNum", String.valueOf(dVar3.num));
            dVar4.q("netType", eVar.bWt);
            dVar4.q("isJson", eVar.dHU ? "1" : "0");
            com.baidu.adp.lib.stats.a.hl().b("frs", dVar4);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
