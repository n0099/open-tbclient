package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    final /* synthetic */ aa eJh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(aa aaVar, int i) {
        super(i);
        this.eJh = aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        boolean z2;
        aq aqVar;
        aq aqVar2;
        aq aqVar3;
        aq aqVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            this.eJh.alQ();
            z = this.eJh.bCP;
            if (z) {
                z2 = this.eJh.bCP;
                if (z2) {
                    aa aaVar = this.eJh;
                    aqVar = this.eJh.eJe;
                    int aWD = aqVar.aWD();
                    aqVar2 = this.eJh.eJe;
                    int aWE = aqVar2.aWE();
                    aqVar3 = this.eJh.eJe;
                    boolean aWF = aqVar3.aWF();
                    aqVar4 = this.eJh.eJe;
                    aaVar.a(aWD, aWE, aWF, aqVar4.aWG());
                }
            }
        }
    }
}
