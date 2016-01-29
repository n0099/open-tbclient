package com.baidu.tieba.payment;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.payment.data.PayResultData;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
/* loaded from: classes.dex */
class j extends HttpMessageListener {
    final /* synthetic */ PaymentConfirmActivity cHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(PaymentConfirmActivity paymentConfirmActivity, int i) {
        super(i);
        this.cHo = paymentConfirmActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        s sVar;
        PayResultData.UnusualInfo describe;
        PayVcodeInfoData vcode;
        PaymentConfirmRequestData paymentConfirmRequestData;
        this.cHo.closeLoadingDialog();
        sVar = this.cHo.cHe;
        sVar.eY(true);
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentPayMessage)) {
            ResponsePaymentPayMessage responsePaymentPayMessage = (ResponsePaymentPayMessage) httpResponsedMessage;
            if (!responsePaymentPayMessage.hasError()) {
                int error = responsePaymentPayMessage.getError();
                if (error == 0) {
                    t.kr("c10294");
                    PaymentConfirmActivity paymentConfirmActivity = this.cHo;
                    paymentConfirmRequestData = this.cHo.cHg;
                    paymentConfirmActivity.kp(paymentConfirmRequestData.getOrder_id());
                    this.cHo.closeActivity();
                    return;
                } else if (error == 2270018) {
                    PayResultData payRequestDataData = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData == null) {
                        return;
                    }
                    this.cHo.M(5, payRequestDataData.getPubkey());
                    return;
                } else if (error == 2150040) {
                    PayResultData payRequestDataData2 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData2 == null || (vcode = payRequestDataData2.getVcode()) == null) {
                        return;
                    }
                    this.cHo.a(vcode);
                    return;
                } else if (error == 2) {
                    PayResultData payRequestDataData3 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData3 == null) {
                        return;
                    }
                    this.cHo.M(5 - payRequestDataData3.getWrongtime(), payRequestDataData3.getPubkey());
                    return;
                } else if (error == 2190005) {
                    this.cHo.cHi = true;
                    this.cHo.M(0, null);
                    return;
                } else if (error != 2270066 && error != 2270040 && error != 2270041 && error != 2270042) {
                    PayResultData payRequestDataData4 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData4 != null && (describe = payRequestDataData4.getDescribe()) != null) {
                        String word = describe.getWord();
                        String url = describe.getUrl();
                        if (!StringUtils.isNull(word) && !StringUtils.isNull(url)) {
                            this.cHo.ba(word, url);
                            return;
                        }
                    }
                    com.baidu.tbadk.core.view.h hVar = new com.baidu.tbadk.core.view.h(this.cHo.getPageContext());
                    String errorString = responsePaymentPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = this.cHo.getResources().getString(t.j.payment_pay_error);
                    }
                    hVar.d(errorString);
                    return;
                } else {
                    this.cHo.kF(error);
                    return;
                }
            }
            this.cHo.showToast(t.j.neterror);
        }
    }
}
