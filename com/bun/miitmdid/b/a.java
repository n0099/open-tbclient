package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f3871a;

    public static String a() {
        if (TextUtils.isEmpty(f3871a)) {
            f3871a = "miitmdid(sdkv_" + sysParamters.enC().c() + ")";
            return f3871a;
        }
        return f3871a;
    }
}
