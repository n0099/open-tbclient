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
    private static HashMap<String, e> mqd;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tbadkCore.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    c.Iw(1);
                }
            }
        });
        mqd = new HashMap<>();
    }

    public static void C(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!mqd.containsKey(str3)) {
            mqd.put(str3, new e(str, str2, z));
        }
    }

    public static e D(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!mqd.containsKey(str3)) {
            mqd.put(str3, new e(str, str2, z));
        }
        return mqd.get(str3);
    }

    public static void dAW() {
    }

    public static void Iw(int i) {
        for (String str : mqd.keySet()) {
            a(mqd.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.mqh;
        d dVar2 = eVar.mqi;
        d dVar3 = eVar.mqj;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
            aVar.append("act", eVar.type);
            aVar.append("httpTimeCost", String.valueOf(dVar.mqe));
            aVar.append("httpNum", String.valueOf(dVar.num));
            aVar.append("httpFailnum", String.valueOf(dVar.mqf));
            aVar.append("httpSize", String.valueOf(dVar.size));
            aVar.append("socketTimeCost", String.valueOf(dVar2.mqe));
            aVar.append("socketNum", String.valueOf(dVar2.num));
            aVar.append("socketFailnum", String.valueOf(dVar2.mqf));
            aVar.append("socketSize", String.valueOf(dVar2.size));
            aVar.append("abortTimeCost", String.valueOf(dVar3.mqe));
            aVar.append("abortNum", String.valueOf(dVar3.num));
            aVar.append("netType", eVar.netType);
            aVar.append("isJson", eVar.mqg ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", aVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
