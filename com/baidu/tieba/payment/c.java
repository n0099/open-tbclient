package com.baidu.tieba.payment;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PaymentConfirmActivity ceE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PaymentConfirmActivity paymentConfirmActivity, int i) {
        super(i);
        this.ceE = paymentConfirmActivity;
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
        PaymentConfirmActivity paymentConfirmActivity = this.ceE;
        qVar = this.ceE.cew;
        paymentConfirmActivity.hideLoadingView(qVar.aeM());
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentConfirmInfoMessage)) {
            ResponsePaymentConfirmInfoMessage responsePaymentConfirmInfoMessage = (ResponsePaymentConfirmInfoMessage) httpResponsedMessage;
            this.ceE.paymentConfirmInfoData = responsePaymentConfirmInfoMessage.getPaymentConfirmInfoData();
            if (!responsePaymentConfirmInfoMessage.hasError()) {
                paymentConfirmInfoData = this.ceE.paymentConfirmInfoData;
                if (paymentConfirmInfoData != null) {
                    PaymentConfirmActivity paymentConfirmActivity2 = this.ceE;
                    PaymentConfirmActivity paymentConfirmActivity3 = this.ceE;
                    paymentConfirmInfoData2 = this.ceE.paymentConfirmInfoData;
                    a = paymentConfirmActivity3.a(paymentConfirmInfoData2);
                    paymentConfirmActivity2.cez = a;
                    qVar2 = this.ceE.cew;
                    paymentConfirmInfoData3 = this.ceE.paymentConfirmInfoData;
                    z = this.ceE.cez;
                    qVar2.b(paymentConfirmInfoData3, z);
                    PaymentConfirmActivity paymentConfirmActivity4 = this.ceE;
                    paymentConfirmInfoData4 = this.ceE.paymentConfirmInfoData;
                    z2 = this.ceE.cez;
                    paymentConfirmActivity4.a(paymentConfirmInfoData4, z2);
                    return;
                }
            }
            String errorString = responsePaymentConfirmInfoMessage.getErrorString();
            if (StringUtils.isNull(errorString)) {
                errorString = this.ceE.getResources().getString(i.h.neterror);
            }
            this.ceE.showToast(errorString);
        }
    }
}
