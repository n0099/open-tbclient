package com.baidu.tieba.yuyinala.liveroom.rename;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    public a(String str, int i, String str2, String str3) {
        super(1031020);
        addParam("room_id", str);
        addParam("modify_status", i);
        addParam("live_id", str2);
        addParam("value", str3);
    }
}
