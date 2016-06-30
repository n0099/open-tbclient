package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.data.PbEcommRecommendMessage;
import com.baidu.tieba.pb.data.PbEcommRecommendResponsedHttpMessage;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class k extends HttpMessageListener {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbActivity pbActivity, int i) {
        super(i);
        this.dPF = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dg dgVar;
        es esVar;
        dg dgVar2;
        dg dgVar3;
        if (httpResponsedMessage instanceof PbEcommRecommendResponsedHttpMessage) {
            PbEcommRecommendResponsedHttpMessage pbEcommRecommendResponsedHttpMessage = (PbEcommRecommendResponsedHttpMessage) httpResponsedMessage;
            if (httpResponsedMessage.hasError() || pbEcommRecommendResponsedHttpMessage.mData == null) {
                if (!StringUtils.isNULL(httpResponsedMessage.getErrorString())) {
                    this.dPF.showToast(httpResponsedMessage.getErrorString());
                } else {
                    this.dPF.showToast(u.j.neterror);
                }
            } else if (pbEcommRecommendResponsedHttpMessage.mData != null && (httpResponsedMessage.getOrginalMessage() instanceof PbEcommRecommendMessage)) {
                PbEcommRecommendMessage pbEcommRecommendMessage = (PbEcommRecommendMessage) httpResponsedMessage.getOrginalMessage();
                long j = pbEcommRecommendResponsedHttpMessage.mData.recommendations;
                dgVar = this.dPF.dOf;
                dgVar.getPbData().aDO().Rl.recommendations = j;
                if (pbEcommRecommendMessage != null) {
                    dgVar3 = this.dPF.dOf;
                    dgVar3.getPbData().aDO().rt().hasRecommend = pbEcommRecommendMessage.recommend;
                }
                esVar = this.dPF.dOO;
                dgVar2 = this.dPF.dOf;
                esVar.j(dgVar2.getPbData());
            }
        }
    }
}
