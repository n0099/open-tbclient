package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class c {
    public static volatile c e;
    public final Map<String, Long> a = new ConcurrentHashMap();
    public final Handler b = new Handler(Looper.getMainLooper());
    public final Map<String, Runnable> c = new ConcurrentHashMap();
    public final Map<String, Runnable> d = new ConcurrentHashMap();

    public static c a() {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c();
                }
            }
        }
        return e;
    }
}
