package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public C0274a f26712a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0274a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26713a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f26714b;

        /* renamed from: c  reason: collision with root package name */
        public long f26715c;

        /* renamed from: d  reason: collision with root package name */
        public long f26716d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26717e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26718f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f26719g;

        public C0274a() {
            this.f26714b = true;
            this.f26715c = -1L;
            this.f26716d = -1L;
            this.f26719g = new HashMap();
        }

        public /* synthetic */ C0274a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f26713a = false;
            this.f26714b = true;
            this.f26715c = -1L;
            this.f26716d = -1L;
            this.f26717e = false;
            this.f26718f = false;
            this.f26719g.clear();
        }
    }

    public final JSONObject a() {
        try {
            if (this.f26712a != null && this.f26712a.f26718f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f26712a.f26713a);
                jSONObject.put("loadasycsearch", this.f26712a.f26714b);
                jSONObject.put("starttosearch", this.f26712a.f26715c);
                jSONObject.put("starttofragment", this.f26712a.f26716d);
                jSONObject.put("state50", this.f26712a.f26717e);
                for (String str : this.f26712a.f26719g.keySet()) {
                    jSONObject.put(str, this.f26712a.f26719g.get(str));
                }
                this.f26712a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f26712a.a();
            return null;
        }
    }
}
