package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.dz;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ea extends CustomMessageListener {
    final /* synthetic */ dz dmN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ea(dz dzVar, int i) {
        super(i);
        this.dmN = dzVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        int i;
        com.baidu.tieba.pb.data.e eVar3;
        Object e;
        dz.a aVar;
        com.baidu.tieba.pb.data.e eVar4;
        dz.a aVar2;
        com.baidu.tieba.pb.data.e eVar5;
        if (customResponsedMessage != null) {
            eVar = this.dmN.pbData;
            if (eVar != null) {
                this.dmN.dmJ = false;
                eVar2 = this.dmN.pbData;
                if (eVar2.avF() != null) {
                    eVar5 = this.dmN.pbData;
                    i = eVar5.avF().size();
                } else {
                    i = 0;
                }
                if (this.dmN.dmC >= i - 3) {
                    aVar = this.dmN.dmK;
                    if (aVar != null) {
                        eVar4 = this.dmN.pbData;
                        if (eVar4.getPage().pK() != 0) {
                            aVar2 = this.dmN.dmK;
                            aVar2.ayy();
                        }
                    }
                }
                if (this.dmN.dmC >= i - 1) {
                    this.dmN.dmC = -1;
                    this.dmN.dmG = 5;
                    com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
                    atVar.setData(TbadkCoreApplication.m11getInst().getResources().getString(t.j.read_thread_over));
                    atVar.bF(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, atVar));
                    return;
                } else if (this.dmN.dmC == -1) {
                    this.dmN.dmG = 5;
                    this.dmN.dmC = 0;
                    com.baidu.tbadk.core.data.at atVar2 = new com.baidu.tbadk.core.data.at();
                    atVar2.bF(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, atVar2));
                    return;
                } else {
                    this.dmN.dmC++;
                    this.dmN.dmG = 1;
                    dz dzVar = this.dmN;
                    int i2 = this.dmN.dmC;
                    eVar3 = this.dmN.pbData;
                    e = dzVar.e(i2, eVar3.avF());
                    com.baidu.tbadk.core.data.at atVar3 = new com.baidu.tbadk.core.data.at();
                    atVar3.bF(1);
                    atVar3.setData(e);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, atVar3));
                    return;
                }
            }
            this.dmN.dmG = 5;
            this.dmN.dmC = 0;
        }
    }
}
