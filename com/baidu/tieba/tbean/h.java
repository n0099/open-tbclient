package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ e eac;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar, int i) {
        super(i);
        this.eac = eVar;
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
            buyTBeanActivity = this.eac.eaa;
            if (buyTBeanActivity != null) {
                buyTBeanActivity2 = this.eac.eaa;
                buyTBeanActivity2.showToast(t.j.neterror);
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
                buyTBeanActivity5 = this.eac.eaa;
                if (buyTBeanActivity5 != null) {
                    buyTBeanActivity6 = this.eac.eaa;
                    buyTBeanActivity6.showToast(t.j.buy_tbean_failed_tip);
                    return;
                }
            } else {
                int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                if (pay_status != 0) {
                    buyTBeanActivity7 = this.eac.eaa;
                    if (buyTBeanActivity7 != null) {
                        buyTBeanActivity8 = this.eac.eaa;
                        buyTBeanActivity8.showToast(t.j.buy_tbean_failed_tip);
                        return;
                    }
                } else {
                    r.kr("c10297");
                    if (!(httpMessage.getExtra() instanceof String)) {
                        str = "";
                    } else {
                        str = (String) httpMessage.getExtra();
                    }
                    com.baidu.tieba.tbadkCore.data.f fVar = new com.baidu.tieba.tbadkCore.data.f();
                    fVar.mK(str);
                    fVar.setStatus(pay_status);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS, fVar));
                    buyTBeanActivity9 = this.eac.eaa;
                    if (buyTBeanActivity9 != null) {
                        buyTBeanActivity10 = this.eac.eaa;
                        buyTBeanActivity10.finish();
                        return;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(responseGetPayinfoMessage.getErrorString())) {
            buyTBeanActivity4 = this.eac.eaa;
            buyTBeanActivity4.showToast(responseGetPayinfoMessage.getErrorString());
            return;
        }
        buyTBeanActivity3 = this.eac.eaa;
        buyTBeanActivity3.showToast(t.j.neterror);
    }
}
