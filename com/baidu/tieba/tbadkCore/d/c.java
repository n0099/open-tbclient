package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, f> dXR;

    static {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        dXR = new HashMap<>();
    }

    public static void h(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!dXR.containsKey(str3)) {
            dXR.put(str3, new f(str, str2, z));
        }
    }

    public static f i(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!dXR.containsKey(str3)) {
            dXR.put(str3, new f(str, str2, z));
        }
        return dXR.get(str3);
    }

    public static void aMO() {
    }

    public static void on(int i) {
        for (String str : dXR.keySet()) {
            a(dXR.get(str), i);
        }
    }

    public static void a(f fVar, int i) {
        e eVar = fVar.dXV;
        e eVar2 = fVar.dXW;
        e eVar3 = fVar.dXX;
        if (eVar.num + eVar2.num + eVar3.num >= i) {
            com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
            dVar.r("act", fVar.type);
            dVar.r("httpTimeCost", String.valueOf(eVar.dXS));
            dVar.r("httpNum", String.valueOf(eVar.num));
            dVar.r("httpFailnum", String.valueOf(eVar.dXT));
            dVar.r("httpSize", String.valueOf(eVar.size));
            dVar.r("socketTimeCost", String.valueOf(eVar2.dXS));
            dVar.r("socketNum", String.valueOf(eVar2.num));
            dVar.r("socketFailnum", String.valueOf(eVar2.dXT));
            dVar.r("socketSize", String.valueOf(eVar2.size));
            dVar.r("abortTimeCost", String.valueOf(eVar3.dXS));
            dVar.r("abortNum", String.valueOf(eVar3.num));
            dVar.r("netType", fVar.caN);
            dVar.r("isJson", fVar.dXU ? "1" : "0");
            com.baidu.adp.lib.stats.a.ht().b("frs", dVar);
            eVar.reset();
            eVar2.reset();
            eVar3.reset();
        }
    }
}
