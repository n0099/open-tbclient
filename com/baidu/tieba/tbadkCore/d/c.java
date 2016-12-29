package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, f> fhv;

    static {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        fhv = new HashMap<>();
    }

    public static void i(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!fhv.containsKey(str3)) {
            fhv.put(str3, new f(str, str2, z));
        }
    }

    public static f j(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!fhv.containsKey(str3)) {
            fhv.put(str3, new f(str, str2, z));
        }
        return fhv.get(str3);
    }

    public static void bgq() {
    }

    public static void rl(int i) {
        for (String str : fhv.keySet()) {
            a(fhv.get(str), i);
        }
    }

    public static void a(f fVar, int i) {
        e eVar = fVar.fhz;
        e eVar2 = fVar.fhA;
        e eVar3 = fVar.fhB;
        if (eVar.num + eVar2.num + eVar3.num >= i) {
            com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
            dVar.q("act", fVar.type);
            dVar.q("httpTimeCost", String.valueOf(eVar.fhw));
            dVar.q("httpNum", String.valueOf(eVar.num));
            dVar.q("httpFailnum", String.valueOf(eVar.fhx));
            dVar.q("httpSize", String.valueOf(eVar.size));
            dVar.q("socketTimeCost", String.valueOf(eVar2.fhw));
            dVar.q("socketNum", String.valueOf(eVar2.num));
            dVar.q("socketFailnum", String.valueOf(eVar2.fhx));
            dVar.q("socketSize", String.valueOf(eVar2.size));
            dVar.q("abortTimeCost", String.valueOf(eVar3.fhw));
            dVar.q("abortNum", String.valueOf(eVar3.num));
            dVar.q("netType", fVar.cSk);
            dVar.q("isJson", fVar.fhy ? "1" : "0");
            com.baidu.adp.lib.stats.a.eI().b("frs", dVar);
            eVar.reset();
            eVar2.reset();
            eVar3.reset();
        }
    }
}
