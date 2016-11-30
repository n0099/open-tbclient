package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ e esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(e eVar, int i) {
        super(i);
        this.esY = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        t tVar;
        t tVar2;
        boolean aOU;
        boolean aOU2;
        t tVar3;
        t tVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            tVar = this.esY.esQ;
            if (tVar != null) {
                tVar2 = this.esY.esQ;
                if (tVar2.aOE == null) {
                    return;
                }
                aOU = this.esY.aOU();
                if (!aOU) {
                    tVar4 = this.esY.esQ;
                    if (tVar4.aOE.isPlaying()) {
                        this.esY.aqw();
                        return;
                    }
                }
                aOU2 = this.esY.aOU();
                if (aOU2) {
                    tVar3 = this.esY.esQ;
                    if (!tVar3.aOE.isPlaying()) {
                        this.esY.aOS();
                    }
                }
            }
        }
    }
}
