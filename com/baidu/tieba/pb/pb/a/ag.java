package com.baidu.tieba.pb.pb.a;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ q cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(q qVar, int i) {
        super(i);
        this.cKS = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        com.baidu.tieba.pb.a.c cVar4;
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ah)) {
            com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(ahVar.getId()) && ahVar.getPraise() != null) {
                cVar = this.cKS.cJZ;
                if (cVar != null) {
                    cVar2 = this.cKS.cJZ;
                    if (cVar2.aoF() != null) {
                        cVar3 = this.cKS.cJZ;
                        if (!TextUtils.isEmpty(cVar3.aoF().getId())) {
                            String id = ahVar.getId();
                            cVar4 = this.cKS.cJZ;
                            if (id.equals(cVar4.aoF().getId())) {
                                amVar = this.cKS.cKF;
                                if (amVar != null) {
                                    amVar2 = this.cKS.cKF;
                                    if (amVar2.cLo != null) {
                                        if (ahVar.getPraise().getIsLike() == 1) {
                                            amVar4 = this.cKS.cKF;
                                            amVar4.cLo.setEnabled(false);
                                            return;
                                        }
                                        amVar3 = this.cKS.cKF;
                                        amVar3.cLo.setEnabled(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
