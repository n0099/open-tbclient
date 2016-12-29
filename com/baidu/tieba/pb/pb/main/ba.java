package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(PbActivity pbActivity, int i) {
        super(i);
        this.eah = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dc dcVar;
        er erVar;
        er erVar2;
        er erVar3;
        er erVar4;
        dc dcVar2;
        er erVar5;
        dc dcVar3;
        dc dcVar4;
        dc dcVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k)) {
            dcVar = this.eah.dYA;
            dcVar.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
            erVar = this.eah.dZk;
            if (erVar != null) {
                dcVar2 = this.eah.dYA;
                if (dcVar2 != null) {
                    erVar5 = this.eah.dZk;
                    dcVar3 = this.eah.dYA;
                    com.baidu.tieba.pb.data.f pbData = dcVar3.getPbData();
                    dcVar4 = this.eah.dYA;
                    boolean aKl = dcVar4.aKl();
                    dcVar5 = this.eah.dYA;
                    erVar5.d(pbData, aKl, dcVar5.aKB());
                }
            }
            erVar2 = this.eah.dZk;
            if (erVar2 != null) {
                erVar3 = this.eah.dZk;
                if (erVar3.aLQ() != null) {
                    erVar4 = this.eah.dZk;
                    erVar4.aLQ().notifyDataSetChanged();
                }
            }
        }
    }
}
