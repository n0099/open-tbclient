package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    public C0564a a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0564a {
        public boolean a;
        public boolean b;
        public long c;
        public long d;
        public boolean e;
        public boolean f;
        public Map<String, Long> g;

        public C0564a() {
            this.b = true;
            this.c = -1L;
            this.d = -1L;
            this.g = new HashMap();
        }

        public /* synthetic */ C0564a(a aVar, byte b) {
            this();
        }

        public final void a() {
            this.a = false;
            this.b = true;
            this.c = -1L;
            this.d = -1L;
            this.e = false;
            this.f = false;
            this.g.clear();
        }
    }

    public final JSONObject a() {
        try {
            if (this.a != null && this.a.f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.a.a);
                jSONObject.put("loadasycsearch", this.a.b);
                jSONObject.put("starttosearch", this.a.c);
                jSONObject.put("starttofragment", this.a.d);
                jSONObject.put("state50", this.a.e);
                for (String str : this.a.g.keySet()) {
                    jSONObject.put(str, this.a.g.get(str));
                }
                this.a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.a.a();
            return null;
        }
    }
}
