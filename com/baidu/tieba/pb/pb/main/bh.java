package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.c;
/* loaded from: classes.dex */
class bh extends HttpMessageListener {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(PbActivity pbActivity, int i) {
        super(i);
        this.cFS = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof PbLotteryHttpResponseMessage) {
            if (httpResponsedMessage.hasError()) {
                this.cFS.showToast(n.j.neterror);
                this.cFS.hideProgressBar();
                return;
            }
            PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage = (PbLotteryHttpResponseMessage) httpResponsedMessage;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (pbLotteryHttpResponseMessage.getError() != 0) {
                if (pbLotteryHttpResponseMessage.getError() != 2390003) {
                    if (pbLotteryHttpResponseMessage.getError() == 3110004) {
                        c cVar = new c(this.cFS.getActivity());
                        c.C0075c c0075c = new c.C0075c();
                        c0075c.cET = this.cFS.getPageContext();
                        c0075c.cEY = this.cFS.getResources().getString(n.j.no_attention_on_forum);
                        c0075c.cES = this.cFS.getResources().getString(n.j.attention_before_lottery);
                        c0075c.cEU = this.cFS.getResources().getString(n.j.cancel);
                        c0075c.cEV = this.cFS.getResources().getString(n.j.attention);
                        c0075c.cEW = new bo(this, currentAccount);
                        c0075c.cEX = new bp(this, pbLotteryHttpResponseMessage, currentAccount);
                        cVar.b(c0075c);
                    } else if (StringUtils.isNull(pbLotteryHttpResponseMessage.getErrorString())) {
                        this.cFS.showToast(n.j.neterror);
                    } else {
                        this.cFS.showToast(pbLotteryHttpResponseMessage.getErrorString());
                    }
                } else {
                    this.cFS.km(1);
                    if (pbLotteryHttpResponseMessage.getLotteryInfo() != null) {
                        c cVar2 = new c(this.cFS.getActivity());
                        c.C0075c c0075c2 = new c.C0075c();
                        c0075c2.cET = this.cFS.getPageContext();
                        c0075c2.cEY = this.cFS.getResources().getString(n.j.no_lottery_chance_tip);
                        c0075c2.cES = this.cFS.getResources().getString(n.j.get_more_lottery_chance_tip);
                        c0075c2.cEU = this.cFS.getResources().getString(n.j.cancel);
                        c0075c2.cEV = this.cFS.getResources().getString(n.j.view);
                        c0075c2.cEW = new bm(this, currentAccount);
                        c0075c2.cEX = new bn(this, pbLotteryHttpResponseMessage, currentAccount);
                        cVar2.a(c0075c2);
                    }
                }
            } else {
                this.cFS.km(1);
                if (pbLotteryHttpResponseMessage.getLotteryInfo() != null) {
                    c cVar3 = new c(this.cFS.getActivity());
                    c.a aVar = new c.a();
                    aVar.cET = this.cFS.getPageContext();
                    aVar.cER = pbLotteryHttpResponseMessage.getLotteryInfo().akD();
                    aVar.cEQ = pbLotteryHttpResponseMessage.getLotteryInfo().akC();
                    aVar.cEU = this.cFS.getResources().getString(n.j.cancel);
                    aVar.cEV = this.cFS.getResources().getString(n.j.check_immediately);
                    aVar.cEW = new bi(this, currentAccount);
                    aVar.cEX = new bj(this, pbLotteryHttpResponseMessage, currentAccount);
                    cVar3.a(aVar);
                } else {
                    c cVar4 = new c(this.cFS.getActivity());
                    c.C0075c c0075c3 = new c.C0075c();
                    c0075c3.cET = this.cFS.getPageContext();
                    c0075c3.cEY = this.cFS.getResources().getString(n.j.very_sorry);
                    c0075c3.cES = this.cFS.getResources().getString(n.j.not_win_lottery_tip);
                    c0075c3.cEU = this.cFS.getResources().getString(n.j.cancel);
                    c0075c3.cEV = this.cFS.getResources().getString(n.j.continue_lottery_tip);
                    c0075c3.cEW = new bk(this, currentAccount);
                    c0075c3.cEX = new bl(this, pbLotteryHttpResponseMessage, currentAccount);
                    cVar4.a(c0075c3);
                }
            }
        }
        com.baidu.adp.lib.h.h.hj().postDelayed(new bq(this), 500L);
    }
}
