package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class g extends HttpMessage {
    public g(String str, String str2) {
        super(1031008);
        addParam("room_id", str);
        addParam("uk", str2);
    }
}
