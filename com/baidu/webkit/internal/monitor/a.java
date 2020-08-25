package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public final class a {
    C0852a a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class C0852a {
        boolean a;
        boolean b;
        long c;
        long d;
        boolean e;
        boolean f;
        Map<String, Long> g;

        private C0852a() {
            this.b = true;
            this.c = -1L;
            this.d = -1L;
            this.g = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ C0852a(a aVar, byte b) {
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

    /* JADX INFO: Access modifiers changed from: protected */
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
