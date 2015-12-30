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
    final /* synthetic */ PaymentConfirmActivity cAI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PaymentConfirmActivity paymentConfirmActivity, int i) {
        super(i);
        this.cAI = paymentConfirmActivity;
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
        PaymentConfirmActivity paymentConfirmActivity = this.cAI;
        sVar = this.cAI.cAy;
        paymentConfirmActivity.hideLoadingView(sVar.Sl());
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentConfirmInfoMessage)) {
            ResponsePaymentConfirmInfoMessage responsePaymentConfirmInfoMessage = (ResponsePaymentConfirmInfoMessage) httpResponsedMessage;
            this.cAI.paymentConfirmInfoData = responsePaymentConfirmInfoMessage.getPaymentConfirmInfoData();
            if (!responsePaymentConfirmInfoMessage.hasError()) {
                paymentConfirmInfoData = this.cAI.paymentConfirmInfoData;
                if (paymentConfirmInfoData != null) {
                    PaymentConfirmActivity paymentConfirmActivity2 = this.cAI;
                    PaymentConfirmActivity paymentConfirmActivity3 = this.cAI;
                    paymentConfirmInfoData2 = this.cAI.paymentConfirmInfoData;
                    a = paymentConfirmActivity3.a(paymentConfirmInfoData2);
                    paymentConfirmActivity2.cAB = a;
                    sVar2 = this.cAI.cAy;
                    paymentConfirmInfoData3 = this.cAI.paymentConfirmInfoData;
                    z = this.cAI.cAB;
                    sVar2.b(paymentConfirmInfoData3, z);
                    PaymentConfirmActivity paymentConfirmActivity4 = this.cAI;
                    paymentConfirmInfoData4 = this.cAI.paymentConfirmInfoData;
                    z2 = this.cAI.cAB;
                    paymentConfirmActivity4.a(paymentConfirmInfoData4, z2);
                    return;
                }
            }
            if (responsePaymentConfirmInfoMessage.getError() == 1) {
                Intent intent = new Intent();
                intent.putExtra("class", 32);
                paymentConfirmRequestData = this.cAI.cAA;
                intent.putExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS, paymentConfirmRequestData);
                TbadkCoreApplication.setIntent(intent);
                ReloginManager.tE().e(null);
                this.cAI.closeActivity();
                return;
            }
            String errorString = responsePaymentConfirmInfoMessage.getErrorString();
            if (StringUtils.isNull(errorString)) {
                errorString = this.cAI.getResources().getString(n.j.neterror);
            }
            this.cAI.showToast(errorString);
        }
    }
}
