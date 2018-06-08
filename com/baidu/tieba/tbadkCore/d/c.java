package com.baidu.tieba.tbadkCore.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, e> gKj;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tieba.tbadkCore.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    c.tA(1);
                }
            }
        });
        gKj = new HashMap<>();
    }

    public static void k(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!gKj.containsKey(str3)) {
            gKj.put(str3, new e(str, str2, z));
        }
    }

    public static e l(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!gKj.containsKey(str3)) {
            gKj.put(str3, new e(str, str2, z));
        }
        return gKj.get(str3);
    }

    public static void bxu() {
    }

    public static void tA(int i) {
        for (String str : gKj.keySet()) {
            a(gKj.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.gKn;
        d dVar2 = eVar.gKo;
        d dVar3 = eVar.gKp;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
            aVar.append(SocialConstants.PARAM_ACT, eVar.type);
            aVar.append("httpTimeCost", String.valueOf(dVar.gKk));
            aVar.append("httpNum", String.valueOf(dVar.num));
            aVar.append("httpFailnum", String.valueOf(dVar.gKl));
            aVar.append("httpSize", String.valueOf(dVar.size));
            aVar.append("socketTimeCost", String.valueOf(dVar2.gKk));
            aVar.append("socketNum", String.valueOf(dVar2.num));
            aVar.append("socketFailnum", String.valueOf(dVar2.gKl));
            aVar.append("socketSize", String.valueOf(dVar2.size));
            aVar.append("abortTimeCost", String.valueOf(dVar3.gKk));
            aVar.append("abortNum", String.valueOf(dVar3.num));
            aVar.append("netType", eVar.netType);
            aVar.append("isJson", eVar.gKm ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", aVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
