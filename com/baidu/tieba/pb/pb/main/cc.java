package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class cc extends CustomMessageListener {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc(PbActivity pbActivity, int i) {
        super(i);
        this.dPF = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        es esVar;
        es esVar2;
        es esVar3;
        esVar = this.dPF.dOO;
        if (esVar != null) {
            esVar2 = this.dPF.dOO;
            if (esVar2.aHh() != null) {
                esVar3 = this.dPF.dOO;
                esVar3.aHh().notifyDataSetChanged();
            }
        }
    }
}
