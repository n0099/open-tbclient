package com.bytedance.sdk.openadsdk.core.video.e;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes6.dex */
public class c {
    public static void a(com.bytedance.sdk.openadsdk.i.f.b bVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            new com.bytedance.sdk.openadsdk.core.video.a.b.a(p.a(), bVar.f4840a, bVar.c, bVar.b).b();
        } else {
            com.bytedance.sdk.openadsdk.i.f.a.a().a(bVar);
        }
    }
}
