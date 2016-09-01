package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, f> ftF;

    static {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        ftF = new HashMap<>();
    }

    public static void i(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!ftF.containsKey(str3)) {
            ftF.put(str3, new f(str, str2, z));
        }
    }

    public static f j(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!ftF.containsKey(str3)) {
            ftF.put(str3, new f(str, str2, z));
        }
        return ftF.get(str3);
    }

    public static void bjz() {
    }

    public static void rC(int i) {
        for (String str : ftF.keySet()) {
            a(ftF.get(str), i);
        }
    }

    public static void a(f fVar, int i) {
        e eVar = fVar.ftJ;
        e eVar2 = fVar.ftK;
        e eVar3 = fVar.ftL;
        if (eVar.num + eVar2.num + eVar3.num >= i) {
            com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
            dVar.q("act", fVar.type);
            dVar.q("httpTimeCost", String.valueOf(eVar.ftG));
            dVar.q("httpNum", String.valueOf(eVar.num));
            dVar.q("httpFailnum", String.valueOf(eVar.ftH));
            dVar.q("httpSize", String.valueOf(eVar.size));
            dVar.q("socketTimeCost", String.valueOf(eVar2.ftG));
            dVar.q("socketNum", String.valueOf(eVar2.num));
            dVar.q("socketFailnum", String.valueOf(eVar2.ftH));
            dVar.q("socketSize", String.valueOf(eVar2.size));
            dVar.q("abortTimeCost", String.valueOf(eVar3.ftG));
            dVar.q("abortNum", String.valueOf(eVar3.num));
            dVar.q("netType", fVar.dgj);
            dVar.q("isJson", fVar.ftI ? "1" : "0");
            com.baidu.adp.lib.stats.a.eI().b("frs", dVar);
            eVar.reset();
            eVar2.reset();
            eVar3.reset();
        }
    }
}
