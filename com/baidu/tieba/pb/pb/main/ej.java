package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ei;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ej extends CustomMessageListener {
    final /* synthetic */ ei ene;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ej(ei eiVar, int i) {
        super(i);
        this.ene = eiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tieba.pb.data.f fVar2;
        int i;
        com.baidu.tieba.pb.data.f fVar3;
        Object b;
        ei.a aVar;
        com.baidu.tieba.pb.data.f fVar4;
        ei.a aVar2;
        com.baidu.tieba.pb.data.f fVar5;
        if (customResponsedMessage != null) {
            fVar = this.ene.pbData;
            if (fVar != null) {
                this.ene.emZ = false;
                fVar2 = this.ene.pbData;
                if (fVar2.aKb() != null) {
                    fVar5 = this.ene.pbData;
                    i = fVar5.aKb().size();
                } else {
                    i = 0;
                }
                if (this.ene.emS >= i - 3) {
                    aVar = this.ene.ena;
                    if (aVar != null) {
                        fVar4 = this.ene.pbData;
                        if (fVar4.getPage().qx() != 0) {
                            aVar2 = this.ene.ena;
                            aVar2.aNd();
                        }
                    }
                }
                if (this.ene.emS >= i - 1) {
                    this.ene.emS = -1;
                    this.ene.emW = 5;
                    com.baidu.tbadk.core.data.bd bdVar = new com.baidu.tbadk.core.data.bd();
                    bdVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(r.l.read_thread_over));
                    bdVar.bR(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bdVar));
                    return;
                } else if (this.ene.emS == -1) {
                    this.ene.emW = 5;
                    this.ene.emS = 0;
                    com.baidu.tbadk.core.data.bd bdVar2 = new com.baidu.tbadk.core.data.bd();
                    bdVar2.bR(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bdVar2));
                    return;
                } else {
                    this.ene.emS++;
                    this.ene.emW = 1;
                    ei eiVar = this.ene;
                    int i2 = this.ene.emS;
                    fVar3 = this.ene.pbData;
                    b = eiVar.b(i2, fVar3.aKb());
                    com.baidu.tbadk.core.data.bd bdVar3 = new com.baidu.tbadk.core.data.bd();
                    bdVar3.bR(1);
                    bdVar3.setData(b);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bdVar3));
                    return;
                }
            }
            this.ene.emW = 5;
            this.ene.emS = 0;
        }
    }
}
