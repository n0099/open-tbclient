package com.baidu.tieba.payment;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import com.baidu.tieba.payment.data.PayResultData;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
/* loaded from: classes.dex */
class j extends HttpMessageListener {
    final /* synthetic */ PaymentConfirmActivity cxe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(PaymentConfirmActivity paymentConfirmActivity, int i) {
        super(i);
        this.cxe = paymentConfirmActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        s sVar;
        PayResultData.UnusualInfo describe;
        PayVcodeInfoData vcode;
        PaymentConfirmRequestData paymentConfirmRequestData;
        this.cxe.closeLoadingDialog();
        sVar = this.cxe.cwU;
        sVar.eL(true);
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentPayMessage)) {
            ResponsePaymentPayMessage responsePaymentPayMessage = (ResponsePaymentPayMessage) httpResponsedMessage;
            if (!responsePaymentPayMessage.hasError()) {
                int error = responsePaymentPayMessage.getError();
                if (error == 0) {
                    t.kr("c10294");
                    PaymentConfirmActivity paymentConfirmActivity = this.cxe;
                    paymentConfirmRequestData = this.cxe.cwW;
                    paymentConfirmActivity.kp(paymentConfirmRequestData.getOrder_id());
                    this.cxe.closeActivity();
                    return;
                } else if (error == 2270018) {
                    PayResultData payRequestDataData = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData == null) {
                        return;
                    }
                    this.cxe.K(5, payRequestDataData.getPubkey());
                    return;
                } else if (error == 2150040) {
                    PayResultData payRequestDataData2 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData2 == null || (vcode = payRequestDataData2.getVcode()) == null) {
                        return;
                    }
                    this.cxe.a(vcode);
                    return;
                } else if (error == 2) {
                    PayResultData payRequestDataData3 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData3 == null) {
                        return;
                    }
                    this.cxe.K(5 - payRequestDataData3.getWrongtime(), payRequestDataData3.getPubkey());
                    return;
                } else if (error == 2190005) {
                    this.cxe.cwY = true;
                    this.cxe.K(0, null);
                    return;
                } else if (error != 2270066 && error != 2270040 && error != 2270041 && error != 2270042) {
                    PayResultData payRequestDataData4 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData4 != null && (describe = payRequestDataData4.getDescribe()) != null) {
                        String word = describe.getWord();
                        String url = describe.getUrl();
                        if (!StringUtils.isNull(word) && !StringUtils.isNull(url)) {
                            this.cxe.aY(word, url);
                            return;
                        }
                    }
                    com.baidu.tbadk.core.view.g gVar = new com.baidu.tbadk.core.view.g(this.cxe.getPageContext());
                    String errorString = responsePaymentPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = this.cxe.getResources().getString(n.i.payment_pay_error);
                    }
                    gVar.e(errorString);
                    return;
                } else {
                    this.cxe.jI(error);
                    return;
                }
            }
            this.cxe.showToast(n.i.neterror);
        }
    }
}
