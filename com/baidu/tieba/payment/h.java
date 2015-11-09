package com.baidu.tieba.payment;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.payment.data.PayResultData;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
/* loaded from: classes.dex */
class h extends HttpMessageListener {
    final /* synthetic */ PaymentConfirmActivity ceE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PaymentConfirmActivity paymentConfirmActivity, int i) {
        super(i);
        this.ceE = paymentConfirmActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        q qVar;
        PayResultData.UnusualInfo describe;
        PayVcodeInfoData vcode;
        this.ceE.closeLoadingDialog();
        qVar = this.ceE.cew;
        qVar.ej(true);
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentPayMessage)) {
            ResponsePaymentPayMessage responsePaymentPayMessage = (ResponsePaymentPayMessage) httpResponsedMessage;
            if (!responsePaymentPayMessage.hasError()) {
                int error = responsePaymentPayMessage.getError();
                if (error == 0) {
                    r.jB("c10294");
                    new com.baidu.tbadk.core.view.f(this.ceE.getPageContext()).dA(this.ceE.getResources().getString(i.h.payment_confirm_success));
                    return;
                } else if (error == 2270018) {
                    PayResultData payRequestDataData = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData == null) {
                        return;
                    }
                    this.ceE.J(5, payRequestDataData.getPubkey());
                    return;
                } else if (error == 2150040) {
                    PayResultData payRequestDataData2 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData2 == null || (vcode = payRequestDataData2.getVcode()) == null) {
                        return;
                    }
                    this.ceE.a(vcode);
                    return;
                } else if (error == 2) {
                    PayResultData payRequestDataData3 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData3 == null) {
                        return;
                    }
                    this.ceE.J(5 - payRequestDataData3.getWrongtime(), payRequestDataData3.getPubkey());
                    return;
                } else if (error == 2190005) {
                    this.ceE.ceA = true;
                    this.ceE.J(0, null);
                    return;
                } else if (error != 2270066 && error != 2270040 && error != 2270041 && error != 2270042) {
                    PayResultData payRequestDataData4 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData4 != null && (describe = payRequestDataData4.getDescribe()) != null) {
                        String word = describe.getWord();
                        String url = describe.getUrl();
                        if (!StringUtils.isNull(word) && !StringUtils.isNull(url)) {
                            this.ceE.aT(word, url);
                            return;
                        }
                    }
                    com.baidu.tbadk.core.view.f fVar = new com.baidu.tbadk.core.view.f(this.ceE.getPageContext());
                    String errorString = responsePaymentPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = this.ceE.getResources().getString(i.h.payment_pay_error);
                    }
                    fVar.dB(errorString);
                    return;
                } else {
                    this.ceE.iQ(error);
                    return;
                }
            }
            this.ceE.showToast(i.h.neterror);
        }
    }
}
