package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ e dML;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(e eVar, int i) {
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
        y yVar5;
        yVar = this.dML.dMD;
        if (yVar != null) {
            yVar2 = this.dML.dMD;
            if (yVar2.cBT != null) {
                yVar3 = this.dML.dMD;
                if (yVar3.aJJ != null) {
                    yVar4 = this.dML.dMD;
                    yVar4.cBT.setVisibility(0);
                    yVar5 = this.dML.dMD;
                    yVar5.aJJ.vr();
                    this.dML.d(false, 0);
                }
            }
        }
    }
}
