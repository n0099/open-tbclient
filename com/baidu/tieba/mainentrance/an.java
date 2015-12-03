package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
class an extends HttpMessageListener {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(SquareSearchActivity squareSearchActivity, int i, boolean z) {
        super(i, z);
        this.cmr = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        this.cmr.arX = true;
        if (httpResponsedMessage instanceof FrsPageHttpResponseMessage) {
            this.cmr.a(httpResponsedMessage, !((FrsPageHttpResponseMessage) httpResponsedMessage).hasNetworkError());
        }
    }
}
