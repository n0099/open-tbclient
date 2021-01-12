package com.baidu.tieba.yuyinala.liveroom.roomcard;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    public a(String str) {
        super(1031019);
        addParam("room_id", str);
    }
}
