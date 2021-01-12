package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class b extends HttpMessage {
    public b(String str, String str2, String str3) {
        super(1031009);
        addParam("room_id", str);
        addParam("uk", str2);
        addParam("apply_type", str3);
    }
}
