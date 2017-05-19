package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ ac eSv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ac acVar, int i) {
        super(i);
        this.eSv = acVar;
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
            this.eSv.ajv();
            z = this.eSv.dsO;
            if (z) {
                z2 = this.eSv.dsO;
                if (z2) {
                    ac acVar = this.eSv;
                    asVar = this.eSv.dsN;
                    int aWE = asVar.aWE();
                    asVar2 = this.eSv.dsN;
                    int aWF = asVar2.aWF();
                    asVar3 = this.eSv.dsN;
                    boolean aWG = asVar3.aWG();
                    asVar4 = this.eSv.dsN;
                    acVar.a(aWE, aWF, aWG, asVar4.aWH());
                }
            }
        }
    }
}
