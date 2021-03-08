package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class c extends HttpMessage {
    public c(int i, int i2, String str) {
        super(1031085);
        addParam("activity_stage", i);
        addParam("activity_state", i2);
        addParam("room_id", str);
    }

    public c(int i, int i2, String str, int i3, int i4, int i5) {
        super(1031085);
        addParam("activity_stage", i);
        addParam("activity_state", i2);
        addParam("room_id", str);
        addParam("num_fields", i3);
        addParam("pk_time", i4);
        addParam("punish_time", i5);
    }
}
