package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, f> eqI;

    static {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        eqI = new HashMap<>();
    }

    public static void h(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!eqI.containsKey(str3)) {
            eqI.put(str3, new f(str, str2, z));
        }
    }

    public static f i(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!eqI.containsKey(str3)) {
            eqI.put(str3, new f(str, str2, z));
        }
        return eqI.get(str3);
    }

    public static void aTP() {
    }

    public static void px(int i) {
        for (String str : eqI.keySet()) {
            a(eqI.get(str), i);
        }
    }

    public static void a(f fVar, int i) {
        e eVar = fVar.eqM;
        e eVar2 = fVar.eqN;
        e eVar3 = fVar.eqO;
        if (eVar.num + eVar2.num + eVar3.num >= i) {
            com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
            dVar.r("act", fVar.type);
            dVar.r("httpTimeCost", String.valueOf(eVar.eqJ));
            dVar.r("httpNum", String.valueOf(eVar.num));
            dVar.r("httpFailnum", String.valueOf(eVar.eqK));
            dVar.r("httpSize", String.valueOf(eVar.size));
            dVar.r("socketTimeCost", String.valueOf(eVar2.eqJ));
            dVar.r("socketNum", String.valueOf(eVar2.num));
            dVar.r("socketFailnum", String.valueOf(eVar2.eqK));
            dVar.r("socketSize", String.valueOf(eVar2.size));
            dVar.r("abortTimeCost", String.valueOf(eVar3.eqJ));
            dVar.r("abortNum", String.valueOf(eVar3.num));
            dVar.r("netType", fVar.clq);
            dVar.r("isJson", fVar.eqL ? "1" : "0");
            com.baidu.adp.lib.stats.a.hz().b("frs", dVar);
            eVar.reset();
            eVar2.reset();
            eVar3.reset();
        }
    }
}
