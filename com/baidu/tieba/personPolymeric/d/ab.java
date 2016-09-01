package com.baidu.tieba.personPolymeric.d;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.g.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    final /* synthetic */ x eJO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(x xVar, int i) {
        super(i);
        this.eJO = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.view.w wVar;
        com.baidu.tieba.view.w wVar2;
        com.baidu.tieba.view.w wVar3;
        if (customResponsedMessage.getCmd() == 2001514 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.g.h)) {
            SparseArray<h.a> sparseArray = ((com.baidu.tieba.g.h) customResponsedMessage.getData()).fcp;
            if (sparseArray.size() > 0) {
                h.a aVar = sparseArray.get(2);
                if (aVar != null && this.eJO.fWm != null && this.eJO.fWm.fWO != null) {
                    this.eJO.fWm.fWO.lA(aVar.fcq);
                }
                wVar = this.eJO.fWl;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    h.a aVar2 = sparseArray.get(5);
                    if (aVar2 != null) {
                        wVar3 = this.eJO.fWl;
                        wVar3.T(5, aVar2.fcq);
                    }
                    h.a aVar3 = sparseArray.get(6);
                    if (aVar3 != null) {
                        wVar2 = this.eJO.fWl;
                        wVar2.T(6, aVar3.fcq);
                    }
                }
            }
        }
    }
}
