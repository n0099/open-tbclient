package com.baidu.tieba.pb.pb.a;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends CustomMessageListener {
    final /* synthetic */ r dgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(r rVar, int i) {
        super(i);
        this.dgC = rVar;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ax)) {
            ax axVar = (ax) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(axVar.getId()) && axVar.getPraise() != null) {
                eVar = this.dgC.dfK;
                if (eVar != null) {
                    eVar2 = this.dgC.dfK;
                    if (eVar2.avB() != null) {
                        eVar3 = this.dgC.dfK;
                        if (!TextUtils.isEmpty(eVar3.avB().getId())) {
                            String id = axVar.getId();
                            eVar4 = this.dgC.dfK;
                            if (id.equals(eVar4.avB().getId())) {
                                anVar = this.dgC.dgr;
                                if (anVar != null) {
                                    anVar2 = this.dgC.dgr;
                                    if (anVar2.dgX != null) {
                                        if (axVar.getPraise().getIsLike() == 1) {
                                            anVar4 = this.dgC.dgr;
                                            anVar4.dgX.setEnabled(false);
                                            return;
                                        }
                                        anVar3 = this.dgC.dgr;
                                        anVar3.dgX.setEnabled(true);
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
