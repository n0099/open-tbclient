package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.data.PbEcommRecommendMessage;
import com.baidu.tieba.pb.data.PbEcommRecommendResponsedHttpMessage;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class k extends HttpMessageListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbActivity pbActivity, int i) {
        super(i);
        this.ebT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dh dhVar;
        ew ewVar;
        dh dhVar2;
        dh dhVar3;
        if (httpResponsedMessage instanceof PbEcommRecommendResponsedHttpMessage) {
            PbEcommRecommendResponsedHttpMessage pbEcommRecommendResponsedHttpMessage = (PbEcommRecommendResponsedHttpMessage) httpResponsedMessage;
            if (httpResponsedMessage.hasError() || pbEcommRecommendResponsedHttpMessage.mData == null) {
                if (!StringUtils.isNULL(httpResponsedMessage.getErrorString())) {
                    this.ebT.showToast(httpResponsedMessage.getErrorString());
                } else {
                    this.ebT.showToast(u.j.neterror);
                }
            } else if (pbEcommRecommendResponsedHttpMessage.mData != null && (httpResponsedMessage.getOrginalMessage() instanceof PbEcommRecommendMessage)) {
                PbEcommRecommendMessage pbEcommRecommendMessage = (PbEcommRecommendMessage) httpResponsedMessage.getOrginalMessage();
                long j = pbEcommRecommendResponsedHttpMessage.mData.recommendations;
                dhVar = this.ebT.eas;
                dhVar.getPbData().aGY().RO.recommendations = j;
                if (pbEcommRecommendMessage != null) {
                    dhVar3 = this.ebT.eas;
                    dhVar3.getPbData().aGY().rs().hasRecommend = pbEcommRecommendMessage.recommend;
                }
                ewVar = this.ebT.ebb;
                dhVar2 = this.ebT.eas;
                ewVar.j(dhVar2.getPbData());
            }
        }
    }
}
