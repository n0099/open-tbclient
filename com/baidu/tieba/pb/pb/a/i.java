package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ e dML;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar, int i) {
        super(i);
        this.dML = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        boolean aEv;
        boolean aEv2;
        y yVar3;
        y yVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            yVar = this.dML.dMD;
            if (yVar != null) {
                yVar2 = this.dML.dMD;
                if (yVar2.aJJ == null) {
                    return;
                }
                aEv = this.dML.aEv();
                if (!aEv) {
                    yVar4 = this.dML.dMD;
                    if (yVar4.aJJ.isPlaying()) {
                        this.dML.aiQ();
                        return;
                    }
                }
                aEv2 = this.dML.aEv();
                if (aEv2) {
                    yVar3 = this.dML.dMD;
                    if (!yVar3.aJJ.isPlaying()) {
                        this.dML.aEs();
                    }
                }
            }
        }
    }
}
