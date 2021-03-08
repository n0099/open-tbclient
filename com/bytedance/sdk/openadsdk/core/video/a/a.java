package com.bytedance.sdk.openadsdk.core.video.a;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f4519a = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();

    public static void a(String str, b bVar) {
        f4519a.put(str, bVar);
    }

    public static b a(String str) {
        return f4519a.get(str);
    }

    public static void b(String str) {
        f4519a.remove(str);
    }

    public static void a(String str, String str2) {
        b.put(str, str2);
    }

    public static String c(String str) {
        return b.get(str);
    }
}
