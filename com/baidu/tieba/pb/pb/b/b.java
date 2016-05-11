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
        boolean awi;
        boolean awi2;
        boolean awi3;
        boolean awi4;
        boolean awi5;
        boolean awi6;
        boolean awi7;
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
                awi7 = this.dhT.awi();
                if (!awi7) {
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
                this.dhT.lH(5);
                return;
            }
            switch (pbLotteryHttpResponseMessage3.getType()) {
                case 0:
                    this.dhT.lG(1);
                    awi5 = this.dhT.awi();
                    if (awi5) {
                        this.dhT.G(0, new StringBuilder(String.valueOf(pbLotteryHttpResponseMessage3.getLotteryInfo().avv().oJ())).toString());
                        break;
                    } else {
                        this.dhT.c(false, pbLotteryHttpResponseMessage3);
                        break;
                    }
                case 1:
                    this.dhT.lG(1);
                    awi4 = this.dhT.awi();
                    if (awi4) {
                        this.dhT.lH(1);
                        break;
                    } else {
                        this.dhT.b(false, pbLotteryHttpResponseMessage3);
                        break;
                    }
                case 2:
                    awi = this.dhT.awi();
                    if (awi) {
                        this.dhT.lH(2);
                        break;
                    } else {
                        this.dhT.a(false, pbLotteryHttpResponseMessage3);
                        break;
                    }
                case 3:
                    this.dhT.lG(1);
                    awi2 = this.dhT.awi();
                    if (awi2) {
                        this.dhT.lH(3);
                        break;
                    } else {
                        this.dhT.awk();
                        break;
                    }
                case 4:
                    this.dhT.lG(1);
                    awi3 = this.dhT.awi();
                    if (awi3) {
                        this.dhT.lH(4);
                        break;
                    } else {
                        this.dhT.b(pbLotteryHttpResponseMessage3);
                        break;
                    }
                default:
                    awi6 = this.dhT.awi();
                    if (awi6) {
                        this.dhT.lH(5);
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
