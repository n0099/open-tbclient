package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.pb.pb.main.ey;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends CustomMessageListener {
    final /* synthetic */ e esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(e eVar, int i) {
        super(i);
        this.esY = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        tVar = this.esY.esQ;
        if (tVar != null) {
            tVar2 = this.esY.esQ;
            if (tVar2.aOE != null) {
                int[] iArr = new int[2];
                tVar3 = this.esY.esQ;
                tVar3.aOE.getLocationInWindow(iArr);
                int i = iArr[1];
                tVar4 = this.esY.esQ;
                if (i + tVar4.aOE.getHeight() < 0) {
                    this.esY.aqw();
                }
                if (customResponsedMessage.getData() instanceof ey.a) {
                    ey.a aVar = (ey.a) customResponsedMessage.getData();
                    if (aVar.eCZ > aVar.eDa) {
                        this.esY.aqw();
                    }
                }
            }
        }
    }
}
