package com.bytedance.sdk.openadsdk.core.video.a;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f28567a = new ConcurrentHashMap<>();

    public static void a(String str, String str2) {
        f28567a.put(str, str2);
    }

    public static String a(String str) {
        return f28567a.get(str);
    }
}
