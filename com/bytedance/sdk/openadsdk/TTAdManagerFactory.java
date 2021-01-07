package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.multipro.b;
@Deprecated
/* loaded from: classes4.dex */
public class TTAdManagerFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final TTAdManager f6384a = new v();

    private TTAdManagerFactory() {
    }

    public static TTAdManager getInstance(Context context) {
        return getInstance(context, false);
    }

    public static TTAdManager getInstance(Context context, boolean z) {
        if (z) {
            b.a();
        }
        m.a(context);
        return f6384a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TTAdManager a() {
        return f6384a;
    }
}
