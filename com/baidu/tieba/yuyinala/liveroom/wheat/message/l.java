package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class l extends HttpMessage {
    public l(String str, String str2) {
        super(1031026);
        addParam("room_id", str);
        addParam("phone_order", str2);
    }
}
