package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class cf extends CustomMessageListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf(PbActivity pbActivity, int i) {
        super(i);
        this.eah = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        er erVar;
        er erVar2;
        er erVar3;
        erVar = this.eah.dZk;
        if (erVar != null) {
            erVar2 = this.eah.dZk;
            if (erVar2.aLQ() != null) {
                erVar3 = this.eah.dZk;
                erVar3.aLQ().notifyDataSetChanged();
            }
        }
    }
}
