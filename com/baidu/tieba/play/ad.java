package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ ac eWv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ac acVar, int i) {
        super(i);
        this.eWv = acVar;
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
            this.eWv.amG();
            z = this.eWv.dyB;
            if (z) {
                z2 = this.eWv.dyB;
                if (z2) {
                    ac acVar = this.eWv;
                    asVar = this.eWv.dyA;
                    int aZf = asVar.aZf();
                    asVar2 = this.eWv.dyA;
                    int aZg = asVar2.aZg();
                    asVar3 = this.eWv.dyA;
                    boolean aZh = asVar3.aZh();
                    asVar4 = this.eWv.dyA;
                    acVar.a(aZf, aZg, aZh, asVar4.aZi());
                }
            }
        }
    }
}
