package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ AtMessageActivity dku;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(AtMessageActivity atMessageActivity, int i) {
        super(i);
        this.dku = atMessageActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AtMeModelController atMeModelController;
        AtMeModelController atMeModelController2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
            Intent intent = (Intent) customResponsedMessage.getData();
            atMeModelController = this.dku.dkr;
            if (atMeModelController != null) {
                atMeModelController2 = this.dku.dkr;
                atMeModelController2.Uo();
            }
        }
    }
}
