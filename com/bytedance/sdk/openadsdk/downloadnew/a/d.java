package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
/* loaded from: classes6.dex */
public class d {
    public static String a(l lVar) {
        if (lVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.d.b U = lVar.U();
        if (U != null && !TextUtils.isEmpty(U.c())) {
            return U.c();
        }
        if (!TextUtils.isEmpty(lVar.G())) {
            return lVar.G();
        }
        if (!TextUtils.isEmpty(lVar.R())) {
            return lVar.R();
        }
        if (TextUtils.isEmpty(lVar.ah())) {
            return "";
        }
        return lVar.ah();
    }
}
