package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends CustomMessageListener {
    final /* synthetic */ r dej;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(r rVar, int i) {
        super(i);
        this.dej = rVar;
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
        anVar = this.dej.ddX;
        if (anVar != null) {
            anVar2 = this.dej.ddX;
            if (anVar2.deu != null) {
                anVar3 = this.dej.ddX;
                if (anVar3.deD != null) {
                    anVar4 = this.dej.ddX;
                    if (anVar4.deA != null) {
                        anVar5 = this.dej.ddX;
                        anVar5.deu.setVisibility(0);
                        anVar6 = this.dej.ddX;
                        anVar6.deD.setVisibility(8);
                        anVar7 = this.dej.ddX;
                        anVar7.deA.stopPlayback();
                        this.dej.ddZ = true;
                        r rVar = this.dej;
                        anVar8 = this.dej.ddX;
                        rVar.c(anVar8);
                    }
                }
            }
        }
    }
}
