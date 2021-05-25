package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public C0272a f26609a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0272a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26610a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f26611b;

        /* renamed from: c  reason: collision with root package name */
        public long f26612c;

        /* renamed from: d  reason: collision with root package name */
        public long f26613d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26614e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26615f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f26616g;

        public C0272a() {
            this.f26611b = true;
            this.f26612c = -1L;
            this.f26613d = -1L;
            this.f26616g = new HashMap();
        }

        public /* synthetic */ C0272a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f26610a = false;
            this.f26611b = true;
            this.f26612c = -1L;
            this.f26613d = -1L;
            this.f26614e = false;
            this.f26615f = false;
            this.f26616g.clear();
        }
    }

    public final JSONObject a() {
        try {
            if (this.f26609a != null && this.f26609a.f26615f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f26609a.f26610a);
                jSONObject.put("loadasycsearch", this.f26609a.f26611b);
                jSONObject.put("starttosearch", this.f26609a.f26612c);
                jSONObject.put("starttofragment", this.f26609a.f26613d);
                jSONObject.put("state50", this.f26609a.f26614e);
                for (String str : this.f26609a.f26616g.keySet()) {
                    jSONObject.put(str, this.f26609a.f26616g.get(str));
                }
                this.f26609a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f26609a.a();
            return null;
        }
    }
}
