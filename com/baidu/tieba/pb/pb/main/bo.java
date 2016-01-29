package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bo extends HttpMessageListener {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(PbActivity pbActivity, int i) {
        super(i);
        this.cNq = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof PbLotteryHttpResponseMessage) {
            if (httpResponsedMessage.hasError()) {
                this.cNq.showToast(t.j.neterror);
                this.cNq.hideProgressBar();
                return;
            }
            PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage = (PbLotteryHttpResponseMessage) httpResponsedMessage;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (pbLotteryHttpResponseMessage.getError() != 0) {
                if (pbLotteryHttpResponseMessage.getError() != 2390003) {
                    if (pbLotteryHttpResponseMessage.getError() == 3110004) {
                        c cVar = new c(this.cNq.getActivity());
                        c.C0077c c0077c = new c.C0077c();
                        c0077c.cMk = this.cNq.getPageContext();
                        c0077c.cMp = this.cNq.getResources().getString(t.j.no_attention_on_forum);
                        c0077c.cMj = this.cNq.getResources().getString(t.j.attention_before_lottery);
                        c0077c.cMl = this.cNq.getResources().getString(t.j.cancel);
                        c0077c.cMm = this.cNq.getResources().getString(t.j.attention);
                        c0077c.cMn = new bv(this, currentAccount);
                        c0077c.cMo = new bw(this, pbLotteryHttpResponseMessage, currentAccount);
                        cVar.b(c0077c);
                    } else if (StringUtils.isNull(pbLotteryHttpResponseMessage.getErrorString())) {
                        this.cNq.showToast(t.j.neterror);
                    } else {
                        this.cNq.showToast(pbLotteryHttpResponseMessage.getErrorString());
                    }
                } else {
                    this.cNq.kM(1);
                    if (pbLotteryHttpResponseMessage.getLotteryInfo() != null) {
                        c cVar2 = new c(this.cNq.getActivity());
                        c.C0077c c0077c2 = new c.C0077c();
                        c0077c2.cMk = this.cNq.getPageContext();
                        c0077c2.cMp = this.cNq.getResources().getString(t.j.no_lottery_chance_tip);
                        c0077c2.cMj = this.cNq.getResources().getString(t.j.get_more_lottery_chance_tip);
                        c0077c2.cMl = this.cNq.getResources().getString(t.j.cancel);
                        c0077c2.cMm = this.cNq.getResources().getString(t.j.view);
                        c0077c2.cMn = new bt(this, currentAccount);
                        c0077c2.cMo = new bu(this, pbLotteryHttpResponseMessage, currentAccount);
                        cVar2.a(c0077c2);
                    }
                }
            } else {
                this.cNq.kM(1);
                if (pbLotteryHttpResponseMessage.getLotteryInfo() != null) {
                    c cVar3 = new c(this.cNq.getActivity());
                    c.a aVar = new c.a();
                    aVar.cMk = this.cNq.getPageContext();
                    aVar.cMi = pbLotteryHttpResponseMessage.getLotteryInfo().aoB();
                    aVar.cMh = pbLotteryHttpResponseMessage.getLotteryInfo().aoA();
                    aVar.cMl = this.cNq.getResources().getString(t.j.cancel);
                    aVar.cMm = this.cNq.getResources().getString(t.j.check_immediately);
                    aVar.cMn = new bp(this, currentAccount);
                    aVar.cMo = new bq(this, pbLotteryHttpResponseMessage, currentAccount);
                    cVar3.a(aVar);
                } else {
                    c cVar4 = new c(this.cNq.getActivity());
                    c.C0077c c0077c3 = new c.C0077c();
                    c0077c3.cMk = this.cNq.getPageContext();
                    c0077c3.cMp = this.cNq.getResources().getString(t.j.very_sorry);
                    c0077c3.cMj = this.cNq.getResources().getString(t.j.not_win_lottery_tip);
                    c0077c3.cMl = this.cNq.getResources().getString(t.j.cancel);
                    c0077c3.cMm = this.cNq.getResources().getString(t.j.continue_lottery_tip);
                    c0077c3.cMn = new br(this, currentAccount);
                    c0077c3.cMo = new bs(this, pbLotteryHttpResponseMessage, currentAccount);
                    cVar4.a(c0077c3);
                }
            }
        }
        com.baidu.adp.lib.h.h.hr().postDelayed(new bx(this), 500L);
    }
}
