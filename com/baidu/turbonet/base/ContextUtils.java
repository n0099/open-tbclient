package com.baidu.turbonet.base;

import android.content.Context;
import com.baidu.turbonet.base.annotations.JNINamespace;
import d.a.k0.a.a;
@JNINamespace
/* loaded from: classes5.dex */
public class ContextUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Context f23028a;

    public static Context a() {
        return f23028a;
    }

    public static void b(Context context) {
        Context context2 = f23028a;
        if (context2 != null && context2 != context) {
            a.a(org.webrtc.ContextUtils.TAG, "Multiple contexts detected, ignoring new application context.");
        } else {
            d(context);
        }
    }

    public static void c() {
        Context context = f23028a;
        if (context != null) {
            nativeInitNativeSideApplicationContext(context);
            return;
        }
        throw new RuntimeException("Cannot have native global application context be null.");
    }

    public static void d(Context context) {
        if (context != null) {
            f23028a = context;
            return;
        }
        throw new RuntimeException("Global application context cannot be set to null.");
    }

    public static native void nativeInitNativeSideApplicationContext(Context context);
}
