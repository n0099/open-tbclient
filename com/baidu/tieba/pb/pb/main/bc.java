package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.c;
/* loaded from: classes.dex */
class bc extends HttpMessageListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(PbActivity pbActivity, int i) {
        super(i);
        this.cjN = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof PbLotteryHttpResponseMessage) {
            if (httpResponsedMessage.hasError()) {
                this.cjN.showToast(i.h.neterror);
                this.cjN.hideProgressBar();
                return;
            }
            PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage = (PbLotteryHttpResponseMessage) httpResponsedMessage;
            if (pbLotteryHttpResponseMessage.getError() == 0) {
                PbActivity.a(this.cjN, 1);
                if (pbLotteryHttpResponseMessage.getLotteryInfo() != null) {
                    c cVar = new c(this.cjN.getActivity());
                    c.a aVar = new c.a();
                    aVar.ciS = this.cjN.getPageContext();
                    aVar.ciQ = pbLotteryHttpResponseMessage.getLotteryInfo().afd();
                    aVar.ciP = pbLotteryHttpResponseMessage.getLotteryInfo().afc();
                    aVar.ciT = this.cjN.getResources().getString(i.h.cancel);
                    aVar.ciU = this.cjN.getResources().getString(i.h.check_immediately);
                    aVar.ciV = new bd(this);
                    aVar.ciW = new be(this, pbLotteryHttpResponseMessage);
                    cVar.a(aVar);
                } else {
                    c cVar2 = new c(this.cjN.getActivity());
                    c.C0072c c0072c = new c.C0072c();
                    c0072c.ciS = this.cjN.getPageContext();
                    c0072c.ciX = this.cjN.getResources().getString(i.h.very_sorry);
                    c0072c.ciR = this.cjN.getResources().getString(i.h.not_win_lottery_tip);
                    c0072c.ciT = this.cjN.getResources().getString(i.h.cancel);
                    c0072c.ciU = this.cjN.getResources().getString(i.h.continue_lottery_tip);
                    c0072c.ciV = new bf(this);
                    c0072c.ciW = new bg(this, pbLotteryHttpResponseMessage);
                    cVar2.a(c0072c);
                }
            } else if (pbLotteryHttpResponseMessage.getError() == 2390003) {
                PbActivity.a(this.cjN, 1);
                if (pbLotteryHttpResponseMessage.getLotteryInfo() != null) {
                    c cVar3 = new c(this.cjN.getActivity());
                    c.C0072c c0072c2 = new c.C0072c();
                    c0072c2.ciS = this.cjN.getPageContext();
                    c0072c2.ciX = this.cjN.getResources().getString(i.h.no_lottery_chance_tip);
                    c0072c2.ciR = this.cjN.getResources().getString(i.h.get_more_lottery_chance_tip);
                    c0072c2.ciT = this.cjN.getResources().getString(i.h.cancel);
                    c0072c2.ciU = this.cjN.getResources().getString(i.h.view);
                    c0072c2.ciV = new bh(this);
                    c0072c2.ciW = new bi(this, pbLotteryHttpResponseMessage);
                    cVar3.a(c0072c2);
                }
            } else if (pbLotteryHttpResponseMessage.getError() == 3110004) {
                c cVar4 = new c(this.cjN.getActivity());
                c.C0072c c0072c3 = new c.C0072c();
                c0072c3.ciS = this.cjN.getPageContext();
                c0072c3.ciX = this.cjN.getResources().getString(i.h.no_attention_on_forum);
                c0072c3.ciR = this.cjN.getResources().getString(i.h.attention_before_lottery);
                c0072c3.ciT = this.cjN.getResources().getString(i.h.cancel);
                c0072c3.ciU = this.cjN.getResources().getString(i.h.attention);
                c0072c3.ciV = new bj(this);
                c0072c3.ciW = new bk(this, pbLotteryHttpResponseMessage);
                cVar4.b(c0072c3);
            } else if (StringUtils.isNull(pbLotteryHttpResponseMessage.getErrorString())) {
                this.cjN.showToast(i.h.neterror);
            } else {
                this.cjN.showToast(pbLotteryHttpResponseMessage.getErrorString());
            }
        }
        com.baidu.adp.lib.g.h.hh().postDelayed(new bl(this), 500L);
    }
}
