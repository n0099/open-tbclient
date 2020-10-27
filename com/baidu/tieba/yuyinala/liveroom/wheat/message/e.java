package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class e extends HttpMessage {
    public e(String str) {
        super(1031006);
        addParam("room_id", str);
    }
}
