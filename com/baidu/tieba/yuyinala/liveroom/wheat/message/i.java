package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class i extends HttpMessage {
    public i(String str) {
        this(str, null);
        if (!TextUtils.isEmpty(str)) {
            addParam("action", str);
        }
    }

    public i(String str, String str2) {
        super(1031027);
        if (!TextUtils.isEmpty(str)) {
            addParam("action", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            addParam("uk", str2);
        }
        addParam("im_uk", com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().ecU());
    }
}
