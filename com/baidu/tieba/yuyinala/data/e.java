package com.baidu.tieba.yuyinala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class e extends HttpMessage {
    public e(String str, String str2, int i) {
        super(1031018);
        addParam("follow_room_id", str);
        addParam("live_id", str2);
        addParam("follow_status", i);
    }
}
