package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleSetResponseMessage;
import com.baidu.tieba.themeCenter.bubble.list.e;
import com.baidu.tieba.themeCenter.dressCenter.k;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ e dFQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.dFQ = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        e.a aVar;
        k kVar;
        List<DressItemData> list;
        BubbleListActivity bubbleListActivity;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003056) {
            BubbleSetResponseMessage bubbleSetResponseMessage = (BubbleSetResponseMessage) httpResponsedMessage;
            if (bubbleSetResponseMessage.getError() != 0) {
                bubbleListActivity = this.dFQ.dFM;
                bubbleListActivity.showToast(bubbleSetResponseMessage.getErrorString());
                return;
            }
            this.dFQ.mW(((Integer) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra()).intValue());
            aVar = this.dFQ.dFP;
            int error = httpResponsedMessage.getError();
            String errorString = httpResponsedMessage.getErrorString();
            kVar = this.dFQ.mRecommand;
            list = this.dFQ.dFO;
            aVar.a(error, errorString, kVar, list);
        }
    }
}
