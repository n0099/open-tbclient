package com.baidu.tieba.yuyinala.liveroom.introduce;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    public b(String str, String str2, String str3, String str4) {
        super(1031034);
        addParam("game_title", str);
        addParam("game_content", str2);
        addParam("room_id", str3);
        addParam("live_id", str4);
    }
}
