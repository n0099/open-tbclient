package com.baidu.wallet.util;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f26593a;

    /* renamed from: com.baidu.wallet.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0273a {

        /* renamed from: a  reason: collision with root package name */
        public static a f26594a = new a();
    }

    public static a a() {
        return C0273a.f26594a;
    }

    public a() {
        this.f26593a = new ConcurrentHashMap<>();
    }

    public static Object a(String str) {
        if (str == null) {
            return null;
        }
        return a().f26593a.get(str);
    }

    public static void a(String str, Object obj) {
        if (str == null) {
            return;
        }
        a a2 = a();
        if (obj == null) {
            a2.f26593a.remove(str);
        } else {
            a2.f26593a.put(str, obj);
        }
    }
}
