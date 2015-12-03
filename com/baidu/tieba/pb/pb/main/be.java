package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.c;
/* loaded from: classes.dex */
class be extends HttpMessageListener {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(PbActivity pbActivity, int i) {
        super(i);
        this.cCm = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof PbLotteryHttpResponseMessage) {
            if (httpResponsedMessage.hasError()) {
                this.cCm.showToast(n.i.neterror);
                this.cCm.hideProgressBar();
                return;
            }
            PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage = (PbLotteryHttpResponseMessage) httpResponsedMessage;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (pbLotteryHttpResponseMessage.getError() != 0) {
                if (pbLotteryHttpResponseMessage.getError() != 2390003) {
                    if (pbLotteryHttpResponseMessage.getError() == 3110004) {
                        c cVar = new c(this.cCm.getActivity());
                        c.C0080c c0080c = new c.C0080c();
                        c0080c.cBo = this.cCm.getPageContext();
                        c0080c.cBt = this.cCm.getResources().getString(n.i.no_attention_on_forum);
                        c0080c.cBn = this.cCm.getResources().getString(n.i.attention_before_lottery);
                        c0080c.cBp = this.cCm.getResources().getString(n.i.cancel);
                        c0080c.cBq = this.cCm.getResources().getString(n.i.attention);
                        c0080c.cBr = new bl(this, currentAccount);
                        c0080c.cBs = new bm(this, pbLotteryHttpResponseMessage, currentAccount);
                        cVar.b(c0080c);
                    } else if (StringUtils.isNull(pbLotteryHttpResponseMessage.getErrorString())) {
                        this.cCm.showToast(n.i.neterror);
                    } else {
                        this.cCm.showToast(pbLotteryHttpResponseMessage.getErrorString());
                    }
                } else {
                    this.cCm.jP(1);
                    if (pbLotteryHttpResponseMessage.getLotteryInfo() != null) {
                        c cVar2 = new c(this.cCm.getActivity());
                        c.C0080c c0080c2 = new c.C0080c();
                        c0080c2.cBo = this.cCm.getPageContext();
                        c0080c2.cBt = this.cCm.getResources().getString(n.i.no_lottery_chance_tip);
                        c0080c2.cBn = this.cCm.getResources().getString(n.i.get_more_lottery_chance_tip);
                        c0080c2.cBp = this.cCm.getResources().getString(n.i.cancel);
                        c0080c2.cBq = this.cCm.getResources().getString(n.i.view);
                        c0080c2.cBr = new bj(this, currentAccount);
                        c0080c2.cBs = new bk(this, pbLotteryHttpResponseMessage, currentAccount);
                        cVar2.a(c0080c2);
                    }
                }
            } else {
                this.cCm.jP(1);
                if (pbLotteryHttpResponseMessage.getLotteryInfo() != null) {
                    c cVar3 = new c(this.cCm.getActivity());
                    c.a aVar = new c.a();
                    aVar.cBo = this.cCm.getPageContext();
                    aVar.cBm = pbLotteryHttpResponseMessage.getLotteryInfo().ajv();
                    aVar.cBl = pbLotteryHttpResponseMessage.getLotteryInfo().aju();
                    aVar.cBp = this.cCm.getResources().getString(n.i.cancel);
                    aVar.cBq = this.cCm.getResources().getString(n.i.check_immediately);
                    aVar.cBr = new bf(this, currentAccount);
                    aVar.cBs = new bg(this, pbLotteryHttpResponseMessage, currentAccount);
                    cVar3.a(aVar);
                } else {
                    c cVar4 = new c(this.cCm.getActivity());
                    c.C0080c c0080c3 = new c.C0080c();
                    c0080c3.cBo = this.cCm.getPageContext();
                    c0080c3.cBt = this.cCm.getResources().getString(n.i.very_sorry);
                    c0080c3.cBn = this.cCm.getResources().getString(n.i.not_win_lottery_tip);
                    c0080c3.cBp = this.cCm.getResources().getString(n.i.cancel);
                    c0080c3.cBq = this.cCm.getResources().getString(n.i.continue_lottery_tip);
                    c0080c3.cBr = new bh(this, currentAccount);
                    c0080c3.cBs = new bi(this, pbLotteryHttpResponseMessage, currentAccount);
                    cVar4.a(c0080c3);
                }
            }
        }
        com.baidu.adp.lib.h.h.hj().postDelayed(new bn(this), 500L);
    }
}
