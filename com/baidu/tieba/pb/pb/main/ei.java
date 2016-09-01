package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eh;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei extends CustomMessageListener {
    final /* synthetic */ eh erA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei(eh ehVar, int i) {
        super(i);
        this.erA = ehVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        int i;
        com.baidu.tieba.pb.data.h hVar3;
        Object e;
        eh.a aVar;
        com.baidu.tieba.pb.data.h hVar4;
        eh.a aVar2;
        com.baidu.tieba.pb.data.h hVar5;
        if (customResponsedMessage != null) {
            hVar = this.erA.pbData;
            if (hVar != null) {
                this.erA.erw = false;
                hVar2 = this.erA.pbData;
                if (hVar2.aLR() != null) {
                    hVar5 = this.erA.pbData;
                    i = hVar5.aLR().size();
                } else {
                    i = 0;
                }
                if (this.erA.erp >= i - 3) {
                    aVar = this.erA.erx;
                    if (aVar != null) {
                        hVar4 = this.erA.pbData;
                        if (hVar4.getPage().qq() != 0) {
                            aVar2 = this.erA.erx;
                            aVar2.aOL();
                        }
                    }
                }
                if (this.erA.erp >= i - 1) {
                    this.erA.erp = -1;
                    this.erA.ert = 5;
                    com.baidu.tbadk.core.data.bc bcVar = new com.baidu.tbadk.core.data.bc();
                    bcVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(t.j.read_thread_over));
                    bcVar.bS(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar));
                    return;
                } else if (this.erA.erp == -1) {
                    this.erA.ert = 5;
                    this.erA.erp = 0;
                    com.baidu.tbadk.core.data.bc bcVar2 = new com.baidu.tbadk.core.data.bc();
                    bcVar2.bS(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar2));
                    return;
                } else {
                    this.erA.erp++;
                    this.erA.ert = 1;
                    eh ehVar = this.erA;
                    int i2 = this.erA.erp;
                    hVar3 = this.erA.pbData;
                    e = ehVar.e(i2, hVar3.aLR());
                    com.baidu.tbadk.core.data.bc bcVar3 = new com.baidu.tbadk.core.data.bc();
                    bcVar3.bS(1);
                    bcVar3.setData(e);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar3));
                    return;
                }
            }
            this.erA.ert = 5;
            this.erA.erp = 0;
        }
    }
}
