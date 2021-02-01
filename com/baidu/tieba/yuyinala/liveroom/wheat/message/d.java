package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class d extends HttpMessage {
    public d(String str, String str2) {
        super(1031010);
        addParam("room_id", str);
        addParam("apply_type", str2);
    }
}
