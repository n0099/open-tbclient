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
    private static HashMap<String, e> ghE;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tbadkCore.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    c.tB(1);
                }
            }
        });
        ghE = new HashMap<>();
    }

    public static void k(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!ghE.containsKey(str3)) {
            ghE.put(str3, new e(str, str2, z));
        }
    }

    public static e l(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!ghE.containsKey(str3)) {
            ghE.put(str3, new e(str, str2, z));
        }
        return ghE.get(str3);
    }

    public static void brI() {
    }

    public static void tB(int i) {
        for (String str : ghE.keySet()) {
            a(ghE.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.ghI;
        d dVar2 = eVar.ghJ;
        d dVar3 = eVar.ghK;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
            aVar.p("act", eVar.type);
            aVar.p("httpTimeCost", String.valueOf(dVar.ghF));
            aVar.p("httpNum", String.valueOf(dVar.num));
            aVar.p("httpFailnum", String.valueOf(dVar.ghG));
            aVar.p("httpSize", String.valueOf(dVar.size));
            aVar.p("socketTimeCost", String.valueOf(dVar2.ghF));
            aVar.p("socketNum", String.valueOf(dVar2.num));
            aVar.p("socketFailnum", String.valueOf(dVar2.ghG));
            aVar.p("socketSize", String.valueOf(dVar2.size));
            aVar.p("abortTimeCost", String.valueOf(dVar3.ghF));
            aVar.p("abortNum", String.valueOf(dVar3.num));
            aVar.p("netType", eVar.netType);
            aVar.p("isJson", eVar.ghH ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", aVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
