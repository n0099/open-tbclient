package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends CustomMessageListener {
    final /* synthetic */ r dgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(r rVar, int i) {
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
        anVar = this.dgC.dgr;
        if (anVar != null) {
            anVar2 = this.dgC.dgr;
            if (anVar2.dgT != null) {
                int[] iArr = new int[2];
                anVar3 = this.dgC.dgr;
                anVar3.dgT.getLocationInWindow(iArr);
                int i = iArr[1];
                anVar4 = this.dgC.dgr;
                if (i + anVar4.dgT.getHeight() < 0) {
                    this.dgC.awh();
                }
            }
        }
    }
}
