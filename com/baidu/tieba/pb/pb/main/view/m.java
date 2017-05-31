package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ l exy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, int i) {
        super(i);
        this.exy = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.widget.richText.e)) {
            com.baidu.tbadk.widget.richText.e eVar = (com.baidu.tbadk.widget.richText.e) customResponsedMessage.getData();
            this.exy.c(eVar);
            this.exy.d(eVar);
        }
    }
}
