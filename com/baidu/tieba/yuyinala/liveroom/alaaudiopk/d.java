package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
/* loaded from: classes11.dex */
public class d extends HttpMessage {
    public d(int i, String str, long j, long j2, int i2) {
        super(1031087);
        addParam("num_fields", i);
        addParam("room_id", str);
        addParam("live_id", j);
        addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, j2);
        addParam("room_mode", i2);
    }
}
