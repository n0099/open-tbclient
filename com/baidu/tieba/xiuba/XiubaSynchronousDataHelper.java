package com.baidu.tieba.xiuba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.adp.lib.g.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.xiuba.XiubaGetUserInfoModel;
import com.baidu.tieba.xiuba.XiubaPayModel;
import com.baidu.tieba.xiuba.XiubaSendMsgModel;
/* loaded from: classes.dex */
public class XiubaSynchronousDataHelper {
    public static final int WHAT_CONNECT = 0;
    public static final int WHAT_DISCONNECT = 1;
    public static final int WHAT_GET_USER_INFO = 3;
    public static final int WHAT_SEND_MSG = 2;
    public static final int WHAT_XIUBA_PAY = 4;
    private static XiubaSynchronousDataHelper mInstance;
    private XiubaPayModel.GetPayCallback mGetPayCallback;
    private XiubaGetUserInfoModel.GetUserInfoCallback mGetUserInfoCallback;
    private Messenger mSendMessenger;
    private XiubaSendMsgModel.SendMsgCallback mSendMsgCallback;
    private int sendType;
    private XiubaMsg xiubaMsg;
    private XiubaPay xiubaPay;
    private Messenger mReplyMessenger = new Messenger(new IncomingHandler(this, null));
    private Connection mConnection = new Connection(this, null);
    private Context mContext = TbadkApplication.m251getInst().getApplicationContext();

    private XiubaSynchronousDataHelper() {
    }

    public static synchronized XiubaSynchronousDataHelper getInstance() {
        XiubaSynchronousDataHelper xiubaSynchronousDataHelper;
        synchronized (XiubaSynchronousDataHelper.class) {
            if (mInstance == null) {
                mInstance = new XiubaSynchronousDataHelper();
            }
            xiubaSynchronousDataHelper = mInstance;
        }
        return xiubaSynchronousDataHelper;
    }

    /* loaded from: classes.dex */
    class IncomingHandler extends Handler {
        private IncomingHandler() {
        }

        /* synthetic */ IncomingHandler(XiubaSynchronousDataHelper xiubaSynchronousDataHelper, IncomingHandler incomingHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 2:
                    XiubaSynchronousDataHelper.this.callbackSendMsg(message);
                    return;
                case 3:
                    XiubaSynchronousDataHelper.this.callbackGetUserInfo(message);
                    return;
                case 4:
                    XiubaSynchronousDataHelper.this.callbackXiubaPay(message);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackGetUserInfo(Message message) {
        UserInfo userInfo = (UserInfo) message.getData().getSerializable("userInfo");
        this.sendType = -1;
        close();
        if (this.mGetUserInfoCallback != null) {
            this.mGetUserInfoCallback.callBack(userInfo);
            this.mGetUserInfoCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackXiubaPay(Message message) {
        ResponsePayData responsePayData = (ResponsePayData) message.getData().getSerializable("responseData");
        this.sendType = -1;
        this.xiubaPay = null;
        close();
        if (this.mGetPayCallback != null) {
            this.mGetPayCallback.callBack(responsePayData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackSendMsg(Message message) {
        ResponseSendMsgData responseSendMsgData = (ResponseSendMsgData) message.getData().getSerializable("responseSendMsgData");
        this.sendType = -1;
        this.xiubaMsg = null;
        close();
        if (this.mSendMsgCallback != null) {
            this.mSendMsgCallback.callBack(responseSendMsgData);
            this.mSendMsgCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Connection implements ServiceConnection {
        private Connection() {
        }

        /* synthetic */ Connection(XiubaSynchronousDataHelper xiubaSynchronousDataHelper, Connection connection) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BdLog.i("Connected");
            XiubaSynchronousDataHelper.this.mSendMessenger = new Messenger(iBinder);
            XiubaSynchronousDataHelper.this.sendConnect();
            if (XiubaSynchronousDataHelper.this.sendType != 2) {
                if (XiubaSynchronousDataHelper.this.sendType != 3) {
                    if (XiubaSynchronousDataHelper.this.sendType != 4 || XiubaSynchronousDataHelper.this.xiubaPay == null) {
                        return;
                    }
                    XiubaSynchronousDataHelper.this.sendPayMsg(XiubaSynchronousDataHelper.this.xiubaPay);
                    return;
                }
                XiubaSynchronousDataHelper.this.sendGetUserInfo();
            } else if (XiubaSynchronousDataHelper.this.xiubaMsg == null) {
            } else {
                XiubaSynchronousDataHelper.this.sendXiubaMsg(XiubaSynchronousDataHelper.this.xiubaMsg);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            XiubaSynchronousDataHelper.this.mSendMessenger = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConnect() {
        Message obtain = Message.obtain((Handler) null, 0);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.mSendMessenger.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    private void sendDisConnect() {
        if (this.mSendMessenger != null) {
            Message obtain = Message.obtain((Handler) null, 1);
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.mSendMessenger.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    public void start() {
        Intent intent = new Intent(this.mContext, XiubaSynchronousDataService.class);
        i.a(this.mContext, this.mConnection);
        i.a(this.mContext, intent, this.mConnection, 1);
    }

    public void close() {
        sendDisConnect();
        BdLog.i(LoginActivityConfig.CLOSE);
        if (this.mSendMessenger != null) {
            i.a(this.mContext, this.mConnection);
        }
    }

    public void startSendXiubaMsg(XiubaMsg xiubaMsg, XiubaSendMsgModel.SendMsgCallback sendMsgCallback) {
        if (xiubaMsg != null) {
            this.sendType = 2;
            this.mSendMsgCallback = sendMsgCallback;
            this.xiubaMsg = xiubaMsg;
            start();
        }
    }

    public void startGetUserInfo(XiubaGetUserInfoModel.GetUserInfoCallback getUserInfoCallback) {
        this.sendType = 3;
        this.mGetUserInfoCallback = getUserInfoCallback;
        start();
    }

    public void startXiubaPay(XiubaPay xiubaPay, XiubaPayModel.GetPayCallback getPayCallback) {
        if (xiubaPay != null) {
            this.sendType = 4;
            this.xiubaPay = xiubaPay;
            this.mGetPayCallback = getPayCallback;
            start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendXiubaMsg(XiubaMsg xiubaMsg) {
        Message obtain = Message.obtain((Handler) null, 2);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                Bundle bundle = new Bundle();
                bundle.putSerializable("xiubaMsg", xiubaMsg);
                obtain.setData(bundle);
                this.mSendMessenger.send(obtain);
                BdLog.i("send-WHAT_SEND_MSG");
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPayMsg(XiubaPay xiubaPay) {
        Message obtain = Message.obtain((Handler) null, 4);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                Bundle bundle = new Bundle();
                bundle.putSerializable("xiubaPay", xiubaPay);
                obtain.setData(bundle);
                this.mSendMessenger.send(obtain);
                BdLog.i("send-WHAT_XIUBA_PAY");
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetUserInfo() {
        Message obtain = Message.obtain((Handler) null, 3);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.mSendMessenger.send(obtain);
                BdLog.i("send-WHAT_GET_USER_INFO");
            } catch (RemoteException e) {
            }
        }
    }
}
