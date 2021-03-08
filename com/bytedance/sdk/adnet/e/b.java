package com.bytedance.sdk.adnet.e;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public interface b {
    a Zj(String str);

    void a();

    void a(String str, a aVar);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4058a;
        public byte[] b;
        public String c;
        public long d;
        public long e;
        public long f;
        public long g;
        public Map<String, String> h = Collections.emptyMap();
        public List<com.bytedance.sdk.adnet.core.a> i;

        public boolean a() {
            return this.f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.g < System.currentTimeMillis();
        }
    }
}
