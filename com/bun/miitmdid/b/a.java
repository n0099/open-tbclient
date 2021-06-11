package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bun.miitmdid.utils.sysParamters;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f26843a;

    public static String a() {
        if (TextUtils.isEmpty(f26843a)) {
            String str = "miitmdid(sdkv_" + sysParamters.a().c() + SmallTailInfo.EMOTION_SUFFIX;
            f26843a = str;
            return str;
        }
        return f26843a;
    }
}
