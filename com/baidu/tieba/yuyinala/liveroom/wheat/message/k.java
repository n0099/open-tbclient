package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class k extends HttpMessage {
    public k(String str, String str2) {
        super(1031026);
        addParam("room_id", str);
        addParam("phone_order", str2);
    }
}
