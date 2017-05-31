package com.baidu.tieba.pb.pb.main.emotion.model;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.pb.main.emotion.message.GetEmotionPidResponseMessage;
import com.baidu.tieba.pb.pb.main.emotion.model.GetEmotionPidModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ GetEmotionPidModel evR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GetEmotionPidModel getEmotionPidModel, int i) {
        super(i);
        this.evR = getEmotionPidModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        GetEmotionPidModel.a aVar;
        GetEmotionPidModel.a aVar2;
        GetEmotionPidModel.a aVar3;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003331 && (httpResponsedMessage instanceof GetEmotionPidResponseMessage)) {
            aVar = this.evR.evP;
            if (aVar != null) {
                GetEmotionPidResponseMessage getEmotionPidResponseMessage = (GetEmotionPidResponseMessage) httpResponsedMessage;
                if (!TextUtils.isEmpty(getEmotionPidResponseMessage.getPid())) {
                    aVar3 = this.evR.evP;
                    aVar3.onSuccess(getEmotionPidResponseMessage.getPid());
                    return;
                }
                aVar2 = this.evR.evP;
                aVar2.onFail(getEmotionPidResponseMessage.getError(), getEmotionPidResponseMessage.getErrorString());
            }
        }
    }
}
