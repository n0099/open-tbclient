package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class d extends HttpMessage {
    public d(String str, String str2, int i, String str3) {
        super(1031011);
        addParam("room_id", str);
        addParam("uk", str2);
        addParam("operator", i);
        addParam("extends", str3);
    }
}
