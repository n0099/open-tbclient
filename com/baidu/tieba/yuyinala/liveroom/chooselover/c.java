package com.baidu.tieba.yuyinala.liveroom.chooselover;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class c extends HttpMessage {
    public c(String str, String str2, String str3, int i) {
        super(1031080);
        addParam("room_id", str3);
        addParam("chooser_uk", str);
        addParam("selected_uk", str2);
        addParam("num_fields", i);
    }
}
