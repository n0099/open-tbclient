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
    final /* synthetic */ eh eqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei(eh ehVar, int i) {
        super(i);
        this.eqD = ehVar;
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
            fVar = this.eqD.pbData;
            if (fVar != null) {
                this.eqD.eqz = false;
                fVar2 = this.eqD.pbData;
                if (fVar2.aKA() != null) {
                    fVar5 = this.eqD.pbData;
                    i = fVar5.aKA().size();
                } else {
                    i = 0;
                }
                if (this.eqD.eqs >= i - 3) {
                    aVar = this.eqD.eqA;
                    if (aVar != null) {
                        fVar4 = this.eqD.pbData;
                        if (fVar4.rr().rn() != 0) {
                            aVar2 = this.eqD.eqA;
                            aVar2.aNG();
                        }
                    }
                }
                if (this.eqD.eqs >= i - 1) {
                    this.eqD.eqs = -1;
                    this.eqD.eqw = 5;
                    com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
                    beVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(w.l.read_thread_over));
                    beVar.bP(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar));
                    return;
                } else if (this.eqD.eqs == -1) {
                    this.eqD.eqw = 5;
                    this.eqD.eqs = 0;
                    com.baidu.tbadk.core.data.be beVar2 = new com.baidu.tbadk.core.data.be();
                    beVar2.bP(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar2));
                    return;
                } else {
                    this.eqD.eqs++;
                    this.eqD.eqw = 1;
                    eh ehVar = this.eqD;
                    int i2 = this.eqD.eqs;
                    fVar3 = this.eqD.pbData;
                    b = ehVar.b(i2, fVar3.aKA());
                    com.baidu.tbadk.core.data.be beVar3 = new com.baidu.tbadk.core.data.be();
                    beVar3.bP(1);
                    beVar3.setData(b);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, beVar3));
                    return;
                }
            }
            this.eqD.eqw = 5;
            this.eqD.eqs = 0;
        }
    }
}
