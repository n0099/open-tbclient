package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f3976a;

    public static String a() {
        if (TextUtils.isEmpty(f3976a)) {
            f3976a = "miitmdid(sdkv_" + sysParamters.eiI().c() + ")";
            return f3976a;
        }
        return f3976a;
    }
}
