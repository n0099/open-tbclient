package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes10.dex */
public class c {
    public static String Lw(int i) {
        if (i == 0) {
            return "00:00";
        }
        if (i <= 60) {
            return i + "";
        }
        int i2 = i / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        if (i2 > 0) {
            i -= i2 * SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        }
        int i3 = i / 60;
        if (i3 > 0) {
            i -= i3 * 60;
        }
        String str = i >= 10 ? i + "" : "0" + i;
        String str2 = i3 >= 10 ? i3 + "" : "0" + i3;
        if (i2 == 0) {
            return str2 + ":" + str;
        }
        return (i2 >= 10 ? i2 + "" : "0" + i2) + ":" + str2 + ":" + str;
    }
}
