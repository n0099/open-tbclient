package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    C0933a f3940a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0933a {

        /* renamed from: a  reason: collision with root package name */
        boolean f3941a;
        boolean b;
        long c;
        long d;
        boolean e;
        boolean f;
        Map<String, Long> g;

        private C0933a() {
            this.b = true;
            this.c = -1L;
            this.d = -1L;
            this.g = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ C0933a(a aVar, byte b) {
            this();
        }

        public final void a() {
            this.f3941a = false;
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
            if (this.f3940a != null && this.f3940a.f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f3940a.f3941a);
                jSONObject.put("loadasycsearch", this.f3940a.b);
                jSONObject.put("starttosearch", this.f3940a.c);
                jSONObject.put("starttofragment", this.f3940a.d);
                jSONObject.put("state50", this.f3940a.e);
                for (String str : this.f3940a.g.keySet()) {
                    jSONObject.put(str, this.f3940a.g.get(str));
                }
                this.f3940a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f3940a.a();
            return null;
        }
    }
}
