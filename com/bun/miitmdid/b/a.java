package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f27061a;

    public static String a() {
        if (TextUtils.isEmpty(f27061a)) {
            String str = "miitmdid(sdkv_" + sysParamters.a().c() + SmallTailInfo.EMOTION_SUFFIX;
            f27061a = str;
            return str;
        }
        return f27061a;
    }
}
