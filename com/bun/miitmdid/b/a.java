package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f5733a;

    public static String a() {
        if (TextUtils.isEmpty(f5733a)) {
            f5733a = "miitmdid(sdkv_" + sysParamters.ekR().c() + ")";
            return f5733a;
        }
        return f5733a;
    }
}
