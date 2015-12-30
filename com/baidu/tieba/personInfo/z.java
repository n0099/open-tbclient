package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends CustomMessageListener {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(d dVar, int i) {
        super(i);
        this.cWV = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        bb bbVar;
        bb bbVar2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            z = this.cWV.cBJ;
            if (z) {
                if (intValue == 0) {
                    bbVar2 = this.cWV.cRx;
                    if (bbVar2.cXE) {
                        this.cWV.aqf();
                        return;
                    }
                }
                bbVar = this.cWV.cRx;
                if (bbVar.cXE) {
                    return;
                }
                this.cWV.aqf();
            }
        }
    }
}
