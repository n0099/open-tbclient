package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, f> fqJ;

    static {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        fqJ = new HashMap<>();
    }

    public static void j(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!fqJ.containsKey(str3)) {
            fqJ.put(str3, new f(str, str2, z));
        }
    }

    public static f k(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!fqJ.containsKey(str3)) {
            fqJ.put(str3, new f(str, str2, z));
        }
        return fqJ.get(str3);
    }

    public static void bif() {
    }

    public static void rW(int i) {
        for (String str : fqJ.keySet()) {
            a(fqJ.get(str), i);
        }
    }

    public static void a(f fVar, int i) {
        e eVar = fVar.fqN;
        e eVar2 = fVar.fqO;
        e eVar3 = fVar.fqP;
        if (eVar.num + eVar2.num + eVar3.num >= i) {
            com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
            dVar.q("act", fVar.type);
            dVar.q("httpTimeCost", String.valueOf(eVar.fqK));
            dVar.q("httpNum", String.valueOf(eVar.num));
            dVar.q("httpFailnum", String.valueOf(eVar.fqL));
            dVar.q("httpSize", String.valueOf(eVar.size));
            dVar.q("socketTimeCost", String.valueOf(eVar2.fqK));
            dVar.q("socketNum", String.valueOf(eVar2.num));
            dVar.q("socketFailnum", String.valueOf(eVar2.fqL));
            dVar.q("socketSize", String.valueOf(eVar2.size));
            dVar.q("abortTimeCost", String.valueOf(eVar3.fqK));
            dVar.q("abortNum", String.valueOf(eVar3.num));
            dVar.q("netType", fVar.netType);
            dVar.q("isJson", fVar.fqM ? "1" : "0");
            com.baidu.adp.lib.stats.a.eG().b("frs", dVar);
            eVar.reset();
            eVar2.reset();
            eVar3.reset();
        }
    }
}
