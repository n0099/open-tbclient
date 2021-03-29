package com.baidu.wallet.util;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f26816a;

    /* renamed from: com.baidu.wallet.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0284a {

        /* renamed from: a  reason: collision with root package name */
        public static a f26817a = new a();
    }

    public static a a() {
        return C0284a.f26817a;
    }

    public a() {
        this.f26816a = new ConcurrentHashMap<>();
    }

    public static Object a(String str) {
        if (str == null) {
            return null;
        }
        return a().f26816a.get(str);
    }

    public static void a(String str, Object obj) {
        if (str == null) {
            return;
        }
        a a2 = a();
        if (obj == null) {
            a2.f26816a.remove(str);
        } else {
            a2.f26816a.put(str, obj);
        }
    }
}
