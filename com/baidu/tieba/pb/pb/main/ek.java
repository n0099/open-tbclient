package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ej;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ek extends CustomMessageListener {
    final /* synthetic */ ej eqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ek(ej ejVar, int i) {
        super(i);
        this.eqd = ejVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tieba.pb.data.f fVar2;
        int i;
        com.baidu.tieba.pb.data.f fVar3;
        Object b;
        ej.a aVar;
        com.baidu.tieba.pb.data.f fVar4;
        ej.a aVar2;
        com.baidu.tieba.pb.data.f fVar5;
        if (customResponsedMessage != null) {
            fVar = this.eqd.pbData;
            if (fVar != null) {
                this.eqd.epZ = false;
                fVar2 = this.eqd.pbData;
                if (fVar2.aJs() != null) {
                    fVar5 = this.eqd.pbData;
                    i = fVar5.aJs().size();
                } else {
                    i = 0;
                }
                if (this.eqd.epS >= i - 3) {
                    aVar = this.eqd.eqa;
                    if (aVar != null) {
                        fVar4 = this.eqd.pbData;
                        if (fVar4.getPage().qQ() != 0) {
                            aVar2 = this.eqd.eqa;
                            aVar2.aMw();
                        }
                    }
                }
                if (this.eqd.epS >= i - 1) {
                    this.eqd.epS = -1;
                    this.eqd.epW = 5;
                    com.baidu.tbadk.core.data.bf bfVar = new com.baidu.tbadk.core.data.bf();
                    bfVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(w.l.read_thread_over));
                    bfVar.bM(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bfVar));
                    return;
                } else if (this.eqd.epS == -1) {
                    this.eqd.epW = 5;
                    this.eqd.epS = 0;
                    com.baidu.tbadk.core.data.bf bfVar2 = new com.baidu.tbadk.core.data.bf();
                    bfVar2.bM(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bfVar2));
                    return;
                } else {
                    this.eqd.epS++;
                    this.eqd.epW = 1;
                    ej ejVar = this.eqd;
                    int i2 = this.eqd.epS;
                    fVar3 = this.eqd.pbData;
                    b = ejVar.b(i2, fVar3.aJs());
                    com.baidu.tbadk.core.data.bf bfVar3 = new com.baidu.tbadk.core.data.bf();
                    bfVar3.bM(1);
                    bfVar3.setData(b);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bfVar3));
                    return;
                }
            }
            this.eqd.epW = 5;
            this.eqd.epS = 0;
        }
    }
}
