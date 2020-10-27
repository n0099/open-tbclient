package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public a(String str, String str2, String str3) {
        super(1031009);
        addParam("room_id", str);
        addParam("uk", str2);
        addParam("apply_type", str3);
    }
}
