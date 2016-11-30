package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.data.PbEcommRecommendMessage;
import com.baidu.tieba.pb.data.PbEcommRecommendResponsedHttpMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class l extends HttpMessageListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(PbActivity pbActivity, int i) {
        super(i);
        this.evL = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        dj djVar;
        ey eyVar;
        dj djVar2;
        dj djVar3;
        if (httpResponsedMessage instanceof PbEcommRecommendResponsedHttpMessage) {
            PbEcommRecommendResponsedHttpMessage pbEcommRecommendResponsedHttpMessage = (PbEcommRecommendResponsedHttpMessage) httpResponsedMessage;
            if (httpResponsedMessage.hasError() || pbEcommRecommendResponsedHttpMessage.mData == null) {
                if (!StringUtils.isNULL(httpResponsedMessage.getErrorString())) {
                    this.evL.showToast(httpResponsedMessage.getErrorString());
                } else {
                    this.evL.showToast(r.j.neterror);
                }
            } else if (pbEcommRecommendResponsedHttpMessage.mData != null && (httpResponsedMessage.getOrginalMessage() instanceof PbEcommRecommendMessage)) {
                PbEcommRecommendMessage pbEcommRecommendMessage = (PbEcommRecommendMessage) httpResponsedMessage.getOrginalMessage();
                long j = pbEcommRecommendResponsedHttpMessage.mData.recommendations;
                djVar = this.evL.euf;
                djVar.getPbData().aOl().Ve.recommendations = j;
                if (pbEcommRecommendMessage != null) {
                    djVar3 = this.evL.euf;
                    djVar3.getPbData().aOl().sM().hasRecommend = pbEcommRecommendMessage.recommend;
                }
                eyVar = this.evL.euP;
                djVar2 = this.evL.euf;
                eyVar.j(djVar2.getPbData());
            }
        }
    }
}
