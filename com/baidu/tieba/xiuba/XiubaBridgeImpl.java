package com.baidu.tieba.xiuba;

import android.content.Context;
import android.util.Log;
import com.baidu.tieba.xiuba.XiubaGetUserInfoModel;
import com.baidu.tieba.xiuba.XiubaPayModel;
import com.baidu.tieba.xiuba.XiubaSendMsgModel;
/* loaded from: classes.dex */
public class XiubaBridgeImpl implements XiubaBridgeInterface {
    @Override // com.baidu.tieba.xiuba.XiubaBridgeInterface
    public void getUserInfo(Context context, XiubaGetUserInfoModel.GetUserInfoCallback getUserInfoCallback) {
        XiubaSynchronousDataHelper.getInstance().startGetUserInfo(getUserInfoCallback);
    }

    @Override // com.baidu.tieba.xiuba.XiubaBridgeInterface
    public void doTiebaPay(XiubaPay xiubaPay, XiubaPayModel.GetPayCallback getPayCallback) {
        XiubaSynchronousDataHelper.getInstance().startXiubaPay(xiubaPay, getPayCallback);
    }

    @Override // com.baidu.tieba.xiuba.XiubaBridgeInterface
    public void sendXiubaMsg(XiubaMsg xiubaMsg, XiubaSendMsgModel.SendMsgCallback sendMsgCallback) {
        Log.i("DDF", "sendXiubaMsg");
        XiubaSynchronousDataHelper.getInstance().startSendXiubaMsg(xiubaMsg, sendMsgCallback);
    }
}
