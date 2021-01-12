package com.baidu.tieba.yuyinala.liveroom.introduce;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    public a(String str) {
        super(1031021);
        addParam("room_id", str);
    }
}
