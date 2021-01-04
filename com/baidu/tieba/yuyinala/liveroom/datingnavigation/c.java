package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class c extends HttpMessage {
    public c(String str, String str2, String str3, int i) {
        super(1031081);
        addParam("activity_stage", str);
        addParam("activity_state", str2);
        addParam("room_id", str3);
        addParam("num_fields", i);
    }
}
