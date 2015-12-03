package com.baidu.tieba.payment;

import android.content.Intent;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.n;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
/* loaded from: classes.dex */
class d extends HttpMessageListener {
    final /* synthetic */ PaymentConfirmActivity cxe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PaymentConfirmActivity paymentConfirmActivity, int i) {
        super(i);
        this.cxe = paymentConfirmActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        s sVar;
        PaymentConfirmRequestData paymentConfirmRequestData;
        PaymentConfirmInfoData paymentConfirmInfoData;
        PaymentConfirmInfoData paymentConfirmInfoData2;
        boolean a;
        s sVar2;
        PaymentConfirmInfoData paymentConfirmInfoData3;
        boolean z;
        PaymentConfirmInfoData paymentConfirmInfoData4;
        boolean z2;
        PaymentConfirmActivity paymentConfirmActivity = this.cxe;
        sVar = this.cxe.cwU;
        paymentConfirmActivity.hideLoadingView(sVar.RT());
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentConfirmInfoMessage)) {
            ResponsePaymentConfirmInfoMessage responsePaymentConfirmInfoMessage = (ResponsePaymentConfirmInfoMessage) httpResponsedMessage;
            this.cxe.paymentConfirmInfoData = responsePaymentConfirmInfoMessage.getPaymentConfirmInfoData();
            if (!responsePaymentConfirmInfoMessage.hasError()) {
                paymentConfirmInfoData = this.cxe.paymentConfirmInfoData;
                if (paymentConfirmInfoData != null) {
                    PaymentConfirmActivity paymentConfirmActivity2 = this.cxe;
                    PaymentConfirmActivity paymentConfirmActivity3 = this.cxe;
                    paymentConfirmInfoData2 = this.cxe.paymentConfirmInfoData;
                    a = paymentConfirmActivity3.a(paymentConfirmInfoData2);
                    paymentConfirmActivity2.cwX = a;
                    sVar2 = this.cxe.cwU;
                    paymentConfirmInfoData3 = this.cxe.paymentConfirmInfoData;
                    z = this.cxe.cwX;
                    sVar2.b(paymentConfirmInfoData3, z);
                    PaymentConfirmActivity paymentConfirmActivity4 = this.cxe;
                    paymentConfirmInfoData4 = this.cxe.paymentConfirmInfoData;
                    z2 = this.cxe.cwX;
                    paymentConfirmActivity4.a(paymentConfirmInfoData4, z2);
                    return;
                }
            }
            if (responsePaymentConfirmInfoMessage.getError() == 1) {
                Intent intent = new Intent();
                intent.putExtra("class", 32);
                paymentConfirmRequestData = this.cxe.cwW;
                intent.putExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS, paymentConfirmRequestData);
                TbadkCoreApplication.setIntent(intent);
                ReloginManager.tU().e(null);
                this.cxe.closeActivity();
                return;
            }
            String errorString = responsePaymentConfirmInfoMessage.getErrorString();
            if (StringUtils.isNull(errorString)) {
                errorString = this.cxe.getResources().getString(n.i.neterror);
            }
            this.cxe.showToast(errorString);
        }
    }
}
