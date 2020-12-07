package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f3979a;

    public static String a() {
        if (TextUtils.isEmpty(f3979a)) {
            f3979a = "miitmdid(sdkv_" + sysParamters.eow().c() + ")";
            return f3979a;
        }
        return f3979a;
    }
}
