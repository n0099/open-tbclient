package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public C0284a f26928a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0284a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26929a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f26930b;

        /* renamed from: c  reason: collision with root package name */
        public long f26931c;

        /* renamed from: d  reason: collision with root package name */
        public long f26932d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26933e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26934f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f26935g;

        public C0284a() {
            this.f26930b = true;
            this.f26931c = -1L;
            this.f26932d = -1L;
            this.f26935g = new HashMap();
        }

        public /* synthetic */ C0284a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f26929a = false;
            this.f26930b = true;
            this.f26931c = -1L;
            this.f26932d = -1L;
            this.f26933e = false;
            this.f26934f = false;
            this.f26935g.clear();
        }
    }

    public final JSONObject a() {
        try {
            if (this.f26928a != null && this.f26928a.f26934f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f26928a.f26929a);
                jSONObject.put("loadasycsearch", this.f26928a.f26930b);
                jSONObject.put("starttosearch", this.f26928a.f26931c);
                jSONObject.put("starttofragment", this.f26928a.f26932d);
                jSONObject.put("state50", this.f26928a.f26933e);
                for (String str : this.f26928a.f26935g.keySet()) {
                    jSONObject.put(str, this.f26928a.f26935g.get(str));
                }
                this.f26928a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f26928a.a();
            return null;
        }
    }
}
