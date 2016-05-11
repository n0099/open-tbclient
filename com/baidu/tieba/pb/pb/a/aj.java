package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends CustomMessageListener {
    final /* synthetic */ r dgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(r rVar, int i) {
        super(i);
        this.dgC = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        an anVar5;
        an anVar6;
        an anVar7;
        an anVar8;
        anVar = this.dgC.dgr;
        if (anVar != null) {
            anVar2 = this.dgC.dgr;
            if (anVar2.dgN != null) {
                anVar3 = this.dgC.dgr;
                if (anVar3.dgW != null) {
                    anVar4 = this.dgC.dgr;
                    if (anVar4.dgT != null) {
                        anVar5 = this.dgC.dgr;
                        anVar5.dgN.setVisibility(0);
                        anVar6 = this.dgC.dgr;
                        anVar6.dgW.setVisibility(8);
                        anVar7 = this.dgC.dgr;
                        anVar7.dgT.stopPlayback();
                        this.dgC.dgt = true;
                        r rVar = this.dgC;
                        anVar8 = this.dgC.dgr;
                        rVar.c(anVar8);
                    }
                }
            }
        }
    }
}
