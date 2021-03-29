package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public C0285a f26929a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0285a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26930a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f26931b;

        /* renamed from: c  reason: collision with root package name */
        public long f26932c;

        /* renamed from: d  reason: collision with root package name */
        public long f26933d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26934e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26935f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f26936g;

        public C0285a() {
            this.f26931b = true;
            this.f26932c = -1L;
            this.f26933d = -1L;
            this.f26936g = new HashMap();
        }

        public /* synthetic */ C0285a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f26930a = false;
            this.f26931b = true;
            this.f26932c = -1L;
            this.f26933d = -1L;
            this.f26934e = false;
            this.f26935f = false;
            this.f26936g.clear();
        }
    }

    public final JSONObject a() {
        try {
            if (this.f26929a != null && this.f26929a.f26935f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f26929a.f26930a);
                jSONObject.put("loadasycsearch", this.f26929a.f26931b);
                jSONObject.put("starttosearch", this.f26929a.f26932c);
                jSONObject.put("starttofragment", this.f26929a.f26933d);
                jSONObject.put("state50", this.f26929a.f26934e);
                for (String str : this.f26929a.f26936g.keySet()) {
                    jSONObject.put(str, this.f26929a.f26936g.get(str));
                }
                this.f26929a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f26929a.a();
            return null;
        }
    }
}
