package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ e elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar, int i) {
        super(i);
        this.elb = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        boolean aMx;
        boolean aMx2;
        y yVar3;
        y yVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            yVar = this.elb.ekR;
            if (yVar != null) {
                yVar2 = this.elb.ekR;
                if (yVar2.aPh == null) {
                    return;
                }
                aMx = this.elb.aMx();
                if (!aMx) {
                    yVar4 = this.elb.ekR;
                    if (yVar4.aPh.isPlaying()) {
                        this.elb.aoo();
                        return;
                    }
                }
                aMx2 = this.elb.aMx();
                if (aMx2) {
                    yVar3 = this.elb.ekR;
                    if (!yVar3.aPh.isPlaying()) {
                        this.elb.aMu();
                    }
                }
            }
        }
    }
}
