package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ e emY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(e eVar, int i) {
        super(i);
        this.emY = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        v vVar;
        v vVar2;
        boolean aNc;
        boolean aNc2;
        v vVar3;
        v vVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            vVar = this.emY.emT;
            if (vVar != null) {
                vVar2 = this.emY.emT;
                if (vVar2.aMF == null) {
                    return;
                }
                aNc = this.emY.aNc();
                if (!aNc) {
                    vVar4 = this.emY.emT;
                    if (vVar4.aMF.isPlaying()) {
                        this.emY.aoC();
                        return;
                    }
                }
                aNc2 = this.emY.aNc();
                if (aNc2) {
                    vVar3 = this.emY.emT;
                    if (!vVar3.aMF.isPlaying()) {
                        this.emY.aMZ();
                    }
                }
            }
        }
    }
}
