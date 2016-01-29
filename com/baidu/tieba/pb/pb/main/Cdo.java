package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.dn;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends CustomMessageListener {
    final /* synthetic */ dn cPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cdo(dn dnVar, int i) {
        super(i);
        this.cPX = dnVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        com.baidu.tieba.pb.a.c cVar3;
        Object e;
        dn.a aVar;
        com.baidu.tieba.pb.a.c cVar4;
        dn.a aVar2;
        com.baidu.tieba.pb.a.c cVar5;
        if (customResponsedMessage != null) {
            cVar = this.cPX.pbData;
            if (cVar == null) {
                this.cPX.cPQ = 5;
                this.cPX.cPN = 0;
                return;
            }
            this.cPX.cPT = false;
            cVar2 = this.cPX.pbData;
            if (cVar2.aoG() != null) {
                cVar5 = this.cPX.pbData;
                i = cVar5.aoG().size();
            } else {
                i = 0;
            }
            i2 = this.cPX.cPN;
            if (i2 >= i - 3) {
                aVar = this.cPX.cPU;
                if (aVar != null) {
                    cVar4 = this.cPX.pbData;
                    if (cVar4.getPage().sv() != 0) {
                        aVar2 = this.cPX.cPU;
                        aVar2.aqG();
                    }
                }
            }
            i3 = this.cPX.cPN;
            if (i3 >= i - 1) {
                this.cPX.cPN = -1;
                this.cPX.cPQ = 5;
                com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                adVar.setData(TbadkCoreApplication.m411getInst().getResources().getString(t.j.read_thread_over));
                adVar.bS(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, adVar));
                return;
            }
            i4 = this.cPX.cPN;
            if (i4 == -1) {
                this.cPX.cPQ = 5;
                this.cPX.cPN = 0;
                com.baidu.tbadk.core.data.ad adVar2 = new com.baidu.tbadk.core.data.ad();
                adVar2.bS(15);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, adVar2));
                return;
            }
            dn dnVar = this.cPX;
            i5 = dnVar.cPN;
            dnVar.cPN = i5 + 1;
            this.cPX.cPQ = 1;
            dn dnVar2 = this.cPX;
            i6 = this.cPX.cPN;
            cVar3 = this.cPX.pbData;
            e = dnVar2.e(i6, cVar3.aoG());
            com.baidu.tbadk.core.data.ad adVar3 = new com.baidu.tbadk.core.data.ad();
            adVar3.bS(1);
            adVar3.setData(e);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, adVar3));
        }
    }
}
