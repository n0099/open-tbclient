package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    C0950a f5672a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C0950a {

        /* renamed from: a  reason: collision with root package name */
        boolean f5673a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5674b;
        long c;
        long d;
        boolean e;
        boolean f;
        Map<String, Long> g;

        private C0950a() {
            this.f5674b = true;
            this.c = -1L;
            this.d = -1L;
            this.g = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ C0950a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f5673a = false;
            this.f5674b = true;
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
            if (this.f5672a != null && this.f5672a.f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f5672a.f5673a);
                jSONObject.put("loadasycsearch", this.f5672a.f5674b);
                jSONObject.put("starttosearch", this.f5672a.c);
                jSONObject.put("starttofragment", this.f5672a.d);
                jSONObject.put("state50", this.f5672a.e);
                for (String str : this.f5672a.g.keySet()) {
                    jSONObject.put(str, this.f5672a.g.get(str));
                }
                this.f5672a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f5672a.a();
            return null;
        }
    }
}
