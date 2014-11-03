package com.baidu.tieba.xiuba;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.tieba.xiuba.XiubaGetUserInfoModel;
import com.baidu.tieba.xiuba.XiubaPayModel;
import com.baidu.tieba.xiuba.XiubaSendMsgModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class XiubaSynchronousDataService extends Service {
    private Messenger mComingMessenger = new Messenger(new IncomingHandler(this, null));
    private List<Messenger> sendMessengers = new ArrayList();
    private XiubaGetUserInfoModel.GetUserInfoCallback getUserInfoCallBack = new XiubaGetUserInfoModel.GetUserInfoCallback() { // from class: com.baidu.tieba.xiuba.XiubaSynchronousDataService.1
        @Override // com.baidu.tieba.xiuba.XiubaGetUserInfoModel.GetUserInfoCallback
        public void callBack(UserInfo userInfo) {
            for (Messenger messenger : XiubaSynchronousDataService.this.sendMessengers) {
                try {
                    Message obtain = Message.obtain((Handler) null, 3);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("userInfo", userInfo);
                    obtain.setData(bundle);
                    messenger.send(obtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private XiubaPayModel.GetPayCallback getPayCallBack = new XiubaPayModel.GetPayCallback() { // from class: com.baidu.tieba.xiuba.XiubaSynchronousDataService.2
        @Override // com.baidu.tieba.xiuba.XiubaPayModel.GetPayCallback
        public void callBack(ResponsePayData responsePayData) {
            for (Messenger messenger : XiubaSynchronousDataService.this.sendMessengers) {
                try {
                    Message obtain = Message.obtain((Handler) null, 4);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("responseData", responsePayData);
                    obtain.setData(bundle);
                    messenger.send(obtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private XiubaSendMsgModel.SendMsgCallback sendMsgCallBack = new XiubaSendMsgModel.SendMsgCallback() { // from class: com.baidu.tieba.xiuba.XiubaSynchronousDataService.3
        @Override // com.baidu.tieba.xiuba.XiubaSendMsgModel.SendMsgCallback
        public void callBack(ResponseSendMsgData responseSendMsgData) {
            for (Messenger messenger : XiubaSynchronousDataService.this.sendMessengers) {
                try {
                    Message obtain = Message.obtain((Handler) null, 2);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("responseSendMsgData", responseSendMsgData);
                    obtain.setData(bundle);
                    messenger.send(obtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    /* loaded from: classes.dex */
    class IncomingHandler extends Handler {
        private IncomingHandler() {
        }

        /* synthetic */ IncomingHandler(XiubaSynchronousDataService xiubaSynchronousDataService, IncomingHandler incomingHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    XiubaSynchronousDataService.this.sendMessengers.add(message.replyTo);
                    return;
                case 1:
                    XiubaSynchronousDataService.this.sendMessengers.remove(message.replyTo);
                    return;
                case 2:
                    XiubaSynchronousDataService.this.SendXiubaMsg(message);
                case 3:
                    XiubaSynchronousDataService.this.GetUserInfo();
                    break;
                case 4:
                    break;
                default:
                    return;
            }
            XiubaSynchronousDataService.this.XiubaPay(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SendXiubaMsg(Message message) {
        XiubaMsg xiubaMsg;
        Bundle data = message.getData();
        if (data != null && (xiubaMsg = (XiubaMsg) data.getSerializable("xiubaMsg")) != null) {
            XiubaSendMsgModel.sendXiubaMsg(xiubaMsg);
            XiubaSendMsgModel.setSendMsgCallback(this.sendMsgCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GetUserInfo() {
        XiubaGetUserInfoModel xiubaGetUserInfoModel = new XiubaGetUserInfoModel();
        xiubaGetUserInfoModel.setUserInfoCallBack(this.getUserInfoCallBack);
        xiubaGetUserInfoModel.sendGetUserInfoTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XiubaPay(Message message) {
        XiubaPay xiubaPay;
        Bundle data = message.getData();
        if (data != null && (xiubaPay = (XiubaPay) data.getSerializable("xiubaPay")) != null) {
            XiubaPayModel xiubaPayModel = new XiubaPayModel();
            XiubaPayModel.setPayCallback(this.getPayCallBack);
            if (xiubaPay.getType() == 0) {
                xiubaPayModel.sendPayMessage(xiubaPay.getXiubaUserId(), xiubaPay.getTdouNum(), xiubaPay.getPassword());
            } else if (xiubaPay.getType() == 1) {
                xiubaPayModel.sendPurchaseTask();
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mComingMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.sendMessengers.clear();
    }
}
