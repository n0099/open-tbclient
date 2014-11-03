package com.baidu.tieba.xiuba;

import android.content.Context;
import com.baidu.tieba.xiuba.XiubaGetUserInfoModel;
import com.baidu.tieba.xiuba.XiubaPayModel;
import com.baidu.tieba.xiuba.XiubaSendMsgModel;
/* loaded from: classes.dex */
public interface XiubaBridgeInterface {
    void doTiebaPay(XiubaPay xiubaPay, XiubaPayModel.GetPayCallback getPayCallback);

    void getUserInfo(Context context, XiubaGetUserInfoModel.GetUserInfoCallback getUserInfoCallback);

    void sendXiubaMsg(XiubaMsg xiubaMsg, XiubaSendMsgModel.SendMsgCallback sendMsgCallback);
}
