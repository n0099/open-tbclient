package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ ac flw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ac acVar, int i) {
        super(i);
        this.flw = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        boolean z2;
        at atVar;
        at atVar2;
        at atVar3;
        at atVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            this.flw.aog();
            z = this.flw.dGT;
            if (z) {
                z2 = this.flw.dGT;
                if (z2) {
                    ac acVar = this.flw;
                    atVar = this.flw.dGS;
                    int bcg = atVar.bcg();
                    atVar2 = this.flw.dGS;
                    int bch = atVar2.bch();
                    atVar3 = this.flw.dGS;
                    boolean bci = atVar3.bci();
                    atVar4 = this.flw.dGS;
                    acVar.a(bcg, bch, bci, atVar4.bcj());
                }
            }
        }
    }
}
