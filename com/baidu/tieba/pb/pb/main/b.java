package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class b extends HttpMessageListener {
    final /* synthetic */ GetLotteryChanceActivity dfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GetLotteryChanceActivity getLotteryChanceActivity, int i) {
        super(i);
        this.dfT = getLotteryChanceActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof AddLotteryCountHttpResponseMessage) {
            AddLotteryCountHttpResponseMessage addLotteryCountHttpResponseMessage = (AddLotteryCountHttpResponseMessage) httpResponsedMessage;
            if (addLotteryCountHttpResponseMessage.getError() == 0) {
                this.dfT.lR(addLotteryCountHttpResponseMessage.getEnableGetChance());
            }
        }
    }
}
