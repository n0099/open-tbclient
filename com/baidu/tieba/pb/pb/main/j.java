package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        gg ggVar;
        gg ggVar2;
        gg ggVar3;
        ggVar = this.ewh.euU;
        if (ggVar != null) {
            ggVar2 = this.ewh.euU;
            if (ggVar2.aQs() != null) {
                ggVar3 = this.ewh.euU;
                ggVar3.aQs().notifyDataSetChanged();
            }
        }
    }
}
