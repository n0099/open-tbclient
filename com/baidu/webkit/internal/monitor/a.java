package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    C0962a f3835a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C0962a {

        /* renamed from: a  reason: collision with root package name */
        boolean f3836a;
        boolean b;
        long c;
        long d;
        boolean e;
        boolean f;
        Map<String, Long> g;

        private C0962a() {
            this.b = true;
            this.c = -1L;
            this.d = -1L;
            this.g = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ C0962a(a aVar, byte b) {
            this();
        }

        public final void a() {
            this.f3836a = false;
            this.b = true;
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
            if (this.f3835a != null && this.f3835a.f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f3835a.f3836a);
                jSONObject.put("loadasycsearch", this.f3835a.b);
                jSONObject.put("starttosearch", this.f3835a.c);
                jSONObject.put("starttofragment", this.f3835a.d);
                jSONObject.put("state50", this.f3835a.e);
                for (String str : this.f3835a.g.keySet()) {
                    jSONObject.put(str, this.f3835a.g.get(str));
                }
                this.f3835a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f3835a.a();
            return null;
        }
    }
}
