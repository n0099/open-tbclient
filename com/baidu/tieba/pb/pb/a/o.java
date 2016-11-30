package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ e esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(e eVar, int i) {
        super(i);
        this.esY = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        t tVar5;
        tVar = this.esY.esQ;
        if (tVar != null) {
            tVar2 = this.esY.esQ;
            if (tVar2.cWB != null) {
                tVar3 = this.esY.esQ;
                if (tVar3.aOE != null) {
                    tVar4 = this.esY.esQ;
                    tVar4.cWB.setVisibility(0);
                    tVar5 = this.esY.esQ;
                    tVar5.aOE.stopPlayback();
                    this.esY.e(false, 0);
                }
            }
        }
    }
}
