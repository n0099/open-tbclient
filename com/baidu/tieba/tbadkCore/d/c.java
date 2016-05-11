package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, f> etS;

    static {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        etS = new HashMap<>();
    }

    public static void h(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!etS.containsKey(str3)) {
            etS.put(str3, new f(str, str2, z));
        }
    }

    public static f i(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = String.valueOf(str) + str2;
        if (!etS.containsKey(str3)) {
            etS.put(str3, new f(str, str2, z));
        }
        return etS.get(str3);
    }

    public static void aUp() {
    }

    public static void ps(int i) {
        for (String str : etS.keySet()) {
            a(etS.get(str), i);
        }
    }

    public static void a(f fVar, int i) {
        e eVar = fVar.etW;
        e eVar2 = fVar.etX;
        e eVar3 = fVar.etY;
        if (eVar.num + eVar2.num + eVar3.num >= i) {
            com.baidu.adp.lib.stats.d dVar = new com.baidu.adp.lib.stats.d("dbg");
            dVar.q("act", fVar.type);
            dVar.q("httpTimeCost", String.valueOf(eVar.etT));
            dVar.q("httpNum", String.valueOf(eVar.num));
            dVar.q("httpFailnum", String.valueOf(eVar.etU));
            dVar.q("httpSize", String.valueOf(eVar.size));
            dVar.q("socketTimeCost", String.valueOf(eVar2.etT));
            dVar.q("socketNum", String.valueOf(eVar2.num));
            dVar.q("socketFailnum", String.valueOf(eVar2.etU));
            dVar.q("socketSize", String.valueOf(eVar2.size));
            dVar.q("abortTimeCost", String.valueOf(eVar3.etT));
            dVar.q("abortNum", String.valueOf(eVar3.num));
            dVar.q("netType", fVar.cmp);
            dVar.q("isJson", fVar.etV ? "1" : "0");
            com.baidu.adp.lib.stats.a.dN().b("frs", dVar);
            eVar.reset();
            eVar2.reset();
            eVar3.reset();
        }
    }
}
