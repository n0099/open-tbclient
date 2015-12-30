package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ e dJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar, int i) {
        super(i);
        this.dJX = eVar;
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
        String str;
        BuyTBeanActivity buyTBeanActivity9;
        BuyTBeanActivity buyTBeanActivity10;
        if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseGetPayinfoMessage) || httpResponsedMessage.getCmd() != 1001505) {
            buyTBeanActivity = this.dJX.dJV;
            if (buyTBeanActivity != null) {
                buyTBeanActivity2 = this.dJX.dJV;
                buyTBeanActivity2.showToast(n.j.neterror);
                return;
            }
            return;
        }
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
        HttpMessage httpMessage = (HttpMessage) responseGetPayinfoMessage.getOrginalMessage();
        if (statusCode == 200 && error == 0) {
            if (responseGetPayinfoMessage.getPayInfoResultData() == null) {
                buyTBeanActivity5 = this.dJX.dJV;
                if (buyTBeanActivity5 != null) {
                    buyTBeanActivity6 = this.dJX.dJV;
                    buyTBeanActivity6.showToast(n.j.buy_tbean_failed_tip);
                    return;
                }
            } else {
                int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                if (pay_status != 0) {
                    buyTBeanActivity7 = this.dJX.dJV;
                    if (buyTBeanActivity7 != null) {
                        buyTBeanActivity8 = this.dJX.dJV;
                        buyTBeanActivity8.showToast(n.j.buy_tbean_failed_tip);
                        return;
                    }
                } else {
                    r.kn("c10297");
                    if (!(httpMessage.getExtra() instanceof String)) {
                        str = "";
                    } else {
                        str = (String) httpMessage.getExtra();
                    }
                    com.baidu.tieba.tbadkCore.data.f fVar = new com.baidu.tieba.tbadkCore.data.f();
                    fVar.mt(str);
                    fVar.setStatus(pay_status);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS, fVar));
                    buyTBeanActivity9 = this.dJX.dJV;
                    if (buyTBeanActivity9 != null) {
                        buyTBeanActivity10 = this.dJX.dJV;
                        buyTBeanActivity10.finish();
                        return;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(responseGetPayinfoMessage.getErrorString())) {
            buyTBeanActivity4 = this.dJX.dJV;
            buyTBeanActivity4.showToast(responseGetPayinfoMessage.getErrorString());
            return;
        }
        buyTBeanActivity3 = this.dJX.dJV;
        buyTBeanActivity3.showToast(n.j.neterror);
    }
}
