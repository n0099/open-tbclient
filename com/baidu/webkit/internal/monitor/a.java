package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public C0287a f26614a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0287a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26615a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f26616b;

        /* renamed from: c  reason: collision with root package name */
        public long f26617c;

        /* renamed from: d  reason: collision with root package name */
        public long f26618d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26619e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26620f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f26621g;

        public C0287a() {
            this.f26616b = true;
            this.f26617c = -1L;
            this.f26618d = -1L;
            this.f26621g = new HashMap();
        }

        public /* synthetic */ C0287a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f26615a = false;
            this.f26616b = true;
            this.f26617c = -1L;
            this.f26618d = -1L;
            this.f26619e = false;
            this.f26620f = false;
            this.f26621g.clear();
        }
    }

    public final JSONObject a() {
        try {
            if (this.f26614a != null && this.f26614a.f26620f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f26614a.f26615a);
                jSONObject.put("loadasycsearch", this.f26614a.f26616b);
                jSONObject.put("starttosearch", this.f26614a.f26617c);
                jSONObject.put("starttofragment", this.f26614a.f26618d);
                jSONObject.put("state50", this.f26614a.f26619e);
                for (String str : this.f26614a.f26621g.keySet()) {
                    jSONObject.put(str, this.f26614a.f26621g.get(str));
                }
                this.f26614a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f26614a.a();
            return null;
        }
    }
}
