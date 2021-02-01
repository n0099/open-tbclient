package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class n extends HttpMessage {
    public n(String str) {
        super(1031084);
        addParam("room_id", str);
    }
}
