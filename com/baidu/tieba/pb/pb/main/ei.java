package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eh;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei extends CustomMessageListener {
    final /* synthetic */ eh etJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei(eh ehVar, int i) {
        super(i);
        this.etJ = ehVar;
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
            hVar = this.etJ.pbData;
            if (hVar != null) {
                this.etJ.etF = false;
                hVar2 = this.etJ.pbData;
                if (hVar2.aMt() != null) {
                    hVar5 = this.etJ.pbData;
                    i = hVar5.aMt().size();
                } else {
                    i = 0;
                }
                if (this.etJ.ety >= i - 3) {
                    aVar = this.etJ.etG;
                    if (aVar != null) {
                        hVar4 = this.etJ.pbData;
                        if (hVar4.getPage().qB() != 0) {
                            aVar2 = this.etJ.etG;
                            aVar2.aPu();
                        }
                    }
                }
                if (this.etJ.ety >= i - 1) {
                    this.etJ.ety = -1;
                    this.etJ.etC = 5;
                    com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
                    beVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(r.j.read_thread_over));
                    beVar.bS(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar));
                    return;
                } else if (this.etJ.ety == -1) {
                    this.etJ.etC = 5;
                    this.etJ.ety = 0;
                    com.baidu.tbadk.core.data.be beVar2 = new com.baidu.tbadk.core.data.be();
                    beVar2.bS(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar2));
                    return;
                } else {
                    this.etJ.ety++;
                    this.etJ.etC = 1;
                    eh ehVar = this.etJ;
                    int i2 = this.etJ.ety;
                    hVar3 = this.etJ.pbData;
                    e = ehVar.e(i2, hVar3.aMt());
                    com.baidu.tbadk.core.data.be beVar3 = new com.baidu.tbadk.core.data.be();
                    beVar3.bS(1);
                    beVar3.setData(e);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar3));
                    return;
                }
            }
            this.etJ.etC = 5;
            this.etJ.ety = 0;
        }
    }
}
