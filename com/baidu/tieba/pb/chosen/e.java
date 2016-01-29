package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbChosenActivity pbChosenActivity, int i) {
        super(i);
        this.cIA = pbChosenActivity;
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
        iVar = this.cIA.cIe;
        iVar.aoy();
        iVar2 = this.cIA.cIe;
        iVar3 = this.cIA.cIe;
        iVar2.cJg = !iVar3.cJg;
        iVar4 = this.cIA.cIe;
        iVar5 = this.cIA.cIe;
        iVar4.fd(iVar5.cJg);
        iVar6 = this.cIA.cIe;
        if (iVar6.cJg) {
            this.cIA.cIq = 1;
        } else {
            this.cIA.cIq = 0;
        }
    }
}
