package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f6032a;

    public static String a() {
        if (TextUtils.isEmpty(f6032a)) {
            f6032a = "miitmdid(sdkv_" + sysParamters.eoM().c() + ")";
            return f6032a;
        }
        return f6032a;
    }
}
