package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public C0284a f27430a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0284a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f27431a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f27432b;

        /* renamed from: c  reason: collision with root package name */
        public long f27433c;

        /* renamed from: d  reason: collision with root package name */
        public long f27434d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27435e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f27436f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f27437g;

        public C0284a() {
            this.f27432b = true;
            this.f27433c = -1L;
            this.f27434d = -1L;
            this.f27437g = new HashMap();
        }

        public /* synthetic */ C0284a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f27431a = false;
            this.f27432b = true;
            this.f27433c = -1L;
            this.f27434d = -1L;
            this.f27435e = false;
            this.f27436f = false;
            this.f27437g.clear();
        }
    }

    public final JSONObject a() {
        try {
            if (this.f27430a != null && this.f27430a.f27436f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f27430a.f27431a);
                jSONObject.put("loadasycsearch", this.f27430a.f27432b);
                jSONObject.put("starttosearch", this.f27430a.f27433c);
                jSONObject.put("starttofragment", this.f27430a.f27434d);
                jSONObject.put("state50", this.f27430a.f27435e);
                for (String str : this.f27430a.f27437g.keySet()) {
                    jSONObject.put(str, this.f27430a.f27437g.get(str));
                }
                this.f27430a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f27430a.a();
            return null;
        }
    }
}
