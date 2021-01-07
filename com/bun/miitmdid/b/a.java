package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f6033a;

    public static String a() {
        if (TextUtils.isEmpty(f6033a)) {
            f6033a = "miitmdid(sdkv_" + sysParamters.eoN().c() + ")";
            return f6033a;
        }
        return f6033a;
    }
}
