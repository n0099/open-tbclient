package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.data.PbEcommRecommendMessage;
import com.baidu.tieba.pb.data.PbEcommRecommendResponsedHttpMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class l extends HttpMessageListener {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(PbActivity pbActivity, int i) {
        super(i);
        this.eqa = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dh dhVar;
        ex exVar;
        dh dhVar2;
        dh dhVar3;
        if (httpResponsedMessage instanceof PbEcommRecommendResponsedHttpMessage) {
            PbEcommRecommendResponsedHttpMessage pbEcommRecommendResponsedHttpMessage = (PbEcommRecommendResponsedHttpMessage) httpResponsedMessage;
            if (httpResponsedMessage.hasError() || pbEcommRecommendResponsedHttpMessage.mData == null) {
                if (!StringUtils.isNULL(httpResponsedMessage.getErrorString())) {
                    this.eqa.showToast(httpResponsedMessage.getErrorString());
                } else {
                    this.eqa.showToast(r.j.neterror);
                }
            } else if (pbEcommRecommendResponsedHttpMessage.mData != null && (httpResponsedMessage.getOrginalMessage() instanceof PbEcommRecommendMessage)) {
                PbEcommRecommendMessage pbEcommRecommendMessage = (PbEcommRecommendMessage) httpResponsedMessage.getOrginalMessage();
                long j = pbEcommRecommendResponsedHttpMessage.mData.recommendations;
                dhVar = this.eqa.eov;
                dhVar.getPbData().aMs().UH.recommendations = j;
                if (pbEcommRecommendMessage != null) {
                    dhVar3 = this.eqa.eov;
                    dhVar3.getPbData().aMs().sK().hasRecommend = pbEcommRecommendMessage.recommend;
                }
                exVar = this.eqa.epe;
                dhVar2 = this.eqa.eov;
                exVar.j(dhVar2.getPbData());
            }
        }
    }
}
