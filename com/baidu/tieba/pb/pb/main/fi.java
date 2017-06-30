package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.fh;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fi extends CustomMessageListener {
    final /* synthetic */ fh eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi(fh fhVar, int i) {
        super(i);
        this.eAW = fhVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tieba.pb.data.f fVar2;
        int i;
        com.baidu.tieba.pb.data.f fVar3;
        Object b;
        fh.a aVar;
        com.baidu.tieba.pb.data.f fVar4;
        fh.a aVar2;
        com.baidu.tieba.pb.data.f fVar5;
        if (customResponsedMessage != null) {
            fVar = this.eAW.pbData;
            if (fVar != null) {
                this.eAW.eAS = false;
                fVar2 = this.eAW.pbData;
                if (fVar2.aMx() != null) {
                    fVar5 = this.eAW.pbData;
                    i = fVar5.aMx().size();
                } else {
                    i = 0;
                }
                if (this.eAW.eAL >= i - 3) {
                    aVar = this.eAW.eAT;
                    if (aVar != null) {
                        fVar4 = this.eAW.pbData;
                        if (fVar4.qu().qq() != 0) {
                            aVar2 = this.eAW.eAT;
                            aVar2.aPQ();
                        }
                    }
                }
                if (this.eAW.eAL >= i - 1) {
                    this.eAW.eAL = -1;
                    this.eAW.eAP = 5;
                    com.baidu.tbadk.core.data.bi biVar = new com.baidu.tbadk.core.data.bi();
                    biVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(w.l.read_thread_over));
                    biVar.bN(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, biVar));
                    return;
                } else if (this.eAW.eAL == -1) {
                    this.eAW.eAP = 5;
                    this.eAW.eAL = 0;
                    com.baidu.tbadk.core.data.bi biVar2 = new com.baidu.tbadk.core.data.bi();
                    biVar2.bN(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, biVar2));
                    return;
                } else {
                    this.eAW.eAL++;
                    this.eAW.eAP = 1;
                    fh fhVar = this.eAW;
                    int i2 = this.eAW.eAL;
                    fVar3 = this.eAW.pbData;
                    b = fhVar.b(i2, fVar3.aMx());
                    com.baidu.tbadk.core.data.bi biVar3 = new com.baidu.tbadk.core.data.bi();
                    biVar3.bN(1);
                    biVar3.setData(b);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, biVar3));
                    return;
                }
            }
            this.eAW.eAP = 5;
            this.eAW.eAL = 0;
        }
    }
}
