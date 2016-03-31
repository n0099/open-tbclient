package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ei;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ej extends CustomMessageListener {
    final /* synthetic */ ei dko;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ej(ei eiVar, int i) {
        super(i);
        this.dko = eiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        com.baidu.tieba.pb.data.e eVar3;
        Object e;
        ei.a aVar;
        com.baidu.tieba.pb.data.e eVar4;
        ei.a aVar2;
        com.baidu.tieba.pb.data.e eVar5;
        if (customResponsedMessage != null) {
            eVar = this.dko.pbData;
            if (eVar == null) {
                this.dko.dkh = 5;
                this.dko.dke = 0;
                return;
            }
            this.dko.dkk = false;
            eVar2 = this.dko.pbData;
            if (eVar2.avw() != null) {
                eVar5 = this.dko.pbData;
                i = eVar5.avw().size();
            } else {
                i = 0;
            }
            i2 = this.dko.dke;
            if (i2 >= i - 3) {
                aVar = this.dko.dkl;
                if (aVar != null) {
                    eVar4 = this.dko.pbData;
                    if (eVar4.getPage().sq() != 0) {
                        aVar2 = this.dko.dkl;
                        aVar2.axW();
                    }
                }
            }
            i3 = this.dko.dke;
            if (i3 >= i - 1) {
                this.dko.dke = -1;
                this.dko.dkh = 5;
                com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                aoVar.setData(TbadkCoreApplication.m411getInst().getResources().getString(t.j.read_thread_over));
                aoVar.bU(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, aoVar));
                return;
            }
            i4 = this.dko.dke;
            if (i4 == -1) {
                this.dko.dkh = 5;
                this.dko.dke = 0;
                com.baidu.tbadk.core.data.ao aoVar2 = new com.baidu.tbadk.core.data.ao();
                aoVar2.bU(15);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, aoVar2));
                return;
            }
            ei eiVar = this.dko;
            i5 = eiVar.dke;
            eiVar.dke = i5 + 1;
            this.dko.dkh = 1;
            ei eiVar2 = this.dko;
            i6 = this.dko.dke;
            eVar3 = this.dko.pbData;
            e = eiVar2.e(i6, eVar3.avw());
            com.baidu.tbadk.core.data.ao aoVar3 = new com.baidu.tbadk.core.data.ao();
            aoVar3.bU(1);
            aoVar3.setData(e);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, aoVar3));
        }
    }
}
