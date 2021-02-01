package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class h extends HttpMessage {
    public h(String str, String str2, String str3) {
        super(1031008);
        addParam("room_id", str);
        addParam("uk", str2);
        addParam("phone_order", str3);
        addParam("im_uk", com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecE());
    }
}
