package com.baidu.tieba.personPolymeric.d;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.g.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ z eJz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(z zVar, int i) {
        super(i);
        this.eJz = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.view.w wVar;
        com.baidu.tieba.view.w wVar2;
        com.baidu.tieba.view.w wVar3;
        if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.g.i)) {
            SparseArray<i.a> sparseArray = ((com.baidu.tieba.g.i) customResponsedMessage.getData()).fhU;
            if (sparseArray.size() > 0) {
                i.a aVar = sparseArray.get(2);
                if (aVar != null && this.eJz.fMf != null && this.eJz.fMf.fMH != null) {
                    this.eJz.fMf.fMH.lN(aVar.fhV);
                }
                wVar = this.eJz.fMe;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    i.a aVar2 = sparseArray.get(5);
                    if (aVar2 != null) {
                        wVar3 = this.eJz.fMe;
                        wVar3.H(5, aVar2.fhV);
                    }
                    i.a aVar3 = sparseArray.get(6);
                    if (aVar3 != null) {
                        wVar2 = this.eJz.fMe;
                        wVar2.H(6, aVar3.fhV);
                    }
                }
            }
        }
    }
}
