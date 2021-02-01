package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f5735a;

    public static String a() {
        if (TextUtils.isEmpty(f5735a)) {
            f5735a = "miitmdid(sdkv_" + sysParamters.enk().c() + ")";
            return f5735a;
        }
        return f5735a;
    }
}
