package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbChosenActivity pbChosenActivity, int i) {
        super(i);
        this.cyo = pbChosenActivity;
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
        iVar = this.cyo.cxR;
        iVar.ajs();
        iVar2 = this.cyo.cxR;
        iVar3 = this.cyo.cxR;
        iVar2.cyV = !iVar3.cyV;
        iVar4 = this.cyo.cxR;
        iVar5 = this.cyo.cxR;
        iVar4.eQ(iVar5.cyV);
        iVar6 = this.cyo.cxR;
        if (iVar6.cyV) {
            this.cyo.cyd = 1;
        } else {
            this.cyo.cyd = 0;
        }
    }
}
