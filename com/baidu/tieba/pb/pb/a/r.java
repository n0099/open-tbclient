package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ e emY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(e eVar, int i) {
        super(i);
        this.emY = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        vVar = this.emY.emT;
        if (vVar != null) {
            vVar2 = this.emY.emT;
            if (vVar2.aMF != null) {
                int[] iArr = new int[2];
                vVar3 = this.emY.emT;
                vVar3.aMF.getLocationInWindow(iArr);
                int i = iArr[1];
                vVar4 = this.emY.emT;
                if (i + vVar4.aMF.getHeight() < 0) {
                    this.emY.aoC();
                }
            }
        }
    }
}
