package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes6.dex */
public class a {
    private static String a;

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = "miitmdid(sdkv_" + sysParamters.dth().c() + ")";
            return a;
        }
        return a;
    }
}
