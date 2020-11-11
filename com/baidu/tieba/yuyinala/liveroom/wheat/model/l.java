package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class l extends HttpMessage {
    public l(String str) {
        super(1031084);
        addParam("room_id", str);
    }
}
