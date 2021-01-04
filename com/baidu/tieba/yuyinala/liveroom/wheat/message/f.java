package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class f extends HttpMessage {
    public f(String str) {
        super(1031006);
        addParam("room_id", str);
    }
}
