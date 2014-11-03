package com.baidu.tieba.xiuba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.ai;
/* loaded from: classes.dex */
public class XiubaSendMsgModel {
    public static SendMsgCallback sendMsgCallback;
    private static final e sendMsgListener;

    /* loaded from: classes.dex */
    public interface SendMsgCallback {
        void callBack(ResponseSendMsgData responseSendMsgData);
    }

    static {
        ai.a(107202, ResponseSendXiubaMessage.class, false, false);
        sendMsgListener = new e(107202) { // from class: com.baidu.tieba.xiuba.XiubaSendMsgModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseSendXiubaMessage)) {
                    ResponseSendXiubaMessage responseSendXiubaMessage = (ResponseSendXiubaMessage) socketResponsedMessage;
                    if (XiubaSendMsgModel.sendMsgCallback != null) {
                        XiubaSendMsgModel.sendMsgCallback.callBack(responseSendXiubaMessage.getSendMsgData());
                    }
                }
            }
        };
    }

    public static void setSendMsgCallback(SendMsgCallback sendMsgCallback2) {
        sendMsgCallback = sendMsgCallback2;
    }

    public static void registerSendMsgListener() {
        MessageManager.getInstance().registerListener(sendMsgListener);
    }

    public static void sendXiubaMsg(XiubaMsg xiubaMsg) {
        RequestSendXiubaMessage requestSendXiubaMessage = new RequestSendXiubaMessage();
        requestSendXiubaMessage.setXiubaMsg(xiubaMsg);
        MessageManager.getInstance().sendMessage(requestSendXiubaMessage);
    }
}
