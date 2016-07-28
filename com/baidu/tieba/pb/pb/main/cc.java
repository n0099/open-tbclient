package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class cc extends CustomMessageListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc(PbActivity pbActivity, int i) {
        super(i);
        this.ebT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ew ewVar;
        ew ewVar2;
        ew ewVar3;
        ewVar = this.ebT.ebb;
        if (ewVar != null) {
            ewVar2 = this.ebT.ebb;
            if (ewVar2.aKs() != null) {
                ewVar3 = this.ebT.ebb;
                ewVar3.aKs().notifyDataSetChanged();
            }
        }
    }
}
