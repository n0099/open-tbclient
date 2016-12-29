package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eb;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ec extends CustomMessageListener {
    final /* synthetic */ eb eej;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ec(eb ebVar, int i) {
        super(i);
        this.eej = ebVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tieba.pb.data.f fVar2;
        int i;
        com.baidu.tieba.pb.data.f fVar3;
        Object e;
        eb.a aVar;
        com.baidu.tieba.pb.data.f fVar4;
        eb.a aVar2;
        com.baidu.tieba.pb.data.f fVar5;
        if (customResponsedMessage != null) {
            fVar = this.eej.pbData;
            if (fVar != null) {
                this.eej.eef = false;
                fVar2 = this.eej.pbData;
                if (fVar2.aIm() != null) {
                    fVar5 = this.eej.pbData;
                    i = fVar5.aIm().size();
                } else {
                    i = 0;
                }
                if (this.eej.edY >= i - 3) {
                    aVar = this.eej.eeg;
                    if (aVar != null) {
                        fVar4 = this.eej.pbData;
                        if (fVar4.getPage().qE() != 0) {
                            aVar2 = this.eej.eeg;
                            aVar2.aLp();
                        }
                    }
                }
                if (this.eej.edY >= i - 1) {
                    this.eej.edY = -1;
                    this.eej.eec = 5;
                    com.baidu.tbadk.core.data.bc bcVar = new com.baidu.tbadk.core.data.bc();
                    bcVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(r.j.read_thread_over));
                    bcVar.bS(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar));
                    return;
                } else if (this.eej.edY == -1) {
                    this.eej.eec = 5;
                    this.eej.edY = 0;
                    com.baidu.tbadk.core.data.bc bcVar2 = new com.baidu.tbadk.core.data.bc();
                    bcVar2.bS(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar2));
                    return;
                } else {
                    this.eej.edY++;
                    this.eej.eec = 1;
                    eb ebVar = this.eej;
                    int i2 = this.eej.edY;
                    fVar3 = this.eej.pbData;
                    e = ebVar.e(i2, fVar3.aIm());
                    com.baidu.tbadk.core.data.bc bcVar3 = new com.baidu.tbadk.core.data.bc();
                    bcVar3.bS(1);
                    bcVar3.setData(e);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bcVar3));
                    return;
                }
            }
            this.eej.eec = 5;
            this.eej.edY = 0;
        }
    }
}
