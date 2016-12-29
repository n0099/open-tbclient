package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ d dXu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(d dVar, int i) {
        super(i);
        this.dXu = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        s sVar;
        s sVar2;
        boolean aIT;
        boolean aIT2;
        s sVar3;
        s sVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            sVar = this.dXu.dXm;
            if (sVar != null) {
                sVar2 = this.dXu.dXm;
                if (sVar2.aNV == null) {
                    return;
                }
                aIT = this.dXu.aIT();
                if (!aIT) {
                    sVar4 = this.dXu.dXm;
                    if (sVar4.aNV.isPlaying()) {
                        this.dXu.akY();
                        return;
                    }
                }
                aIT2 = this.dXu.aIT();
                if (aIT2) {
                    sVar3 = this.dXu.dXm;
                    if (!sVar3.aNV.isPlaying()) {
                        this.dXu.aIR();
                    }
                }
            }
        }
    }
}
