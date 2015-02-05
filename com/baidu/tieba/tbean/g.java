package com.baidu.tieba.tbean;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ d cbU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, int i) {
        super(i);
        this.cbU = dVar;
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
        BuyTBeanActivity buyTBeanActivity11;
        BuyTBeanActivity buyTBeanActivity12;
        BuyTBeanActivity buyTBeanActivity13;
        if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseGetPayinfoMessage) || httpResponsedMessage.getCmd() != 1001505) {
            buyTBeanActivity = this.cbU.cbS;
            if (buyTBeanActivity != null) {
                buyTBeanActivity2 = this.cbU.cbS;
                buyTBeanActivity2.showToast(z.neterror);
                return;
            }
            return;
        }
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
        if (statusCode == 200 && error == 0) {
            if (responseGetPayinfoMessage.getPayInfoResultData() == null) {
                buyTBeanActivity5 = this.cbU.cbS;
                if (buyTBeanActivity5 != null) {
                    buyTBeanActivity6 = this.cbU.cbS;
                    buyTBeanActivity6.showToast(z.buy_tbean_failed_tip);
                    return;
                }
            } else {
                int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                if (pay_status != 0) {
                    buyTBeanActivity7 = this.cbU.cbS;
                    if (buyTBeanActivity7 != null) {
                        buyTBeanActivity8 = this.cbU.cbS;
                        buyTBeanActivity8.showToast(z.buy_tbean_failed_tip);
                        return;
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001233, Integer.valueOf(pay_status)));
                    buyTBeanActivity9 = this.cbU.cbS;
                    if (buyTBeanActivity9 != null) {
                        buyTBeanActivity10 = this.cbU.cbS;
                        buyTBeanActivity10.finish();
                        buyTBeanActivity11 = this.cbU.cbS;
                        if (!StringUtils.isNull(buyTBeanActivity11.aiG())) {
                            buyTBeanActivity12 = this.cbU.cbS;
                            Activity pageActivity = buyTBeanActivity12.getPageContext().getPageActivity();
                            buyTBeanActivity13 = this.cbU.cbS;
                            com.baidu.tbadk.browser.a.x(pageActivity, buyTBeanActivity13.aiG());
                            return;
                        }
                        return;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(responseGetPayinfoMessage.getErrorString())) {
            buyTBeanActivity4 = this.cbU.cbS;
            buyTBeanActivity4.showToast(responseGetPayinfoMessage.getErrorString());
            return;
        }
        buyTBeanActivity3 = this.cbU.cbS;
        buyTBeanActivity3.showToast(z.neterror);
    }
}
