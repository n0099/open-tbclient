package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class i extends HttpMessage {
    public i(String str, String str2, String str3) {
        super(1031012);
        addParam("room_id", str);
        addParam("uk", str2);
        addParam("status", str3);
    }
}
