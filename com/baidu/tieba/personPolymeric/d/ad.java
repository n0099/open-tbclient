package com.baidu.tieba.personPolymeric.d;

import android.util.SparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.g.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ z eJo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(z zVar, int i) {
        super(i);
        this.eJo = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.view.w wVar;
        com.baidu.tieba.view.w wVar2;
        com.baidu.tieba.view.w wVar3;
        if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.g.i)) {
            SparseArray<i.a> sparseArray = ((com.baidu.tieba.g.i) customResponsedMessage.getData()).feb;
            if (sparseArray.size() > 0) {
                i.a aVar = sparseArray.get(2);
                if (aVar != null && this.eJo.fIa != null && this.eJo.fIa.fIC != null) {
                    this.eJo.fIa.fIC.lA(aVar.fec);
                }
                wVar = this.eJo.fHZ;
                if (wVar instanceof com.baidu.tieba.view.j) {
                    i.a aVar2 = sparseArray.get(5);
                    if (aVar2 != null) {
                        wVar3 = this.eJo.fHZ;
                        wVar3.H(5, aVar2.fec);
                    }
                    i.a aVar3 = sparseArray.get(6);
                    if (aVar3 != null) {
                        wVar2 = this.eJo.fHZ;
                        wVar2.H(6, aVar3.fec);
                    }
                }
            }
        }
    }
}
