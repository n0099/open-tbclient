package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ j est;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, int i) {
        super(i);
        this.est = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.widget.richText.e)) {
            com.baidu.tbadk.widget.richText.e eVar = (com.baidu.tbadk.widget.richText.e) customResponsedMessage.getData();
            this.est.c(eVar);
            this.est.d(eVar);
        }
    }
}
