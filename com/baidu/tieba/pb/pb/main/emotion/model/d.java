package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.emotion.message.SearchEmotionResponseMessage;
import com.baidu.tieba.pb.pb.main.emotion.model.SearchEmotionModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends HttpMessageListener {
    final /* synthetic */ SearchEmotionModel eFn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SearchEmotionModel searchEmotionModel, int i) {
        super(i);
        this.eFn = searchEmotionModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        SearchEmotionModel.a aVar;
        SearchEmotionModel.a aVar2;
        SearchEmotionModel.a aVar3;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003330 && (httpResponsedMessage instanceof SearchEmotionResponseMessage)) {
            aVar = this.eFn.eES;
            if (aVar != null) {
                SearchEmotionResponseMessage searchEmotionResponseMessage = (SearchEmotionResponseMessage) httpResponsedMessage;
                if (searchEmotionResponseMessage.getData() != null) {
                    aVar3 = this.eFn.eES;
                    aVar3.a(searchEmotionResponseMessage.getData());
                    return;
                }
                aVar2 = this.eFn.eES;
                aVar2.onFail(searchEmotionResponseMessage.getError(), searchEmotionResponseMessage.getErrorString());
            }
        }
    }
}
