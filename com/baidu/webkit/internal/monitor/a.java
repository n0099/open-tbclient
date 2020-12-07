package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    C0953a f3943a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0953a {

        /* renamed from: a  reason: collision with root package name */
        boolean f3944a;
        boolean b;
        long c;
        long d;
        boolean e;
        boolean f;
        Map<String, Long> g;

        private C0953a() {
            this.b = true;
            this.c = -1L;
            this.d = -1L;
            this.g = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ C0953a(a aVar, byte b) {
            this();
        }

        public final void a() {
            this.f3944a = false;
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
            if (this.f3943a != null && this.f3943a.f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f3943a.f3944a);
                jSONObject.put("loadasycsearch", this.f3943a.b);
                jSONObject.put("starttosearch", this.f3943a.c);
                jSONObject.put("starttofragment", this.f3943a.d);
                jSONObject.put("state50", this.f3943a.e);
                for (String str : this.f3943a.g.keySet()) {
                    jSONObject.put(str, this.f3943a.g.get(str));
                }
                this.f3943a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f3943a.a();
            return null;
        }
    }
}
