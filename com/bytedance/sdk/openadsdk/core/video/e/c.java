package com.bytedance.sdk.openadsdk.core.video.e;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes6.dex */
public class c {
    public static void a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            com.bytedance.sdk.openadsdk.video.b.a aVar = new com.bytedance.sdk.openadsdk.video.b.a();
            aVar.b(bVar.f29453c);
            aVar.a(bVar.f29451a);
            aVar.a(bVar.f29452b);
            com.bytedance.sdk.openadsdk.video.a.b.a.a(p.a(), aVar);
            return;
        }
        com.bytedance.sdk.openadsdk.k.f.a.a().a(bVar);
    }
}
