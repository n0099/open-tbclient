package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, e> nsZ;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tbadkCore.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    c.KV(1);
                }
            }
        });
        nsZ = new HashMap<>();
    }

    public static void H(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!nsZ.containsKey(str3)) {
            nsZ.put(str3, new e(str, str2, z));
        }
    }

    public static e I(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!nsZ.containsKey(str3)) {
            nsZ.put(str3, new e(str, str2, z));
        }
        return nsZ.get(str3);
    }

    public static void dPw() {
    }

    public static void KV(int i) {
        for (String str : nsZ.keySet()) {
            a(nsZ.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.ntd;
        d dVar2 = eVar.nte;
        d dVar3 = eVar.ntf;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
            aVar.append("act", eVar.type);
            aVar.append("httpTimeCost", String.valueOf(dVar.nta));
            aVar.append("httpNum", String.valueOf(dVar.num));
            aVar.append("httpFailnum", String.valueOf(dVar.ntb));
            aVar.append("httpSize", String.valueOf(dVar.size));
            aVar.append("socketTimeCost", String.valueOf(dVar2.nta));
            aVar.append("socketNum", String.valueOf(dVar2.num));
            aVar.append("socketFailnum", String.valueOf(dVar2.ntb));
            aVar.append("socketSize", String.valueOf(dVar2.size));
            aVar.append("abortTimeCost", String.valueOf(dVar3.nta));
            aVar.append("abortNum", String.valueOf(dVar3.num));
            aVar.append("netType", eVar.netType);
            aVar.append("isJson", eVar.ntc ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", aVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
