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
    private static HashMap<String, e> hmA;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tieba.tbadkCore.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    c.vw(1);
                }
            }
        });
        hmA = new HashMap<>();
    }

    public static void k(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!hmA.containsKey(str3)) {
            hmA.put(str3, new e(str, str2, z));
        }
    }

    public static e l(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!hmA.containsKey(str3)) {
            hmA.put(str3, new e(str, str2, z));
        }
        return hmA.get(str3);
    }

    public static void bDL() {
    }

    public static void vw(int i) {
        for (String str : hmA.keySet()) {
            a(hmA.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.hmE;
        d dVar2 = eVar.hmF;
        d dVar3 = eVar.hmG;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
            aVar.append(SocialConstants.PARAM_ACT, eVar.type);
            aVar.append("httpTimeCost", String.valueOf(dVar.hmB));
            aVar.append("httpNum", String.valueOf(dVar.num));
            aVar.append("httpFailnum", String.valueOf(dVar.hmC));
            aVar.append("httpSize", String.valueOf(dVar.size));
            aVar.append("socketTimeCost", String.valueOf(dVar2.hmB));
            aVar.append("socketNum", String.valueOf(dVar2.num));
            aVar.append("socketFailnum", String.valueOf(dVar2.hmC));
            aVar.append("socketSize", String.valueOf(dVar2.size));
            aVar.append("abortTimeCost", String.valueOf(dVar3.hmB));
            aVar.append("abortNum", String.valueOf(dVar3.num));
            aVar.append("netType", eVar.netType);
            aVar.append("isJson", eVar.hmD ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", aVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
