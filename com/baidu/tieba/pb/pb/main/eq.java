package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ep;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eq extends CustomMessageListener {
    final /* synthetic */ ep elY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eq(ep epVar, int i) {
        super(i);
        this.elY = epVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tieba.pb.data.f fVar2;
        int i;
        com.baidu.tieba.pb.data.f fVar3;
        Object b;
        ep.a aVar;
        com.baidu.tieba.pb.data.f fVar4;
        ep.a aVar2;
        com.baidu.tieba.pb.data.f fVar5;
        if (customResponsedMessage != null) {
            fVar = this.elY.pbData;
            if (fVar != null) {
                this.elY.elU = false;
                fVar2 = this.elY.pbData;
                if (fVar2.aHI() != null) {
                    fVar5 = this.elY.pbData;
                    i = fVar5.aHI().size();
                } else {
                    i = 0;
                }
                if (this.elY.elN >= i - 3) {
                    aVar = this.elY.elV;
                    if (aVar != null) {
                        fVar4 = this.elY.pbData;
                        if (fVar4.qB().qx() != 0) {
                            aVar2 = this.elY.elV;
                            aVar2.aKW();
                        }
                    }
                }
                if (this.elY.elN >= i - 1) {
                    this.elY.elN = -1;
                    this.elY.elR = 5;
                    com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
                    bgVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(w.l.read_thread_over));
                    bgVar.bM(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar));
                    return;
                } else if (this.elY.elN == -1) {
                    this.elY.elR = 5;
                    this.elY.elN = 0;
                    com.baidu.tbadk.core.data.bg bgVar2 = new com.baidu.tbadk.core.data.bg();
                    bgVar2.bM(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar2));
                    return;
                } else {
                    this.elY.elN++;
                    this.elY.elR = 1;
                    ep epVar = this.elY;
                    int i2 = this.elY.elN;
                    fVar3 = this.elY.pbData;
                    b = epVar.b(i2, fVar3.aHI());
                    com.baidu.tbadk.core.data.bg bgVar3 = new com.baidu.tbadk.core.data.bg();
                    bgVar3.bM(1);
                    bgVar3.setData(b);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar3));
                    return;
                }
            }
            this.elY.elR = 5;
            this.elY.elN = 0;
        }
    }
}
