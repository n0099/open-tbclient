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
    private static HashMap<String, e> nnm;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tbadkCore.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    c.KZ(1);
                }
            }
        });
        nnm = new HashMap<>();
    }

    public static void F(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!nnm.containsKey(str3)) {
            nnm.put(str3, new e(str, str2, z));
        }
    }

    public static e G(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str + str2;
        if (!nnm.containsKey(str3)) {
            nnm.put(str3, new e(str, str2, z));
        }
        return nnm.get(str3);
    }

    public static void dPA() {
    }

    public static void KZ(int i) {
        for (String str : nnm.keySet()) {
            a(nnm.get(str), i);
        }
    }

    public static void a(e eVar, int i) {
        d dVar = eVar.nnq;
        d dVar2 = eVar.nnr;
        d dVar3 = eVar.nns;
        if (dVar.num + dVar2.num + dVar3.num >= i) {
            com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
            aVar.append("act", eVar.type);
            aVar.append("httpTimeCost", String.valueOf(dVar.nnn));
            aVar.append("httpNum", String.valueOf(dVar.num));
            aVar.append("httpFailnum", String.valueOf(dVar.nno));
            aVar.append("httpSize", String.valueOf(dVar.size));
            aVar.append("socketTimeCost", String.valueOf(dVar2.nnn));
            aVar.append("socketNum", String.valueOf(dVar2.num));
            aVar.append("socketFailnum", String.valueOf(dVar2.nno));
            aVar.append("socketSize", String.valueOf(dVar2.size));
            aVar.append("abortTimeCost", String.valueOf(dVar3.nnn));
            aVar.append("abortNum", String.valueOf(dVar3.num));
            aVar.append("netType", eVar.netType);
            aVar.append("isJson", eVar.nnp ? "1" : "0");
            BdStatisticsManager.getInstance().debug("frs", aVar);
            dVar.reset();
            dVar2.reset();
            dVar3.reset();
        }
    }
}
