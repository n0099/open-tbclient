package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ ac eUf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ac acVar, int i) {
        super(i);
        this.eUf = acVar;
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
            this.eUf.alF();
            z = this.eUf.dwl;
            if (z) {
                z2 = this.eUf.dwl;
                if (z2) {
                    ac acVar = this.eUf;
                    asVar = this.eUf.dwk;
                    int aYe = asVar.aYe();
                    asVar2 = this.eUf.dwk;
                    int aYf = asVar2.aYf();
                    asVar3 = this.eUf.dwk;
                    boolean aYg = asVar3.aYg();
                    asVar4 = this.eUf.dwk;
                    acVar.a(aYe, aYf, aYg, asVar4.aYh());
                }
            }
        }
    }
}
