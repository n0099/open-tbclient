package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ d cqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, int i) {
        super(i);
        this.cqs = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        BuyTBeanActivity buyTBeanActivity;
        BuyTBeanActivity buyTBeanActivity2;
        BuyTBeanActivity buyTBeanActivity3;
        BuyTBeanActivity buyTBeanActivity4;
        BuyTBeanActivity buyTBeanActivity5;
        BuyTBeanActivity buyTBeanActivity6;
        BuyTBeanActivity buyTBeanActivity7;
        BuyTBeanActivity buyTBeanActivity8;
        BuyTBeanActivity buyTBeanActivity9;
        BuyTBeanActivity buyTBeanActivity10;
        if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseGetPayinfoMessage) || httpResponsedMessage.getCmd() != 1001505) {
            buyTBeanActivity = this.cqs.cqq;
            if (buyTBeanActivity != null) {
                buyTBeanActivity2 = this.cqs.cqq;
                buyTBeanActivity2.showToast(y.neterror);
                return;
            }
            return;
        }
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
        if (statusCode == 200 && error == 0) {
            if (responseGetPayinfoMessage.getPayInfoResultData() == null) {
                buyTBeanActivity5 = this.cqs.cqq;
                if (buyTBeanActivity5 != null) {
                    buyTBeanActivity6 = this.cqs.cqq;
                    buyTBeanActivity6.showToast(y.buy_tbean_failed_tip);
                    return;
                }
            } else {
                int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                if (pay_status != 0) {
                    buyTBeanActivity7 = this.cqs.cqq;
                    if (buyTBeanActivity7 != null) {
                        buyTBeanActivity8 = this.cqs.cqq;
                        buyTBeanActivity8.showToast(y.buy_tbean_failed_tip);
                        return;
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001233, Integer.valueOf(pay_status)));
                    buyTBeanActivity9 = this.cqs.cqq;
                    if (buyTBeanActivity9 != null) {
                        buyTBeanActivity10 = this.cqs.cqq;
                        buyTBeanActivity10.finish();
                        return;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(responseGetPayinfoMessage.getErrorString())) {
            buyTBeanActivity4 = this.cqs.cqq;
            buyTBeanActivity4.showToast(responseGetPayinfoMessage.getErrorString());
            return;
        }
        buyTBeanActivity3 = this.cqs.cqq;
        buyTBeanActivity3.showToast(y.neterror);
    }
}
