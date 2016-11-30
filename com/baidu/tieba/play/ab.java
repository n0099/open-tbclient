package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    final /* synthetic */ aa ffP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(aa aaVar, int i) {
        super(i);
        this.ffP = aaVar;
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
            this.ffP.aro();
            z = this.ffP.bWF;
            if (z) {
                z2 = this.ffP.bWF;
                if (z2) {
                    aa aaVar = this.ffP;
                    aqVar = this.ffP.ffM;
                    int bcW = aqVar.bcW();
                    aqVar2 = this.ffP.ffM;
                    int bcX = aqVar2.bcX();
                    aqVar3 = this.ffP.ffM;
                    boolean bcY = aqVar3.bcY();
                    aqVar4 = this.ffP.ffM;
                    aaVar.a(bcW, bcX, bcY, aqVar4.bcZ());
                }
            }
        }
    }
}
