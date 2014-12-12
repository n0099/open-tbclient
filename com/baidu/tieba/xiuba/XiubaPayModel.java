package com.baidu.tieba.xiuba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes.dex */
public class XiubaPayModel {
    private static GetPayCallback getPayCallback;
    private static HttpMessageListener getPayInfoListener;
    private static final e sendPayListener;

    /* loaded from: classes.dex */
    public interface GetPayCallback {
        void callBack(ResponsePayData responsePayData);
    }

    static {
        a.a(308006, ResponseXiubaPayMessage.class, false, false);
        sendPayListener = new e(308006) { // from class: com.baidu.tieba.xiuba.XiubaPayModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseXiubaPayMessage)) {
                    ResponseXiubaPayMessage responseXiubaPayMessage = (ResponseXiubaPayMessage) socketResponsedMessage;
                    if (XiubaPayModel.getPayCallback != null) {
                        XiubaPayModel.getPayCallback.callBack(responseXiubaPayMessage.getResponsePayData());
                    }
                }
            }
        };
        getPayInfoListener = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.xiuba.XiubaPayModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponseGetPayinfoMessage) && httpResponsedMessage.getCmd() == 1001505) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    ResponsePayData responsePayData = new ResponsePayData();
                    responsePayData.setErrorCode(error);
                    responsePayData.setErrorMsg(httpResponsedMessage.getErrorString());
                    ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0 || responseGetPayinfoMessage.getPayInfoResultData() == null || responseGetPayinfoMessage.getPayInfoResultData().getPay_status() != 0) {
                        if (XiubaPayModel.getPayCallback != null) {
                            responsePayData.setErrorCode(3L);
                            XiubaPayModel.getPayCallback.callBack(responsePayData);
                        }
                    } else if (XiubaPayModel.getPayCallback != null) {
                        responsePayData.setErrorCode(1L);
                        XiubaPayModel.getPayCallback.callBack(responsePayData);
                    }
                }
            }
        };
    }

    public static void setPayCallback(GetPayCallback getPayCallback2) {
        getPayCallback = getPayCallback2;
    }

    public static void registerPayListener() {
        MessageManager.getInstance().registerListener(getPayInfoListener);
        MessageManager.getInstance().registerListener(sendPayListener);
    }

    public void sendPayMessage(String str, long j, String str2) {
        RequestXiubaPayMessage requestXiubaPayMessage = new RequestXiubaPayMessage();
        requestXiubaPayMessage.setXiubaUserId(str);
        requestXiubaPayMessage.setTdouNum(j);
        requestXiubaPayMessage.setPassword(str2);
        MessageManager.getInstance().sendMessage(requestXiubaPayMessage);
    }

    public void sendPurchaseTask() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(TbadkApplication.getInst(), 0)));
    }
}
