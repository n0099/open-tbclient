package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ e dML;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(e eVar, int i) {
        super(i);
        this.dML = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        yVar = this.dML.dMD;
        if (yVar != null) {
            yVar2 = this.dML.dMD;
            if (yVar2.aJJ != null) {
                int[] iArr = new int[2];
                yVar3 = this.dML.dMD;
                yVar3.aJJ.getLocationInWindow(iArr);
                int i = iArr[1];
                yVar4 = this.dML.dMD;
                if (i + yVar4.aJJ.getHeight() < 0) {
                    this.dML.aiQ();
                }
            }
        }
    }
}
