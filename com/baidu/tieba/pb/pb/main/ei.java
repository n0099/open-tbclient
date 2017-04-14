package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eh;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei extends CustomMessageListener {
    final /* synthetic */ eh eom;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei(eh ehVar, int i) {
        super(i);
        this.eom = ehVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tieba.pb.data.f fVar2;
        int i;
        com.baidu.tieba.pb.data.f fVar3;
        Object b;
        eh.a aVar;
        com.baidu.tieba.pb.data.f fVar4;
        eh.a aVar2;
        com.baidu.tieba.pb.data.f fVar5;
        if (customResponsedMessage != null) {
            fVar = this.eom.pbData;
            if (fVar != null) {
                this.eom.eoi = false;
                fVar2 = this.eom.pbData;
                if (fVar2.aJz() != null) {
                    fVar5 = this.eom.pbData;
                    i = fVar5.aJz().size();
                } else {
                    i = 0;
                }
                if (this.eom.eoa >= i - 3) {
                    aVar = this.eom.eoj;
                    if (aVar != null) {
                        fVar4 = this.eom.pbData;
                        if (fVar4.rr().rn() != 0) {
                            aVar2 = this.eom.eoj;
                            aVar2.aMF();
                        }
                    }
                }
                if (this.eom.eoa >= i - 1) {
                    this.eom.eoa = -1;
                    this.eom.eoe = 5;
                    com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
                    beVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(w.l.read_thread_over));
                    beVar.bP(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar));
                    return;
                } else if (this.eom.eoa == -1) {
                    this.eom.eoe = 5;
                    this.eom.eoa = 0;
                    com.baidu.tbadk.core.data.be beVar2 = new com.baidu.tbadk.core.data.be();
                    beVar2.bP(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar2));
                    return;
                } else {
                    this.eom.eoa++;
                    this.eom.eoe = 1;
                    eh ehVar = this.eom;
                    int i2 = this.eom.eoa;
                    fVar3 = this.eom.pbData;
                    b = ehVar.b(i2, fVar3.aJz());
                    com.baidu.tbadk.core.data.be beVar3 = new com.baidu.tbadk.core.data.be();
                    beVar3.bP(1);
                    beVar3.setData(b);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar3));
                    return;
                }
            }
            this.eom.eoe = 5;
            this.eom.eoa = 0;
        }
    }
}
