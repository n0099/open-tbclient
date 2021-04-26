package com.bytedance.sdk.openadsdk.core.video.a;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f29208a = new ConcurrentHashMap<>();

    public static void a(String str, String str2) {
        f29208a.put(str, str2);
    }

    public static String a(String str) {
        return f29208a.get(str);
    }
}
