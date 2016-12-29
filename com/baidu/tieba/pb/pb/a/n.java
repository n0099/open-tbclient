package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends CustomMessageListener {
    final /* synthetic */ d dXu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(d dVar, int i) {
        super(i);
        this.dXu = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        s sVar5;
        sVar = this.dXu.dXm;
        if (sVar != null) {
            sVar2 = this.dXu.dXm;
            if (sVar2.cBJ != null) {
                sVar3 = this.dXu.dXm;
                if (sVar3.aNV != null) {
                    sVar4 = this.dXu.dXm;
                    sVar4.cBJ.setVisibility(0);
                    sVar5 = this.dXu.dXm;
                    sVar5.aNV.stopPlayback();
                    this.dXu.e(false, 0);
                }
            }
        }
    }
}
