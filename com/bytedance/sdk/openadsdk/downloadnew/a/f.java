package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
/* loaded from: classes6.dex */
public class f {
    public static String a(l lVar) {
        if (lVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.d.b ah = lVar.ah();
        if (ah != null && !TextUtils.isEmpty(ah.c())) {
            return ah.c();
        }
        if (!TextUtils.isEmpty(lVar.S())) {
            return lVar.S();
        }
        if (!TextUtils.isEmpty(lVar.ae())) {
            return lVar.ae();
        }
        if (TextUtils.isEmpty(lVar.ay())) {
            return "";
        }
        return lVar.ay();
    }
}
