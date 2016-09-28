package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ e emY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(e eVar, int i) {
        super(i);
        this.emY = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        v vVar5;
        vVar = this.emY.emT;
        if (vVar != null) {
            vVar2 = this.emY.emT;
            if (vVar2.cRg != null) {
                vVar3 = this.emY.emT;
                if (vVar3.aMF != null) {
                    vVar4 = this.emY.emT;
                    vVar4.cRg.setVisibility(0);
                    vVar5 = this.emY.emT;
                    vVar5.aMF.stopPlayback();
                    this.emY.e(false, 0);
                }
            }
        }
    }
}
