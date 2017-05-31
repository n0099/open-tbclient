package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ey;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ez extends CustomMessageListener {
    final /* synthetic */ ey erL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ez(ey eyVar, int i) {
        super(i);
        this.erL = eyVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tieba.pb.data.f fVar2;
        int i;
        com.baidu.tieba.pb.data.f fVar3;
        Object b;
        ey.a aVar;
        com.baidu.tieba.pb.data.f fVar4;
        ey.a aVar2;
        com.baidu.tieba.pb.data.f fVar5;
        if (customResponsedMessage != null) {
            fVar = this.erL.pbData;
            if (fVar != null) {
                this.erL.erH = false;
                fVar2 = this.erL.pbData;
                if (fVar2.aID() != null) {
                    fVar5 = this.erL.pbData;
                    i = fVar5.aID().size();
                } else {
                    i = 0;
                }
                if (this.erL.erA >= i - 3) {
                    aVar = this.erL.erI;
                    if (aVar != null) {
                        fVar4 = this.erL.pbData;
                        if (fVar4.qx().qt() != 0) {
                            aVar2 = this.erL.erI;
                            aVar2.aLS();
                        }
                    }
                }
                if (this.erL.erA >= i - 1) {
                    this.erL.erA = -1;
                    this.erL.erE = 5;
                    com.baidu.tbadk.core.data.bh bhVar = new com.baidu.tbadk.core.data.bh();
                    bhVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(w.l.read_thread_over));
                    bhVar.bN(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar));
                    return;
                } else if (this.erL.erA == -1) {
                    this.erL.erE = 5;
                    this.erL.erA = 0;
                    com.baidu.tbadk.core.data.bh bhVar2 = new com.baidu.tbadk.core.data.bh();
                    bhVar2.bN(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar2));
                    return;
                } else {
                    this.erL.erA++;
                    this.erL.erE = 1;
                    ey eyVar = this.erL;
                    int i2 = this.erL.erA;
                    fVar3 = this.erL.pbData;
                    b = eyVar.b(i2, fVar3.aID());
                    com.baidu.tbadk.core.data.bh bhVar3 = new com.baidu.tbadk.core.data.bh();
                    bhVar3.bN(1);
                    bhVar3.setData(b);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bhVar3));
                    return;
                }
            }
            this.erL.erE = 5;
            this.erL.erA = 0;
        }
    }
}
