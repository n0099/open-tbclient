package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
/* loaded from: classes11.dex */
public class e extends HttpMessage {
    public e(int i, String str, int i2, int i3, int i4) {
        super(1031087);
        addParam("num_fields", i);
        addParam("room_id", str);
        addParam("live_id", i2);
        addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, i3);
        addParam("room_mode", i4);
    }
}
