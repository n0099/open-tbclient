package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends CustomMessageListener {
    final /* synthetic */ k eYE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, int i) {
        super(i);
        this.eYE = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        boolean z2;
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            this.eYE.bap();
            z = this.eYE.eYA;
            if (z) {
                z2 = this.eYE.eYA;
                if (z2) {
                    k kVar = this.eYE;
                    xVar = this.eYE.eYz;
                    int bax = xVar.bax();
                    xVar2 = this.eYE.eYz;
                    int bay = xVar2.bay();
                    xVar3 = this.eYE.eYz;
                    boolean baz = xVar3.baz();
                    xVar4 = this.eYE.eYz;
                    kVar.a(bax, bay, baz, xVar4.baA());
                }
            }
        }
    }
}
