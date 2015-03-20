package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
class aj extends HttpMessageListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(SquareSearchActivity squareSearchActivity, int i, boolean z) {
        super(i, z);
        this.bzG = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        this.bzG.bzu = true;
        if (httpResponsedMessage instanceof FrsPageHttpResponseMessage) {
            this.bzG.a(httpResponsedMessage, !((FrsPageHttpResponseMessage) httpResponsedMessage).hasNetworkError());
        }
    }
}
