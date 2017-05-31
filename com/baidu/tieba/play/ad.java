package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ ac fbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ac acVar, int i) {
        super(i);
        this.fbg = acVar;
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
            this.fbg.akv();
            z = this.fbg.dyg;
            if (z) {
                z2 = this.fbg.dyg;
                if (z2) {
                    ac acVar = this.fbg;
                    atVar = this.fbg.dyf;
                    int aXV = atVar.aXV();
                    atVar2 = this.fbg.dyf;
                    int aXW = atVar2.aXW();
                    atVar3 = this.fbg.dyf;
                    boolean aXX = atVar3.aXX();
                    atVar4 = this.fbg.dyf;
                    acVar.a(aXV, aXW, aXX, atVar4.aXY());
                }
            }
        }
    }
}
