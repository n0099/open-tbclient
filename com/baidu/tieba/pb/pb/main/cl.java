package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class cl extends HttpMessageListener {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl(PbActivity pbActivity, int i) {
        super(i);
        this.dht = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        boolean awe;
        boolean awe2;
        boolean awe3;
        boolean awe4;
        boolean awe5;
        boolean awe6;
        boolean awe7;
        if (httpResponsedMessage instanceof PbLotteryHttpResponseMessage) {
            PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage = (PbLotteryHttpResponseMessage) httpResponsedMessage;
            this.dht.dgR = pbLotteryHttpResponseMessage;
            if (httpResponsedMessage.hasError()) {
                awe7 = this.dht.awe();
                if (!awe7) {
                    if (!StringUtils.isNULL(httpResponsedMessage.getErrorString())) {
                        this.dht.showToast(httpResponsedMessage.getErrorString());
                    } else {
                        this.dht.showToast(t.j.neterror);
                    }
                    this.dht.hideProgressBar();
                    return;
                }
                this.dht.lS(5);
                return;
            }
            switch (pbLotteryHttpResponseMessage.getType()) {
                case 0:
                    this.dht.lU(1);
                    awe5 = this.dht.awe();
                    if (awe5) {
                        this.dht.H(0, new StringBuilder(String.valueOf(pbLotteryHttpResponseMessage.getLotteryInfo().avp().rp())).toString());
                        break;
                    } else {
                        this.dht.c(false, pbLotteryHttpResponseMessage);
                        break;
                    }
                case 1:
                    this.dht.lU(1);
                    awe4 = this.dht.awe();
                    if (awe4) {
                        this.dht.lS(1);
                        break;
                    } else {
                        this.dht.b(false, pbLotteryHttpResponseMessage);
                        break;
                    }
                case 2:
                    awe = this.dht.awe();
                    if (awe) {
                        this.dht.lS(2);
                        break;
                    } else {
                        this.dht.a(false, pbLotteryHttpResponseMessage);
                        break;
                    }
                case 3:
                    this.dht.lU(1);
                    awe2 = this.dht.awe();
                    if (awe2) {
                        this.dht.lS(3);
                        break;
                    } else {
                        this.dht.awg();
                        break;
                    }
                case 4:
                    this.dht.lU(1);
                    awe3 = this.dht.awe();
                    if (awe3) {
                        this.dht.lS(4);
                        break;
                    } else {
                        this.dht.b(pbLotteryHttpResponseMessage);
                        break;
                    }
                default:
                    awe6 = this.dht.awe();
                    if (awe6) {
                        this.dht.lS(5);
                        break;
                    } else {
                        this.dht.a(pbLotteryHttpResponseMessage);
                        break;
                    }
            }
        }
        com.baidu.adp.lib.h.h.hx().postDelayed(new cm(this), 500L);
    }
}
