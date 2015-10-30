package com.baidu.tieba.payment;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PaymentConfirmActivity ced;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PaymentConfirmActivity paymentConfirmActivity, int i) {
        super(i);
        this.ced = paymentConfirmActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        q qVar;
        PaymentConfirmInfoData paymentConfirmInfoData;
        PaymentConfirmInfoData paymentConfirmInfoData2;
        boolean a;
        q qVar2;
        PaymentConfirmInfoData paymentConfirmInfoData3;
        boolean z;
        PaymentConfirmInfoData paymentConfirmInfoData4;
        boolean z2;
        PaymentConfirmActivity paymentConfirmActivity = this.ced;
        qVar = this.ced.cdV;
        paymentConfirmActivity.hideLoadingView(qVar.aer());
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentConfirmInfoMessage)) {
            ResponsePaymentConfirmInfoMessage responsePaymentConfirmInfoMessage = (ResponsePaymentConfirmInfoMessage) httpResponsedMessage;
            this.ced.paymentConfirmInfoData = responsePaymentConfirmInfoMessage.getPaymentConfirmInfoData();
            if (!responsePaymentConfirmInfoMessage.hasError()) {
                paymentConfirmInfoData = this.ced.paymentConfirmInfoData;
                if (paymentConfirmInfoData != null) {
                    PaymentConfirmActivity paymentConfirmActivity2 = this.ced;
                    PaymentConfirmActivity paymentConfirmActivity3 = this.ced;
                    paymentConfirmInfoData2 = this.ced.paymentConfirmInfoData;
                    a = paymentConfirmActivity3.a(paymentConfirmInfoData2);
                    paymentConfirmActivity2.cdY = a;
                    qVar2 = this.ced.cdV;
                    paymentConfirmInfoData3 = this.ced.paymentConfirmInfoData;
                    z = this.ced.cdY;
                    qVar2.b(paymentConfirmInfoData3, z);
                    PaymentConfirmActivity paymentConfirmActivity4 = this.ced;
                    paymentConfirmInfoData4 = this.ced.paymentConfirmInfoData;
                    z2 = this.ced.cdY;
                    paymentConfirmActivity4.a(paymentConfirmInfoData4, z2);
                    return;
                }
            }
            String errorString = responsePaymentConfirmInfoMessage.getErrorString();
            if (StringUtils.isNull(errorString)) {
                errorString = this.ced.getResources().getString(i.h.neterror);
            }
            this.ced.showToast(errorString);
        }
    }
}
