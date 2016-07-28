package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ e dYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(e eVar, int i) {
        super(i);
        this.dYX = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        y yVar5;
        yVar = this.dYX.dYN;
        if (yVar != null) {
            yVar2 = this.dYX.dYN;
            if (yVar2.cEI != null) {
                yVar3 = this.dYX.dYN;
                if (yVar3.aKC != null) {
                    yVar4 = this.dYX.dYN;
                    yVar4.cEI.setVisibility(0);
                    yVar5 = this.dYX.dYN;
                    yVar5.aKC.vr();
                    this.dYX.e(false, 0);
                }
            }
        }
    }
}
