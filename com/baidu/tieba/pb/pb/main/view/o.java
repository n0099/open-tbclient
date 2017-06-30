package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ n eGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(n nVar, int i) {
        super(i);
        this.eGW = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.widget.richText.e)) {
            com.baidu.tbadk.widget.richText.e eVar = (com.baidu.tbadk.widget.richText.e) customResponsedMessage.getData();
            this.eGW.c(eVar);
            this.eGW.d(eVar);
        }
    }
}
