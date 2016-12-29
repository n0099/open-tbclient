package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.er;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ d dXu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(d dVar, int i) {
        super(i);
        this.dXu = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        sVar = this.dXu.dXm;
        if (sVar != null) {
            sVar2 = this.dXu.dXm;
            if (sVar2.aNV != null) {
                int[] iArr = new int[2];
                sVar3 = this.dXu.dXm;
                sVar3.aNV.getLocationInWindow(iArr);
                int i = iArr[1];
                sVar4 = this.dXu.dXm;
                if (i + sVar4.aNV.getHeight() < 0) {
                    this.dXu.akY();
                }
                if (customResponsedMessage.getData() instanceof er.a) {
                    er.a aVar = (er.a) customResponsedMessage.getData();
                    if (aVar.ehf > aVar.ehg) {
                        this.dXu.akY();
                    }
                }
            }
        }
    }
}
