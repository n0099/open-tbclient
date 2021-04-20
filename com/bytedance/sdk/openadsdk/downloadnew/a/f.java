package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
/* loaded from: classes5.dex */
public class f {
    public static String a(l lVar) {
        if (lVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.d.b an = lVar.an();
        if (an != null && !TextUtils.isEmpty(an.c())) {
            return an.c();
        }
        if (!TextUtils.isEmpty(lVar.Y())) {
            return lVar.Y();
        }
        if (TextUtils.isEmpty(lVar.ak())) {
            return !TextUtils.isEmpty(lVar.aF()) ? lVar.aF() : "";
        }
        return lVar.ak();
    }
}
