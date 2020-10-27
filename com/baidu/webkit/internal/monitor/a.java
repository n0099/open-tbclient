package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    C0917a f3938a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0917a {

        /* renamed from: a  reason: collision with root package name */
        boolean f3939a;
        boolean b;
        long c;
        long d;
        boolean e;
        boolean f;
        Map<String, Long> g;

        private C0917a() {
            this.b = true;
            this.c = -1L;
            this.d = -1L;
            this.g = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ C0917a(a aVar, byte b) {
            this();
        }

        public final void a() {
            this.f3939a = false;
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
            if (this.f3938a != null && this.f3938a.f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f3938a.f3939a);
                jSONObject.put("loadasycsearch", this.f3938a.b);
                jSONObject.put("starttosearch", this.f3938a.c);
                jSONObject.put("starttofragment", this.f3938a.d);
                jSONObject.put("state50", this.f3938a.e);
                for (String str : this.f3938a.g.keySet()) {
                    jSONObject.put(str, this.f3938a.g.get(str));
                }
                this.f3938a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f3938a.a();
            return null;
        }
    }
}
