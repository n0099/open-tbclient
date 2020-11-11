package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    public b(String str, String str2, String str3, String str4) {
        super(1031007);
        addParam("room_id", str);
        addParam("phone_type", str2);
        addParam("phone_order", str3);
        addParam(BuyTBeanActivityConfig.CALLBACK, str4);
    }
}
