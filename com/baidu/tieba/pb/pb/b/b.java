package com.baidu.tieba.pb.pb.b;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLotteryHttpResponseMessage;
import com.baidu.tieba.pb.pb.main.PbLotteryRequestMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ a dhT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.dhT = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage;
        boolean awl;
        boolean awl2;
        boolean awl3;
        boolean awl4;
        boolean awl5;
        boolean awl6;
        boolean awl7;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage2;
        boolean z;
        if (httpResponsedMessage instanceof PbLotteryHttpResponseMessage) {
            PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage3 = (PbLotteryHttpResponseMessage) httpResponsedMessage;
            this.dhT.dhR = pbLotteryHttpResponseMessage3;
            pbLotteryHttpResponseMessage = this.dhT.dhR;
            if (pbLotteryHttpResponseMessage.getOrginalMessage().getExtra() instanceof PbLotteryRequestMessage) {
                pbLotteryHttpResponseMessage2 = this.dhT.dhR;
                PbLotteryRequestMessage pbLotteryRequestMessage = (PbLotteryRequestMessage) pbLotteryHttpResponseMessage2.getOrginalMessage().getExtra();
                z = this.dhT.mIsSenior;
                if (!z && pbLotteryRequestMessage.getIsSenior()) {
                    return;
                }
            }
            if (httpResponsedMessage.hasError()) {
                awl7 = this.dhT.awl();
                if (!awl7) {
                    if (!StringUtils.isNULL(httpResponsedMessage.getErrorString())) {
                        pbActivity3 = this.dhT.dhQ;
                        pbActivity3.showToast(httpResponsedMessage.getErrorString());
                    } else {
                        pbActivity = this.dhT.dhQ;
                        pbActivity.showToast(t.j.neterror);
                    }
                    pbActivity2 = this.dhT.dhQ;
                    pbActivity2.hideProgressBar();
                    return;
                }
                this.dhT.lG(5);
                return;
            }
            switch (pbLotteryHttpResponseMessage3.getType()) {
                case 0:
                    this.dhT.lF(1);
                    awl5 = this.dhT.awl();
                    if (awl5) {
                        this.dhT.G(0, new StringBuilder(String.valueOf(pbLotteryHttpResponseMessage3.getLotteryInfo().avy().oJ())).toString());
                        break;
                    } else {
                        this.dhT.c(false, pbLotteryHttpResponseMessage3);
                        break;
                    }
                case 1:
                    this.dhT.lF(1);
                    awl4 = this.dhT.awl();
                    if (awl4) {
                        this.dhT.lG(1);
                        break;
                    } else {
                        this.dhT.b(false, pbLotteryHttpResponseMessage3);
                        break;
                    }
                case 2:
                    awl = this.dhT.awl();
                    if (awl) {
                        this.dhT.lG(2);
                        break;
                    } else {
                        this.dhT.a(false, pbLotteryHttpResponseMessage3);
                        break;
                    }
                case 3:
                    this.dhT.lF(1);
                    awl2 = this.dhT.awl();
                    if (awl2) {
                        this.dhT.lG(3);
                        break;
                    } else {
                        this.dhT.awn();
                        break;
                    }
                case 4:
                    this.dhT.lF(1);
                    awl3 = this.dhT.awl();
                    if (awl3) {
                        this.dhT.lG(4);
                        break;
                    } else {
                        this.dhT.b(pbLotteryHttpResponseMessage3);
                        break;
                    }
                default:
                    awl6 = this.dhT.awl();
                    if (awl6) {
                        this.dhT.lG(5);
                        break;
                    } else {
                        this.dhT.a(pbLotteryHttpResponseMessage3);
                        break;
                    }
            }
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(new c(this), 500L);
    }
}
