package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    public a(String str, int i, int i2) {
        super(1031086);
        addParam("room_id", str);
        addParam("activity_stage", i);
        addParam("add_time", i2);
    }
}
