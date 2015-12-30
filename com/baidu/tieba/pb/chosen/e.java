package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbChosenActivity pbChosenActivity, int i) {
        super(i);
        this.cBV = pbChosenActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.chosen.a.i iVar;
        com.baidu.tieba.pb.chosen.a.i iVar2;
        com.baidu.tieba.pb.chosen.a.i iVar3;
        com.baidu.tieba.pb.chosen.a.i iVar4;
        com.baidu.tieba.pb.chosen.a.i iVar5;
        com.baidu.tieba.pb.chosen.a.i iVar6;
        iVar = this.cBV.cBy;
        iVar.akA();
        iVar2 = this.cBV.cBy;
        iVar3 = this.cBV.cBy;
        iVar2.cCB = !iVar3.cCB;
        iVar4 = this.cBV.cBy;
        iVar5 = this.cBV.cBy;
        iVar4.eP(iVar5.cCB);
        iVar6 = this.cBV.cBy;
        if (iVar6.cCB) {
            this.cBV.cBK = 1;
        } else {
            this.cBV.cBK = 0;
        }
    }
}
