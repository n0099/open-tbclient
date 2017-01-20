package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ ac eSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ac acVar, int i) {
        super(i);
        this.eSz = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        boolean z2;
        as asVar;
        as asVar2;
        as asVar3;
        as asVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            this.eSz.amY();
            z = this.eSz.dxq;
            if (z) {
                z2 = this.eSz.dxq;
                if (z2) {
                    ac acVar = this.eSz;
                    asVar = this.eSz.dxp;
                    int aYq = asVar.aYq();
                    asVar2 = this.eSz.dxp;
                    int aYr = asVar2.aYr();
                    asVar3 = this.eSz.dxp;
                    boolean aYs = asVar3.aYs();
                    asVar4 = this.eSz.dxp;
                    acVar.a(aYq, aYr, aYs, asVar4.aYt());
                }
            }
        }
    }
}
