package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, e> gCY;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tbadkCore.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    c.ux(1);
                }
            }
        });
        gCY = new HashMap<>();
    }

    public static void k(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!gCY.containsKey(str3)) {
            gCY.put(str3, new e(str, str2, z));
        }
    }

    public static e l(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!gCY.containsKey(str3)) {
            gCY.put(str3, new e(str, str2, z));
        }
        return gCY.get(str3);
    }

    public static void bxo() {
    }

    public static void ux(int i) {
        for (String str : gCY.keySet()) {
            a(gCY.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.gDc;
        d dVar2 = eVar.gDd;
        d dVar3 = eVar.gDe;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
            aVar.p("act", eVar.type);
            aVar.p("httpTimeCost", String.valueOf(dVar.gCZ));
            aVar.p("httpNum", String.valueOf(dVar.num));
            aVar.p("httpFailnum", String.valueOf(dVar.gDa));
            aVar.p("httpSize", String.valueOf(dVar.size));
            aVar.p("socketTimeCost", String.valueOf(dVar2.gCZ));
            aVar.p("socketNum", String.valueOf(dVar2.num));
            aVar.p("socketFailnum", String.valueOf(dVar2.gDa));
            aVar.p("socketSize", String.valueOf(dVar2.size));
            aVar.p("abortTimeCost", String.valueOf(dVar3.gCZ));
            aVar.p("abortNum", String.valueOf(dVar3.num));
            aVar.p("netType", eVar.netType);
            aVar.p("isJson", eVar.gDb ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", aVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
