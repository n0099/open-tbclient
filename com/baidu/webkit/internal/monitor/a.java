package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public C0289a f26622a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0289a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26623a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f26624b;

        /* renamed from: c  reason: collision with root package name */
        public long f26625c;

        /* renamed from: d  reason: collision with root package name */
        public long f26626d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26627e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26628f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f26629g;

        public C0289a() {
            this.f26624b = true;
            this.f26625c = -1L;
            this.f26626d = -1L;
            this.f26629g = new HashMap();
        }

        public /* synthetic */ C0289a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f26623a = false;
            this.f26624b = true;
            this.f26625c = -1L;
            this.f26626d = -1L;
            this.f26627e = false;
            this.f26628f = false;
            this.f26629g.clear();
        }
    }

    public final JSONObject a() {
        try {
            if (this.f26622a != null && this.f26622a.f26628f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f26622a.f26623a);
                jSONObject.put("loadasycsearch", this.f26622a.f26624b);
                jSONObject.put("starttosearch", this.f26622a.f26625c);
                jSONObject.put("starttofragment", this.f26622a.f26626d);
                jSONObject.put("state50", this.f26622a.f26627e);
                for (String str : this.f26622a.f26629g.keySet()) {
                    jSONObject.put(str, this.f26622a.f26629g.get(str));
                }
                this.f26622a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f26622a.a();
            return null;
        }
    }
}
