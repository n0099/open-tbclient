package com.baidu.tieba.yuyinala.liveroom.publishlover;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    public a(String str, String str2, String str3, int i) {
        super(1031082);
        addParam("host_uk", str);
        addParam("publish_uk", str2);
        addParam("room_id", str3);
        addParam("num_fields", i);
    }
}
