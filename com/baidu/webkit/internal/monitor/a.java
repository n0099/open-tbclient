package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    C0956a f5674a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0956a {

        /* renamed from: a  reason: collision with root package name */
        boolean f5675a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5676b;
        long c;
        long d;
        boolean e;
        boolean f;
        Map<String, Long> g;

        private C0956a() {
            this.f5676b = true;
            this.c = -1L;
            this.d = -1L;
            this.g = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ C0956a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f5675a = false;
            this.f5676b = true;
            this.c = -1L;
            this.d = -1L;
            this.e = false;
            this.f = false;
            this.g.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JSONObject a() {
        try {
            if (this.f5674a != null && this.f5674a.f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f5674a.f5675a);
                jSONObject.put("loadasycsearch", this.f5674a.f5676b);
                jSONObject.put("starttosearch", this.f5674a.c);
                jSONObject.put("starttofragment", this.f5674a.d);
                jSONObject.put("state50", this.f5674a.e);
                for (String str : this.f5674a.g.keySet()) {
                    jSONObject.put(str, this.f5674a.g.get(str));
                }
                this.f5674a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f5674a.a();
            return null;
        }
    }
}
