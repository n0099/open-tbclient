package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ e dYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar, int i) {
        super(i);
        this.dYX = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        boolean aHF;
        boolean aHF2;
        y yVar3;
        y yVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            yVar = this.dYX.dYN;
            if (yVar != null) {
                yVar2 = this.dYX.dYN;
                if (yVar2.aKC == null) {
                    return;
                }
                aHF = this.dYX.aHF();
                if (!aHF) {
                    yVar4 = this.dYX.dYN;
                    if (yVar4.aKC.isPlaying()) {
                        this.dYX.ajA();
                        return;
                    }
                }
                aHF2 = this.dYX.aHF();
                if (aHF2) {
                    yVar3 = this.dYX.dYN;
                    if (!yVar3.aKC.isPlaying()) {
                        this.dYX.aHC();
                    }
                }
            }
        }
    }
}
