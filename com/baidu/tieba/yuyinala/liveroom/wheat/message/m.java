package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class m extends HttpMessage {
    public m(String str) {
        super(1031090);
        addParam("data_type", str);
    }

    public m(String str, String str2) {
        super(1031090);
        addParam("data_type", str);
        addParam("frame_ids", str2);
    }
}
