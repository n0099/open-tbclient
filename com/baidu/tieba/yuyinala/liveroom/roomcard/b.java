package com.baidu.tieba.yuyinala.liveroom.roomcard;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    public b(String str, String str2, int i) {
        super(1031018);
        addParam("follow_room_id", str);
        addParam("live_id", str2);
        addParam("follow_status", i);
    }
}
