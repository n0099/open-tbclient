package com.baidu.tieba.payment;

import android.content.Intent;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
/* loaded from: classes.dex */
class d extends HttpMessageListener {
    final /* synthetic */ PaymentConfirmActivity cHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PaymentConfirmActivity paymentConfirmActivity, int i) {
        super(i);
        this.cHo = paymentConfirmActivity;
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
        PaymentConfirmActivity paymentConfirmActivity = this.cHo;
        sVar = this.cHo.cHe;
        paymentConfirmActivity.hideLoadingView(sVar.Us());
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentConfirmInfoMessage)) {
            ResponsePaymentConfirmInfoMessage responsePaymentConfirmInfoMessage = (ResponsePaymentConfirmInfoMessage) httpResponsedMessage;
            this.cHo.paymentConfirmInfoData = responsePaymentConfirmInfoMessage.getPaymentConfirmInfoData();
            if (!responsePaymentConfirmInfoMessage.hasError()) {
                paymentConfirmInfoData = this.cHo.paymentConfirmInfoData;
                if (paymentConfirmInfoData != null) {
                    PaymentConfirmActivity paymentConfirmActivity2 = this.cHo;
                    PaymentConfirmActivity paymentConfirmActivity3 = this.cHo;
                    paymentConfirmInfoData2 = this.cHo.paymentConfirmInfoData;
                    a = paymentConfirmActivity3.a(paymentConfirmInfoData2);
                    paymentConfirmActivity2.cHh = a;
                    sVar2 = this.cHo.cHe;
                    paymentConfirmInfoData3 = this.cHo.paymentConfirmInfoData;
                    z = this.cHo.cHh;
                    sVar2.b(paymentConfirmInfoData3, z);
                    PaymentConfirmActivity paymentConfirmActivity4 = this.cHo;
                    paymentConfirmInfoData4 = this.cHo.paymentConfirmInfoData;
                    z2 = this.cHo.cHh;
                    paymentConfirmActivity4.a(paymentConfirmInfoData4, z2);
                    return;
                }
            }
            if (responsePaymentConfirmInfoMessage.getError() == 1) {
                Intent intent = new Intent();
                intent.putExtra("class", 32);
                paymentConfirmRequestData = this.cHo.cHg;
                intent.putExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS, paymentConfirmRequestData);
                TbadkCoreApplication.setIntent(intent);
                ReloginManager.uJ().e(null);
                this.cHo.closeActivity();
                return;
            }
            String errorString = responsePaymentConfirmInfoMessage.getErrorString();
            if (StringUtils.isNull(errorString)) {
                errorString = this.cHo.getResources().getString(t.j.neterror);
            }
            this.cHo.showToast(errorString);
        }
    }
}
