package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f3974a;

    public static String a() {
        if (TextUtils.isEmpty(f3974a)) {
            f3974a = "miitmdid(sdkv_" + sysParamters.eeT().c() + ")";
            return f3974a;
        }
        return f3974a;
    }
}
