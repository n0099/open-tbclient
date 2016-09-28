package com.baidu.tieba.personPolymeric.d;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.f.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    final /* synthetic */ x eLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(x xVar, int i) {
        super(i);
        this.eLR = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.view.w wVar;
        com.baidu.tieba.view.w wVar2;
        com.baidu.tieba.view.w wVar3;
        if (customResponsedMessage.getCmd() == 2001514 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.f.h)) {
            SparseArray<h.a> sparseArray = ((com.baidu.tieba.f.h) customResponsedMessage.getData()).feY;
            if (sparseArray.size() > 0) {
                h.a aVar = sparseArray.get(2);
                if (aVar != null && this.eLR.fYr != null && this.eLR.fYr.fYT != null) {
                    this.eLR.fYr.fYT.lC(aVar.aPh);
                }
                wVar = this.eLR.fYq;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    h.a aVar2 = sparseArray.get(5);
                    if (aVar2 != null) {
                        wVar3 = this.eLR.fYq;
                        wVar3.T(5, aVar2.aPh);
                    }
                    h.a aVar3 = sparseArray.get(6);
                    if (aVar3 != null) {
                        wVar2 = this.eLR.fYq;
                        wVar2.T(6, aVar3.aPh);
                    }
                }
            }
        }
    }
}
