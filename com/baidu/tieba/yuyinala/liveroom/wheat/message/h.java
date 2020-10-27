package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class h extends HttpMessage {
    public h(String str) {
        this(str, null);
        if (!TextUtils.isEmpty(str)) {
            addParam("action", str);
        }
    }

    public h(String str, String str2) {
        super(1031027);
        if (!TextUtils.isEmpty(str)) {
            addParam("action", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            addParam("uk", str2);
        }
    }
}
