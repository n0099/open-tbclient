package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.emotion.message.SuggestEmotionResponseMessage;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends HttpMessageListener {
    final /* synthetic */ SuggestEmotionModel eFp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SuggestEmotionModel suggestEmotionModel, int i) {
        super(i);
        this.eFp = suggestEmotionModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        SuggestEmotionModel.a aVar;
        SuggestEmotionModel.a aVar2;
        SuggestEmotionModel.a aVar3;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003329 && (httpResponsedMessage instanceof SuggestEmotionResponseMessage)) {
            aVar = this.eFp.eFo;
            if (aVar != null) {
                SuggestEmotionResponseMessage suggestEmotionResponseMessage = (SuggestEmotionResponseMessage) httpResponsedMessage;
                if (suggestEmotionResponseMessage.getData() != null) {
                    aVar3 = this.eFp.eFo;
                    aVar3.a(suggestEmotionResponseMessage.getData());
                    return;
                }
                aVar2 = this.eFp.eFo;
                aVar2.onFail(suggestEmotionResponseMessage.getError(), suggestEmotionResponseMessage.getErrorString());
            }
        }
    }
}
