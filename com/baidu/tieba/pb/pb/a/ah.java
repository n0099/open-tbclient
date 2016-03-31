package com.baidu.tieba.pb.pb.a;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends CustomMessageListener {
    final /* synthetic */ r dej;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(r rVar, int i) {
        super(i);
        this.dej = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.pb.data.e eVar3;
        com.baidu.tieba.pb.data.e eVar4;
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.as)) {
            com.baidu.tbadk.core.data.as asVar = (com.baidu.tbadk.core.data.as) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(asVar.getId()) && asVar.getPraise() != null) {
                eVar = this.dej.ddq;
                if (eVar != null) {
                    eVar2 = this.dej.ddq;
                    if (eVar2.avv() != null) {
                        eVar3 = this.dej.ddq;
                        if (!TextUtils.isEmpty(eVar3.avv().getId())) {
                            String id = asVar.getId();
                            eVar4 = this.dej.ddq;
                            if (id.equals(eVar4.avv().getId())) {
                                anVar = this.dej.ddX;
                                if (anVar != null) {
                                    anVar2 = this.dej.ddX;
                                    if (anVar2.deE != null) {
                                        if (asVar.getPraise().getIsLike() == 1) {
                                            anVar4 = this.dej.ddX;
                                            anVar4.deE.setEnabled(false);
                                            return;
                                        }
                                        anVar3 = this.dej.ddX;
                                        anVar3.deE.setEnabled(true);
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
