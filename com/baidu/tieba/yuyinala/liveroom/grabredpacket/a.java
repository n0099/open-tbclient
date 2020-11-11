package com.baidu.tieba.yuyinala.liveroom.grabredpacket;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        super(1031083);
        addParam("live_id", str);
        addParam("room_id", str2);
        addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str3);
        addParam("uk_1", str4);
        addParam("uk_2", str5);
        addParam("num_fields", str6);
    }
}
