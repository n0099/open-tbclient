package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class e extends HttpMessage {
    public e(String str, String str2, int i, String str3) {
        super(1031011);
        addParam("room_id", str);
        addParam("uk", str2);
        addParam("operator", i);
        addParam("extends", str3);
    }
}
