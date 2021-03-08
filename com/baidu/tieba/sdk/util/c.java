package com.baidu.tieba.sdk.util;

import com.baidu.live.adp.framework.controller.HttpResponsedRule;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes10.dex */
public class c extends HttpResponsedRule {
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.controller.ResponsedMessageRule
    /* renamed from: h */
    public HttpResponsedMessage process(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_NET, UbcStatConstant.ContentType.UBC_TYPE_NET_WORK, "liveroom", "net_error"), httpResponsedMessage, true);
        }
        return httpResponsedMessage;
    }
}
