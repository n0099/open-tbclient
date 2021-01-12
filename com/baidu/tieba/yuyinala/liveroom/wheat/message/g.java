package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class g extends HttpMessage {
    public g(String str) {
        super(1031014);
        addParam("room_id", str);
    }
}
