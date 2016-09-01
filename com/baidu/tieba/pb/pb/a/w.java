package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ e elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(e eVar, int i) {
        super(i);
        this.elb = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        y yVar5;
        yVar = this.elb.ekR;
        if (yVar != null) {
            yVar2 = this.elb.ekR;
            if (yVar2.cQp != null) {
                yVar3 = this.elb.ekR;
                if (yVar3.aPh != null) {
                    yVar4 = this.elb.ekR;
                    yVar4.cQp.setVisibility(0);
                    yVar5 = this.elb.ekR;
                    yVar5.aPh.wv();
                    this.elb.d(false, 0);
                }
            }
        }
    }
}
